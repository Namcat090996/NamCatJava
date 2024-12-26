package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.namcat_e_commerce.entities.DonHang;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.service.DonHangService;
import vn.com.namcat_e_commerce.service.GioHangService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DonHangController {
    
    @Autowired
    DonHangService donHangService;
    
    @Autowired
    GioHangService gioHangService;
    
    @RequestMapping(value = "/donhang")
    public String hienThiDonHang(Model model, HttpSession session)
    {
        List<DonHang> lstDH = new ArrayList<DonHang>();
        List<GioHang> lstGH = new ArrayList<GioHang>();
        
        String nguoiDung = "";
        int soLuong = 0;
        
        if(session.getAttribute("user_Online") != null)
        {
            nguoiDung = session.getAttribute("user_Online").toString();
            lstGH = gioHangService.layDSGioHangTheoTenNguoiDung(nguoiDung);
            soLuong = lstGH.size();
            
            //Lấy ds đơn hàng
            lstDH = donHangService.layDSDonHangByTenND(nguoiDung);
            
            model.addAttribute("lstDH", lstDH);
            model.addAttribute("SoLuong", soLuong);
            model.addAttribute("User_Online", nguoiDung);
            
            return "donhang";
        }
        
        return "redirect:/login2";
    }
    
}
