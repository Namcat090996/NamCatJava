package vn.com.namcat_srb_staff.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_srb_staff.entities.HeSoLuong;

import java.util.List;

@Repository
public class HeSoLuongImpl implements HeSoLuongDao {
    
    @Autowired
    HeSoLuongRepository heSoLuongRepository;
    
    @Override
    public List<HeSoLuong> getList() {
        return heSoLuongRepository.findAll();
    }
    
    @Override
    public HeSoLuong findById(Integer id) {
        return null;
    }
    
    @Override
    public boolean add(HeSoLuong heSoLuong) {
        return false;
    }
    
    @Override
    public boolean update(HeSoLuong heSoLuong) {
        return false;
    }
    
    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
