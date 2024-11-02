package vn.com.stanford.staffmanagement.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChucVuMapper implements RowMapper<ChucVu> {

    /**
     * Function to return a list or an object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public ChucVu mapRow(ResultSet rs, int rowNum) throws SQLException {

        //Declare object
        ChucVu chucVu = new ChucVu();

        //Get attributes for object
        chucVu.setMaChucVu(rs.getString("MaChucVu"));
        chucVu.setTenChucVu(rs.getString("TenChucVu"));

        //Return object
        return chucVu;
    }
}
