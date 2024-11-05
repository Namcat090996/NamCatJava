package vn.com.namcat.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.namcat.bookstore.entities.ChuDe;
import vn.com.namcat.bookstore.entities.Sach;
import vn.com.namcat.bookstore.service.ChuDeService;
import vn.com.namcat.bookstore.service.SachService;

import javax.validation.Valid;
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
    public String hienThiDanhSach(Model model)
    {
        //Declare list
        List<Sach> lstSach = sachService.layDanhSach();

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
    @RequestMapping(value = "/admin/sach/ThemMoiSach", method = RequestMethod.POST)
    public String themMoiHoacSuaSach(@ModelAttribute("sach") @Valid Sach objSach, BindingResult result, Model model)
    {
        return "";
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
                model.addAttribute("error", "Không thể xóa thông tin này. Vui lòng chọn thông tin khác");

            }
        }

        //Return to main page if deletion fails
        List<Sach> lstSach = sachService.layDanhSach();
        model.addAttribute("lstSach", lstSach);
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
