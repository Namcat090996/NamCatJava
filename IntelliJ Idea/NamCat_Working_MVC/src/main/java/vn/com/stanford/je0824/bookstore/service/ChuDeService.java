package vn.com.stanford.je0824.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.stanford.je0824.bookstore.entities.ChuDe;
import vn.com.stanford.je0824.bookstore.model.ChuDeDao;

import java.util.List;

@Service
public class ChuDeService {

    @Autowired
    ChuDeDao chuDeDao;

    public List<ChuDe> layDanhSach()
    {
        return chuDeDao.getList();
    }

    public ChuDe layChiTietCD(String maChuDe)
    {
        return chuDeDao.getById(maChuDe);
    }

    public boolean themCD(ChuDe chude)
    {
        return chuDeDao.add(chude);
    }

    public boolean capNhatCD(ChuDe chude)
    {
        return chuDeDao.update(chude);
    }

    public boolean xoaCD(String maChuDe)
    {
        return chuDeDao.delete(maChuDe);
    }
}
