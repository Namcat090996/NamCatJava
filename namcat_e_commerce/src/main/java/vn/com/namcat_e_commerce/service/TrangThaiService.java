package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.LoaiSanPham;
import vn.com.namcat_e_commerce.entities.TrangThai;
import vn.com.namcat_e_commerce.model.LoaiSPDao;
import vn.com.namcat_e_commerce.model.TrangThaiDao;

import java.util.List;

@Service
public class TrangThaiService {
    
    @Autowired
    TrangThaiDao trangThaiDao;
    
    public List<TrangThai> getList() {
        return trangThaiDao.getList();
    }
    
}
