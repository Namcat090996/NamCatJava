package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.com.namcat_e_commerce.entities.GioHang;

import java.util.List;

public interface GioHangRepository extends JpaRepository<GioHang, Integer> {
    
    public List<GioHang> findAllByTenNguoiDung(String tenNguoiDung);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cart WHERE username = :tenNguoiDung", nativeQuery = true)
    public int deleteByTenNguoiDung(@Param("tenNguoiDung") String tenNguoiDung);
}
