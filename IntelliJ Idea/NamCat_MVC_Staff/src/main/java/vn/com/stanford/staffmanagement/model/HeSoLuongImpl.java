package vn.com.stanford.staffmanagement.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.staffmanagement.entities.ChucVuMapper;
import vn.com.stanford.staffmanagement.entities.HeSoLuong;
import vn.com.stanford.staffmanagement.entities.HeSoLuongMapper;

import java.util.List;

@Repository
public class HeSoLuongImpl implements HeSoLuongDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Function to get list
     * @return
     */
    @Override
    public List<HeSoLuong> getList() {

        //Declare SQL command
        String strList = "Select Id, HeSo, PhuCap, MoTa from HeSoLuong";

        //Execute the queries and return the result
        return jdbcTemplate.query(strList, new HeSoLuongMapper());
    }

    @Override
    public HeSoLuong findById(String id) {
        return null;
    }

    @Override
    public boolean add(HeSoLuong heSoLuong) {
        return false;
    }

    @Override
    public boolean update(HeSoLuong heSoLuong) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
