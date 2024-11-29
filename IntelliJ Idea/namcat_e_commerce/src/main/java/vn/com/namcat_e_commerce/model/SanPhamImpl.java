package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.List;

@Repository
public class SanPhamImpl implements SanPhamDao {
    
    @Autowired
    SanPhamRepository sanPhamRepository;
    
    @Override
    public List<SanPham> getList() {
        return sanPhamRepository.findAll();
    }
    
    @Override
    public SanPham findById(Integer id) {
        return null;
    }
    
    @Override
    public boolean add(SanPham sanPham) {
        return false;
    }
    
    @Override
    public boolean update(SanPham sanPham) {
        return false;
    }
    
    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
