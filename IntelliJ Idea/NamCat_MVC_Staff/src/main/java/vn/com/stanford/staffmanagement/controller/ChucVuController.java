package vn.com.stanford.staffmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.stanford.staffmanagement.entities.ChucVu;
import vn.com.stanford.staffmanagement.service.ChucVuService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChucVuController {

    @Autowired
    ChucVuService chucVuService;

    @RequestMapping(value = "/admin/chucvu", method = RequestMethod.GET)
    public String hienThiDanhSachChucVu(Model model)
    {
        //Get chucvu list
        List<ChucVu> lstChucVu = chucVuService.layDanhSach();

        //Add to model
        model.addAttribute("lstChucVu", lstChucVu);

        //Return result
        return "admin/QuanLyChucVu";
    }
}
