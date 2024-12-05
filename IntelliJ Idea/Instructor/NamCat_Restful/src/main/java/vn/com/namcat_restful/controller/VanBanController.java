package vn.com.namcat_restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.namcat_restful.entities.DonVi;
import vn.com.namcat_restful.entities.LoaiVanBan;
import vn.com.namcat_restful.entities.VanBan;
import vn.com.namcat_restful.entities.VanBanModel;
import vn.com.namcat_restful.service.DonViService;
import vn.com.namcat_restful.service.LoaiVBService;
import vn.com.namcat_restful.service.VanBanService;

import java.util.List;

@Controller
public class VanBanController {
    
    @Autowired
    VanBanService vanBanService;
    
    @Autowired
    DonViService donViService;
    
    @Autowired
    LoaiVBService loaiVBService;
    
    @RequestMapping(value = "/admin/vanban")
    public String hienThiVanBanTheoNgay(@ModelAttribute("vanban") VanBanModel objVB, Model model)
    {
        
        //Get list and return page
        List<VanBan> lstVB = vanBanService.timKiemVanBanTheoNgay(objVB.getTuKhoa(), objVB.getLoaiVanBan(), objVB.getDonVi(), objVB.getTuNgay(), objVB.getDenNgay());
        
        //Keep user information which has typed
        model.addAttribute("vanban", objVB);
        
        model.addAttribute("lstVB", lstVB);
        
        return "admin/QuanLyVanBan";
    }
    
    @ModelAttribute("lstLoaiVB")
    public List<LoaiVanBan> layDanhSachLoaiVB()
    {
        //Get list
        List<LoaiVanBan> lstLoaiVB = loaiVBService.layDSLoaiVB();
        
        //Return result
        return lstLoaiVB;
    }
    
    @ModelAttribute("lstDonVi")
    public List<DonVi> layDanhSachDonVi()
    {
        //Get list
        List<DonVi> lstDonVi = donViService.layDSDonVi();
        
        //Return result
        return lstDonVi;
    }
}
