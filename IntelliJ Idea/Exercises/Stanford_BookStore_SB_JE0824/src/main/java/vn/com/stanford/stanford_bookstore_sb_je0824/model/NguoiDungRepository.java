package vn.com.stanford.stanford_bookstore_sb_je0824.model;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {

    NguoiDung findByTenDangNhap(String ten);
}
