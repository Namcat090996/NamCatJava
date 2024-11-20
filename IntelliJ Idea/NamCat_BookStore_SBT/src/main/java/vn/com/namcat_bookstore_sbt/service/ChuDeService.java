package vn.com.namcat_bookstore_sbt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_bookstore_sbt.entities.ChuDe;
import vn.com.namcat_bookstore_sbt.model.ChuDeDao;

import java.util.List;

@Service
public class ChuDeService {

    @Autowired
    ChuDeDao chuDeDao;

    public List<ChuDe> layDanhSach()
    {
        return chuDeDao.getList();
    }

    public ChuDe layChiTiet(String maChuDe)
    {
        return chuDeDao.getById(maChuDe);
    }

    public boolean themMoi(ChuDe objChuDe)
    {
        return chuDeDao.add(objChuDe);
    }

    public boolean capNhat(ChuDe objChuDe)
    {
        return chuDeDao.update(objChuDe);
    }

    public boolean xoa(String maSach)
    {
        return chuDeDao.delete(maSach);
    }
}
