package vn.com.stanford.je0824.bookstore.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChuDeMapper implements RowMapper<ChuDe> {
    @Override
    public ChuDe mapRow(ResultSet rs, int rowNum) throws SQLException {

        ChuDe chuDe = new ChuDe();

        chuDe.setMaChuDe(rs.getString("MaChuDe"));

        chuDe.setTenChuDe(rs.getString("TenChuDe"));

        return chuDe;
    }
}
