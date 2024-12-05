package vn.com.stanford.workingrestfulapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.stanford.workingrestfulapi.entities.ChuDe;
import vn.com.stanford.workingrestfulapi.entities.Message;
import vn.com.stanford.workingrestfulapi.service.ChuDeService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ChuDeApiController {

@Autowired
ChuDeService chuDeService;

@GetMapping("/chude")
public ResponseEntity<List<ChuDe>> layDanhSach() {

    //Lấy danh sách
    List<ChuDe> lstChuDe = chuDeService.layDanhSach();

    return new ResponseEntity<List<ChuDe>>(lstChuDe, HttpStatus.OK);
}

@GetMapping("/chude/{id}")
public ResponseEntity<?> layChiTietTheoMa(@PathVariable("id") String id)
{
    ChuDe objCD = chuDeService.layChiTiet(id);

    if(objCD != null)
    {
        return new ResponseEntity<ChuDe>(objCD, HttpStatus.OK);
    }
    else
    {
        Message err = new Message("Không tìm thấy chủ đề có mã: " + id);
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

    Message msg = new Message("Không thể thêm mới chủ đề");
    return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
}

@PutMapping("/chude/{id}")
public ResponseEntity<?> capNhatChuDe(@PathVariable("id") String id, @RequestBody ChuDe objCD)
    {
        ChuDe objCD2 = chuDeService.layChiTiet(id);


        if(objCD2 == null)
        {
            Message msg = new Message("Không thể tìm thấy chủ đề có mã: " + id);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
        {
            boolean kq = chuDeService.capNhat(objCD);
            if(kq)
            {
                return new ResponseEntity<ChuDe>(objCD, HttpStatus.OK);
            }
            else
            {
                Message msg = new Message("Không cập nhật được chủ đề có mã: " + id);
                return new ResponseEntity<Message>(msg, HttpStatus.NOT_MODIFIED);
            }
        }
    }

    @DeleteMapping("/chude/{id}")
    public ResponseEntity<?> xoaChuDe(@PathVariable("id") String id)
    {
        ChuDe objCD = chuDeService.layChiTiet(id);

        if(objCD == null)
        {
            Message msg = new Message("Không thể tìm thấy chủ đề có mã: " + id);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
        {
            boolean kq = chuDeService.xoa(id);
            if(kq)
            {
                Message msg = new Message("Xóa chủ đề có mã: " + id + " thành công");
                return new ResponseEntity<Message>(msg, HttpStatus.OK);
            }
            else
            {
                Message msg = new Message("Không xóa được chủ đề có mã: " + id);
                return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
            }
        }
    }
}
