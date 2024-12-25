package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.namcat_e_commerce.entities.*;
import vn.com.namcat_e_commerce.service.GioHangService;
import vn.com.namcat_e_commerce.service.LoaiSPService;
import vn.com.namcat_e_commerce.service.MauSacService;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TimKiemSPController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @Autowired
    GioHangService gioHangService;
    
    @Autowired
    MauSacService mauSacService;
    
    @Autowired
    LoaiSPService loaiSPService;
    
    @RequestMapping(value = "/timkiem")
    public String timKiemSanPham(@RequestParam(value = "tuKhoa", required = false) String tuKhoa, @RequestParam(value = "lstLoaiSP", required = false) List<String> lstLoaiSP, @RequestParam(value = "lstMauSac", required = false) List<String> lstMauSac,@RequestParam(value = "price_order", required = false) String order, Model model, HttpSession session)
    {
        List<SanPham> lstSP = new ArrayList<>();
        int soLuongSP = 0;
        
        if(tuKhoa != null) {
            //Get list and return page
            lstSP = sanPhamService.timSPTheoTuKhoa(tuKhoa);
            soLuongSP = lstSP.size();
            model.addAttribute("tuKhoa", tuKhoa);
        }
        else {
            //Get list and return page
            lstSP = sanPhamService.timSPTheoLoaiVaGiaDaDuyet(lstLoaiSP, order, lstMauSac, 0, 0);
            soLuongSP = lstSP.size();
            model.addAttribute("lstLSP", lstLoaiSP);
            model.addAttribute("lstMS", lstMauSac);
            model.addAttribute("order", order);
        }
        
        model.addAttribute("lstSP", lstSP);
        model.addAttribute("soLuongSP", soLuongSP);
        
        String nguoiDung = "";
        long soLuong = 0;
        
        if(session.getAttribute("user_Online") != null)
        {
            nguoiDung = session.getAttribute("user_Online").toString();
            soLuong = gioHangService.soLuongGH_TND(nguoiDung);
            model.addAttribute("User_Online", nguoiDung);
            model.addAttribute("SoLuong", soLuong);
        }
        
        return "timkiem";
    }
    
    @ModelAttribute("lstTatCaMauSac")
    public List<MauSac> layDanhSachMauSac()
    {
        //Get list
        List<MauSac> lstMauSac = mauSacService.getList();
        
        //Return result
        return lstMauSac;
    }
    
    @ModelAttribute("lstTatCaLoaiSP")
    public List<LoaiSanPham> layDanhSachLoaiSP()
    {
        //Get list
        List<LoaiSanPham> lstLoaiSP = loaiSPService.getList();
        
        //Return result
        return lstLoaiSP;
    }
}
