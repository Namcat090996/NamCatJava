package vn.com.namcat_bookstore_sbt.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.namcat_bookstore_sbt.entities.Sach;

import java.util.List;

public interface SachRepository extends JpaRepository<Sach, String> {

    //Declare extension function if needed

    /**
     * Function to find book by keyword and subject code
     * @param tuKhoa
     * @param maChuDe
     * @return
     */
    @Query("SELECT s from Sach s where ((length(:keyword) = 0 or (length(:keyword) > 0 and (s.maSach = :keyword or s.tenSach like %:keyword% or s.tacGia like %:keyword%))) and (length(:maChuDe) = 0 or (length(:maChuDe) > 0 and s.maChuDe = :maChuDe)))")
    public List<Sach> timKiemSach(@Param("keyword") String tuKhoa, @Param("maChuDe") String maChuDe);

    /**
     * Function to find book by subject code
     * @param maChuDe
     * @return
     */
    public Sach findByMaChuDe(String maChuDe);
}
