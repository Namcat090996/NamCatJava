package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_e_commerce.entities.GioHang;

import java.util.List;

public interface GioHangRepository extends JpaRepository<GioHang, Integer> {
    
    public List<GioHang> findAllByTenNguoiDung(String tenNguoiDung);
}
