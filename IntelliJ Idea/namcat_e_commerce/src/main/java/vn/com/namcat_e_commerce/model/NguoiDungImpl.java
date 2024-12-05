package vn.com.namcat_e_commerce.model;

import vn.com.namcat_e_commerce.entities.NguoiDung;

import java.util.List;

public class NguoiDungImpl implements NguoiDungDao {
    
    @Override
    public List<NguoiDung> getList() {
        return List.of();
    }
    
    @Override
    public NguoiDung findById(String id) {
        return null;
    }
    
    @Override
    public boolean add(NguoiDung nguoiDung) {
        return false;
    }
    
    @Override
    public boolean update(NguoiDung nguoiDung) {
        return false;
    }
    
    @Override
    public boolean delete(String id) {
        return false;
    }
}
