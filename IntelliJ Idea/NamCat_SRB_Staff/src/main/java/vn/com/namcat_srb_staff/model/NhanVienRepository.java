package vn.com.namcat_srb_staff.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.namcat_srb_staff.entities.NhanVien;

import java.util.List;

public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    
//    /**
//     * Function to get total salary list of staff
//     * @param tuKhoa
//     * @param maPhong
//     * @param maChucVu
//     * @return
//     */
//    @Query(value = "Select nv from NhanVien nv where " +
//            "((length(:keyword) = 0 or (length(:keyword) > 0 and (nv.maNV = :keyword or nv.hoTen like %:keyword%))) and " +
//            "(length(:maPhong) = 0 or (length(:maPhong) > 0 and nv.maPhong = :maPhong)) and" +
//            "(length(:maChucVu) = 0 or (length(:maChucVu) > 0 and nv.maChucVu = :maChucVu)))")
//    public List<NhanVien> layBangLuongNhanVien(@Param("keyword") String tuKhoa, @Param("maPhong") String maPhong, @Param("maChucVu") String maChucVu);
}
