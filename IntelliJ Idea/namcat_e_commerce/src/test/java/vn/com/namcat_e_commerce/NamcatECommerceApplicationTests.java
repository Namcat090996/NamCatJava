package vn.com.namcat_e_commerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.namcat_e_commerce.entities.DonHang;
import vn.com.namcat_e_commerce.entities.GiaTien;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.model.*;

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
    
    
    
    @Test
    void contextLoads() {
        
        List<SanPham> lstSP = sanPhamDao.layDSHangHot();
        
        List<SanPham> lstSP2 = sanPhamDao.layDSHangMoi();
        
        List<DonHang> lstDH = donHangDao.timDonHang("", "PENDING");
    }
    
}
