package vn.com.namcat_e_commerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.namcat_e_commerce.entities.GiaTien;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.model.GiaTienDao;
import vn.com.namcat_e_commerce.model.NguoiDungDao;
import vn.com.namcat_e_commerce.model.SanPhamDao;
import vn.com.namcat_e_commerce.model.SanPhamRepository;

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
    GiaTienDao giaTienDao;
    
    @Test
    void contextLoads() {
        
        List<SanPham> lstSP = sanPhamDao.timSPTheoLoaiVaGia("","","", 0, 0);
        
        List<GiaTien> lstGT = giaTienDao.getList();
        
        SanPham SP = sanPhamDao.findById(1);
        
        List<SanPham> lstSP2 = sanPhamDao.timSPTheoTen("Máy");
        
        NguoiDung nguoiDung = nguoiDungDao.findById("admin");
        
    }
    
}
