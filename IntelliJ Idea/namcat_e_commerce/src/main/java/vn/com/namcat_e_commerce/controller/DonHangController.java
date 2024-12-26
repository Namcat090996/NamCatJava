package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.com.namcat_e_commerce.entities.*;
import vn.com.namcat_e_commerce.service.DonHangService;
import vn.com.namcat_e_commerce.service.GioHangService;
import vn.com.namcat_e_commerce.service.NguoiDungSevice;
import vn.com.namcat_e_commerce.service.TrangThaiService;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"Online_User", "Online_User_VaiTro"})
public class DonHangController {
    
    @Autowired
    DonHangService donHangService;
    
    @Autowired
    GioHangService gioHangService;
    
    @Autowired
    NguoiDungSevice nguoiDungSevice;
    
    @Autowired
    TrangThaiService trangThaiService;
    
    @RequestMapping(value = "/donhang")
    public String hienThiDonHang(Model model, HttpSession session)
    {
        List<DonHang> lstDH = new ArrayList<DonHang>();
        List<GioHang> lstGH = new ArrayList<GioHang>();
        
        String nguoiDung = "";
        int soLuong = 0;
        
        if(session.getAttribute("user_Online") != null)
        {
            nguoiDung = session.getAttribute("user_Online").toString();
            lstGH = gioHangService.layDSGioHangTheoTenNguoiDung(nguoiDung);
            soLuong = lstGH.size();
            
            //Lấy ds đơn hàng
            lstDH = donHangService.layDSDonHangByTenND(nguoiDung);
            
            model.addAttribute("lstDH", lstDH);
            model.addAttribute("SoLuong", soLuong);
            model.addAttribute("User_Online", nguoiDung);
            
            return "donhang";
        }
        
        return "redirect:/login2";
    }
    
    @RequestMapping(value = "/admin/donhang")
    public String hienThiDonHangAdmin(@ModelAttribute("Online_User") String onlineUser, @ModelAttribute("Online_User_VaiTro") String vaiTroUser, @ModelAttribute("donhang") DonHang objDH, Model model)
    {
        //Get list and return page
        List<DonHang> lStDH = donHangService.layDSDonHangTheoTNDvaTT(objDH.getTenNguoiDung(), objDH.getTrangThai());
        
        //Keep user information which has typed
        model.addAttribute("donhang", objDH);
        model.addAttribute("lStDH", lStDH);
        model.addAttribute("Online_User", onlineUser);
        model.addAttribute("Online_User_VaiTro", vaiTroUser);
        
        return "admin/QuanLyDonHang";
    }
    
    @ModelAttribute("lstND")
    public List<NguoiDung> layDanhSachTND()
    {
        //Get list
        List<NguoiDung> lstTND = nguoiDungSevice.getList();
        
        //Return result
        return lstTND;
    }
    
    @ModelAttribute("lstTrangThai")
    public List<TrangThai> layDanhSachTrangThai()
    {
        //Get list
        List<TrangThai> lstTrangThai = trangThaiService.getList();
        
        //Return result
        return lstTrangThai;
    }
}
