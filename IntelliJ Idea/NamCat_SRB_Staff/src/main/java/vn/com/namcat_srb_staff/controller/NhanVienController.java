package vn.com.namcat_srb_staff.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_srb_staff.entities.*;
import vn.com.namcat_srb_staff.service.ChucVuService;
import vn.com.namcat_srb_staff.service.HeSoLuongService;
import vn.com.namcat_srb_staff.service.NhanVienService;
import vn.com.namcat_srb_staff.service.PhongBanService;

import java.util.List;

@Controller
public class NhanVienController {
    
    @Autowired
    NhanVienService nhanVienService;
    
    @Autowired
    PhongBanService phongBanService;
    
    @Autowired
    ChucVuService chucVuService;
    
    @Autowired
    HeSoLuongService heSoLuongService;
    
    @RequestMapping(value = "/admin/nhanvien")
    public String hienThiDanhSachNV(@ModelAttribute("nhanvien") NhanVienModel objNV, Model model)
    {
        //Keep user information which has typed
        model.addAttribute("nhanvien", objNV);
        
        //Get list and return page
        List<NhanVienModel> lstNV = nhanVienService.layBangLuongNhanVien(objNV.getTuKhoa(), objNV.getMaPhong(), objNV.getMaChucVu());
        
        model.addAttribute("lstNV", lstNV);
        
        return "admin/QuanLyNhanVien";
    }
    
    @RequestMapping(value = "/admin/nhanvien/them")
    public String hienThiThemMoiNV(Model model)
    {
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("maNVCheck", "");
        
        return "admin/NhanVienAdd";
    }
    
    @RequestMapping(value = "/admin/nhanvien/sua/{id}")
    public String hienThiChiTietNV(@PathVariable("id") String maNV, Model model)
    {
        //Get object by id
        NhanVien objNV = nhanVienService.layChiTiet(maNV);
        
        model.addAttribute("nhanvien", objNV);
        model.addAttribute("maNVCheck", maNV);
        
        return "admin/NhanVienAdd";
    }
    
    @RequestMapping(value = "/admin/nhanvien/themMoiNV", method = RequestMethod.POST)
    public String themMoiHoacSuaNhanVien(@ModelAttribute("nhanvien") @Valid NhanVien objNV, BindingResult result, @RequestParam("idCheck") String idCheck, Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("nhanvien", objNV);
            return "admin/NhanVienAdd";
        }
        else
        {
            boolean isInsert = true;
            
            if(objNV.getHeSoId() == 0)
            {
                model.addAttribute("heSoError", "Bạn phải chọn hệ số lương");
                return "admin/NhanVienAdd";
            }
            
            if(!idCheck.isEmpty())
            {
                isInsert = false;
            }
            
            boolean ketQua = false;
            
            if(isInsert)
            {
                NhanVien objNVCheck = nhanVienService.layChiTiet(objNV.getMaNV());
                
                if(objNVCheck == null)
                {
                    ketQua = nhanVienService.themMoi(objNV);
                }
                else
                {
                    model.addAttribute("duplicatedId", "Mã nhân viên này đã tồn tại");
                    model.addAttribute("nhanvien", objNV);
                    return "admin/NhanVienAdd";
                }
            }
            else
            {
                ketQua = nhanVienService.capNhat(objNV);
            }
            
            if(ketQua)
            {
                return "redirect:/admin/nhanvien";
            }
            
            return "admin/NhanVienAdd";
        }
    }
    
    @RequestMapping(value = "/admin/nhanvien/xoa/{id}")
    public String xoaThongTinNV(@PathVariable("id") String maNV, Model model)
    {
        NhanVien objNV = nhanVienService.layChiTiet(maNV);
        
        boolean ketQua = false;
        
        if(objNV != null)
        {
            try {
                ketQua = nhanVienService.xoa(maNV);
                if(ketQua)
                {
                    return "redirect:/admin/nhanvien";
                }
            }
            catch (DataIntegrityViolationException ex)
            {
                model.addAttribute("deleteFail","Không thể xóa thông tin này");
            }
        }
        
        List<NhanVienModel> lstNV = nhanVienService.layBangLuongNhanVien("","","");
        
        model.addAttribute("lstNV", lstNV);
        
        return "admin/QuanLyNhanVien";
    }
    
    @ModelAttribute("lstChucVu")
    public List<ChucVu> hienThiDanhSachChucVu()
    {
        //Get list
        List<ChucVu> lstChucVu = chucVuService.layDanhSachChucVu();
        
        //Return result
        return lstChucVu;
    }
    
    @ModelAttribute("lstPhongBan")
    public List<PhongBan> hienThiDanhSachPhongBan()
    {
        //Get list
        List<PhongBan> lstPhongBan = phongBanService.layDanhSachPhongBan();
        
        //Return result
        return lstPhongBan;
    }
    
    @ModelAttribute("lstHSLuong")
    public List<HeSoLuong> hienThiDanhSachHSLuong()
    {
        //Get list
        List<HeSoLuong> lstHSLuong = heSoLuongService.layDanhSachHSLuong();
        
        //Return result
        return lstHSLuong;
    }
}
