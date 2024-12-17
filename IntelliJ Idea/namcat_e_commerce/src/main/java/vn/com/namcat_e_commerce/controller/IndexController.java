package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.util.List;

@Controller
public class IndexController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @RequestMapping(value = "/trangchu")
    public String hienThiIndex(Model model)
    {
        //Get list and return page
        List<SanPham> lstSP = sanPhamService.getList();
        
        model.addAttribute("lstSP", lstSP);
        
        return "index";
    }
}
