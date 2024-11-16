package vn.com.stanford.stanford_bookstore_sb_je0824.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GioiThieuController {

    @RequestMapping("/hello")
    public String hienThiLoiGioiThieu(Model model)
    {
        model.addAttribute("loiChao", "Chào mừng các bạn đến với Spring Boot !");

        return "GioiThieu";
    }
}
