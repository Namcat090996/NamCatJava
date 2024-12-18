package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.namcat_e_commerce.entities.DaDuyet;
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
        List<SanPham> lstSPHot = sanPhamService.layDSHot();
        List<SanPham> lstSPNew = sanPhamService.layDSNew();
        List<SanPham> lstSlider = sanPhamService.layDSSlider();
        List<SanPham> lstDienThoai = sanPhamService.layDSDienThoai();
        List<SanPham> lstManHinh = sanPhamService.layDSManHinh();
        
        model.addAttribute("lstSPHot", lstSPHot);
        model.addAttribute("lstDSNew", lstSPNew);
        model.addAttribute("lstSlider", lstSlider);
        model.addAttribute("lstDienThoai", lstDienThoai);
        model.addAttribute("lstManHinh", lstManHinh);
        
        return "index";
    }
    
    @RequestMapping(value = "/sanpham/xemnhanh", method = RequestMethod.GET)
    public String hienThiModalXemNhanh(@RequestParam(value = "maXemNhanh", required = false) String maSP, Model model)
    {
        //Get object
        SanPham objSP = sanPhamService.findById(maSP);
        
        model.addAttribute("objSPQuick", objSP);
        
        return "index :: modalContent";
    }
    
    
    
    
}
