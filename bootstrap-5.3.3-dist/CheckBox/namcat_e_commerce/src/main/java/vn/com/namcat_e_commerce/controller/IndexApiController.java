package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.service.NguoiDungSevice;
import vn.com.namcat_e_commerce.service.SanPhamService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class IndexApiController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @GetMapping("/sanpham/xemnhanh/{id}")
    public ResponseEntity<?> xemNhanhSP(@PathVariable("id") String id) {
        
        SanPham objSP = sanPhamService.findById(id);
        
        if(objSP != null) {
            
            String giaSPFormat = String.format("%,dđ", objSP.getGiaSanPham());
            
            objSP.setGiaTienFormat(giaSPFormat);
            
            return new ResponseEntity<SanPham>(objSP, HttpStatus.OK);
        }
        else {
            Message msg = new Message("not_found_qv", "Không tìm thấy sản phẩm với mã: " + id);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
    }
}
