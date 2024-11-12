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
    /**
     * Hàm lấy danh sách chủ đề
     * @return
     */
    @Override
    public List<ChuDe> getList() {
        //Khai báo danh sách
        List<ChuDe> lstChuDe = new ArrayList<>();

        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Bắt đầu phiên làm việc
        Transaction tx = session.beginTransaction();

        TypedQuery<ChuDe> query = session.createQuery("from ChuDe", ChuDe.class);

        lstChuDe = query.getResultList();

        tx.commit();

        return lstChuDe;
    }

    @Override
    public ChuDe getById(String id) {
        ChuDe objChuDe = null;
        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Bắt đầu phiên làm việc
        Transaction tx = session.beginTransaction();

        objChuDe = session.get(ChuDe.class, id);

        tx.commit();

        return objChuDe;
    }

    @Override
    public boolean add(ChuDe objCD) {

        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Bắt đầu phiên làm việc
        Transaction tx = session.beginTransaction();
        Object obj = session.save(objCD);
        tx.commit();
        if(obj != null)
            return  true;
        return false;
    }

    @Override
    public boolean update(ChuDe obj) {

        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Bắt đầu phiên làm việc
        Transaction tx = session.beginTransaction();
        session.update(obj);
        tx.commit();

        return  true;
    }

    @Override
    public boolean delete(String id) {
        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Bắt đầu phiên làm việc
        Transaction tx = session.beginTransaction();
        ChuDe objCD = session.get(ChuDe.class, id);
        if(objCD != null)
        {
            session.delete(objCD);

            tx.commit();

            return true;
        }

        return false;
    }
}
