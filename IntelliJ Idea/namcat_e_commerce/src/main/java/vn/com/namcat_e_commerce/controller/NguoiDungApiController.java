package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.service.NguoiDungSevice;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api")
public class NguoiDungApiController {
    
    @Autowired
    NguoiDungSevice nguoiDungSevice;
    
    @GetMapping("/nguoidung/{id}")
    public ResponseEntity<?> layChiTiet(@PathVariable("id") String id) {
        
        NguoiDung objND = nguoiDungSevice.findById(id);
        
        if(objND != null) {
            return new ResponseEntity<NguoiDung>(objND, HttpStatus.OK);
        }
        else {
            Message msg = new Message("not_found", "Không tìm thấy người dùng với mã: " + id);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping(value = "/nguoidung/themmoi")
    public ResponseEntity<?> themMoi(@RequestParam Map<String, String> nguoidung) {
        
        List<Message> msg = new ArrayList<Message>();
        
        //Lấy tên người dùng đầu vào
        String tenNguoiDung = nguoidung.get("tenNguoiDung");
        
        if(!tenNguoiDung.matches("^[A-Za-z0-9+_.-]+$")) {
            msg.add(new Message("er_tenNguoiDung", "Tên người dùng không được chứa các kí tự đặc biệt"));
        }
        
        NguoiDung objNDCheck = nguoiDungSevice.findById(tenNguoiDung);
        
        //Kiểm tra người dùng đã tồn tại chưa
        if(objNDCheck != null) {
            msg.add(new Message("er_tenNguoiDung", "Tên người dùng này đã tồn tại"));
        }
        
        //Kiểm tra email
        String email = nguoidung.get("email");
        boolean b_email = nguoiDungSevice.kiemTraEmailTonTai(email);
        
        if(b_email)
        {
            msg.add(new Message("er_email", "Địa chỉ email này đã tồn tại"));
        }
        
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            msg.add(new Message("er_email", "Địa chỉ email không hợp lệ"));
        }
        
        //Kiểm tra họ tên
        String hoTen = nguoidung.get("hoTen");
        
        if(!hoTen.matches("^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$")) {
            msg.add(new Message("er_hoTen", "Họ tên người dùng không hợp lệ"));
        }
        
        //Kiểm tra số điện thoại
        String dienThoai = nguoidung.get("dienThoai");
        boolean b_dienThoai = nguoiDungSevice.kiemTraSDTTonTai(nguoidung.get("dienThoai"));
        
        if(b_dienThoai)
        {
            msg.add(new Message("er_dienThoai", "Số điện thoại này đã tồn tại"));
        }
        
        if(!dienThoai.matches("\\d{10}")) {
            msg.add(new Message("er_dienThoai", "Số điện thoại người dùng chỉ được bao gồm 10 chữ số"));
        }
        
        NguoiDung objND = new NguoiDung();
        
        objND.setTenNguoiDung(tenNguoiDung);
        objND.setMatKhau(nguoidung.get("matKhau"));
        objND.setEmail(nguoidung.get("email"));
        objND.setDienThoai(nguoidung.get("dienThoai"));
        objND.setHoTen(nguoidung.get("hoTen"));
        objND.setVaiTro(nguoidung.get("vaiTro"));
        objND.setDiaChi(nguoidung.get("diaChi"));
        
//        boolean ketQua = sanPhamService.add(objSP);
//
//        if (ketQua) {
//            return new ResponseEntity<SanPham>(objSP, HttpStatus.OK);
//        }
        
        Message msg1 = new Message("er_sanPham", "Thêm mới sản phẩm thất bại");
        return new ResponseEntity<Message>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
//    @PutMapping(value = "/sanpham/capnhat/{id}", consumes = {"multipart/form-data"})
//    public ResponseEntity<?> capNhat(@PathVariable("id") String maSanPham,
//                                     @RequestParam Map<String, String> sanpham,
//                                     @RequestParam(value = "fUpload", required = false) MultipartFile fUpload) {
//
//        List<Message> msg = new ArrayList<Message>();
//        SanPham objSP = sanPhamService.findById(maSanPham);
//
//        if(objSP == null) {
//            msg.add(new Message("er_maSanPham", "Không tìm thấy sản phẩm với mã: " + maSanPham));
//        }
//
//        int giaSanPham = 1000, tonKho = 0;
//
//        //Bắt lỗi giá sản phẩm
//        try {
//            giaSanPham = Integer.parseInt(sanpham.get("giaSanPham"));
//
//            //Kiểm tra giá trị tối tiểu
//            if (giaSanPham < 1000) {
//                msg.add(new Message("er_giaSanPham", "Giá sản phẩm phải lớn hơn 1000đ"));
//            }
//        } catch (NumberFormatException ex) {
//            msg.add(new Message("er_giaSanPham", "Giá sản phẩm phải là số nguyên dương"));
//        }
//
//        //Bắt lỗi tồn kho
//        try {
//            tonKho = Integer.parseInt(sanpham.get("tonKho"));
//
//            //Kiểm tra giá trị tối tiểu
//            if (tonKho < 0) {
//                msg.add(new Message("er_tonKho", "Số lượng tồn kho phải là số nguyên dương"));
//            }
//        } catch (NumberFormatException ex) {
//            msg.add(new Message("er_tonKho", "Số lượng tồn kho phải là số nguyên dương"));
//        }
//
//        String tenFile = "";
//        if (objSP != null) {
//            tenFile = objSP.getAnhSanPham();
//        }
//        String loaiFile = "";
//
//        //Xu ly upload file
//        if (fUpload != null && !fUpload.isEmpty()) {
//            try {
//                String fileUpload = xuLyUploadFile(fUpload);
//
//                String[] uploadInfo = fileUpload.split(",");
//
//                tenFile = uploadInfo[0];
//                loaiFile = uploadInfo[1];
//
//                if (!loaiFile.equals("jpg") && !loaiFile.equals("png")) {
//                    msg.add(new Message("er_image", "Chỉ cho phép tải file ảnh jpg hoặc png"));
//                }
//            } catch (Exception ex) {
//                msg.add(new Message("er_image", "Có lỗi khi tải ảnh"));
//            }
//        }
//
//        // Xử lý ngày tạo
//        LocalDate ngayTao;
//        try {
//            String ngayTaoStr = sanpham.get("ngayTao");
//            if (ngayTaoStr != null && !ngayTaoStr.isEmpty()) {
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                ngayTao = LocalDate.parse(ngayTaoStr, formatter);
//            } else {
//                ngayTao = LocalDate.now(); // Nếu người dùng không điền ngày sẽ tự động lấy ngày hôm nay
//            }
//        } catch (DateTimeParseException ex) {
//            ngayTao = objSP.getNgayTao();
//        }
//
//        if (!msg.isEmpty()) {
//            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
//        }
//
//        objSP.setTenSanPham(sanpham.get("tenSanPham"));
//        objSP.setGiaSanPham(giaSanPham);
//        objSP.setTonKho(tonKho);
//        objSP.setLoaiSanPham(sanpham.get("loaiSanPham"));
//        objSP.setAnhSanPham(tenFile);
//        objSP.setMoTa(sanpham.get("moTa"));
//        objSP.setNoiDung(sanpham.get("noiDung"));
//        objSP.setNgayTao(ngayTao);
//        objSP.setNgayCapNhap(LocalDate.now());
//        objSP.setMauSac(sanpham.get("mauSac"));
//
//        boolean ketQua = sanPhamService.update(objSP);
//
//        if (ketQua) {
//            return new ResponseEntity<SanPham>(objSP, HttpStatus.OK);
//        }
//
//        Message msg1 = new Message("er_sanPham", "Cập nhật sản phẩm thất bại");
//        return new ResponseEntity<Message>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @DeleteMapping("/sanpham/xoa/{id}")
//    public ResponseEntity<?> xoa(@PathVariable("id") String maSanPham)
//    {
//        SanPham objSP = sanPhamService.findById(maSanPham);
//
//        if(objSP == null)
//        {
//            Message msg = new Message("er_maSanPham", "Không tìm thấy sản phẩm với mã: " + maSanPham);
//            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
//        }
//        else
//        {
//            boolean ketQua = sanPhamService.delete(maSanPham);
//
//            if(ketQua)
//            {
//                Message msg = new Message("ok_sanPham", "Xóa thành công sản phẩm với mã: " + maSanPham);
//                return new ResponseEntity<Message>(msg, HttpStatus.OK);
//            }
//
//            Message msg = new Message("er_sanPham", "Không thể xóa thông tin đang được sử dụng. Vui lòng kiểm tra lại");
//            return new ResponseEntity<Message>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
