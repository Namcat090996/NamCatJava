package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    
    public List<SanPham> findByTenSanPhamLike(String tuKhoa);
    
}
