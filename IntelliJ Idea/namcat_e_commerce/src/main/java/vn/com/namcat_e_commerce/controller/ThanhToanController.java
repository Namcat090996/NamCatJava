package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.namcat_e_commerce.entities.DonHang;
import vn.com.namcat_e_commerce.entities.DonHangChiTiet;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.service.DHChiTietService;
import vn.com.namcat_e_commerce.service.DonHangService;
import vn.com.namcat_e_commerce.service.GioHangService;
import vn.com.namcat_e_commerce.service.NguoiDungSevice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ThanhToanController {
    
    @Autowired
    NguoiDungSevice nguoiDungSevice;
    
    @Autowired
    GioHangService gioHangService;
    
    @Autowired
    DonHangService donHangService;
    
    @Autowired
    DHChiTietService dhChiTietService;
    
    @RequestMapping(value = "/dathang")
    public String datHang(HttpSession session, Model model) {
        
        List<GioHang> lstGH = new ArrayList<GioHang>();
        String nguoiDung = "";
        int soLuong = 0;
        int tongTienGH = 0;
        
        if(session.getAttribute("user_Online") != null)
        {
            nguoiDung = session.getAttribute("user_Online").toString();
            lstGH = gioHangService.layDSGioHangTheoTenNguoiDung(nguoiDung);
            soLuong = lstGH.size();
            for(GioHang gh : lstGH)
            {
                tongTienGH += gh.getTongTien();
            }
            
            NguoiDung objND = nguoiDungSevice.findById(nguoiDung);
            
            model.addAttribute("lstGH", lstGH);
            model.addAttribute("objND", objND);
            model.addAttribute("SoLuong", soLuong);
            model.addAttribute("User_Online", nguoiDung);
            model.addAttribute("tongTienGH", tongTienGH);
            
            return "checkout";
        }
        
        return "redirect:/login2";
    }
    
    @RequestMapping(value = "/dathang/thanhtoan")
    public String thanhToanSanPham(@ModelAttribute("objND") @Valid DonHang objND, BindingResult result, @RequestParam(value = "ghiChu", required = false) String ghiChu, HttpSession session, Model model) {
        
        DonHang objDH = new DonHang();
        DonHangChiTiet objDHCT;
        List<GioHang> lstGH = new ArrayList<GioHang>();
        String nguoiDung = "";
        int soLuong = 0;
        int tongTienDH = 0;
        boolean donHang = false, donHangCT = false;
        
        if(session.getAttribute("user_Online") != null)
        {
            nguoiDung = session.getAttribute("user_Online").toString();
            lstGH = gioHangService.layDSGioHangTheoTenNguoiDung(nguoiDung);
            soLuong = lstGH.size();
            for (GioHang gh : lstGH) {
                tongTienDH += gh.getTongTien();
            }
            
            model.addAttribute("SoLuong", soLuong);
            model.addAttribute("User_Online", nguoiDung);
            
            if (result.hasErrors()) {
                model.addAttribute("lstGH", lstGH);
                model.addAttribute("objND", objND);
                model.addAttribute("tongTienGH", tongTienDH);
                return "checkout";
            }
            
            String maDH = taoMaDonHang(nguoiDung);
            
            //Tạo đơn hàng
            objDH.setMaDonHang(maDH);
            objDH.setTenNguoiDung(nguoiDung);
            objDH.setNgayTao(LocalDate.now());
            objDH.setTrangThai("PENDING");
            objDH.setTongTien(tongTienDH);
            objDH.setTenDonHang("Electronics");
            objDH.setHoTen(objND.getHoTen());
            objDH.setDiaChi(objND.getDiaChi());
            objDH.setEmail(objND.getEmail());
            objDH.setDienThoai(objND.getDienThoai());
            objDH.setGhiChu(ghiChu);
            
            try {
                donHang = donHangService.add(objDH);
                
                for (GioHang gh : lstGH) {
                    objDHCT = new DonHangChiTiet();
                    
                    //Tạo đơn hàng chi tiết
                    objDHCT.setMaDonHang(maDH);
                    objDHCT.setMaSanPham(gh.getMaSanPham());
                    objDHCT.setSoLuong(gh.getSoLuong());
                    objDHCT.setGiaSanPham(gh.getTongTien());
                    objDHCT.setTenSanPham(gh.getTenSanPham());
                    
                    donHangCT = dhChiTietService.add(objDHCT);
                    
                    if (!donHangCT) {
                        return "404";
                    }
                }
                
                if (donHang) {
                    return "order_success";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            return "404";
        } else {
            return "redirect:/login2";
        }
    }
    
    public String taoMaDonHang(String tenNguoiDung) {
        
        // Đếm số lượng đơn hàng đã tạo bởi người dùng
        long soLuongDH = donHangService.soLuongDHByNguoiDung(tenNguoiDung);
        
        if(soLuongDH > 0)
        {
            // Tăng dần thứ tự
            long soDonHangTiepTheo = soLuongDH + 1;
            
            // Tạo mã đơn hàng, đánh số đơn hàng phải đủ 4 số, không đủ thì tự chèn số 0 phía trước
            return "ORD_" + tenNguoiDung.toUpperCase() + "_" + String.format("%04d", soDonHangTiepTheo);
        }
        else
        {
            // Tạo mã đơn hàng, đánh số đơn hàng phải đủ 4 số, không đủ thì tự chèn số 0 phía trước
            return "ORD_" + tenNguoiDung.toUpperCase() + "_0001";
        }
    }
}
