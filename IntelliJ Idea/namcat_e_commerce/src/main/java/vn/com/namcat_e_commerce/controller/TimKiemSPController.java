package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.service.GioHangService;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.util.List;
import java.util.Map;

@Controller
public class TimKiemSPController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @Autowired
    GioHangService gioHangService;
    
    @RequestMapping(value = "/timkiem", method = RequestMethod.GET)
    public String timKiemSanPham(@RequestParam(value = "tuKhoa", required = false) String tuKhoa, Model model, HttpSession session)
    {
        if(tuKhoa == null)
        {
            tuKhoa = "";
        }
        
        //Get list and return page
        List<SanPham> lstSP = sanPhamService.timSPTheoTuKhoa(tuKhoa);
        int soLuongSP = lstSP.size();
        
        String nguoiDung = "";
        long soLuong = 0;
        
        if(session.getAttribute("user_Online") != null)
        {
            nguoiDung = session.getAttribute("user_Online").toString();
            soLuong = gioHangService.soLuongGH_TND(nguoiDung);
            model.addAttribute("User_Online", nguoiDung);
            model.addAttribute("SoLuong", soLuong);
        }
        
        model.addAttribute("tuKhoa", tuKhoa);
        model.addAttribute("lstSP", lstSP);
        model.addAttribute("soLuongSP", soLuongSP);
        
        return "timkiem";
    }
    
    @RequestMapping(value = "/timkiem/chitiet", method = RequestMethod.POST)
    public String timKiemChiTietSP(@RequestParam Map<String, String> lstLuaChon, HttpSession session) {
        
        String id = "";
        String soLuong = "";
        boolean ketQua = false;
        
        for (Map.Entry<String, String> gioHang : lstLuaChon.entrySet()) {
            try {
                id = gioHang.getKey();
                soLuong = gioHang.getValue();
                
            } catch (Exception ex) {
                System.out.println("Key và Value không phải dạng số");
                ex.printStackTrace();
            }
        }
        
        return "404";
    }
}
