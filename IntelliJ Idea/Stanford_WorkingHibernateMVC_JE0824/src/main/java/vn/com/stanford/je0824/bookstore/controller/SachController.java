package vn.com.stanford.je0824.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.stanford.je0824.bookstore.entities.ChuDe;
import vn.com.stanford.je0824.bookstore.entities.SachModel;
import vn.com.stanford.je0824.bookstore.model.SachDao;
import vn.com.stanford.je0824.bookstore.entities.Sach;
import vn.com.stanford.je0824.bookstore.service.ChuDeService;
import vn.com.stanford.je0824.bookstore.service.SachService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class SachController {

    @Autowired
    SachService sachService;

    @Autowired
    ChuDeService chuDeService;

    @RequestMapping(value = "/admin/sach")
    public String hienThiDanhSach(@ModelAttribute("sach") SachModel objSach, Model model) {

        model.addAttribute("sach", objSach);
        //Lấy danh sách thông tin sách
        List<Sach> lstSach = sachService.timKiemThongTinSach(objSach.getTuKhoa(), objSach.getMaChuDe());

        //Đưa vào model để hiển thị ra view
        model.addAttribute("lstSach", lstSach);

        return "admin/QuanLySach";
    }

    @RequestMapping(value = "/admin/sach/them")
    public String hienThiThemMoiSach(Model model) {

        model.addAttribute("sach", new Sach());

        return "admin/SachAdd";
    }

    @RequestMapping(value = "/admin/sach/sua/{id}")
    public String hienThiChiTietSach(@PathVariable("id") String id, Model model) {

        Sach objSach = sachService.layChiTiet(id);

        model.addAttribute("sach", objSach);

        return "admin/SachAdd";
    }

    /**
     * Xử lý thêm mới hoặc sửa thông tin sách
     * @param objSach
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/sach/themMoiSach", method = RequestMethod.POST)
    public String themMoiHoacSuaSach(@ModelAttribute("sach") @Valid Sach objSach, BindingResult result, @RequestParam("fUpload")MultipartFile fUpload, HttpServletRequest request, Model model)
    {
        System.out.println("Mã sách: " + objSach.getMaSach());
        System.out.println("Tên sách: " + objSach.getTenSach());

        if(result.hasErrors()) {

            model.addAttribute("message", "Bạn cần phải nhập đủ thông tin");
            model.addAttribute("sach", objSach);

            return "admin/SachAdd";
        }
        else
        {
            boolean isInsert = true;
            String tenAnh = "";
            //Nếu sách đã có thì là sửa
            Sach objSachOld = sachService.layChiTiet(objSach.getMaSach());

            if (objSachOld != null) {
                isInsert = false;
                tenAnh = objSachOld.getAnhSach();
            }

            //Xử lý upload file
            if(fUpload != null)
            {
                //Lấy tên ảnh
                tenAnh = fUpload.getOriginalFilename();

                //Lấy đường dẫn ảnh
                String strDuongDan = request.getServletContext().getInitParameter("file-upload");

                try
                {
                    //Tạo file
                    File file = new File(strDuongDan, tenAnh);

                    fUpload.transferTo(file);
                }
                catch (IOException ex)
                {
                    System.out.println("Có lỗi xảy ra khi upload file: " + ex.getMessage());
                }
            }

            //Gán ảnh vào đối tượng để lưu  sb
            objSach.setAnhSach(tenAnh);

            boolean ketQua = false;

            if (isInsert) {
                objSach.setNgayTao(new Date());
                objSach.setNgayCapNhat(new Date());

                ketQua = sachService.themMoi(objSach);
            } else {
                objSach.setNgayCapNhat(new Date());

                ketQua = sachService.capNhat(objSach);
            }

            if (ketQua) {
                return "redirect:/admin/sach";
            }
        }

        return "admin/SachAdd";
    }

    /**
     * Xóa thông tin sách
     * @param id
     * @return
     */
    @RequestMapping(value = "/admin/sach/xoa/{id}")
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

        return "admin/QuanLySach";
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
