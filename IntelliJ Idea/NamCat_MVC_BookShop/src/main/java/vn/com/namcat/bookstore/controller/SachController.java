package vn.com.namcat.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.namcat.bookstore.entities.Sach;
import vn.com.namcat.bookstore.service.ChuDeService;
import vn.com.namcat.bookstore.service.SachService;

import java.util.List;

@Controller
public class SachController {

    @Autowired
    SachService sachService;

    @Autowired
    ChuDeService chuDeService;

    @RequestMapping(value = "/admin/sach")
    public String hienThiDanhSach(Model model)
    {
        //Declare list
        List<Sach> lstSach = sachService.layDanhSach();

        //Add to model
        model.addAttribute("lstSach", lstSach);

        //Return result
        return "admin/QuanLySach";
    }

    @RequestMapping(value = "/admin/sach/them")
    public String hienThiThemMoiSach(Model model)
    {
        //Add to model
        model.addAttribute("sach", new Sach());

        //Return result
        return "admin/SachAdd";
    }

    @RequestMapping(value = "/admin/sach/sua/{id}")
    public String hienThiChiTietSach(@PathVariable("id") String maSach, Model model)
    {
        //Get detailed object by id
        Sach objSach = sachService.layChiTiet(maSach);

        //Add to model if object is not null
        if(objSach != null) {
            model.addAttribute("sach", objSach);
        }

        //Return result
        return "admin/SachAdd";
    }

}
