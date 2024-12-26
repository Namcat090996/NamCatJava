package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.com.namcat_e_commerce.entities.*;
import vn.com.namcat_e_commerce.service.*;

import java.util.List;

@Controller
@SessionAttributes({"Online_User", "Online_User_VaiTro"})
public class SanPhamController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @Autowired
    LoaiSPService loaiSPService;
    
    @Autowired
    MauSacService mauSacService;
    
    @Autowired
    GiaTienService giaTienService;
    
    @Autowired
    DaDuyetService daDuyetService;
    
    @RequestMapping(value = "/admin/sanpham")
    public String hienThiSPTheoTenVaLoai(@ModelAttribute("Online_User") String onlineUser, @ModelAttribute("Online_User_VaiTro") String vaiTroUser, @ModelAttribute("sanpham") SanPhamModel objSP, Model model)
    {
        //Get list and return page
        List<SanPham> lstSP = sanPhamService.timSPTheoLoaiVaGiaKhongDuyet(objSP.getTuKhoa(), objSP.getLoaiSP(), objSP.getMauSac(), objSP.getTuGia(), objSP.getDenGia(), objSP.getDaDuyet());

        //Keep user information which has typed
        model.addAttribute("sanpham", objSP);
        model.addAttribute("lstSP", lstSP);
        model.addAttribute("Online_User", onlineUser);
        model.addAttribute("Online_User_VaiTro", vaiTroUser);

        return "admin/QuanLySanPham";
    }
    
    @ModelAttribute("lstLoaiSP")
    public List<LoaiSanPham> layDanhSachLoaiSP()
    {
        //Get list
        List<LoaiSanPham> lstLoaiSP = loaiSPService.getList();
        
        //Return result
        return lstLoaiSP;
    }
    
    @ModelAttribute("lstDaDuyet")
    public List<DaDuyet> layDanhSachDaDuyet()
    {
        //Get list
        List<DaDuyet> lstDaDuyet = daDuyetService.getList();
        
        //Return result
        return lstDaDuyet;
    }
    
    @ModelAttribute("lstMauSac")
    public List<MauSac> layDanhSachMauSac()
    {
        //Get list
        List<MauSac> lstMauSac = mauSacService.getList();
        
        //Return result
        return lstMauSac;
    }
    
    @ModelAttribute("lstGiaTien")
    public List<GiaTien> layDanhSachGiaTien()
    {
        //Get list
        List<GiaTien> lstGiaTien = giaTienService.getList();

        //Return result
        return lstGiaTien;
    }
    
}
