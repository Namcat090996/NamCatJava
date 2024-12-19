package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api")
@SessionAttributes("Online_User")
public class SanPhamApiController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @GetMapping("/sanpham/{id}")
    public ResponseEntity<?> layChiTiet(@PathVariable("id") String id) {
        
        SanPham objSP = sanPhamService.findById(id);
        
        if(objSP != null) {
            return new ResponseEntity<SanPham>(objSP, HttpStatus.OK);
        }
        else {
            Message msg = new Message("not_found", "Không tìm thấy sản phẩm với mã: " + id);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
    }
    
    @Value("${fileupload.path}")
    private String fUploadPath;
    
    public String xuLyUploadFile(MultipartFile fUpload) throws IOException {
        
        String tenFile = fUpload.getOriginalFilename();
        
        String loaiFile = "";
        
        String duongDan = fUploadPath;
        
        Path directory = Paths.get(duongDan);
        
        if(!Files.exists(directory))
        {
            Files.createDirectories(directory);
        }
        
        Path filePath = directory.resolve(tenFile);
        
        fUpload.transferTo(filePath.toFile());
        
        if(tenFile.contains(".") && tenFile.lastIndexOf(".") != 0)
        {
            loaiFile = tenFile.substring(tenFile.lastIndexOf(".") + 1).toLowerCase();
        }
        
        return tenFile + "," + loaiFile;
    }
    
    @PostMapping(value = "/sanpham/themmoi", consumes = {"multipart/form-data"})
    public ResponseEntity<?> themMoi(@ModelAttribute("Online_User") String onlineUser, @RequestParam Map<String, String> sanpham,
                                     @RequestParam(value = "fUpload", required = false) MultipartFile fUpload) {
        
        List<Message> msg = new ArrayList<Message>();
        
        //Lấy mã sản phẩm đầu vào
        String maSanPham = sanpham.get("maSanPham");
        
        if(!maSanPham.matches("^SP\\d{2,}$")) {
            msg.add(new Message("er_maSanPham", "Mã SP phải bắt đầu bằng 'SP' và theo sau ít nhất 02 chữ số"));
        }
        
        SanPham objSPCheck = sanPhamService.findById(maSanPham);
        
        //Kiểm tra sản phẩm đã tồn tại chưa
        if(objSPCheck != null) {
            msg.add(new Message("er_maSanPham", "Mã sản phẩm này đã tồn tại"));
        }
        
        int giaSanPham = 1000, tonKho = 0;
        
        //Bắt lỗi giá sản phẩm
        try {
            giaSanPham = Integer.parseInt(sanpham.get("giaSanPham"));
            
            //Kiểm tra giá trị tối tiểu
            if (giaSanPham < 1000) {
                msg.add(new Message("er_giaSanPham", "Giá sản phẩm phải lớn hơn 1000đ"));
            }
        } catch (NumberFormatException ex) {
            msg.add(new Message("er_giaSanPham", "Giá sản phẩm phải là số nguyên dương"));
        }
        
        //Bắt lỗi tồn kho
        try {
            tonKho = Integer.parseInt(sanpham.get("tonKho"));
            
            //Kiểm tra giá trị tối tiểu
            if (tonKho < 0) {
                msg.add(new Message("er_tonKho", "Số lượng tồn kho phải là số nguyên dương"));
            }
        } catch (NumberFormatException ex) {
            msg.add(new Message("er_tonKho", "Số lượng tồn kho phải là số nguyên dương"));
        }
        
        String tenFile = "";
        String loaiFile = "";
        
        //Xu ly upload file
        if (fUpload != null && !fUpload.isEmpty()) {
            try {
                String fileUpload = xuLyUploadFile(fUpload);
                
                String[] uploadInfo = fileUpload.split(",");
                
                tenFile = uploadInfo[0];
                loaiFile = uploadInfo[1];
                
                if (!loaiFile.equals("jpg") && !loaiFile.equals("png")) {
                    msg.add(new Message("er_image", "Chỉ cho phép tải file ảnh jpg hoặc png"));
                }
            } catch (Exception ex) {
                msg.add(new Message("er_image", "Có lỗi khi tải ảnh"));
            }
        } else {
            msg.add(new Message("er_image", "Vui lòng tải lên ảnh sản phẩm"));
        }
        
        // Xử lý ngày tạo
        LocalDate ngayTao;
        try {
            String ngayTaoStr = sanpham.get("ngayTao");
            if (ngayTaoStr != null && !ngayTaoStr.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                ngayTao = LocalDate.parse(ngayTaoStr, formatter);
            } else {
                ngayTao = LocalDate.now(); // Nếu người dùng không điền ngày sẽ tự động lấy ngày hôm nay
            }
        } catch (DateTimeParseException ex) {
            ngayTao = LocalDate.now();
        }
        
        String moTa = sanpham.get("moTa");
        
        if(moTa.length() > 20)
        {
            msg.add(new Message("er_moTa", "Mô tả sản phẩm chỉ được tối đa 20 kí tự"));
        }
        
        if (!msg.isEmpty()) {
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
        
        SanPham objSP = new SanPham();
        
        objSP.setMaSanPham(maSanPham);
        objSP.setTenSanPham(sanpham.get("tenSanPham"));
        objSP.setGiaSanPham(giaSanPham);
        objSP.setTonKho(tonKho);
        objSP.setLoaiSanPham(sanpham.get("loaiSanPham"));
        objSP.setAnhSanPham(tenFile);
        objSP.setMoTa(moTa);
        objSP.setNoiDung(sanpham.get("noiDung"));
        objSP.setNgayTao(ngayTao);
        objSP.setTenNguoiTao(onlineUser);
        objSP.setDaDuyet(0);
        objSP.setMauSac(sanpham.get("mauSac"));
        
        boolean ketQua = sanPhamService.add(objSP);
        
        if (ketQua) {
            return new ResponseEntity<SanPham>(objSP, HttpStatus.OK);
        }
        
        Message msg1 = new Message("er_sanPham", "Thêm mới sản phẩm thất bại");
        return new ResponseEntity<Message>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PutMapping(value = "/sanpham/capnhat/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> capNhat(@PathVariable("id") String maSanPham,
                                     @RequestParam Map<String, String> sanpham,
                                     @RequestParam(value = "fUpload", required = false) MultipartFile fUpload) {
        
        List<Message> msg = new ArrayList<Message>();
        SanPham objSP = sanPhamService.findById(maSanPham);
        
        if(objSP == null) {
            Message msg1 = new Message("er_maSanPham", "Không tìm thấy sản phẩm với mã: " + maSanPham);
            return new ResponseEntity<Message>(msg1, HttpStatus.BAD_REQUEST);
        }
        
        int giaSanPham = 1000, tonKho = 0;
        
        //Bắt lỗi giá sản phẩm
        try {
            giaSanPham = Integer.parseInt(sanpham.get("giaSanPham"));
            
            //Kiểm tra giá trị tối tiểu
            if (giaSanPham < 1000) {
                msg.add(new Message("er_giaSanPham", "Giá sản phẩm phải lớn hơn 1000đ"));
            }
        } catch (NumberFormatException ex) {
            msg.add(new Message("er_giaSanPham", "Giá sản phẩm phải là số nguyên dương"));
        }
        
        //Bắt lỗi tồn kho
        try {
            tonKho = Integer.parseInt(sanpham.get("tonKho"));
            
            //Kiểm tra giá trị tối tiểu
            if (tonKho < 0) {
                msg.add(new Message("er_tonKho", "Số lượng tồn kho phải là số nguyên dương"));
            }
        } catch (NumberFormatException ex) {
            msg.add(new Message("er_tonKho", "Số lượng tồn kho phải là số nguyên dương"));
        }
        
        String tenFile = "";
        if (objSP != null) {
            tenFile = objSP.getAnhSanPham();
        }
        String loaiFile = "";
        
        //Xu ly upload file
        if (fUpload != null && !fUpload.isEmpty()) {
            try {
                String fileUpload = xuLyUploadFile(fUpload);
                
                String[] uploadInfo = fileUpload.split(",");
                
                tenFile = uploadInfo[0];
                loaiFile = uploadInfo[1];
                
                if (!loaiFile.equals("jpg") && !loaiFile.equals("png")) {
                    msg.add(new Message("er_image", "Chỉ cho phép tải file ảnh jpg hoặc png"));
                }
            } catch (Exception ex) {
                msg.add(new Message("er_image", "Có lỗi khi tải ảnh"));
            }
        }
        
        // Xử lý ngày tạo
        LocalDate ngayTao;
        try {
            String ngayTaoStr = sanpham.get("ngayTao");
            if (ngayTaoStr != null && !ngayTaoStr.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                ngayTao = LocalDate.parse(ngayTaoStr, formatter);
            } else {
                ngayTao = LocalDate.now(); // Nếu người dùng không điền ngày sẽ tự động lấy ngày hôm nay
            }
        } catch (DateTimeParseException ex) {
            ngayTao = objSP.getNgayTao();
        }
        
        if (!msg.isEmpty()) {
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
        
        objSP.setTenSanPham(sanpham.get("tenSanPham"));
        objSP.setGiaSanPham(giaSanPham);
        objSP.setTonKho(tonKho);
        objSP.setLoaiSanPham(sanpham.get("loaiSanPham"));
        objSP.setAnhSanPham(tenFile);
        objSP.setMoTa(sanpham.get("moTa"));
        objSP.setNoiDung(sanpham.get("noiDung"));
        objSP.setNgayTao(ngayTao);
        objSP.setNgayCapNhap(LocalDate.now());
        objSP.setMauSac(sanpham.get("mauSac"));
        
        boolean ketQua = sanPhamService.update(objSP);
        
        if (ketQua) {
            return new ResponseEntity<SanPham>(objSP, HttpStatus.OK);
        }
        
        Message msg2 = new Message("er_sanPham", "Cập nhật sản phẩm thất bại");
        return new ResponseEntity<Message>(msg2, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @DeleteMapping("/sanpham/xoa/{id}")
    public ResponseEntity<?> xoa(@PathVariable("id") String maSanPham)
    {
        SanPham objSP = sanPhamService.findById(maSanPham);
        
        if(objSP == null)
        {
            Message msg = new Message("er_maSanPham", "Không tìm thấy sản phẩm với mã: " + maSanPham);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
        else
        {
            boolean ketQua = sanPhamService.delete(maSanPham);
            
            if(ketQua)
            {
                Message msg = new Message("ok_sanPham", "Xóa thành công sản phẩm với mã: " + maSanPham);
                return new ResponseEntity<Message>(msg, HttpStatus.OK);
            }
            
            Message msg = new Message("er_sanPham", "Không thể xóa thông tin đang được sử dụng. Vui lòng kiểm tra lại");
            return new ResponseEntity<Message>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping(value = "/sanpham/duyet/{id}")
    public ResponseEntity<?> duyetSanPham(@ModelAttribute("Online_User") String onlineUser, @PathVariable("id") String maSanPham) {
        
        SanPham objSP = sanPhamService.findById(maSanPham);
        
        if(objSP == null)
        {
            Message msg = new Message("er_maSanPham", "Không tìm thấy sản phẩm với mã: " + maSanPham);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
        else
        {
            objSP.setNgayDuyet(LocalDate.now());
            objSP.setTenNguoiDuyet(onlineUser);
            objSP.setDaDuyet(1);
            
            boolean ketQua = sanPhamService.update(objSP);
            
            if(ketQua)
            {
                Message msg = new Message("ok_sanPham", "Duyệt thành công sản phẩm với mã: " + maSanPham);
                return new ResponseEntity<Message>(msg, HttpStatus.OK);
            }
            
            Message msg = new Message("er_sanPham", "Không thể duyệt sản phẩm với mã: " + maSanPham);
            return new ResponseEntity<Message>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
