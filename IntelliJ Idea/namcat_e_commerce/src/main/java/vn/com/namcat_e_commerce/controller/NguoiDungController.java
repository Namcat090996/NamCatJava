package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.*;
import vn.com.namcat_e_commerce.service.NguoiDungSevice;
import vn.com.namcat_e_commerce.service.VaiTroService;

import java.util.List;

@Controller
@SessionAttributes({"Online_User", "Online_User_VaiTro"})
public class NguoiDungController {
    
    @Autowired
    NguoiDungSevice nguoiDungSevice;
    
    @Autowired
    VaiTroService vaiTroService;
    
    @RequestMapping(value = "/admin/nguoidung")
    public String timKiemNguoiDung(@ModelAttribute("Online_User") String onlineUser, @ModelAttribute("Online_User_VaiTro") String vaiTroUser, @RequestParam(value ="tuKhoa", required = false) String tuKhoa, Model model)
    {
        //Get list and return page
        List<NguoiDung> lstND = nguoiDungSevice.timNguoiDung(tuKhoa);
        
        model.addAttribute("tuKhoa", tuKhoa);
        model.addAttribute("lstND", lstND);
        model.addAttribute("Online_User", onlineUser);
        model.addAttribute("Online_User_VaiTro", vaiTroUser);
        
        if(vaiTroUser.equals("admin")) {
            return "admin/QuanLyNguoiDung";
        }
        
        return "redirect:/login";
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
