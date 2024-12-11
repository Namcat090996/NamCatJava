package vn.com.namcat_e_commerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.model.NguoiDungDao;
import vn.com.namcat_e_commerce.model.SanPhamDao;

import java.util.List;

@SpringBootTest
class NamcatECommerceApplicationTests {
    
    @Autowired
    SanPhamDao sanPhamDao;
    
    @Autowired
    NguoiDungDao nguoiDungDao;
    
    @Test
    void contextLoads() {
        
        List<SanPham> lstSP = sanPhamDao.timSPTheoLoai("", "ASC", "", -1, -1);
        
        List<SanPham> lstSP2 = sanPhamDao.timSPTheoTen("Máy");
        
        List<SanPham> lstSP3 = sanPhamDao.hienThiSanPhamDaDuyet();
        
        NguoiDung nguoiDung = nguoiDungDao.findById("admin");
        
        System.out.println(nguoiDung.getTenNguoiDung());
        
        for(SanPham sp : lstSP3)
        {
            System.out.println(sp.getTenSanPham() + "-----" + sp.getGiaSanPham() + "-----" + sp.getLoaiSanPham());
        }
    }
    
}
