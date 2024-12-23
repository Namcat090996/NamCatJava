package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.namcat_e_commerce.entities.AnhSanPham;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.service.AnhSanPhamService;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api")
@SessionAttributes("Online_User")
public class SanPhamApiController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @Autowired
    AnhSanPhamService anhSanPhamService;
    
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
    
    public List<String> xuLyUploadFile(MultipartFile[] fUpload) throws IOException {
        
        List<String> danhSachAnh = new ArrayList<String>();
        
        for(MultipartFile file : fUpload)
        {
            String tenFile = file.getOriginalFilename();
            
            String loaiFile = "";
            
            String duongDan = fUploadPath;
            
            Path directory = Paths.get(duongDan);
            
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            
            Path filePath = directory.resolve(tenFile);
            
            file.transferTo(filePath.toFile());
            
            if (tenFile.contains(".") && tenFile.lastIndexOf(".") != 0) {
                loaiFile = tenFile.substring(tenFile.lastIndexOf(".") + 1).toLowerCase();
            }
            
            danhSachAnh.add(tenFile + "," + loaiFile);
        }

        return danhSachAnh;
    }
    
    @PostMapping(value = "/sanpham/themmoi", consumes = {"multipart/form-data"})
    public ResponseEntity<?> themMoi(@ModelAttribute("Online_User") String onlineUser, @RequestParam Map<String, String> sanpham, @RequestParam(value = "fUpload", required = false) MultipartFile[] fUpload) {
        
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
        
        //Bắt lỗi mô tả
        String moTa = sanpham.get("moTa");
        
        if(moTa.length() > 20)
        {
            msg.add(new Message("er_moTa", "Mô tả sản phẩm chỉ được tối đa 20 kí tự"));
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
        
        if (!msg.isEmpty()) {
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
        
        SanPham objSP = new SanPham();
        
        objSP.setMaSanPham(maSanPham);
        objSP.setTenSanPham(sanpham.get("tenSanPham"));
        objSP.setGiaSanPham(giaSanPham);
        objSP.setTonKho(tonKho);
        objSP.setLoaiSanPham(sanpham.get("loaiSanPham"));
        objSP.setMoTa(moTa);
        objSP.setNoiDung(sanpham.get("noiDung"));
        objSP.setNgayTao(ngayTao);
        objSP.setTenNguoiTao(onlineUser);
        objSP.setDaDuyet(0);
        objSP.setMauSac(sanpham.get("mauSac"));
        
        boolean ketQua = sanPhamService.add(objSP);
        
        //Xu ly upload file
        if(fUpload != null && fUpload.length > 0) {
            
            String tenFile = "";
            String loaiFile = "";
            
            try {
                List<String> files = xuLyUploadFile(fUpload);
                
                for(String file : files)
                {
                    AnhSanPham objAnhSP = new AnhSanPham();
                    String[] uploadInfo = file.split(",");
                    
                    tenFile = uploadInfo[0];
                    loaiFile = uploadInfo[1];
                    if (!loaiFile.equals("jpg") && !loaiFile.equals("png")) {
                        ketQua = sanPhamService.delete(objSP.getMaSanPham());
                        msg.add(new Message("er_image", "Chỉ cho phép tải file ảnh jpg hoặc png"));
                        return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
                    }
                    
                    objAnhSP.setMaSanPham(maSanPham);
                    objAnhSP.setAnhSanPham(tenFile);
                    
                    boolean kqAnh = anhSanPhamService.add(objAnhSP);
                }
                
                //Gán ảnh chính là ảnh đầu tiên
                String[] thongTinAnhDauTien = files.get(0).split(",");
                String tenAnh = thongTinAnhDauTien[0];
                objSP.setAnhSanPham(tenAnh);
                
                ketQua = sanPhamService.update(objSP);
                
            } catch (Exception ex) {
                ketQua = sanPhamService.delete(objSP.getMaSanPham());
                msg.add(new Message("er_image", "Có lỗi khi tải ảnh lên"));
                return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
            }
        }
        else {
            ketQua = sanPhamService.delete(objSP.getMaSanPham());
            msg.add(new Message("er_image", "Vui lòng tải lên ít nhất 01 ảnh sản phẩm"));
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
        
        if (ketQua) {
            return new ResponseEntity<SanPham>(objSP, HttpStatus.OK);
        }
        
        Message msg1 = new Message("er_sanPham", "Thêm mới sản phẩm thất bại");
        return new ResponseEntity<Message>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PutMapping(value = "/sanpham/capnhat/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> capNhat(@PathVariable("id") String maSanPham,
                                     @RequestParam Map<String, String> sanpham,
                                     @RequestParam(value = "fUpload", required = false) MultipartFile[] fUpload) {
        
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
        
        //Xu ly upload file
        if(fUpload != null && fUpload.length > 0) {
            
            String tenFile = "";
            String loaiFile = "";
            
            try {
                //Xử lý ảnh
                List<String> files = xuLyUploadFile(fUpload);
                
                //Lấy ds ảnh cũ để so sánh
                List<AnhSanPham> lstASPOld = anhSanPhamService.timTheoMaSP(maSanPham);
                
                //Tạo danh sách ảnh cũ cần xóa(không có trong list mới)
                List<AnhSanPham> anhCanXoa = new ArrayList<>();
                
                //Tạo danh sách ảnh mới
                List<String> lstAnhMoi = new ArrayList<>();
                
                //Lấy danh sách ảnh mới
                for(String anh : files)
                {
                    String[] uploadInfo = anh.split(",");
                    tenFile = uploadInfo[0];
                    loaiFile = uploadInfo[1];
                    lstAnhMoi.add(tenFile);
                    if (!loaiFile.equals("jpg") && !loaiFile.equals("png")) {
                        msg.add(new Message("er_image", "Chỉ cho phép tải file ảnh jpg hoặc png"));
                        return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
                    }
                }
                
                //Tạo danh sách ảnh mới cần thêm (chỉ chứa tên ảnh)
                List<String> anhCanThem = new ArrayList<>(lstAnhMoi);
                
                // So sánh danh sách cũ và mới
                for (AnhSanPham anhCu : lstASPOld) {
                    boolean tonTai = false;
                    for (String anhMoi : lstAnhMoi) {
                        if (anhCu.getAnhSanPham().equals(anhMoi)) {
                            tonTai = true;
                            anhCanThem.remove(anhMoi); // Đã tồn tại, không cần thêm
                            break;
                        }
                    }
                    if (!tonTai) {
                        anhCanXoa.add(anhCu); // Ảnh cũ không tồn tại trong danh sách mới, cần xóa
                    }
                }
                
                // Xóa ảnh cũ không còn tồn tại
                for (AnhSanPham anh : anhCanXoa) {
                    anhSanPhamService.delete(anh.getId());
                }
                
                for(String anhMoi : anhCanThem)
                {
                    AnhSanPham objASP = new AnhSanPham();
                    objASP.setMaSanPham(maSanPham);
                    objASP.setAnhSanPham(anhMoi);
                    
                    boolean kqAnh = anhSanPhamService.add(objASP);
                }

                //Gán ảnh chính
                if(!anhCanThem.isEmpty()) {
                    String tenAnh = anhCanThem.get(0);
                    objSP.setAnhSanPham(tenAnh);
                }
                
            } catch (Exception ex) {
                msg.add(new Message("er_image", "Có lỗi khi tải ảnh lên"));
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
    
    @PostMapping(value = "/sanpham/duyet")
    public ResponseEntity<?> xyLyDuyetHoacBoDuyet(@RequestParam("sanPhamChon") String sanPhamChon, @RequestParam("thaoTac") String thaoTac, @ModelAttribute("Online_User") String onlineUser) {
        
        //Chuyển chuỗi mã sản phẩm thành danh sách
        String[] arr_maSP = sanPhamChon.split(";");
        List<String> lstMaSP = Arrays.stream(arr_maSP).toList();
        
        try {
            if(thaoTac.equals("duyet")) {
                for(String maSP : lstMaSP) {
                    SanPham objSP = sanPhamService.findById(maSP);
                    
                    objSP.setNgayDuyet(LocalDate.now());
                    objSP.setTenNguoiDuyet(onlineUser);
                    objSP.setDaDuyet(1);
                    
                    boolean ketQua = sanPhamService.update(objSP);
                }
            }
            else if(thaoTac.equals("boDuyet")) {
                for(String maSP : lstMaSP) {
                    SanPham objSP = sanPhamService.findById(maSP);
                    
                    objSP.setNgayDuyet(null);
                    objSP.setTenNguoiDuyet(null);
                    objSP.setDaDuyet(0);
                    
                    boolean ketQua = sanPhamService.update(objSP);
                }
            }
            else {
                Message msg = new Message("er_thaoTac", "Thao tác không hợp lệ");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception ex) {
            Message msg = new Message("er_duyet", "Có lỗi xảy ra khi thực hiện duyệt sản phẩm");
            return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
        }
        
        Message msg = new Message("er_duyetTC", "Duyệt thành công các sản phẩm đã chọn");
        return new ResponseEntity<Message>(msg, HttpStatus.OK);
    }
    

}
