package vn.com.stanford.staffmanagement.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.staffmanagement.entities.NhanVien;
import vn.com.stanford.staffmanagement.entities.NhanVienModelMapper;
import vn.com.stanford.staffmanagement.entities.NhanVienModel;

import java.util.List;

@Repository
public class NhanVienImpl implements NhanVienDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Function to get total salary list of staff
     * @return
     */
    @Override
    public List<NhanVienModel> danhSachTongLuongNV() {

        //Declare SQL command
        String strSalary = "Select * from vBangLuongNhanVien";

        //Return the result
        return jdbcTemplate.query(strSalary, new NhanVienModelMapper());
    }

    @Override
    public List<NhanVien> getList() {
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public NhanVien findById(String id) {
        return null;
    }

    @Override
    public boolean add(NhanVien nhanVien) {
        return false;
    }

    @Override
    public boolean update(NhanVien nhanVien) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
