package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.TrangThai;

import java.util.List;

@Repository
public class TrangThaiImpl implements TrangThaiDao {
    
    @Autowired
    TrangThaiRepository trangThaiRepository;
    
    @Override
    public List<TrangThai> getList() {
        return trangThaiRepository.findAll();
    }
    
    @Override
    public TrangThai findById(String id) {
        return null;
    }
    
    @Override
    public boolean add(TrangThai trangThai) {
        return false;
    }
    
    @Override
    public boolean update(TrangThai trangThai) {
        return false;
    }
    
    @Override
    public boolean delete(String id) {
        return false;
    }
}
