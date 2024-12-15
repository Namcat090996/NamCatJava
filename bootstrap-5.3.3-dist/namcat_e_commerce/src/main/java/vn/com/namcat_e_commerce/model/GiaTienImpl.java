package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.GiaTien;

import java.util.List;

@Repository
public class GiaTienImpl implements GiaTienDao {
    
    @Autowired
    GiaTienRepository giaTienRepository;
    
    @Override
    public List<GiaTien> getList() {
        return giaTienRepository.findAll();
    }
    
    @Override
    public GiaTien findById(Integer id) {
        return null;
    }
    
    @Override
    public boolean add(GiaTien giaTien) {
        return false;
    }
    
    @Override
    public boolean update(GiaTien giaTien) {
        return false;
    }
    
    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
