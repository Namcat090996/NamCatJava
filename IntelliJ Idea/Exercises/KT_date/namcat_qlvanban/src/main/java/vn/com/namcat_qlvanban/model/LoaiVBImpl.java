package vn.com.namcat_qlvanban.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_qlvanban.entities.LoaiVanBan;

import java.util.List;

@Repository
public class LoaiVBImpl implements LoaiVanBanDao {
    
    @Autowired
    LoaiVBRepository loaiVBRepository;
    
    @Override
    public List<LoaiVanBan> getList() {
        return loaiVBRepository.findAll();
    }
    
    @Override
    public LoaiVanBan findById(String id) {
        return null;
    }
    
    @Override
    public boolean add(LoaiVanBan loaiVanBan) {
        return false;
    }
    
    @Override
    public boolean update(LoaiVanBan loaiVanBan) {
        return false;
    }
    
    @Override
    public boolean delete(String id) {
        return false;
    }
}
