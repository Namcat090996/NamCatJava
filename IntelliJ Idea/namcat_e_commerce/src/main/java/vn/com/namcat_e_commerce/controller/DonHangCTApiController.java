package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.DonHangChiTiet;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.service.DHChiTietService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class DonHangCTApiController {
    
    @Autowired
    DHChiTietService dhChiTietService;
    
    @GetMapping("/donhang/xemnhanh/{id}")
    public ResponseEntity<?> xemNhanhDH(@PathVariable("id") String maDH) {
        
        List<DonHangChiTiet> lstDHCT = dhChiTietService.layDSDonHangCTByMaDH(maDH);
        
        if(lstDHCT != null && !lstDHCT.isEmpty()) {
            
            return new ResponseEntity<List<DonHangChiTiet>>(lstDHCT, HttpStatus.OK);
        }
        else {
            Message msg = new Message("not_found", "Không tìm thấy đơn hàng với mã: " + maDH);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
    }
}
