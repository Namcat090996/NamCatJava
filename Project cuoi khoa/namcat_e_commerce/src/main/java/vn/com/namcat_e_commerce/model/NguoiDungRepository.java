package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, String> {
    
    public NguoiDung findByEmail(String email);
    
    public NguoiDung findByDienThoai(String dienThoai);
}
