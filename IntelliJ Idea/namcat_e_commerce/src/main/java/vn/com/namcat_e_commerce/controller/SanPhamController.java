package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.namcat_e_commerce.entities.LoaiSanPham;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.entities.SanPhamModel;
import vn.com.namcat_e_commerce.service.LoaiSPService;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.util.List;

@Controller
public class SanPhamController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @Autowired
    LoaiSPService loaiSPService;
    
    @RequestMapping(value = "/admin/sanpham")
    public String hienThiSPTheoTenVaLoai(@ModelAttribute("sanpham") SanPhamModel objSP, Model model)
    {
        //Get list and return page
        List<SanPham> lstSP = sanPhamService.timSPTheoTenVaLoai(objSP.getTuKhoa(), objSP.getLoaiSP());
        
        //Keep user information which has typed
        model.addAttribute("vanban", objSP);
        
        model.addAttribute("lstSP", lstSP);
        
        return "admin/SanPhamCallAPI";
    }
    
    @ModelAttribute("lstLoaiSP")
    public List<LoaiSanPham> layDanhSachLoaiSP()
    {
        //Get list
        List<LoaiSanPham> lstLoaiSP = loaiSPService.getList();
        
        //Return result
        return lstLoaiSP;
    }
    
}
