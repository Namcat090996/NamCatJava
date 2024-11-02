package vn.com.stanford.staffmanagement.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.staffmanagement.entities.HeSoLuongMapper;
import vn.com.stanford.staffmanagement.entities.PhongBan;
import vn.com.stanford.staffmanagement.entities.PhongBanMapper;

import java.util.List;

@Repository
public class PhongBanImpl implements PhongBanDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<PhongBan> getList() {

        //Declare SQL command
        String strList = "Select MaPhong, TenPhong, DienThoai from PhongBan";

        //Execute the queries and return the result
        return jdbcTemplate.query(strList, new PhongBanMapper());
    }

    @Override
    public PhongBan findById(String id) {
        return null;
    }

    @Override
    public boolean add(PhongBan phongBan) {
        return false;
    }

    @Override
    public boolean update(PhongBan phongBan) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
