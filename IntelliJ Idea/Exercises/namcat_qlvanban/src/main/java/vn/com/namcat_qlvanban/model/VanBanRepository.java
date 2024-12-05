package vn.com.namcat_qlvanban.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.namcat_qlvanban.entities.VanBan;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface VanBanRepository extends JpaRepository<VanBan, String> {
    
    @Query(value = "Select vb from VanBan vb where " +
            "((length(:tuKhoa) = 0 or (length(:tuKhoa) > 0 and (vb.maVanBan like %:tuKhoa% or vb.tieuDe like %:tuKhoa%))) and " +
            "(length(:loaiVanBan) = 0 or (length(:loaiVanBan) > 0 and vb.loaiVanBan = :loaiVanBan)) and" +
            "(length(:donVi) = 0 or (length(:donVi) > 0 and vb.donVi = :donVi)))")
    public List<VanBan> timKiemVanBan(@Param("tuKhoa") String tuKhoa, @Param("loaiVanBan") String loaiVanBan, @Param("donVi") String donVi);
    
    @Query(value = "Select vb from VanBan vb where " +
            "((length(:tuKhoa) = 0 or (length(:tuKhoa) > 0 and (vb.maVanBan like %:tuKhoa% or vb.tieuDe like %:tuKhoa%))) and " +
            "(length(:loaiVanBan) = 0 or (length(:loaiVanBan) > 0 and vb.loaiVanBan = :loaiVanBan)) and" +
            "(length(:donVi) = 0 or (length(:donVi) > 0 and vb.donVi = :donVi)) and " +
            "(:tuNgay is null or vb.ngayTao >= :tuNgay) and " +
            "(:denNgay is null or vb.ngayTao <= :denNgay)) " +
            "ORDER BY CAST(SUBSTRING(vb.maVanBan, 3) AS int) ASC")
    public List<VanBan> timKiemVanBanTheoNgay(@Param("tuKhoa") String tuKhoa, @Param("loaiVanBan") String loaiVanBan, @Param("donVi") String donVi, @Param("tuNgay") LocalDate tuNgay, @Param("denNgay") LocalDate denNgay);
}
