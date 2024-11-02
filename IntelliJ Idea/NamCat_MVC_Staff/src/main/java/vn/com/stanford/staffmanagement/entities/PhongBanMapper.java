package vn.com.stanford.staffmanagement.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhongBanMapper implements RowMapper<PhongBan> {

    @Override
    public PhongBan mapRow(ResultSet rs, int rowNum) throws SQLException {

        //Declare object
        PhongBan phongBan = new PhongBan();

        //Get attributes for object
        phongBan.setMaPhong(rs.getString("MaPhong"));
        phongBan.setTenPhong(rs.getString("TenPhong"));
        phongBan.setDienThoai(rs.getString("DienThoai"));

        //Return object
        return phongBan;
    }
}
