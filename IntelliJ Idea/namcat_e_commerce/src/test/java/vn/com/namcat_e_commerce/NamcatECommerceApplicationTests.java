package vn.com.namcat_e_commerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.namcat_e_commerce.entities.*;
import vn.com.namcat_e_commerce.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class NamcatECommerceApplicationTests {
    
    @Autowired
    SanPhamDao sanPhamDao;
    
    @Autowired
    NguoiDungDao nguoiDungDao;
    
    @Autowired
    SanPhamRepository sanPhamRepository;
    
    @Autowired
    DonHangDao donHangDao;
    
    @Autowired
    GioHangDao gioHangDao;
    
    @Autowired
    GioHangRepository gioHangRepository;
    
    @Test
    void contextLoads() {
        
        List<String> lstLoaiSanPham = new ArrayList<>();
        List<String> lstMauSac = new ArrayList<>();
        
        lstLoaiSanPham.add("Màn hình");
        lstLoaiSanPham.add("Điện thoại");
        lstMauSac.add("Đỏ");
        lstMauSac.add("Trắng");
        
        List<SanPham> lstSanPham = sanPhamDao.timSPTheoLoaiVaGiaDaDuyet(lstLoaiSanPham,"",lstMauSac,0,0);
        
    }
    
}
