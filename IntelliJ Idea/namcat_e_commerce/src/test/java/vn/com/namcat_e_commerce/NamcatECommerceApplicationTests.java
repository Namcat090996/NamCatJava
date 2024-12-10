package vn.com.namcat_e_commerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.model.SanPhamDao;

import java.util.List;

@SpringBootTest
class NamcatECommerceApplicationTests {
    
    @Autowired
    SanPhamDao sanPhamDao;
    
    @Test
    void contextLoads() {
        
        List<SanPham> lstSP = sanPhamDao.timSPTheoLoai("", "DSC");
        
        for(SanPham sp : lstSP)
        {
            System.out.println(sp.getTenSanPham() + "-----" + sp.getGiaSanPham() + "-----" + sp.getLoaiSanPham());
        }
    }
    
}
