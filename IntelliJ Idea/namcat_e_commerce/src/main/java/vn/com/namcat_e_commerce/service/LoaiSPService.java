package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.LoaiSanPham;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.model.LoaiSPDao;
import vn.com.namcat_e_commerce.model.SanPhamDao;

import java.util.List;

@Service
public class LoaiSPService {
    
    @Autowired
    LoaiSPDao loaiSPDao;
    
    public List<LoaiSanPham> getList() {
        return loaiSPDao.getList();
    }
    
    public LoaiSanPham findById(String id) {
        return loaiSPDao.findById(id);
    }
    
    public boolean add(LoaiSanPham objLSP) {
        return loaiSPDao.add(objLSP);
    }
    
    public boolean update(LoaiSanPham objLSP) {
        return loaiSPDao.update(objLSP);
    }
    
    public boolean delete(String id) {
        return loaiSPDao.delete(id);
    }
}
