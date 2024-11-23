package vn.com.namcat_srb_staff.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_srb_staff.entities.ChucVu;

import java.util.List;

@Repository
public class ChucVuImpl implements ChucVuDao {
    
    @Autowired
    ChucVuRepository chucVuRepository;
    
    @Override
    public List<ChucVu> getList() {
        return chucVuRepository.findAll();
    }
    
    @Override
    public ChucVu findById(String id) {
        return null;
    }
    
    @Override
    public boolean add(ChucVu chucVu) {
        return false;
    }
    
    @Override
    public boolean update(ChucVu chucVu) {
        return false;
    }
    
    @Override
    public boolean delete(String id) {
        return false;
    }
}
