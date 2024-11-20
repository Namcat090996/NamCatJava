package vn.com.stanford.stanford_bookstore_sb_je0824.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.Sach;
import vn.com.stanford.stanford_bookstore_sb_je0824.model.SachDao;

import java.util.List;

@Service
public class SachService {

    @Autowired
    SachDao sachDao;

    public List<Sach> timKiemThongTinSach(String tuKhoa, String maChuDe)
    {
        return sachDao.timKiemSach(tuKhoa, maChuDe);
    }

    public List<Sach> layDanhSach()
    {
        return  sachDao.getList();
    }

    public Sach layChiTiet(String maSach)
    {
        return  sachDao.getById(maSach);
    }

    public boolean themMoi(Sach objSach)
    {
        return sachDao.add(objSach);
    }

    public boolean capNhat(Sach objSach)
    {
        return sachDao.update(objSach);
    }

    public boolean xoa(String maSach)
    {
        return sachDao.delete(maSach);
    }

}
