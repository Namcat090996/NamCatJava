package vn.com.stanford.workingrestfulapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.stanford.workingrestfulapi.entities.ChuDe;
import vn.com.stanford.workingrestfulapi.entities.Message;
import vn.com.stanford.workingrestfulapi.service.ChuDeService;

import java.util.List;

@RestController
@RequestMapping("api")
public class ChuDeApiController {
    
    @Autowired
    ChuDeService chuDeService;
    
    @GetMapping("/chude")
    public ResponseEntity<List<ChuDe>> layDanhSach() {
        //Lay danh sach
        List<ChuDe> lstChuDe = chuDeService.layDanhSach();
        
        return new ResponseEntity<List<ChuDe>>(lstChuDe, HttpStatus.OK);
    }
    
    @GetMapping("/chude/{id}")
    public ResponseEntity<?> layChiTietTheoMa(@PathVariable("id") String id) {
        ChuDe objCD = chuDeService.layChiTiet(id);
        
        if(objCD != null)
        {
            return new ResponseEntity<ChuDe>(objCD, HttpStatus.OK);
        }
        else
        {
            Message err = new Message("Khong tim thay chu de co ma: " + id);
            return new ResponseEntity<Message>(err, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/chude")
    public ResponseEntity<?> themMoiChuDe(@RequestBody ChuDe objCD)
    {
        boolean kq = chuDeService.themMoi(objCD);
        
        if(kq)
        {
            return new ResponseEntity<ChuDe>(objCD, HttpStatus.OK);
        }
        
        Message msg = new Message("Khong the them moi chu de");
        
        return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/chude/{id}")
    public ResponseEntity<?> capNhatChuDe(@PathVariable("id") String id, @RequestBody ChuDe objCD)
    {
        ChuDe objCD1 = chuDeService.layChiTiet(id);
        
        if(objCD1 == null)
        {
            Message msg = new Message("Khong tim thay chu de co ma: " + id);
            
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
        else
        {
            boolean kq = chuDeService.capNhat(objCD);
            
            if(kq)
            {
                return new ResponseEntity<ChuDe>(objCD, HttpStatus.OK);
            }
            else
            {
                Message msg2 = new Message("Khong cap nhat duoc chu de co ma: " + id);
                
                return new ResponseEntity<Message>(msg2, HttpStatus.NOT_MODIFIED);
            }
        }
    }
    
    @DeleteMapping("/chude/{id}")
    public ResponseEntity<?> capNhatChuDe(@PathVariable("id") String id)
    {
        ChuDe objCD = chuDeService.layChiTiet(id);
        
        if(objCD == null)
        {
            Message msg = new Message("Khong tim thay chu de co ma: " + id);
            
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
        else
        {
            boolean kq = chuDeService.xoa(id);
            
            if(kq)
            {
                return new ResponseEntity<ChuDe>(objCD, HttpStatus.OK);
            }
            else
            {
                Message msg2 = new Message("Khong xoa duoc chu de co ma: " + id);
                
                return new ResponseEntity<Message>(msg2, HttpStatus.NOT_FOUND);
            }
        }
    }
    
}
