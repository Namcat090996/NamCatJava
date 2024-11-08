package vn.com.stanford.je0824.bookstore.model;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.je0824.bookstore.entities.Sach;
import vn.com.stanford.je0824.bookstore.entities.SachMapper;

import java.util.ArrayList;
import java.util.List;

@Repository("sachDao")
public class SachImpl implements SachDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Tìm kiếm thông tin sách theo nhiều tiêu chí
     * @param tuKhoa
     * @param maCD
     * @return
     */
    @Override
    public List<Sach> timKiemSach(String tuKhoa, String maCD)
    {
        String strSQL = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach,DaDuyet, NgayTao, NgayCapNhat, TacGia, MaChuDe from Sach where 1=1";
        if(tuKhoa!= null && !tuKhoa.isEmpty())
        {
            strSQL += " and (MaSach = '" + tuKhoa + "' OR TenSach like '%" + tuKhoa + "%' OR TacGia like '%" + tuKhoa + "%')";
        }

        if(maCD!= null && !maCD.isEmpty())
        {
            strSQL+= " and MaChuDe = '" + maCD + "'";
        }

        //Khai báo danh sách
        List<Sach> lstSach = new ArrayList<>();

        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Bắt đầu phiên làm việc
        Transaction tx = session.beginTransaction();

        TypedQuery<Sach> query = session.createNativeQuery(strSQL, Sach.class);

        lstSach = query.getResultList();

        tx.commit();

        return lstSach;
    }

    @Override
    public List<Sach> getList() {

        //Khai báo danh sách
        List<Sach> lstSach = new ArrayList<>();

        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Bắt đầu phiên làm việc
        Transaction tx = session.beginTransaction();

        TypedQuery<Sach> query = session.createQuery("from Sach", Sach.class);

        lstSach = query.getResultList();

        tx.commit();

        return lstSach;
    }

    @Override
    public Sach getById(String maSach) {

        Sach objSach = null;
        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Bắt đầu phiên làm việc
        Transaction tx = session.beginTransaction();

        objSach = session.get(Sach.class, maSach);

        tx.commit();

        return objSach;
    }

    @Override
    public boolean add(Sach objSach) {
        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Bắt đầu phiên làm việc
        Transaction tx = session.beginTransaction();
        Object obj = session.save(objSach);
        tx.commit();
        if(obj != null)
            return  true;
        return false;
    }

    @Override
    public boolean update(Sach obj) {
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
        Sach objSach = session.get(Sach.class, id);
        if(objSach != null)
        {
            session.delete(objSach);

            tx.commit();

            return true;
        }

        return false;
    }
}
