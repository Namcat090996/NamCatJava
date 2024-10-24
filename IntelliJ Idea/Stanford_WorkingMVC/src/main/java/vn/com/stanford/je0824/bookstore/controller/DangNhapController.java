package vn.com.stanford.je0824.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DangNhapController {

    /**
     * Hiển thị form
     * @return
     */
    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public String dangNhapHeThong()
    {
        return "DangNhap";
    }

    /**
     * Xử lý khi nguoười dùng nhấn nút đăng nhập
     * @param tenDangNhap
     * @param matKhau
     * @param model
     * @return
     */
    @RequestMapping(value = "/thucHienDangNhap", method = RequestMethod.POST)
    public String xuLyDangNhap(@RequestParam("tenDangNhap") String tenDangNhap, @RequestParam("matKhau") String matKhau, Model model)
    {
        model.addAttribute("tenDangNhap", tenDangNhap);
        model.addAttribute("matKhau", matKhau);

        return "DangNhap";
    }
}
