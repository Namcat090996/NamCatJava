package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.model.GioHangDao;
import vn.com.namcat_e_commerce.service.GioHangService;

@Controller
@SessionAttributes("Online_User")
public class GioHangController {

}
