package vn.com.namcat_e_commerce.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.namcat_e_commerce.entities.SanPham;

import java.time.LocalDate;
import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    
    @Query(value = "Select sp from SanPham sp where " +
            "((length(:tuKhoa) = 0 or (length(:tuKhoa) > 0 and sp.tenSanPham like %:tuKhoa%)))" +
            " and sp.daDuyet = 1 ORDER BY sp.giaSanPham ASC")
    public List<SanPham> timTheoTenSanPham(@Param("tuKhoa") String tuKhoa);
    
    
    @Query(value = "Select sp from SanPham sp where" +
            " (length(:tuKhoa) = 0 or (length(:tuKhoa) > 0 and sp.tenSanPham like %:tuKhoa%)) and" +
            " (length(:loaiSP) = 0 or (length(:loaiSP) > 0 and sp.loaiSanPham like %:loaiSP%))" +
            " ORDER BY sp.giaSanPham ASC")
    public List<SanPham> timSPTheoTenVaLoai(@Param("tuKhoa") String tuKhoa, @Param("loaiSP") String loaiSP);
    
}
