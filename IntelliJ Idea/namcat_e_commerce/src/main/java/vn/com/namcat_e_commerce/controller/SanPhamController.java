package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.entities.SanPhamModel;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.util.List;

@Controller
public class SanPhamController {
    
    @Autowired
    SanPhamService sanPhamService;
    
}
