package vn.com.namcat_bookstore_sbt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.namcat_bookstore_sbt.entities.NguoiDung;
import vn.com.namcat_bookstore_sbt.model.NguoiDungDao;

import java.util.List;

@SpringBootTest
class NamCatBookStoreSbtApplicationTests {

    @Autowired
    NguoiDungDao nguoiDungDao;
    
    @Test
    void layDanhSachNguoiDung()
    {
        NguoiDung objUser = nguoiDungDao.layNguoiDungTheoTenDangNhap("admin");
        if(objUser != null)
        {
            System.out.println(objUser.getTenDangNhap());
        }
    }

}
