package vn.com.namcat_e_commerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.namcat_e_commerce.entities.DonHang;
import vn.com.namcat_e_commerce.entities.GiaTien;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.model.*;

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
    
    @Test
    void contextLoads() {
        
        List<DonHang> lstDH = donHangDao.timDonHang("", "PENDING");
        
        String[] arr_maSP = {"1","2","3","4","5",};
        
        List<String> lstMaSP = Arrays.stream(arr_maSP).toList();
        
        String hoTen = "Huỳnh Nam Cát";
        if (hoTen.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")) {
            System.out.println("Hợp lệ");
        } else {
            System.out.println("Không hợp lệ");
        }
    }
    
}
