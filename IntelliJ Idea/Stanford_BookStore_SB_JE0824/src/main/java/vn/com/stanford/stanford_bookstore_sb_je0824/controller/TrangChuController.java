package vn.com.stanford.stanford_bookstore_sb_je0824.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.ChuDe;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.Sach;
import vn.com.stanford.stanford_bookstore_sb_je0824.service.ChuDeService;
import vn.com.stanford.stanford_bookstore_sb_je0824.service.SachService;

import java.util.List;

@Controller
public class TrangChuController {

    @Autowired
    SachService sachService;

    @RequestMapping(value = "/trang-chu")
    public String hienThiTrangChu(Model model)
    {
        //Lấy danh sách
        List<Sach> lstSach = sachService.timKiemThongTinSach("", "");

        model.addAttribute("lstSach", lstSach);

        return "TrangChu";
    }

    @RequestMapping(value = "/trang-chu/{ma}")
    public String hienThiTrangChuTheoChuDe(Model model, @PathVariable("ma") String ma)
    {
        //Lấy danh sách
        List<Sach> lstSach = sachService.timKiemThongTinSach("", ma);

        model.addAttribute("lstSach", lstSach);

        return "TrangChu";
    }

    @Autowired
    ChuDeService chuDeService;
    /**
     * Hiển thị danh sách chủ đề lên giao diện thêm, sửa sách
     * @return
     */
    @ModelAttribute("lstChuDe")
    public List<ChuDe> hienThiDanhSachChuDe()
    {
        //Lấy danh sách chủ đề
        List<ChuDe> lstChuDe = chuDeService.layDanhSach();

        return lstChuDe;
    }

    @RequestMapping(value = "/chi-tiet/{ma}")
    public String hienThiChiTiet(Model model, @PathVariable("ma") String ma)
    {
        Sach objSach = sachService.layChiTiet(ma);

        model.addAttribute("sach", objSach);

        return "ChiTiet";
    }
}
