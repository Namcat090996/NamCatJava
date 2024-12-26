package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_e_commerce.entities.DonHang;
import vn.com.namcat_e_commerce.entities.DonHangChiTiet;

import java.util.List;

public interface DHChiTietRepository extends JpaRepository<DonHangChiTiet, Integer> {
    
    public List<DonHangChiTiet> findAllByMaDonHang(String maDonHang);
}
