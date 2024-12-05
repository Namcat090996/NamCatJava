package vn.com.stanford_workingapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import vn.com.stanford_workingapi.entities.ChuDe;
import vn.com.stanford_workingapi.entities.Message;
import vn.com.stanford_workingapi.service.ChuDeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ChuDeApiController {

    @Autowired
    ChuDeService chuDeService;
    @Autowired
    private View error;
    
    @GetMapping("/chude")
    public ResponseEntity<List<ChuDe>> layDanhSach() {
        List<ChuDe> lstChuDe = chuDeService.layDanhSach();
        
        return new ResponseEntity<List<ChuDe>>(lstChuDe, HttpStatus.OK);
    }
    
    @GetMapping("/chude/{id}")
    public ResponseEntity<?> layChiTiet(@PathVariable("id") String id) {
        ChuDe chuDe = chuDeService.layChiTiet(id);
        
        if(chuDe != null)
        {
            return new ResponseEntity<ChuDe>(chuDe, HttpStatus.OK);
        }
        else
        {
            Message err = new Message("Khong tim thay chu de co ma: " + id);
            return new ResponseEntity<Message>(err, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/chude")
    public ResponseEntity<?> themMoiChuDe(@Valid @RequestBody ChuDe chuDe, BindingResult result, @RequestParam("fUpload") MultipartFile fUpload) {
        
        List<Message> msg = new ArrayList<Message>();
        
        if(result.hasErrors())
        {
            for(FieldError fieldError : result.getFieldErrors())
            {
                msg.add(new Message(fieldError.getField(), fieldError.getDefaultMessage()));
            }
            
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
        
        ChuDe objCD = chuDeService.layChiTiet(chuDe.getMaChuDe());
        
        if(objCD != null)
        {
            msg.add(new Message("maChuDe", "Ma chu de nay da ton tai"));
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
        
        if(fUpload.isEmpty()) {
            msg.add(new Message("fUpload", "Vui lòng tải lên 01 tệp"));
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
        
        boolean ketQua = chuDeService.themMoi(chuDe);
        
        if(ketQua) {
            return new ResponseEntity<>(objCD, HttpStatus.CREATED);
        }
        else {
            msg.add(new Message("general", "Không thể thêm văn bản"));
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
    }
}
