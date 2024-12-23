package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.*;
import vn.com.namcat_e_commerce.service.AnhSanPhamService;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.util.List;

@Controller
@SessionAttributes({"Online_User", "Online_User_VaiTro"})
public class AnhSanPhamController {
    
    @Autowired
    AnhSanPhamService anhSanPhamService;
    
    @Autowired
    SanPhamService sanPhamService;
    
    @RequestMapping(value = "/admin/anhsanpham", method = RequestMethod.GET)
    public String timKiemAnhSanPham(@ModelAttribute("Online_User") String onlineUser, @ModelAttribute("Online_User_VaiTro") String vaiTroUser, @ModelAttribute("sanpham") SanPhamModel objSP, Model model)
    {
        //Get list and return page
        List<AnhSanPham> lstASP = anhSanPhamService.layDanhSachAnh(objSP.getTuKhoa());
        
        model.addAttribute("sanpham", objSP);
        model.addAttribute("lstASP", lstASP);
        model.addAttribute("Online_User", onlineUser);
        model.addAttribute("Online_User_VaiTro", vaiTroUser);
        
        if(vaiTroUser.equals("admin")) {
            return "admin/QuanLyAnhSanPham";
        }
        
        return "redirect:/login";
    }
    
    @ModelAttribute("lstSP")
    public List<SanPham> layDanhSachMaSanPham()
    {
        //Get list
        List<SanPham> lstSP = sanPhamService.getList();
        
        //Return result
        return lstSP;
    }
}
