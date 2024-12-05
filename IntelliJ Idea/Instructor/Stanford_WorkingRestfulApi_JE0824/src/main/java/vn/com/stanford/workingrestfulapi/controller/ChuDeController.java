package vn.com.stanford.workingrestfulapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChuDeController {

    @GetMapping("/admin/chude")
    public String hienThiDanhSachChuDe() {
        return "ChuDeCallApi";
    }
}
