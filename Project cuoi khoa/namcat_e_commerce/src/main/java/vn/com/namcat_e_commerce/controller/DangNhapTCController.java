package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.service.GioHangService;
import vn.com.namcat_e_commerce.service.NguoiDungSevice;

@Controller
public class DangNhapTCController {
    
    @Autowired
    GioHangService gioHangService;
    
    @Autowired
    NguoiDungSevice nguoiDungSevice;
    
    @RequestMapping(value = "/login2")
    public String showLoginForm(Model model)
    {
        model.addAttribute("user", new NguoiDung());
        model.addAttribute("User_Online", "");
        
        return "dangnhap";
    }
    
    @RequestMapping(value = "/register")
    public String showRegisterForm(Model model)
    {
        model.addAttribute("User_Online", "");
        model.addAttribute("objND", new NguoiDung());
        
        return "dangky";
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
            return "dangnhap";
        }
        
        NguoiDung objNDCheck = nguoiDungSevice.findById(taiKhoan);
        
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
                return "dangnhap";
            }
        }
        else
        {
            model.addAttribute("login_fail", "Tài khoản không tồn tại hoặc không có quyền truy cập");
            return "dangnhap";
        }
    }
    
    @RequestMapping(value = "/logout2")
    public String showLogin(Model model, HttpSession session)
    {
        session.removeAttribute("user_Online");
        return "redirect:/login2";
    }
    
    @RequestMapping(value = "/register/submit")
    public String dangKyKhachHang(@ModelAttribute("objND") @Valid NguoiDung objND, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("objND", objND);
            return "dangky";
        }
        else
        {
            //Lấy tên người dùng đầu vào
            String tenNguoiDung = objND.getTenNguoiDung();
            
            NguoiDung objNDCheck = nguoiDungSevice.findById(tenNguoiDung);
            
            //Kiểm tra người dùng đã tồn tại chưa
            if(objNDCheck != null) {
                model.addAttribute("username_tonTai", "Tài khoản người dùng này đã tồn tại");
                return "dangky";
            }
            
            //Kiểm tra email tồn tại
            String email = objND.getEmail().trim();
            boolean b_email = nguoiDungSevice.kiemTraEmailTonTai(email);
            
            if(b_email)
            {
                model.addAttribute("email_tonTai", "Email người dùng này đã tồn tại");
                return "dangky";
            }
            
            //Kiểm tra số điện thoại tồn tại
            String dienThoai = objND.getDienThoai().trim();
            boolean b_dienThoai = nguoiDungSevice.kiemTraSDTTonTai(dienThoai);
            
            if(b_dienThoai)
            {
                model.addAttribute("dienThoai_tonTai", "Số điện thoại này đã tồn tại");
                return "dangky";
            }
            
            //Mã hóa mật khẩu
            String matKhauMH = BCrypt.hashpw(objND.getMatKhau(), BCrypt.gensalt());
            
            objND.setMatKhau(matKhauMH);
            objND.setVaiTro("customer");
            
            boolean ketQua = nguoiDungSevice.add(objND);
            
            if(ketQua) {
                return "register_success";
            }
            
            model.addAttribute("register_fail", "Đăng ký người dùng không thành công");
            return "dangky";
        }
    }
}
