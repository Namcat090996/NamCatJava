package vn.com.namcat_e_commerce.service;

import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.LoaiSanPham;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.model.LoaiSPDao;
import vn.com.namcat_e_commerce.model.NguoiDungDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class NguoiDungSevice {
    
    @Autowired
    NguoiDungDao nguoiDungDao;
    
    public boolean kiemTraEmailTonTai(String emai) {
        return nguoiDungDao.kiemTraEmailTonTai(emai);
    }
    
    public boolean kiemTraSDTTonTai(String dienThoai) {
        return nguoiDungDao.kiemTraSDTTonTai(dienThoai);
    }
    
    public List<NguoiDung> timNguoiDung(String tuKhoa) {
        return nguoiDungDao.timNguoiDung(tuKhoa);
    }
    
    public List<NguoiDung> getList() {
        return nguoiDungDao.getList();
    }
    
    public NguoiDung findById(String id) {
        return nguoiDungDao.findById(id);
    }
    
    public boolean add(NguoiDung objND) {
        return nguoiDungDao.add(objND);
    }
    
    public boolean update(NguoiDung objND) {
        return nguoiDungDao.update(objND);
    }
    
    public boolean delete(String id) {
        return nguoiDungDao.delete(id);
    }
}
