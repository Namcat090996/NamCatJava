package vn.com.stanford.stanford_bookstore_sb_je0824.model;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.ChuDe;

import java.util.ArrayList;
import java.util.List;

@Repository("chuDeDao")
public class ChuDeImpl implements ChuDeDao {

    ChuDeRepository chuDeRepository;

    /**
     * Hàm lấy danh sách chủ đề
     * @return
     */
    @Override
    public List<ChuDe> getList() {
        return chuDeRepository.findAll();
    }

    @Override
    public ChuDe getById(String maSach) {
        ChuDe objChuDe = null;

        objChuDe = chuDeRepository.findById(maSach).get();

        return objChuDe;
    }

    @Override
    public boolean add(ChuDe objCD) {

        ChuDe objChuDe = chuDeRepository.save(objCD);

        if(objCD != null)
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean update(ChuDe obj) {

        ChuDe objCD = getById(obj.getMaChuDe());

        if(objCD != null)
        {
            //Gan lai gia tri
            objCD.setTenChuDe(obj.getTenChuDe());
            chuDeRepository.save(objCD);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        //Kết nối đến db qua hibernate
        ChuDe objCD = getById(id);
        if(objCD != null)
        {
            chuDeRepository.delete(objCD);
            return true;
        }
        return false;
    }
}
