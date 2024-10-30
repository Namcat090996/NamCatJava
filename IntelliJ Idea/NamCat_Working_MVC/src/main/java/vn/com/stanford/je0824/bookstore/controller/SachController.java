package vn.com.stanford.je0824.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.com.stanford.je0824.bookstore.entities.ChuDe;
import vn.com.stanford.je0824.bookstore.entities.Sach;
import vn.com.stanford.je0824.bookstore.service.ChuDeService;
import vn.com.stanford.je0824.bookstore.service.SachService;

import javax.naming.Binding;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class SachController {

    @Autowired
    SachService sachService;

    @Autowired
    ChuDeService chuDeService;
    @Qualifier("httpServletRequest")
    @Autowired
    private ServletRequest httpServletRequest;

    @RequestMapping(value = "/admin/sach", method = RequestMethod.GET)
    public String hienThiDanhSach(Model model)
    {
        //Lấy danh sách thông tin sách
        List<Sach> lstSach = sachService.layDanhSach();

        //Đưa vào model để hiển thị ra view
        model.addAttribute("lstSach", lstSach);

        return "admin/QuanLySach";
    }

    @RequestMapping(value = "/admin/sach/them", method = RequestMethod.GET)
    public String hienThiThemMoiSach(Model model)
    {
        model.addAttribute("sach", new Sach());

        return "admin/SachAdd";
    }

    @RequestMapping(value = "/admin/sach/sua/{id}", method = RequestMethod.GET)
    public String hienThiChiTietSach(@PathVariable("id") String maSach, Model model)
    {
        Sach objSach = sachService.layChiTiet(maSach);

        model.addAttribute("sach", objSach);
        model.addAttribute("idCheck", objSach.getMaSach());

        return "admin/SachAdd";
    }

    @RequestMapping(value = "/admin/sach/themMoiSach", method = RequestMethod.POST)
    public String themMoiHoacSuaSach(@ModelAttribute("sach") @Valid Sach objSach, BindingResult result, Model model, @RequestParam("hSachId") String hSachId)
    {
        System.out.println("Mã sách: " + objSach.getMaSach());
        System.out.println("Tên sách: " + objSach.getTenSach());
        System.out.println("Mã sách check: " + hSachId);

        if(result.hasErrors())
        {
            model.addAttribute("message", "Bạn cần phải nhập đủ thông tin");
            model.addAttribute("sach", objSach);

            return "admin/SachAdd";
        }
        else
        {
            boolean isInsert = true;

            if(!hSachId.isEmpty())
            {
                isInsert = false;
            }

            Sach objSachOld = sachService.layChiTiet(objSach.getMaSach());

            boolean ketQua = false;

            if(isInsert)
            {
                objSach.setNgayTao(new Date());
                objSach.setNgayCapNhat(new Date());
                if(objSachOld == null)
                {
                    ketQua = sachService.themMoi(objSach);
                }
                else
                {
                    model.addAttribute("sach_message", "Mã sách đã tồn tại");
                    model.addAttribute("sach", objSach);
                    return "admin/SachAdd";
                }
            }
            else
            {
                objSach.setNgayCapNhat(new Date());
                ketQua = sachService.capNhat(objSach);
            }

            if(ketQua)
            {
                return "redirect:/admin/sach";
            }
        }

        return "admin/SachAdd";
    }

    @RequestMapping(value = "/admin/sach/xoa/{id}", method = RequestMethod.GET)
    public String xoaThongTinSach(@PathVariable("id") String maSach)
    {
        boolean ketQua = false;

        Sach objSach = sachService.layChiTiet(maSach);

        if(objSach != null)
        {
            ketQua = sachService.xoa(maSach);
        }

        if(ketQua)
        {
            return "redirect:/admin/sach";
        }

        return "admin/SachAdd";
    }

    @ModelAttribute("chuDeList")
    public List<ChuDe> hienThiDanhSachChuDe()
    {
        //Lấy danh sách chủ đề
        List<ChuDe> lstChuDe = chuDeService.layDanhSach();

        return lstChuDe;
    }
}
