package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.service.SanPhamService;


@Controller
public class SinglePageController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @RequestMapping(value = "/chitiet/{id}")
    public String hienThiChiTiet(Model model, @PathVariable("id") String maSP)
    {
        SanPham objSP = sanPhamService.findById(maSP);
        
        model.addAttribute("objSP", objSP);
        
        return "single-product";
    }
}
