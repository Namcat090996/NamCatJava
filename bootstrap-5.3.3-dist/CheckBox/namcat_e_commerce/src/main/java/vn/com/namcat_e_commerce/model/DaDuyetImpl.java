package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.DaDuyet;

import java.util.List;

@Repository
public class DaDuyetImpl implements DaDuyetDao {
    
    @Autowired
    DaDuyetRepository daDuyetRepository;
    
    @Override
    public List<DaDuyet> getList() {
        return daDuyetRepository.findAll();
    }
    
    @Override
    public DaDuyet findById(Integer id) {
        return null;
    }
    
    @Override
    public boolean add(DaDuyet daDuyet) {
        return false;
    }
    
    @Override
    public boolean update(DaDuyet daDuyet) {
        return false;
    }
    
    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
