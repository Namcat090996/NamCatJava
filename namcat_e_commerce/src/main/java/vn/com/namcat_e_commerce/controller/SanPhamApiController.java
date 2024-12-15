package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<?> themMoi(@RequestParam Map<String, String> sanpham,
                                     @RequestParam(value = "fUpload", required = false) MultipartFile fUpload,
                                     HttpSession session) {
        
        //Lấy mã văn bản đầu vào
        String maSanPham = sanpham.get("maSanPham");
        
        if(!maSanPham.matches("^[A-Za-z0-9]+$")) {
            Message msg = new Message("er_maSanPham", "Mã sản phẩm chỉ bao gồm các kí tự chữ cái và số");
            return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
        }
        
        SanPham objSPCheck = sanPhamService.findById(maSanPham);
        
        //Kiểm tra sản phẩm đã tồn tại chưa
        if(objSPCheck != null) {
            Message msg = new Message("er_maSanPham", "Mã sản phẩm này đã tồn tại");
            return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
        }
        else
        {
            int giaSanPham = 1000, tonKho = 0;
            
            //Kiểm tra tên sản phẩm đã tồn tại chưa
            boolean tonTai = sanPhamService.kiemTraTenDaTonTai(sanpham.get("tenSanPham"));
            
            if(tonTai)
            {
                Message msg = new Message("er_tenSanPham", "Tên sản phẩm này đã tồn tại");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
            }
            
            //Bắt lỗi giá sản phẩm
            try {
                giaSanPham = Integer.parseInt(sanpham.get("giaSanPham"));
                
                //Kiểm tra giá trị tối tiểu
                if(giaSanPham < 1000)
                {
                    Message msg = new Message("er_giaSanPham", "Giá sản phẩm phải lớn hơn 1000đ");
                    return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
                }
            }
            catch (NumberFormatException ex)
            {
                Message msg = new Message("er_giaSanPham", "Giá sản phẩm phải là số nguyên dương");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
            }
            
            //Bắt lỗi tồn kho
            try {
                tonKho = Integer.parseInt(sanpham.get("tonKho"));
                
                //Kiểm tra giá trị tối tiểu
                if(tonKho < 0)
                {
                    Message msg = new Message("er_tonKho", "Số lượng tồn kho phải là số nguyên dương");
                    return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
                }
            }
            catch (NumberFormatException ex)
            {
                Message msg = new Message("er_tonKho", "Số lượng tồn kho phải là số nguyên dương");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
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
    
                    if(!loaiFile.equals("img") && !loaiFile.equals("png"))
                    {
                        Message msg = new Message("er_image", "Chỉ cho phép tải file ảnh img hoặc png");
                        return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
                    }
                } catch (Exception ex) {
                    Message msg = new Message("er_image", "Có lỗi khi tải ảnh");
                    return new ResponseEntity<Message>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                Message msg = new Message("er_image", "Vui lòng tải lên ảnh sản phẩm");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
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
                Message msg = new Message("er_ngayTao", "Ngày tạo không đúng định dạng (yyyy-MM-dd)");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
            }
            
            //Lấy tên người tạo
            String tenNguoiTao = (String) session.getAttribute("userOnline");
            
            SanPham objSP = new SanPham();
            
            objSP.setMaSanPham(maSanPham);
            objSP.setTenSanPham(sanpham.get("tenSanPham"));
            objSP.setGiaSanPham(giaSanPham);
            objSP.setTonKho(tonKho);
            objSP.setLoaiSanPham(sanpham.get("loaiSanPham"));
            objSP.setAnhSanPham(tenFile);
            objSP.setMoTa(sanpham.get("moTa"));
            objSP.setNoiDung(sanpham.get("noiDung"));
            objSP.setNgayTao(ngayTao);
            objSP.setTenNguoiTao(tenNguoiTao);
            objSP.setDaDuyet(0);
            objSP.setMauSac(sanpham.get("mauSac"));
            
            boolean ketQua = sanPhamService.add(objSP);
            
            if (ketQua) {
                return new ResponseEntity<SanPham>(objSP, HttpStatus.OK);
            } else {
                Message msg = new Message("er_sanPham", "Thêm mới sản phẩm thất bại");
                return new ResponseEntity<Message>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
        }
    }
    
    @PutMapping(value = "/sanpham/capnhat/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> capNhat(@PathVariable("id") String maSanPham,
                                     @RequestParam Map<String, String> sanpham,
                                     @RequestParam(value = "fUpload", required = false) MultipartFile fUpload) {
        
        SanPham objSP = sanPhamService.findById(maSanPham);
        
        if(objSP == null) {
            Message msg = new Message("er_maSanPham", "Không tìm thấy sản phẩm với mã: " + maSanPham);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
        else
        {
            int giaSanPham = 1000, tonKho = 0;
            
            //Kiểm tra tên sản phẩm đã tồn tại chưa
            boolean tonTai = sanPhamService.kiemTraTenDaTonTai(sanpham.get("tenSanPham"));
            
            if(tonTai)
            {
                Message msg = new Message("er_tenSanPham", "Tên sản phẩm này đã tồn tại");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
            }
            
            //Bắt lỗi giá sản phẩm
            try {
                giaSanPham = Integer.parseInt(sanpham.get("giaSanPham"));
                
                //Kiểm tra giá trị tối tiểu
                if(giaSanPham < 1000)
                {
                    Message msg = new Message("er_giaSanPham", "Giá sản phẩm phải lớn hơn 1000đ");
                    return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
                }
            }
            catch (NumberFormatException ex)
            {
                Message msg = new Message("er_giaSanPham", "Giá sản phẩm phải là số nguyên dương");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
            }
            
            //Bắt lỗi tồn kho
            try {
                tonKho = Integer.parseInt(sanpham.get("tonKho"));
                
                //Kiểm tra giá trị tối tiểu
                if(tonKho < 0)
                {
                    Message msg = new Message("er_tonKho", "Số lượng tồn kho phải là số nguyên dương");
                    return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
                }
            }
            catch (NumberFormatException ex)
            {
                Message msg = new Message("er_tonKho", "Số lượng tồn kho phải là số nguyên dương");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
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
                    
                    if(!loaiFile.equals("img") && !loaiFile.equals("png"))
                    {
                        Message msg = new Message("er_image", "Chỉ cho phép tải file ảnh img hoặc png");
                        return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
                    }
                } catch (Exception ex) {
                    Message msg = new Message("er_image", "Có lỗi khi tải ảnh");
                    return new ResponseEntity<Message>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                Message msg = new Message("er_image", "Vui lòng tải lên ảnh sản phẩm");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
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
                Message msg = new Message("er_ngayTao", "Ngày tạo không đúng định dạng (yyyy-MM-dd)");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
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
            } else {
                Message msg = new Message("er_sanPham", "Cập nhật sản phẩm thất bại");
                return new ResponseEntity<Message>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
        }
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
            
            Message msg = new Message("er_sanPham", "Không thể xóa sản phẩm với mã: " + maSanPham);
            return new ResponseEntity<Message>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping(value = "/sanpham/duyet/{id}")
    public ResponseEntity<?> duyetSanPham(@PathVariable("id") String maSanPham, HttpSession session) {
        
        SanPham objSP = sanPhamService.findById(maSanPham);
        
        if(objSP == null)
        {
            Message msg = new Message("er_maSanPham", "Không tìm thấy sản phẩm với mã: " + maSanPham);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
        else
        {
            //Lấy tên người duyệt
            String tenNguoiDuyet = (String) session.getAttribute("userOnline");
            
            objSP.setNgayDuyet(LocalDate.now());
            objSP.setTenNguoiDuyet(tenNguoiDuyet);
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
