package vn.com.stanford.stanford_bookstore_sb_je0824;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.ChuDe;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.Sach;
import vn.com.stanford.stanford_bookstore_sb_je0824.model.ChuDeDao;
import vn.com.stanford.stanford_bookstore_sb_je0824.model.SachDao;

import java.util.List;

@SpringBootTest
class StanfordBookStoreSbJe0824ApplicationTests {

    @Autowired
    SachDao sachDao;

    @Autowired
    ChuDeDao chuDeDao;

    @Test
    void contextLoads() {
    }

    @Test
    void layDanhSachSach() {

        List<Sach> lstSach = sachDao.timKiemSach("", "");

        System.out.println("Danh sach sach: ");
        for (Sach s : lstSach)
        {
            System.out.println(s.getMaSach() + "\t" + s.getTenSach());
        }
    }

    @Test
    void layDanhSachChuDe() {

        List<ChuDe> lstChuDe = chuDeDao.getList();

        System.out.println("Danh sach chu de: ");
        for (ChuDe s : lstChuDe)
        {
            System.out.println(s.getMaChuDe() + "\t" + s.getTenChuDe());
        }
    }

}
