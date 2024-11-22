package vn.com.namcat_bookstore_sbt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.namcat_bookstore_sbt.entities.ChuDe;
import vn.com.namcat_bookstore_sbt.entities.Sach;
import vn.com.namcat_bookstore_sbt.entities.SachModel;
import vn.com.namcat_bookstore_sbt.service.ChuDeService;
import vn.com.namcat_bookstore_sbt.service.SachService;

import java.io.File;
import java.io.IOException;
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
        List<Sach> lstSach = sachService.timKiemThongTinSach(objSach.getTuKhoa(), objSach.getMaChuDe());

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

        model.addAttribute("maSachCheck", "");

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

        model.addAttribute("maSachCheck", maSach);

        //Return to page
        return "admin/SachAdd";
    }

    //Get path to upload image
    @Value("${fileupload.path}")
    private String fileUploadPath;

    @RequestMapping(value = "/admin/sach/themMoiSach", method = RequestMethod.POST)
    public String themMoiHoacSuaSach(Model model, BindingResult result, @ModelAttribute("sach") Sach objSach, MultipartFile fUpload)
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
            String tenAnh = "";

            if(objCheck != null)
            {
                isInsert = false;
                tenAnh = objSach.getAnhSach();
            }

            String path = "";

            if(fUpload != null && !fUpload.isEmpty())
            {
                tenAnh = fUpload.getOriginalFilename();

                path = fileUploadPath;

                try {
                    File directory = new File(path);
                    
                    if(!directory.exists())
                    {
                        directory.mkdir();
                    }
                    
                    File file = new File(directory, tenAnh);
                    
                    fUpload.transferTo(file);
                }
                catch (IOException ex)
                {
                    System.out.println("Co loi xay ra");
                }
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
}
