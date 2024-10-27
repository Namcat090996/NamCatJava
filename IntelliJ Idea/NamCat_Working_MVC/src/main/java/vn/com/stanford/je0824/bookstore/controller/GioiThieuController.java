package vn.com.stanford.je0824.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GioiThieuController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String loiGioiThieu(Model model)
    {
        model.addAttribute("loiChao", "Chào mừng các bạn đến với Spring MVC !");
        return "GioiThieu";
    }
}
