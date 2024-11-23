package vn.com.namcat_srb_staff.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_srb_staff.entities.PhongBan;

import java.util.List;

@Repository
public class PhongBanImpl implements PhongBanDao {
    
    @Autowired
    PhongBanRepository phongBanRepository;
    
    @Override
    public List<PhongBan> getList() {
        return phongBanRepository.findAll();
    }
    
    @Override
    public PhongBan findById(String id) {
        return null;
    }
    
    @Override
    public boolean add(PhongBan phongBan) {
        return false;
    }
    
    @Override
    public boolean update(PhongBan phongBan) {
        return false;
    }
    
    @Override
    public boolean delete(String id) {
        return false;
    }
}
