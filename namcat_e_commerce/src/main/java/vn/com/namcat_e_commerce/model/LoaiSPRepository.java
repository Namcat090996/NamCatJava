package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_e_commerce.entities.LoaiSanPham;

public interface LoaiSPRepository extends JpaRepository<LoaiSanPham, String> {
}
