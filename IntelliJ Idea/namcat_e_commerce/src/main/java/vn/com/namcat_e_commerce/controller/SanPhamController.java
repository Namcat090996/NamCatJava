package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.namcat_e_commerce.entities.*;
import vn.com.namcat_e_commerce.service.*;

import java.util.List;

@Controller
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
    public String hienThiSPTheoTenVaLoai(@ModelAttribute("sanpham") SanPhamModel objSP, Model model)
    {
        //Get list and return page
        List<SanPham> lstSP = sanPhamService.timSPTheoLoaiVaGiaKhongDuyet(objSP.getTuKhoa(), objSP.getLoaiSP(), objSP.getMauSac(), objSP.getTuGia(), objSP.getDenGia(), objSP.getDaDuyet());

        //Keep user information which has typed
        model.addAttribute("vanban", objSP);

        model.addAttribute("lstSP", lstSP);

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
    
    @ModelAttribute("Online_User")
    public String layThongTinUserOnline(HttpSession session)
    {
        return (String) session.getAttribute("userOnline");
    }
}
