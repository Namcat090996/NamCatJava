package vn.com.stanford.staffmanagement.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanVienMapper implements RowMapper<NhanVien> {

    /**
     * Function to return a list or an object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {
        //Declare object
        NhanVien nhanVien = new NhanVien();

        //Get attributes for object
        nhanVien.setMaNV(rs.getString("MaNhanVien"));
        nhanVien.setHoTen(rs.getString("HoTen"));
        nhanVien.setGioiTinh(rs.getInt("GioiTinh"));
        nhanVien.setNgaySinh(rs.getDate("NgaySinh"));
        nhanVien.setDienThoai(rs.getString("DienThoai"));
        nhanVien.setEmail(rs.getString("Email"));
        nhanVien.setDiaChi(rs.getString("DiaChi"));
        nhanVien.setSoCMT(rs.getString("SoCMT"));
        nhanVien.setNgayCap(rs.getDate("NgayCap"));
        nhanVien.setNoiCap(rs.getString("NoiCap"));
        nhanVien.setHeSoId(rs.getInt("HeSoId"));
        nhanVien.setMaChucVu(rs.getString("MaChucVu"));
        nhanVien.setMaPhong(rs.getString("MaPhong"));

        //Return object
        return nhanVien;
    }
}
