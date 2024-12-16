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
        
        List<SanPham> lstSP = sanPhamDao.timSPTheoLoaiVaGiaKhongDuyet("","","", 0, 0, -1);
        
        SanPham objSP = sanPhamDao.findById("DT01");
        
        SanPham objSP2 = sanPhamRepository.findByTenSanPham("Laptop MSI Prestige 14 AI Studio C1UDXG-058VN");
        
        boolean ketQua = sanPhamDao.delete("DT01");
        
        List<SanPham> lstSP2 = sanPhamDao.timSPTheoTen("Máy");
        
        NguoiDung nguoiDung = nguoiDungDao.findById("admin");
        
        String dienThoai = "070303994888";
        
        boolean b_dienThoai = dienThoai.matches("\\d{10}");
        
    }
    
}
