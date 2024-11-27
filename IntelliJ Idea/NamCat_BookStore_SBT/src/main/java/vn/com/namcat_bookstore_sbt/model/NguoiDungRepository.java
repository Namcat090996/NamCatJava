package vn.com.namcat_bookstore_sbt.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.namcat_bookstore_sbt.entities.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    
    NguoiDung findByTenDangNhap(String ten);
}
