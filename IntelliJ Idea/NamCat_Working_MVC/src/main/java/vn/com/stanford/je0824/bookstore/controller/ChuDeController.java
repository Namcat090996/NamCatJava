package vn.com.stanford.je0824.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.stanford.je0824.bookstore.entities.ChuDe;
import vn.com.stanford.je0824.bookstore.service.ChuDeService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ChuDeController {

    @Autowired
    ChuDeService chuDeService;

    @RequestMapping(value = "/admin/chude", method = RequestMethod.GET)
    public String hienThiDanhSachChuDe(Model model)
    {
        //Lấy danh sách chủ để
        List<ChuDe> lstChuDe = chuDeService.layDanhSach();

        model.addAttribute("chuDe", lstChuDe);

        return "admin/DanhSachChuDe";
    }

    @RequestMapping(value = "/admin/chude/them", method = RequestMethod.GET)
    public String hienThiThemMoiCD(Model model)
    {
        model.addAttribute("chude", new ChuDe());

        return "admin/ChuDeAdd";
    }

    @RequestMapping(value = "/admin/chude/sua/{id}", method = RequestMethod.GET)
    public String hienThiChiTietCD(@PathVariable("id") String maChuDe, Model model)
    {
        ChuDe chuDe = chuDeService.layChiTietCD(maChuDe);

        model.addAttribute("chude", chuDe);

        return "admin/ChuDeAdd";
    }

    @RequestMapping(value = "/admin/chude/themMoiCD", method = RequestMethod.POST)
    public String themMoiHoacSuaChuDe(@ModelAttribute("chude") @Valid ChuDe objCD, BindingResult result, Model model)
    {
        System.out.println("Mã chủ đề: " + objCD.getMaChuDe());
        System.out.println("Tên chủ đề: " + objCD.getTenChuDe());

        if(result.hasErrors())
        {
            model.addAttribute("message", "Bạn phải nhập đầy đủ thông tin cần thiết");
            //Giữ thông tin khi người dùng chưa nhập đầy đủ nhưng đã nhấn submit
            model.addAttribute("chude", objCD);

            return "admin/ChuDeAdd";
        }
        else
        {
            boolean isInsert = true;

            //Nếu chủ đề đã có thì là sửa
            ChuDe chuDe = chuDeService.layChiTietCD(objCD.getMaChuDe());

            if(chuDe != null)
            {
                isInsert = false;
            }

            boolean ketQua = false;

            if(isInsert)
            {
                ketQua = chuDeService.themCD(objCD);
            }
            else
            {
                ketQua = chuDeService.capNhatCD(objCD);
            }

            if(ketQua)
            {
                return "redirect:/admin/chude";
            }
        }

        return "admin/ChuDeAdd";
    }

    @RequestMapping(value = "/admin/chude/xoa/{id}")
    public String xoaChuDe(@PathVariable("id") String maCD, Model model)
    {
        ChuDe chuDe = chuDeService.layChiTietCD(maCD);

        if(chuDe != null)
        {
            try {
                boolean ketQua = chuDeService.xoaCD(maCD);

                if(ketQua)
                {
                    return "redirect:/admin/chude";
                }
            }
            catch (DataIntegrityViolationException ex) {


                model.addAttribute("error", "Fuck u");
            }
        }
        List<ChuDe> lstChuDe = chuDeService.layDanhSach();
        model.addAttribute("chuDe", lstChuDe);
        return "admin/DanhSachChuDe";
    }
}
