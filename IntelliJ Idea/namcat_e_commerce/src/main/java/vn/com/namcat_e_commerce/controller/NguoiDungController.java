package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.namcat_e_commerce.entities.*;
import vn.com.namcat_e_commerce.service.GiaTienService;
import vn.com.namcat_e_commerce.service.NguoiDungSevice;
import vn.com.namcat_e_commerce.service.VaiTroService;

import java.util.List;

@Controller
public class NguoiDungController {
    
    @Autowired
    NguoiDungSevice nguoiDungSevice;
    
    @Autowired
    VaiTroService vaiTroService;
    
    @RequestMapping(value = "/admin/nguoidung", method = RequestMethod.GET)
    public String timKiemNguoiDung(@RequestParam(value = "tuKhoa", required = false) String tuKhoa, Model model)
    {
        //Get list and return page
        List<NguoiDung> lstND = nguoiDungSevice.timNguoiDung(tuKhoa);
        
        model.addAttribute("tuKhoa", tuKhoa);
        model.addAttribute("lstND", lstND);
        
        return "admin/QuanLyNguoiDung";
    }
    
    @ModelAttribute("lstVaiTro")
    public List<VaiTro> layDanhSachVaiTro()
    {
        //Get list
        List<VaiTro> lstVaiTro = vaiTroService.getList();
        
        //Return result
        return lstVaiTro;
    }
}
