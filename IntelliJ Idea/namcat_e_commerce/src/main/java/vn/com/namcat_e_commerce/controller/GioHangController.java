package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.service.GioHangService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GioHangController {
    
    @Autowired
    GioHangService gioHangService;
    
    @RequestMapping(value = "/giohang/xoa/{id}")
    public String xoaGioHang(@PathVariable("id") Integer id, HttpSession session)
    {
        if(session.getAttribute("user_Online") != null)
        {
            GioHang objGH = gioHangService.timGioHang(id);
            
            boolean ketQua = false;
            
            if(objGH != null)
            {
                try {
                    ketQua = gioHangService.xoa(id);
                    if(ketQua)
                    {
                        return "redirect:/giohang";
                    }
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                    return "404";
                }
            }
            
            return "404";
        }
        else
        {
            return "redirect:/login2";
        }
        
    }
    
    @RequestMapping(value = "/giohang")
    public String hienThiGioHang(Model model, HttpSession session)
    {
        List<GioHang> lstGH = new ArrayList<GioHang>();
        
        String nguoiDung = "";
        int soLuong = 0;
        long tongTienGH = 0;
        
        if(session.getAttribute("user_Online") != null)
        {
            nguoiDung = session.getAttribute("user_Online").toString();
            lstGH = gioHangService.layDSGioHangTheoTenNguoiDung(nguoiDung);
            soLuong = lstGH.size();
            for(GioHang gh : lstGH)
            {
                tongTienGH += gh.getTongTien();
            }
            
            model.addAttribute("lstGH", lstGH);
            model.addAttribute("SoLuong", soLuong);
            model.addAttribute("User_Online", nguoiDung);
            model.addAttribute("tongTienGH", tongTienGH);
            
            return "giohang";
        }
        
        return "redirect:/login2";
    }
    
    @RequestMapping(value = "/giohang/capnhat")
    public String capNhatGioHang(@RequestParam Map<String, String> lstGioHang, HttpSession session) {
        
        int id = 0;
        int soLuong = 0;
        boolean ketQua = false;
        
        
        for (Map.Entry<String, String> gioHang : lstGioHang.entrySet()) {
            try {
                id = Integer.parseInt(gioHang.getKey());
                soLuong = Integer.parseInt(gioHang.getValue());
                
                GioHang objGH = gioHangService.timGioHang(id);
                
                if (objGH != null) {
                    objGH.setSoLuong(soLuong);
                    objGH.setTongTien(objGH.getGiaSanPham() * soLuong);
                    
                    ketQua = gioHangService.capNhat(objGH);
                }
            } catch (Exception ex) {
                System.out.println("Key và Value không phải dạng số");
                ex.printStackTrace();
            }
        }
        
        if (ketQua || lstGioHang.isEmpty()) {
            return "redirect:/giohang";
        }
        
        return "404";
    }
    
    @RequestMapping(value = "/giohang/xoaAll")
    public String xoaAllGioHang(HttpSession session) {
        
        List<GioHang> lstGH = new ArrayList<GioHang>();
        String nguoiDung = "";
        int soLuong = 0;
        
        if(session.getAttribute("user_Online") != null)
        {
            nguoiDung = session.getAttribute("user_Online").toString();
            lstGH = gioHangService.layDSGioHangTheoTenNguoiDung(nguoiDung);
            soLuong = lstGH.size();
            
            boolean ketQua = false;
            
            if(soLuong > 0) {
                try {
                    ketQua = gioHangService.xoaGHByTenNguoiDung(nguoiDung);
                    if(ketQua)
                    {
                        return "redirect:/giohang";
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return "404";
                }
            }
            else {
                return "redirect:/giohang";
            }
            
            return "404";
        }
        else {
            return "redirect:/login2";
        }
    }
}
