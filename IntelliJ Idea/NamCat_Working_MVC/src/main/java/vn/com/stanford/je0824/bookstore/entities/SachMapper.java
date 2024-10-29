package vn.com.stanford.je0824.bookstore.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SachMapper implements RowMapper<Sach> {

    @Override
    public Sach mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sach objSach = new Sach();

        objSach.setMaSach(rs.getString("MaSach"));

        objSach.setTenSach(rs.getString("TenSach"));

        objSach.setMoTa(rs.getString("MoTa"));

        objSach.setAnhSach(rs.getString("AnhSach"));

        objSach.setGiaSach(rs.getInt("GiaSach"));

        objSach.setTacGia(rs.getString("TacGia"));

        objSach.setMaChuDe(rs.getString("MaChuDe"));

        objSach.setNgayTao(rs.getDate("NgayTao"));

        objSach.setNgayTao(rs.getDate("NgayCapNhat"));

        return objSach;
    }
}
