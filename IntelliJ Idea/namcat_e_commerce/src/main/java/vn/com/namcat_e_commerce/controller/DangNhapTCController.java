package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.model.NguoiDungDao;
import vn.com.namcat_e_commerce.service.GioHangService;

@Controller
public class DangNhapTCController {
    
    @Autowired
    NguoiDungDao nguoiDungDao;
    
    @Autowired
    GioHangService gioHangService;
    
    @RequestMapping(value = "/login2")
    public String showLoginForm(Model model)
    {
        model.addAttribute("user", new NguoiDung());
        model.addAttribute("User_Online", "");
        
        return "dangnhap_register";
    }
    
    @RequestMapping(value = "/submit2", method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute("user") NguoiDung objND, Model model, HttpSession session)
    {
        String taiKhoan = objND.getTenNguoiDung();
        String matKhau = objND.getMatKhau();
        
        //Giữ thông tin người dùng sau khi nhập
        model.addAttribute("user", objND);
        
        //Kiểm tra field nhập
        if (taiKhoan == null || matKhau == null || taiKhoan.isEmpty() || matKhau.isEmpty()) {
            model.addAttribute("login_fail", "Tên đăng nhập và mật khẩu không được để trống");
            return "dangnhap_register";
        }
        
        NguoiDung objNDCheck = nguoiDungDao.findById(taiKhoan);
        
        //Tài khoản có tồn tại và đúng vai trò
        if(objNDCheck != null)
        {
            //Mã hóa mật khẩu
            String mkMaHoa = BCrypt.hashpw(matKhau, BCrypt.gensalt());
            
            //Kiểm tra mật khẩu
            if(BCrypt.checkpw(matKhau, objNDCheck.getMatKhau()))
            {
                //Lưu vào session
                session.setAttribute("user_Online", taiKhoan);
                
                return "redirect:/trangchu";
            }
            else
            {
                model.addAttribute("login_fail", "Tài khoản hoặc mật khẩu không chính xác");
                return "dangnhap_register";
            }
        }
        else
        {
            model.addAttribute("login_fail", "Tài khoản không tồn tại hoặc không có quyền truy cập");
            return "dangnhap_register";
        }
    }
}
