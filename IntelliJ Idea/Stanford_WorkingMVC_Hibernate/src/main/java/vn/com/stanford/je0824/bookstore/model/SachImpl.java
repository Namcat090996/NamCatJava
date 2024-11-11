package vn.com.stanford.je0824.bookstore.model;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    JdbcTemplate jdbcTemplate;

    /**
     * Tìm kiếm thông tin sách theo nhiều tiêu chí
     * @param tuKhoa
     * @param maCD
     * @return
     */
    @Override
    public List<Sach> timKiemSach(String tuKhoa, String maCD)
    {
        String strSQL = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, NgayTao, NgayCapNhat, TacGia, MaChuDe from Sach where 1=1";
        if(tuKhoa!= null && !tuKhoa.isEmpty())
        {
            strSQL += " and (MaSach = '" + tuKhoa + "' OR TenSach like '%" + tuKhoa + "%' OR TacGia like '%" + tuKhoa + "%')";
        }

        if(maCD!= null && !maCD.isEmpty())
        {
            strSQL+= " and MaChuDe = '" + maCD + "'";
        }

        List<Sach> lstSach = new ArrayList<Sach>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        TypedQuery<Sach> query = session.createNativeQuery(strSQL, Sach.class);

        lstSach = query.getResultList();

        tx.commit();

        return lstSach;
    }

    @Override
    public List<Sach> getList() {
        List<Sach> lstSach = new ArrayList<Sach>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        TypedQuery<Sach> query = session.createQuery("from Sach", Sach.class);

        lstSach = query.getResultList();

        tx.commit();

        return lstSach;
    }

    @Override
    public Sach getById(String maSach) {

        Sach objSach = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        objSach = session.get(Sach.class, maSach);

        tx.commit();

        return objSach;
    }

    @Override
    public boolean add(Sach obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        Object objSach = session.save(obj);

        tx.commit();

        if(objSach != null)
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean update(Sach obj) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        session.update(obj);

        tx.commit();

        return true;
    }

    @Override
    public boolean delete(String id) {

        String strDelete = "Delete from Sach where MaSach = ?";

        boolean ketQua = false;
        ketQua = jdbcTemplate.update(strDelete, id) > 0;

        return ketQua;
    }
}
