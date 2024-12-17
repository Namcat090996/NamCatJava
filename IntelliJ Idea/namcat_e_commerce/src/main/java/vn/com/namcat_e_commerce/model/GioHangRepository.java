package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_e_commerce.entities.GioHang;

public interface GioHangRepository extends JpaRepository<GioHang, Integer> {
}
