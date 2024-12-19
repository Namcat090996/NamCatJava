package vn.com.stanford.stanford_bookstore_sb_je0824.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.NguoiDung;
import vn.com.stanford.stanford_bookstore_sb_je0824.model.NguoiDungDao;

@Service
public class NguoiDungService {

    @Autowired
    NguoiDungDao nguoiDungDao;

    public NguoiDung layThongTinDangNhap(String tenDangNhap)
    {
        return nguoiDungDao.layNguoiDungTheoTenDangNhap(tenDangNhap);
    }
}
