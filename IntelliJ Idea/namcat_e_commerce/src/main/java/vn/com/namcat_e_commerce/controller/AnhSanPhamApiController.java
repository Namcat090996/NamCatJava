package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.AnhSanPham;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.service.AnhSanPhamService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class AnhSanPhamApiController {
    
    @Autowired
    AnhSanPhamService anhSanPhamService;
    
    @DeleteMapping("anhsanpham/xoa/{id}")
    public ResponseEntity<?> xoa(@PathVariable("id") Integer id)
    {
        AnhSanPham objASP = anhSanPhamService.findById(id);
        
        if(objASP == null)
        {
            Message msg = new Message("er_anhSanPham", "Không tìm thấy ảnh sản phẩm với id: " + id);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
        else
        {
            boolean ketQua = anhSanPhamService.delete(id);
            
            if(ketQua)
            {
                Message msg = new Message("ok_anhSanPham", "Xóa thành công ảnh sản phẩm với mã: " + id);
                return new ResponseEntity<Message>(msg, HttpStatus.OK);
            }
            
            Message msg = new Message("er_anhSanPham", "Không thể xóa thông tin đang được sử dụng. Vui lòng kiểm tra lại");
            return new ResponseEntity<Message>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
