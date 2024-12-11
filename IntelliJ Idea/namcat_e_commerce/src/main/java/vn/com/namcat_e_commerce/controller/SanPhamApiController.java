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
public class SanPhamApiController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @GetMapping("/sanpham/{id}")
    public ResponseEntity<?> layChiTiet(@PathVariable("id") int id) {
        
        SanPham objSP = sanPhamService.findById(id);
        
        if(objSP != null) {
            return new ResponseEntity<SanPham>(objSP, HttpStatus.OK);
        }
        else {
            Message msg = new Message("not_found", "Không tìm thấy chủ đề có mã: " + id);
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
    public ResponseEntity<?> themMoi(@RequestParam Map<String, String> sanpham, @RequestParam(value = "fUpload", required = false) MultipartFile fUpload) {
        
        List<Message> msg = new ArrayList<>();
        
        try {
            //Bắt lỗi giá sản phẩm
            double giaSanPham = Double.parseDouble(sanpham.get("giaSanPham"));
            
            if(giaSanPham < 1)
            {
                msg.add(new Message("toiThieu_SP", "Giá sản phẩm phải là số nguyên dương"));
                return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
            }
            
            //Math.floor để làm tròn đến số nguyên lớn nhất (không lớn hơn giá trị gốc)
            if(giaSanPham != Math.floor(giaSanPham))
            {
                msg.add(new Message("soNguyen_SP", "Giá sản phẩm phải là số nguyên dương"));
                return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
            }
        }
        catch (NumberFormatException ex)
        {
            msg.add(new Message("dinhDang_SP", "Giá sản phẩm phải là số nguyên dương"));
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
        
        //Bắt lỗi tồn kho
        try {
            double tonKho = Double.parseDouble(sanpham.get("tonKho"));
            
            if(tonKho < 1)
            {
                msg.add(new Message("toiThieu_TK", "Số lượng tồn kho phải là số nguyên dương"));
                return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
            }
            
            //Math.floor để làm tròn đến số nguyên lớn nhất (không lớn hơn giá trị gốc)
            if(tonKho != Math.floor(tonKho))
            {
                msg.add(new Message("soNguyen_TK", "Số lượng tồn kho phải là số nguyên dương"));
                return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
            }
        }
        catch (NumberFormatException ex)
        {
            msg.add(new Message("dinhDang_TK", "Số lượng tồn kho phải là số nguyên dương"));
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
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
                    msg1.add(new Message("dinhDang", "Chỉ cho phép tải file ảnh img hoặc png"));
                    return new ResponseEntity<List<Message>>(msg1, HttpStatus.BAD_REQUEST);
                }
            } catch (Exception ex) {
                msg1.add(new Message("anhLoi", "Có lỗi khi tải ảnh"));
                return new ResponseEntity<List<Message>>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            msg1.add(new Message("thieuAnh", "Vui lòng tải lên ảnh sản phẩm"));
            return new ResponseEntity<List<Message>>(msg1, HttpStatus.BAD_REQUEST);
        }
        
        // Xử lý ngày tạo
        LocalDate ngayTao;
        try {
            String ngayTaoStr = vanban.get("ngayTao");
            if (ngayTaoStr != null && !ngayTaoStr.isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                ngayTao = LocalDate.parse(ngayTaoStr, formatter);
            } else {
                ngayTao = LocalDate.now(); // Nếu người dùng không điền ngày sẽ tự động lấy ngày hôm nay
            }
        } catch (DateTimeParseException ex) {
            msg1.add(new Message("dinhDangNgay", "Ngày tạo không đúng định dạng (yyyy-MM-dd)"));
            return new ResponseEntity<>(msg1, HttpStatus.BAD_REQUEST);
        }
        
        VanBan objVB = new VanBan();
        
        objVB.setMaVanBan(maVanBan);
        objVB.setTieuDe(vanban.get("tieuDe"));
        objVB.setMoTa(vanban.get("moTa"));
        objVB.setNoiDung(vanban.get("noiDung"));
        objVB.setNgayTao(ngayTao);
        objVB.setNgayCapNhat(LocalDate.now());
        objVB.setTenFile(tenFile);
        objVB.setDinhDang(loaiFile);
        objVB.setSoTrang(soTrang);
        objVB.setLoaiVanBan(vanban.get("loaiVanBan"));
        objVB.setDonVi(vanban.get("donVi"));
        
        boolean ketQua = vanBanService.themVanBan(objVB);
        
        if (ketQua) {
            return new ResponseEntity<VanBan>(objVB, HttpStatus.OK);
        } else {
            msg1.add(new Message("vanBan", "Khong the them moi van ban"));
            return new ResponseEntity<List<Message>>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    

}
