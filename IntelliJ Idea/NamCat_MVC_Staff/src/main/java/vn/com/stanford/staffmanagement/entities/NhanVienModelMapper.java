package vn.com.stanford.staffmanagement.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanVienModelMapper implements RowMapper<NhanVienModel> {

    /**
     * Function to return a list or an object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public NhanVienModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        //Declare object
        NhanVienModel nhanVienModel = new NhanVienModel();

        //Get attributes for object
        nhanVienModel.setMaNV(rs.getString("MaNV"));
        nhanVienModel.setHoTen(rs.getString("HoTen"));
        nhanVienModel.setGioiTinh(rs.getInt("GioiTinh"));
        nhanVienModel.setNgaySinh(rs.getDate("NgaySinh"));
        nhanVienModel.setDienThoai(rs.getString("DienThoai"));
        nhanVienModel.setEmail(rs.getString("Email"));
        nhanVienModel.setDiaChi(rs.getString("DiaChi"));
        nhanVienModel.setTenPhong(rs.getString("TenPhong"));
        nhanVienModel.setTenChucVu(rs.getString("TenChucVu"));
        nhanVienModel.setTongLuong(rs.getInt("TongLuong"));

        //Return object
        return nhanVienModel;
    }
}
