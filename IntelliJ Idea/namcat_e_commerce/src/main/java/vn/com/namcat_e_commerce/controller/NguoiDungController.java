package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.entities.SanPhamModel;
import vn.com.namcat_e_commerce.service.GiaTienService;
import vn.com.namcat_e_commerce.service.NguoiDungSevice;

import java.util.List;

@Controller
public class NguoiDungController {
    
    @Autowired
    NguoiDungSevice nguoiDungSevice;
    
    @RequestMapping(value = "/admin/nguoidung")
    public String hienThiSPTheoTenVaLoai(Model model)
    {
        //Get list and return page
        List<NguoiDung> lstND = nguoiDungSevice.getList();
        
        model.addAttribute("lstND", lstND);
        
        return "admin/QuanLyNguoiDung";
    }
}
