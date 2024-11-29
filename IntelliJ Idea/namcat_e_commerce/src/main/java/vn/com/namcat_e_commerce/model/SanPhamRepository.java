package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    
    @Query(value = "")
    public List<SanPham> timkiemSP(@Param("keyword") String tuKhoa, @Param("keyword") String tuKhoa)
}
