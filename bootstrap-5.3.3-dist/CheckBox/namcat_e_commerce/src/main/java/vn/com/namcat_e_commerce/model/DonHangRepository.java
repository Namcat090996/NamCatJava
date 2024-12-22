package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_e_commerce.entities.DonHang;

public interface DonHangRepository extends JpaRepository<DonHang, String> {
}
