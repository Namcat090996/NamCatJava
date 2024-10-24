package vn.com.stanford.je0824.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.stanford.je0824.bookstore.service.ChuDeService;
import vn.com.stanford.je0824.bookstore.entities.*;

import java.util.List;

@Controller
public class ChuDeController {

    @Autowired
    ChuDeService chuDeService;

    /**
     * Xử lý hiển thị danh sách chủ đề lên giao diện
     * @param model
     * @return
     */
    @RequestMapping(value="/chude", method = RequestMethod.GET)
    public String hienThiDanhSachChuDe(Model model)
    {
        //Lấy danh sách chủ đề
        List<ChuDe> lstChuDe = chuDeService.layDanhSach();

        model.addAttribute("chuDe", lstChuDe);

        return "DanhSachChuDe";
    }
}
