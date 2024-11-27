package vn.com.namcat_bookstore_sbt.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_bookstore_sbt.entities.NguoiDung;

import java.util.List;

@Repository
public class NguoiDungImpl implements NguoiDungDao {
    
    @Autowired
    NguoiDungRepository nguoiDungRepository;
    
    @Override
    public List<NguoiDung> getList() {
        return nguoiDungRepository.findAll();
    }
    
    @Override
    public NguoiDung getById(Integer id) {
        return nguoiDungRepository.getById(id.intValue());
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
    public boolean delete(Integer id) {
        return false;
    }
    
    public NguoiDung layNguoiDungTheoTenDangNhap(String ten)
    {
        return nguoiDungRepository.findByTenDangNhap(ten);
    }
}
