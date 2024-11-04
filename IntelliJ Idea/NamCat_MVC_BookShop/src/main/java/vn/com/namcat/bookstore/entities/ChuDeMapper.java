package vn.com.namcat.bookstore.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChuDeMapper implements RowMapper<ChuDe> {

    @Override
    public ChuDe mapRow(ResultSet rs, int rowNum) throws SQLException {

        //Declare object
        ChuDe chuDe = new ChuDe();

        //Get attributes for object
        chuDe.setMaChuDe(rs.getString("MaChuDe"));
        chuDe.setTenChuDe(rs.getString("TenChuDe"));

        //Return object
        return chuDe;
    }
}
