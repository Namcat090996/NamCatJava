package vn.com.namcat.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.namcat.bookstore.entities.ChuDe;
import vn.com.namcat.bookstore.entities.Sach;
import vn.com.namcat.bookstore.entities.SachModel;
import vn.com.namcat.bookstore.service.ChuDeService;
import vn.com.namcat.bookstore.service.SachService;

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

    /**
     * Function to get book list
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/sach")
    public String hienThiDanhSach(@ModelAttribute("sach") SachModel objSach, Model model)
    {
        //Keep user infomation which has typed
        model.addAttribute("sach", objSach);

        //Declare list
        List<Sach> lstSach = sachService.timKiemSach(objSach.getTuKhoa(), objSach.getMaChuDe());

        //Add to model
        model.addAttribute("lstSach", lstSach);

        //Return result
        return "admin/QuanLySach";
    }

    /**
     * Function to display the book insertion view
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/sach/them")
    public String hienThiThemMoiSach(Model model)
    {
        //Add to model
        model.addAttribute("sach", new Sach());

        //Return result
        return "admin/SachAdd";
    }

    /**
     * Function to display detailed book
     * @param maSach
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/sach/sua/{id}")
    public String hienThiChiTietSach(@PathVariable("id") String maSach, Model model)
    {
        //Get detailed object by id
        Sach objSach = sachService.layChiTiet(maSach);

        //Add to model if object is not null
        if(objSach != null) {
            model.addAttribute("sach", objSach);
            model.addAttribute("hSachId", maSach);
        }

        //Return result
        return "admin/SachAdd";
    }

    /**
     * Function to insert or update book
     * @return
     */
    @RequestMapping(value = "/admin/sach/themMoiSach", method = RequestMethod.POST)
    public String themMoiHoacSuaSach(@ModelAttribute("sach") @Valid Sach objSach, BindingResult result, @RequestParam("fUpload") MultipartFile fUpload, HttpServletRequest request, Model model, @RequestParam("idCheck") String maSachCheck)
    {
        if(result.hasErrors())
        {
            //Keep user infomation which has typed
            model.addAttribute("sach", objSach);

            //Keep current page
            return "admin/SachAdd";
        }
        else
        {
            //Declare image name
            String tenAnh = "";

            //Declare boolean
            boolean isInsert = true;
            boolean ketQua = false;

            //Get object by id
            Sach objSachOld = sachService.layChiTiet(objSach.getMaSach());

            //In case of updating information
            if(!maSachCheck.isEmpty())
            {
                isInsert = false;
                //Keep old book name if user don't upload image
                tenAnh = objSachOld.getAnhSach();
            }

            //Process the upload file
            if(!fUpload.isEmpty())
            {
                //Get book name
                tenAnh = fUpload.getOriginalFilename();

                //Get path from web.xml
                String strDuongDan = request.getServletContext().getInitParameter("file-upload");

                //Use try-catch if an error occurs during upload process
                try
                {
                    //Create directory object with the path
                    File directory = new File(strDuongDan);

                    //Check if the directory has existed -> check if the path has existed
                    if(!directory.exists())
                    {
                        //If the directory & path have not existed, create the directory
                        directory.mkdir();
                    }

                    //Create file object with directory & image name
                    File file = new File(directory, tenAnh);

                    //Save uploaded file into above directory
                    fUpload.transferTo(file);
                }
                catch (IOException ex) {
                    System.out.println("Có lỗi xảy ra khi upload file: " + ex.getMessage());
                }
            }

            //Assign uploaded file to book object
            objSach.setAnhSach(tenAnh);

            //In case of insert a new book
            if(isInsert)
            {
                //Use if-else to check if maSach is duplicated
                if(objSachOld == null)
                {
                    //Insert a new book
                    ketQua = sachService.themMoi(objSach);
                    objSach.setNgayTao(new Date());
                    objSach.setNgayCapNhat(new Date());
                }
                else
                {
                    //Add alert to model
                    model.addAttribute("duplicateId", "Mã sách này đã tồn tại");

                    //Keep user infomation which has typed
                    model.addAttribute("sach", objSach);

                    //Keep current page
                    return "admin/SachAdd";
                }
            }
            else //In case of update book information
            {
                //Update book information
                ketQua = sachService.capNhat(objSach);
                objSach.setNgayCapNhat(new Date());
            }

            if(ketQua)
            {
                return "redirect:/admin/sach";
            }
            
            return "admin/SachAdd";
        }

        
    }

    /**
     * Function to delete book
     * @return
     */
    @RequestMapping(value = "/admin/sach/xoa/{id}")
    public String xoaThongTinSach(@PathVariable("id") String maSach, Model model)
    {
        //Declare an object
        Sach objSach = sachService.layChiTiet(maSach);

        //Declare boolean
        boolean ketQua = false;

        //Execute the delete function
        if(objSach != null)
        {
            //Use try-catch to avoid user deletes information that has been used (Foreign_Key)
            try {
                ketQua = sachService.xoa(maSach);

                //If ketQua is true
                if(ketQua)
                {
                    return "redirect:/admin/sach/";
                }
            }
            catch (DataIntegrityViolationException ex)
            {
                //Add to model
                model.addAttribute("error", "Không thể xóa thông tin này. Vui lòng thử lại");
            }
        }

        //Return to main page if deletion fails
        //Get list
        List<Sach> lstSach = sachService.layDanhSach();

        //Add to model
        model.addAttribute("lstSach", lstSach);

        //Return
        return "admin/QuanLySach";
    }

    /**
     * Function to get list
     * @return
     */
    @ModelAttribute("lstChuDe")
    public List<ChuDe> hienThiDanhSachCD()
    {
        //Get object list
        List<ChuDe> lstChuDe = chuDeService.layDanhSach();

        //Return result
        return lstChuDe;
    }

}
