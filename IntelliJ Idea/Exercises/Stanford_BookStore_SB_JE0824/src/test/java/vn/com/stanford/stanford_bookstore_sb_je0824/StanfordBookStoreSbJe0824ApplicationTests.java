package vn.com.stanford.stanford_bookstore_sb_je0824;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.ChuDe;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.NguoiDung;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.Sach;
import vn.com.stanford.stanford_bookstore_sb_je0824.model.*;
import vn.com.stanford.stanford_bookstore_sb_je0824.service.ChuDeService;

import java.util.List;

@SpringBootTest
class StanfordBookStoreSbJe0824ApplicationTests {

    @Autowired
    SachDao sachDao;

    @Autowired
    ChuDeService chuDeService;

    @Test
    void contextLoads() {
    }

    @Test
    void layDanhSachSach() {

        List<Sach> lstSach = sachDao.getList();

        System.out.println("Danh sach sach: ");
        for (Sach s : lstSach)
        {
            System.out.println(s.getMaSach() + "\t" + s.getTenSach());
        }
    }

    @Test
    void layDanhSachChuDe() {

        List<ChuDe> lstChuDe = chuDeService.layDanhSach();

        System.out.println("Danh sach chu de: ");
        for (ChuDe s : lstChuDe)
        {
            System.out.println(s.getMaChuDe() + "\t" + s.getTenChuDe());
        }
    }

    @Autowired
    NguoiDungDao nguoiDungDao;

    @Test
    void layTaiKhoanDangNhap() {

        NguoiDung objUser = nguoiDungDao.layNguoiDungTheoTenDangNhap("admin");
        if(objUser != null)
        {
            System.out.println("Tài khoản người dùng: " + objUser.getTenDangNhap());
        }
    }
}
