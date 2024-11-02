package vn.com.stanford.je0824.bookstore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.je0824.bookstore.entities.ChuDe;
import vn.com.stanford.je0824.bookstore.entities.ChuDeMapper;

import java.util.List;

@Repository
public class ChuDeImpl implements ChuDeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Hàm lấy danh sách chủ đề
     * @return
     */
    @Override
    public List<ChuDe> getList() {
        String sql = "SELECT * FROM ChuDe";
        return jdbcTemplate.query(sql, new ChuDeMapper());
    }

    @Override
    public ChuDe getById(String id) {
        return null;
    }

    @Override
    public boolean add(ChuDe obj) {
        return false;
    }

    @Override
    public boolean update(ChuDe obj) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
