package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.model.NguoiDungDao;

@Controller
@SessionAttributes({"Online_User", "Online_User_VaiTro"})
public class DangNhapController {
    
    @Autowired
    NguoiDungDao nguoiDungDao;
    
    @RequestMapping(value = "/login")
    public String showLoginForm(Model model, HttpSession session)
    {
        model.addAttribute("nguoidung", new NguoiDung());
        return "admin/Login";
    }
    
    @RequestMapping(value = "/logout")
    public String showLogin(Model model, HttpSession session)
    {
        session.setAttribute("userOnline", null);
        return "redirect:/login";
    }
    
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute("nguoidung") NguoiDung objND, Model model, HttpSession session)
    {
        String taiKhoan = objND.getTenNguoiDung();
        String matKhau = objND.getMatKhau();
        
        //Giữ thông tin người dùng sau khi nhập
        model.addAttribute("nguoidung", objND);
        
        //Kiểm tra field nhập
        if (taiKhoan == null || matKhau == null || taiKhoan.isEmpty() || matKhau.isEmpty()) {
            model.addAttribute("login_fail", "Tên đăng nhập và mật khẩu không được để trống");
            return "admin/Login";
        }
        
        NguoiDung objNDCheck = nguoiDungDao.findById(taiKhoan);
        
        //Tài khoản có tồn tại và đúng vai trò
        if(objNDCheck != null && (objNDCheck.getVaiTro().equals("admin") || objNDCheck.getVaiTro().equals("approver")))
        {
            //Mã hóa mật khẩu
            String mkMaHoa = BCrypt.hashpw(matKhau, BCrypt.gensalt());
            
            //Kiểm tra mật khẩu
            if(BCrypt.checkpw(matKhau, objNDCheck.getMatKhau()))
            {
                //Lưu vào session
                session.setAttribute("userOnline", taiKhoan);
                session.setAttribute("vaiTroUserOnline", objNDCheck.getVaiTro());
                
                model.addAttribute("Online_User", taiKhoan);
                model.addAttribute("Online_User_VaiTro", objNDCheck.getVaiTro());
                
                return "redirect:/admin/sanpham";
            }
            else
            {
                model.addAttribute("login_fail", "Tài khoản hoặc mật khẩu không chính xác");
                return "admin/Login";
            }
        }
        else
        {
            model.addAttribute("login_fail", "Tài khoản không tồn tại hoặc không có quyền truy cập");
            return "admin/Login";
        }
    }
    
    @ModelAttribute("Online_User")
    public String layThongTinUserOnline(HttpSession session) {
        return (String) session.getAttribute("userOnline");
    }
    
    @ModelAttribute("Online_User_VaiTro")
    public String layThongTinVaiTroUserOnline(HttpSession session) {
        return (String) session.getAttribute("vaiTroUserOnline");
    }
}
