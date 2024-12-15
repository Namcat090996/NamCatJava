package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.LoaiSanPham;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.model.LoaiSPDao;
import vn.com.namcat_e_commerce.model.NguoiDungDao;

import java.util.List;

@Service
public class NguoiDungSevice {
    
    @Autowired
    NguoiDungDao nguoiDungDao;
    
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
