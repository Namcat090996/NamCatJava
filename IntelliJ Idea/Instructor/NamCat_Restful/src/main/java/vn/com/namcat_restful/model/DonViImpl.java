package vn.com.namcat_restful.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_restful.entities.DonVi;

import java.util.List;

@Repository
public class DonViImpl implements DonViDao {
    
    @Autowired
    DonViRepository donViRepository;
    
    @Override
    public List<DonVi> getList() {
        return donViRepository.findAll();
    }
    
    @Override
    public DonVi findById(String id) {
        return null;
    }
    
    @Override
    public boolean add(DonVi donVi) {
        return false;
    }
    
    @Override
    public boolean update(DonVi donVi) {
        return false;
    }
    
    @Override
    public boolean delete(String id) {
        return false;
    }
}
