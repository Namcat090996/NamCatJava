package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.model.GioHangDao;
import vn.com.namcat_e_commerce.service.GioHangService;
import vn.com.namcat_e_commerce.service.SanPhamService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class GioHangApiController {
    
    @Autowired
    GioHangService gioHangService;
    
    @Autowired
    GioHangDao gioHangDao;
    
    @Autowired
    SanPhamService sanPhamService;
    
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
            SanPham objSP = sanPhamService.findById(maSanPham);
            boolean ketQua = false;
            
            //Kiểm tra hàng đã có trong giỏ hay chưa
            if(objGH != null)
            {
                int soLuongMoi = objGH.getSoLuong() + 1;
                int giaSanPham = objGH.getGiaSanPham();
                objGH.setSoLuong(soLuongMoi);
                int tongTienMoi = soLuongMoi*giaSanPham;
                objGH.setTongTien(tongTienMoi);
                
                ketQua = gioHangDao.update(objGH);
                
                if(ketQua)
                {
                    Message msg = new Message("GH_update", "Cập nhật giỏ hàng thành công");
                    return new ResponseEntity<Message>(msg,HttpStatus.OK);
                }
            }
            else
            {
                objGH = new GioHang();
                objGH.setTenNguoiDung(userOnline);
                objGH.setMaSanPham(maSanPham);
                objGH.setSoLuong(1);
                objGH.setGiaSanPham(objSP.getGiaSanPham());
                objGH.setTongTien(objSP.getGiaSanPham());
                objGH.setAnhSanPham(objSP.getAnhSanPham());
                objGH.setTenSanPham(objSP.getTenSanPham());
                ketQua = gioHangDao.add(objGH);
                
                if(ketQua)
                {
                    Message msg = new Message("GH_add", "Thêm mới giỏ hàng thành công");
                    return new ResponseEntity<Message>(msg,HttpStatus.OK);
                }
            }

            Message msg = new Message("GH_fail", "Thêm mới/ cập nhật giỏ hàng thất bại");
            return new ResponseEntity<Message>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e) {
            e.printStackTrace();
            Message msg = new Message("GH_error", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại");
            return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
