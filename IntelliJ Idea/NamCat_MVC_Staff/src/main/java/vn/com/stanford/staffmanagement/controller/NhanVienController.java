package vn.com.stanford.staffmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.stanford.staffmanagement.entities.*;
import vn.com.stanford.staffmanagement.service.ChucVuService;
import vn.com.stanford.staffmanagement.service.HeSoLuongService;
import vn.com.stanford.staffmanagement.service.NhanVienService;
import vn.com.stanford.staffmanagement.service.PhongBanService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class NhanVienController {

    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    ChucVuService chucVuService;

    @Autowired
    PhongBanService phongBanService;

    @Autowired
    HeSoLuongService heSoLuongService;

    @RequestMapping(value = "/admin/nhanvien")
    public String hienThiDanhSachNhanVien(@ModelAttribute("nhanvien") NhanVienModel objNV,Model model)
    {
        //Keep the user data which is typed
        model.addAttribute("nhanvien", objNV);

        //Declare and get the list
        List<NhanVienModel> lstNV = nhanVienService.layDanhSachLuongNV(objNV.getTuKhoa(), objNV.getMaPhong(), objNV.getMaChucVu());

        //Add to model
        model.addAttribute("lstNhanVien", lstNV);

        //Return main page
        return "admin/QuanLyNhanVien";
    }

    @RequestMapping(value = "/admin/nhanvien/them")
    public String hienThiThemMoiNV(Model model) {

        //Add to model
        model.addAttribute("nhanvien", new NhanVien());

        //Return result
        return "admin/NhanVienAdd";
    }

    @RequestMapping(value = "/admin/nhanvien/sua/{id}")
    public String hienThiChiTietNV(@PathVariable("id") String maNV, Model model) {

        //Get detailed object by id
        NhanVien objNV = nhanVienService.layChiTietNV(maNV);

        //Add to model
        model.addAttribute("nhanvien", objNV);

        //Return result
        return "admin/NhanVienAdd";
    }

    @RequestMapping(value = "/admin/nhanvien/themMoiNV", method = RequestMethod.POST)
    public String themMoiHoacSuaNV(@ModelAttribute("nhanvien") @Valid NhanVien objNV, BindingResult result, Model model)
    {
        if(result.hasErrors()) {
            model.addAttribute("nhanvien", objNV);

            return "admin/NhanVienAdd";
        }
        else
        {
            boolean isInsert = true;

            //Nếu sách đã có thì là sửa
            NhanVien objNVOld = nhanVienService.layChiTietNV(objNV.getMaNV());

            if (objNVOld != null) {
                isInsert = false;
            }

            boolean ketQua = false;

            if (isInsert) {

                ketQua = nhanVienService.themNV(objNV);
            } else {

                ketQua = nhanVienService.suaNV(objNV);
            }

            if (ketQua) {
                return "redirect:/admin/nhanvien";
            }
        }

        return "admin/NhanVienAdd";
    }

    @RequestMapping(value = "/admin/nhanvien/xoa/{id}")
    public String xoaNhanVien(@PathVariable("id") String maNV, Model model) {

        //Get object by id
        NhanVien objNV = nhanVienService.layChiTietNV(maNV);

        //If object has existed
        if (objNV != null) {

            //Declare boolean
            boolean ketQua = false;

            //Execute the delete function
            ketQua = nhanVienService.xoaNV(objNV.getMaNV());

            if (ketQua) {
                return "redirect:/admin/nhanvien";
            }
        }

        //If object is null or deletion doesn't succeed
        model.addAttribute("error_message", "Xóa thông tin không thành công. Vui lòng thử lại");
        return "admin/QuanLyNhanVien";
    }

    @ModelAttribute("chucVuList")
    public List<ChucVu> hienThiDanhSachChucVu()
    {
        //Get list
        List<ChucVu> lstChucVu = chucVuService.layDanhSach();

        //Return result
        return lstChucVu;
    }

    @ModelAttribute("phongBanList")
    public List<PhongBan> hienThiDanhSachPhongBan()
    {
        //Get list
        List<PhongBan> lstPhongBan = phongBanService.layDanhSach();

        //Return result
        return lstPhongBan;
    }

    @ModelAttribute("heSoLuongList")
    public List<HeSoLuong> hienThiDanhSachHSLuong()
    {
        //Get list
        List<HeSoLuong> lstHSLuong = heSoLuongService.layDanhSach();

        //Return result
        return lstHSLuong;
    }
}
