package vn.com.namcat_bookstore_sbt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.namcat_bookstore_sbt.entities.Sach;
import vn.com.namcat_bookstore_sbt.entities.SachModel;
import vn.com.namcat_bookstore_sbt.service.ChuDeService;
import vn.com.namcat_bookstore_sbt.service.SachService;

import java.util.List;

@Controller
public class SachController {

    @Autowired
    SachService sachService;

    @Autowired
    ChuDeService chuDeService;

    @RequestMapping(value = "/admin/sach")
    public String hienThiDanhSach(@ModelAttribute("sach") SachModel objSach, Model model)
    {
        //Keep user information which has typed
        model.addAttribute("sach", objSach);

        //Get list by keyword and subject code
        List<Sach> lstSach = sachService.timKiemThongTinSach(objSach.getMaSach(), objSach.getMaChuDe());

        //Add to model and send to view
        model.addAttribute("lstSach", lstSach);

        //Return to page
        return "admin/QuanLySach";
    }

    @RequestMapping(value = "/admin/sach/them")
    public String hienThiThemMoiSach(Model model)
    {
        //Add to model and send to view (avoid error when object not found)
        model.addAttribute("sach", new Sach());

        //Return to page
        return "admin/SachAdd";
    }

    @RequestMapping(value = "/admin/sach/sua/{id}")
    public String hienThiChiTietSach(Model model, @PathVariable("id") String maSach)
    {
        //Get object by id
        Sach objSach = sachService.layChiTiet(maSach);

        //Keep user information which has typed
        model.addAttribute("sach", objSach);

        //Return to page
        return "admin/SachAdd";
    }

    //Get path to upload image
    @Value("")

    @RequestMapping(value = "/admin/sach/themMoiSach", method = RequestMethod.POST)
    public String themMoiHoacSuaSach(Model model, BindingResult result, @ModelAttribute("sach") Sach objSach)
    {
        if(result.hasErrors())
        {
            //Keep user information which has typed
            model.addAttribute("sach", objSach);

            //Return page
            return "admin/SachAdd";
        }
        else
        {
            Sach objCheck = sachService.layChiTiet(objSach.getMaSach());
            boolean isInsert = true;

            if(objCheck != null)
            {
                isInsert = false;
            }

            boolean ketQua = false;

            if(isInsert)
            {
                ketQua = sachService.themMoi(objSach);
            }
            else
            {
                ketQua = sachService.capNhat(objSach);
            }

            if(ketQua)
            {
                return "redirect:/admin/sach";
            }
        }

        return "admin/SachAdd";
    }
}
