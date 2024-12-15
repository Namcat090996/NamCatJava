package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.VaiTro;

import java.util.List;

@Repository
public class VaiTroImpl implements VaiTroDao {
    
    @Autowired
    VaiTroRepository vaiTroRepository;
    
    @Override
    public List<VaiTro> getList() {
        return vaiTroRepository.findAll();
    }
    
    @Override
    public VaiTro findById(String id) {
        return null;
    }
    
    @Override
    public boolean add(VaiTro vaiTro) {
        return false;
    }
    
    @Override
    public boolean update(VaiTro vaiTro) {
        return false;
    }
    
    @Override
    public boolean delete(String id) {
        return false;
    }
}
