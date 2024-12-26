package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_e_commerce.entities.DonHang;
import vn.com.namcat_e_commerce.entities.GioHang;

import java.util.List;

public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
    
    public long countAllByTenNguoiDung(String tenNguoiDung);
    
    public List<DonHang> findAllByTenNguoiDung(String tenNguoiDung);
}
