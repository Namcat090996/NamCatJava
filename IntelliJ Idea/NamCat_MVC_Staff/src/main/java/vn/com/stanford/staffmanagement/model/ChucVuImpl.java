package vn.com.stanford.staffmanagement.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.staffmanagement.entities.ChucVu;
import vn.com.stanford.staffmanagement.entities.ChucVuMapper;
import vn.com.stanford.staffmanagement.entities.NhanVienModelMapper;

import java.util.List;

@Repository
public class ChucVuImpl implements ChucVuDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Function to get list
     * @return
     */
    @Override
    public List<ChucVu> getList() {

        //Declare SQL command
        String strList = "Select MaChucVu, TenChucVu from ChucVu";

        //Execute the queries and return the result
        return jdbcTemplate.query(strList, new ChucVuMapper());
    }

    @Override
    public ChucVu findById(String id) {
        return null;
    }

    @Override
    public boolean add(ChucVu chucVu) {
        return false;
    }

    @Override
    public boolean update(ChucVu chucVu) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
