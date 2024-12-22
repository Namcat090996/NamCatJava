package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_e_commerce.entities.AnhSanPham;

import java.util.List;

public interface AnhSanPhamRepository extends JpaRepository<AnhSanPham, Integer> {
    
    public List<AnhSanPham> findAllByMaSanPham(String maSP);
}
