package vn.com.stanford.je0824.bookstore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.je0824.bookstore.entities.ChuDe;
import vn.com.stanford.je0824.bookstore.entities.ChuDeMapper;

import java.util.List;

@Repository
public class ChuDeImpl implements ChuDeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Hàm lấy danh sách chủ đề
     * @return
     */
    @Override
    public List<ChuDe> getList() {

        String strList = "Select * from ChuDe";

        return jdbcTemplate.query(strList, new ChuDeMapper());
    }

    @Override
    public ChuDe getById(String maChuDe) {
        try
        {
            String strDetail = "Select MaChuDe, TenChuDe from ChuDe where MaChuDe = ?";

            return jdbcTemplate.queryForObject(strDetail, new ChuDeMapper(), maChuDe);
        }
        catch(EmptyResultDataAccessException ex)
        {
            return null;
        }

    }

    @Override
    public boolean add(ChuDe chuDe) {
        String strAdd = "Insert into ChuDe(MaChuDe, TenChuDe) values(?,?)";

        boolean ketQua = false;

        ketQua = jdbcTemplate.update(strAdd, chuDe.getMaChuDe(), chuDe.getTenChuDe()) > 0;

        return ketQua;
    }

    @Override
    public boolean update(ChuDe chuDe) {
        String strUpdate = "Update ChuDe set TenChuDe = ? where MaChuDe = ?";

        boolean ketQua = false;

        ketQua = jdbcTemplate.update(strUpdate, chuDe.getTenChuDe(), chuDe.getMaChuDe()) > 0;

        return ketQua;
    }

    @Override
    public boolean delete(String maChuDe) {
        String strDelete = "Delete from ChuDe where MaChuDe = ?";

        boolean ketQua = false;

        ketQua = jdbcTemplate.update(strDelete, maChuDe) > 0;

        return ketQua;

    }
}
