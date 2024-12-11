package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.TrangThai;
import vn.com.namcat_e_commerce.entities.VaiTro;
import vn.com.namcat_e_commerce.model.TrangThaiDao;
import vn.com.namcat_e_commerce.model.VaiTroDao;

import java.util.List;

@Service
public class VaiTroService {
    
    @Autowired
    VaiTroDao vaiTroDao;
    
    public List<VaiTro> getList() {
        return vaiTroDao.getList();
    }
    
    public VaiTro findById(String id) {
        return vaiTroDao.findById(id);
    }
    
    public boolean add(VaiTro objVT) {
        return vaiTroDao.add(objVT);
    }
    
    public boolean update(VaiTro objVT) {
        return vaiTroDao.update(objVT);
    }
    
    public boolean delete(String id) {
        return vaiTroDao.delete(id);
    }
}
