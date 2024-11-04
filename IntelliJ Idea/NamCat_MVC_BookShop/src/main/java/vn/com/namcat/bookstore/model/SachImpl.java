package vn.com.namcat.bookstore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.namcat.bookstore.entities.Sach;
import vn.com.namcat.bookstore.entities.SachMapper;

import java.util.List;

@Repository
public class SachImpl implements SachDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Function to get list
     * @return
     */
    @Override
    public List<Sach> getList() {
        //Declare SQL command
        String strList = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, NgayTao, NgayCapNhat, TacGia, MaChuDe from Sach";

        //Execute the queries and return result
        return jdbcTemplate.query(strList, new SachMapper());
    }

    /**
     * Function to get detailed object by id
     * @param maSach
     * @return
     */
    @Override
    public Sach findById(String maSach) {
        //Use try-catch if no id is found
        try
        {
            //Declare SQL command
            String strDetail = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, NgayTao, NgayCapNhat, TacGia, MaChuDe from Sach where MaSach = ?";

            //Execute the queries and return result
            return jdbcTemplate.queryForObject(strDetail, new SachMapper(), maSach);
        }
        catch (EmptyResultDataAccessException ex)
        {
            return null;
        }
    }

    /**
     * Function to insert a new object
     * @param obj
     * @return
     */
    @Override
    public boolean add(Sach obj) {
        //Declare SQL command
        String strInsert = "Insert into Sach(MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, NgayTao, NgayCapNhat, MaChuDe) values(?,?,?,?,?,?,?,?,?)";

        //Declare a boolean
        boolean ketQua = false;

        //Execute the queries
        ketQua = jdbcTemplate.update(strInsert, obj.getMaSach(), obj.getTenSach(), obj.getMoTa(), obj.getAnhSach(), obj.getGiaSach(), obj.getTacGia(), obj.getNgayTao(), obj.getNgayCapNhat(), obj.getMaChuDe()) > 0;

        //return result
        return ketQua;
    }

    /**
     * Function update info of selected object
     * @param obj
     * @return
     */
    @Override
    public boolean update(Sach obj) {
        //Declare SQL command
        String strUpdate = "Update Sach set TenSach = ?, MoTa = ?, AnhSach = ?, GiaSach = ?, TacGia = ?, NgayCapNhat = ?, MaChuDe = ? where MaSach = ?";

        //Declare a boolean
        boolean ketQua = false;

        //Execute the queries
        ketQua = jdbcTemplate.update(strUpdate, obj.getTenSach(), obj.getMoTa(), obj.getAnhSach(), obj.getGiaSach(), obj.getTacGia(), obj.getNgayCapNhat(), obj.getMaChuDe(), obj.getMaSach()) > 0;

        //return result
        return ketQua;
    }

    /**
     * Function to delete object by id
     * @param maSach
     * @return
     */
    @Override
    public boolean delete(String maSach) {
        //Declare SQL command
        String strDelete = "Delete from Sach where MaSach = ?";

        //Declare a boolean
        boolean ketQua = false;

        //Execute the queries
        ketQua = jdbcTemplate.update(strDelete, maSach) > 0;

        //return result
        return ketQua;
    }
}
