package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.LoaiSanPham;
import vn.com.namcat_e_commerce.entities.MauSac;
import vn.com.namcat_e_commerce.model.LoaiSPDao;
import vn.com.namcat_e_commerce.model.MauSacDao;

import java.util.List;

@Service
public class MauSacService {
    
    @Autowired
    MauSacDao mauSacDao;
    
    public List<MauSac> getList() {
        return mauSacDao.getList();
    }
    
    public MauSac findById(Integer id) {
        return mauSacDao.findById(id);
    }
    
    public boolean add(MauSac objMS) {
        return mauSacDao.add(objMS);
    }
    
    public boolean update(MauSac objMS) {
        return mauSacDao.update(objMS);
    }
    
    public boolean delete(Integer id) {
        return mauSacDao.delete(id);
    }
}
