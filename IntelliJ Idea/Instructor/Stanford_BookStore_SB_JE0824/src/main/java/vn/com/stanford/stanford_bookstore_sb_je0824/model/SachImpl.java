package vn.com.stanford.stanford_bookstore_sb_je0824.model;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.Sach;

import java.util.ArrayList;
import java.util.List;

@Repository("sachDao")
public class SachImpl implements SachDao{

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

        //Declare an object
        Sach objSach = null;

        //Use try-catch to avoid errors related session
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            //Get object by id
            objSach = session.get(Sach.class, maSach);
        }
        catch (Exception ex)
        {
            //Print errors
            ex.printStackTrace();
        }

        //Return result
        return objSach == null ? new Sach() : objSach;
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
