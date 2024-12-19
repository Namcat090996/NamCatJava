package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.model.GioHangDao;
import vn.com.namcat_e_commerce.service.GioHangService;

@Controller
@SessionAttributes("Online_User")
public class GioHangController {
    
    @Autowired
    GioHangService gioHangService;
    
    @Autowired
    GioHangDao gioHangDao;

    @RequestMapping(value = "/giohang/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> themHangVaoGio(@PathVariable("id") String maSanPham, @ModelAttribute("Online_User") String userOnline, Model model, HttpSession session) {
        
        //Kiểm tra đã đăng nhập hay chưa
        if(session != null && session.getAttribute("userOnline") != null) {
            
            //Kiểm tra thêm userOnline nếu lấy từ session về không thành công
            if(userOnline == null || userOnline.isEmpty())
            {
                Message msg = new Message("GH_login_invalid", "Người dùng không tồn tại");
                return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
            }
            
            GioHang objGH = gioHangService.layChiTietGH_TND_MSP(userOnline, maSanPham);
            boolean ketQua = false;
            
            if(objGH != null) {
                //Kiểm tra hàng đã có trong giỏ hay chưa
                if(gioHangService.kiemTraGH_TND_MSP(userOnline, maSanPham))
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
        }
        else {
            Message msg = new Message("GH_login", "Vui lòng đăng nhập");
            return new ResponseEntity<Message>(msg,HttpStatus.BAD_REQUEST);
        }
        
        //Nếu lỗi không xác định
        Message msg = new Message("GH_error", "Đã xảy ra lỗi");
        return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
}
