package org.example.stanford_bookstore_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GioiThieuController {

    @RequestMapping(value = "/hello")
    public String loiChao()
    {
        return "templates/GioiThieu";
    }
}
