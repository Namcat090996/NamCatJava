package vn.com.namcat.bookstore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.namcat.bookstore.entities.ChuDe;
import vn.com.namcat.bookstore.entities.ChuDeMapper;

import java.util.List;

@Repository
public class ChuDeImpl implements ChuDeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Function to get list
     * @return
     */
    @Override
    public List<ChuDe> getList() {
        //Declare SQL command
        String strList = "Select MaChuDe, TenChuDe from ChuDe";

        //Execute the queries and return the result
        return jdbcTemplate.query(strList, new ChuDeMapper());
    }

    /**
     * Function to get detailed object by id
     * @param id
     * @return
     */
    @Override
    public ChuDe findById(String id) {
        return null;
    }

    /**
     * Function to insert a new object
     * @param chuDe
     * @return
     */
    @Override
    public boolean add(ChuDe chuDe) {
        return false;
    }

    /**
     * Function update info of selected object
     * @param chuDe
     * @return
     */
    @Override
    public boolean update(ChuDe chuDe) {
        return false;
    }

    /**
     * Function to delete object by id
     * @param id
     * @return
     */
    @Override
    public boolean delete(String id) {
        return false;
    }
}
