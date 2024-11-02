package vn.com.stanford.staffmanagement.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HeSoLuongMapper implements RowMapper<HeSoLuong> {

    @Override
    public HeSoLuong mapRow(ResultSet rs, int rowNum) throws SQLException {

        //Declare object
        HeSoLuong heSoLuong = new HeSoLuong();

        //Get attributes for object
        heSoLuong.setId(rs.getInt("Id"));
        heSoLuong.setHeSo(rs.getFloat("HeSo"));
        heSoLuong.setPhuCap(rs.getInt("PhuCap"));
        heSoLuong.setMoTa(rs.getString("MoTa"));

        //Return object
        return heSoLuong;
    }
}
