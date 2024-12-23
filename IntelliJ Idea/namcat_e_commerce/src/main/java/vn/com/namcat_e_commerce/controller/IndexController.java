package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.AnhSanPham;
import vn.com.namcat_e_commerce.entities.DaDuyet;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.service.AnhSanPhamService;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.util.List;

@Controller
public class IndexController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @RequestMapping(value = "/trangchu")
    public String hienThiIndex(Model model, HttpSession session)
    {
        //Get list and return page
        List<SanPham> lstSPHot = sanPhamService.layDSHot();
        List<SanPham> lstSPNew = sanPhamService.layDSNew();
        List<SanPham> lstSlider = sanPhamService.layDSSlider();
        List<SanPham> lstDienThoai = sanPhamService.layDSDienThoai();
        List<SanPham> lstManHinh = sanPhamService.layDSManHinh();
        
        String soLuong = "";
        
        if(session.getAttribute("user_Online") != null)
        {
            soLuong = session.getAttribute("user_Online").toString();
        }
        else
        {
            soLuong = "0";
        }
        
        model.addAttribute("lstSPHot", lstSPHot);
        model.addAttribute("lstDSNew", lstSPNew);
        model.addAttribute("lstSlider", lstSlider);
        model.addAttribute("lstDienThoai", lstDienThoai);
        model.addAttribute("lstManHinh", lstManHinh);
        model.addAttribute("User_Online", soLuong);
        
        return "index";
    }
    

    
}
