package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.service.GioHangService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GioHangController {
    
    @Autowired
    GioHangService gioHangService;
    
    @RequestMapping(value = "/giohang/xoa/{id}")
    public String xoaGioHang(@PathVariable("id") Integer id, Model model)
    {
        GioHang objGH = gioHangService.timGioHang(id);
        
        boolean ketQua = false;
        
        if(objGH != null)
        {
            try {
                ketQua = gioHangService.xoa(id);
                if(ketQua)
                {
                    return "redirect:/giohang";
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        return "redirect:/giohang";
    }
    
    @RequestMapping(value = "/giohang")
    public String hienThiGioHang(Model model, HttpSession session)
    {
        List<GioHang> lstGH = new ArrayList<GioHang>();
        
        String nguoiDung = "";
        String soLuong = "0";
        
        if(session.getAttribute("soLuongGH") != null)
        {
            soLuong = session.getAttribute("soLuongGH").toString();
        }
        
        if(session.getAttribute("user_Online") != null)
        {
            nguoiDung = session.getAttribute("user_Online").toString();
            lstGH = gioHangService.layDSGioHangTheoTenNguoiDung(nguoiDung);
            
            model.addAttribute("lstGH", lstGH);
            model.addAttribute("SoLuong", soLuong);
            model.addAttribute("User_Online", nguoiDung);
            
            return "giohang";
        }
        
        return "redirect:/login2";
    }
}
