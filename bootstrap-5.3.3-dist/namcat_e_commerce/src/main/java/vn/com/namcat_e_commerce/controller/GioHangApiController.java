package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.model.GioHangDao;
import vn.com.namcat_e_commerce.service.GioHangService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class GioHangApiController {
    
    @Autowired
    GioHangService gioHangService;
    
    @Autowired
    GioHangDao gioHangDao;
    
    @RequestMapping(value = "/giohang/them/{id}")
    public ResponseEntity<?> themHangVaoGio(@PathVariable("id") String maSanPham, HttpSession session) {
        
        String userOnline = (String) session.getAttribute("user_Online");
        
        if(userOnline == null || userOnline.isEmpty())
        {
            Message msg = new Message("GH_login", "Vui lòng đăng nhập");
            return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
        }
        
        try {
            GioHang objGH = gioHangService.layChiTietGH_TND_MSP(userOnline, maSanPham);
            boolean ketQua = false;
            
            //Kiểm tra hàng đã có trong giỏ hay chưa
            if(objGH != null)
            {
                objGH.setSoLuong(objGH.getSoLuong() + 1);
                ketQua = gioHangDao.update(objGH);
            }
            else
            {
                objGH = new GioHang();
                objGH.setTenNguoiDung(userOnline);
                objGH.setMaSanPham(maSanPham);
                objGH.setSoLuong(1);
                ketQua = gioHangDao.add(objGH);
            }
            
            if(ketQua)
            {
                Message msg = new Message("GH_success", "Thêm mới/ cập nhật giỏ hàng thành công");
                return new ResponseEntity<Message>(msg,HttpStatus.OK);
            }
            else
            {
                Message msg = new Message("GH_fail", "Thêm mới/ cập nhật giỏ hàng thất bại");
                return new ResponseEntity<Message>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            Message msg = new Message("GH_error", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại");
            return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
