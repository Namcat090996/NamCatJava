package vn.com.stanford.je0824.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.stanford.je0824.bookstore.entities.ChuDe;
import vn.com.stanford.je0824.bookstore.entities.Sach;
import vn.com.stanford.je0824.bookstore.service.ChuDeService;
import vn.com.stanford.je0824.bookstore.service.SachService;

import java.util.Date;
import java.util.List;

@Controller
public class SachController {

    @Autowired
    SachService sachService;

    @Autowired
    ChuDeService chuDeService;

    @RequestMapping(value = "admin/sach", method = RequestMethod.GET)
    public String hienThiDanhSach(Model model)
    {
        //Lấy danh sách thông tin sách
        List<Sach> lstSach = sachService.layDanhSach();

        //Dựa vào model để hiển thị ra view
        model.addAttribute("lstSach", lstSach);

        return "admin/QuanLySach";
    }

    @RequestMapping(value = "/admin/sach/them")
    public String hienThiThemMoiSach(Model model) {
        model.addAttribute("Sach", new Sach());

        return "admin/SachAdd";
    }

    @RequestMapping(value = "/admin/sach/sua/{id}")
    public String hienThiChiTietSach(@PathVariable("id") String id, Model model) {

        Sach objSach = sachService.layChiTiet(id)
                ;

        model.addAttribute("sach", objSach);

        return "admin/SachAdd";
    }

    /**
     * Xử lý thêm mới hoặc sửa thông tin sách
     * @param objSach
     * @param model
     * @return
     */
    @RequestMapping(value = "admin/sach/themMoiSach", method = RequestMethod.POST)
    public String themMoiHoacSuaSach(@ModelAttribute("sach") Sach objSach, Model model) {

        System.out.println("Mã sách: " + objSach.getMaSach());
        System.out.println("Tên sách: " + objSach.getTenSach());

        boolean isInsert = true;

        //Nếu sách đã có thì là sửa
        Sach objSachOld = sachService.layChiTiet(objSach.getMaSach());

        if(objSachOld != null)
        {
            isInsert = false;
        }

        boolean ketQua = false;

        if(isInsert)
        {
            objSach.setNgayTao(new Date());
            objSach.setNgayCapNhat(new Date());

            ketQua = sachService.themMoi(objSach);
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

        return "admin/SachAdd";
    }

    /**
     * Lấy thông tin sách
     * @param id
     * @return
     */
    @RequestMapping(value = "/admin/sach/sua/{id}")
    public String xoaThongTinSach(@PathVariable("id") String id) {

        Sach objSach = sachService.layChiTiet(id);

        if(objSach != null)
        {
            boolean ketQua = sachService.xoa(id);

            if(ketQua)
            {
                return "redirect:/admin/sach";
            }
        }

        return "admin/SachAdd";
    }

    /**
     * Hiển thị danh sách chủ đề lên giao diện thêm, sửa sách
     * @return
     */
    @ModelAttribute("chuDeList")
    public List<ChuDe> hienThiDanhSachChuDe()
    {
        //Lấy danh sách chủ đề
        List<ChuDe> lstChuDe = chuDeService.layDanhSach();

        return lstChuDe;
    }
}
