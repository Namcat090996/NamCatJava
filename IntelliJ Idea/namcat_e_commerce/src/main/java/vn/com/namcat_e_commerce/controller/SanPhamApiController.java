package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.service.SanPhamService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class SanPhamApiController {
    
    @Autowired
    SanPhamService sanPhamService;
    

}
