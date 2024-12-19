package vn.com.stanford.stanford_bookstore_sb_je0824.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.Sach;

import java.util.List;

public interface SachRepository extends JpaRepository<Sach, String> {
    @Query("SELECT s FROM Sach s WHERE ((s.tenSach like :tuKhoa OR s.maSach = :tuKhoa OR s.tacGia like :tuKhoa) AND (LENGTH(:maChuDe) = 0 OR (LENGTH(:maChuDe) > 0 AND s.maChuDe = :maChuDe)))")
    public List<Sach> timKiemSach(@Param("tuKhoa") String tuKhoa, @Param("maChuDe") String maChuDe);

    public List<Sach> findByMaChuDe(String maChuDe);
}
