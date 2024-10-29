package vn.com.stanford.je0824.bookstore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.je0824.bookstore.entities.Sach;
import vn.com.stanford.je0824.bookstore.entities.SachMapper;

import java.util.List;

@Repository
public class SachImpl implements SachDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Sach> getList() {
        String strList = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, NgayTao, NgayCapNhat, TacGia, MaChuDe from Sach";
        return jdbcTemplate.query(strList, new SachMapper());
    }

    @Override
    public Sach getById(String maSach) {
        try {
            String strDetail = "Select * from Sach where MaSach = ?";
            return jdbcTemplate.queryForObject(strDetail, new SachMapper(), maSach);
        }
        catch (EmptyResultDataAccessException ex)
        {
            return null;
        }

    }

    @Override
    public boolean add(Sach obj) {
        String strInsert = "Insert into Sach(MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, NgayTao, NgayCapNhat, MaChuDe) values(?,?,?,?,?,?,?,?,?)";

        boolean ketQua = false;

        ketQua = jdbcTemplate.update(strInsert, obj.getMaSach(), obj.getTenSach(), obj.getMoTa(), obj.getAnhSach(), obj.getGiaSach(), obj.getTacGia(), obj.getNgayTao(), obj.getNgayCapNhat(), obj.getMaChuDe()) > 0;

        return ketQua;
    }

    @Override
    public boolean update(Sach obj) {
        String strUpdate = "Update Sach set TenSach=?,MoTa=?,AnhSach=?,GiaSach=?,TacGia=?,NgayCapNhat=?,MaChuDe=? where MaSach = ?";

        boolean ketQua = false;

        ketQua = jdbcTemplate.update(strUpdate, obj.getTenSach(), obj.getMoTa(), obj.getAnhSach(), obj.getGiaSach(), obj.getTacGia(), obj.getNgayCapNhat(), obj.getMaChuDe(), obj.getMaSach()) > 0;

        return ketQua;
    }

    @Override
    public boolean delete(String maSach) {
        String strDelete = "Delete from Sach where MaSach = ?";

        boolean ketQua = false;

        ketQua = jdbcTemplate.update(strDelete, maSach) > 0;

        return ketQua;
    }
}
