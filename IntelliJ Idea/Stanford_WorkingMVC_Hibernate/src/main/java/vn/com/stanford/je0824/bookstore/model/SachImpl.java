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
//        //Declare list
//        List<Sach> lstSach = null;
//
//        //Use try-catch to avoid errors related session
//        try (Session session = HibernateUtil.getSessionFactory().openSession())
//        {
//            //Create queries from database and specify the return type as Sach
//            TypedQuery<Sach> query = session.createQuery("from Sach", Sach.class);
//
//            //Execute queries and get result
//            lstSach = query.getResultList();
//        }
//        catch (Exception ex)
//        {
//            //Print errors
//            ex.printStackTrace();
//        }
//
//        //Return result
//        return lstSach == null ? new ArrayList<Sach>() : lstSach;
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
//        //Declare an object
//        Sach objSach = null;
//
//        //Use try-catch to avoid errors related session
//        try(Session session = HibernateUtil.getSessionFactory().openSession())
//        {
//            //Get object by id
//            objSach = session.get(Sach.class, maSach);
//        }
//        catch (Exception ex)
//        {
//            //Print errors
//            ex.printStackTrace();
//        }
//
//        //Return result
//        return objSach == null ? new Sach() : objSach;

        Sach objSach = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        objSach = session.get(Sach.class, maSach);

        tx.commit();

        return objSach;
    }

    @Override
    public boolean add(Sach obj) {
//        //Declare boolean
//        boolean ketQua = false;
//
//        //Declare transaction
//        Transaction tx = null;
//
//        //Use try-catch to avoid errors related session
//        try(Session session = HibernateUtil.getSessionFactory().openSession())
//        {
//            //Begin the transaction
//            tx = session.beginTransaction();
//
//            //Save the object to database and obj will return the primary key(maSach)
//            Object obj = session.save(objSach);
//
//            //Commit the transaction, if failed, can be rolled back to keep the original state
//            tx.commit();
//
//            //If returned object is not null, return true
//            if(obj != null)
//            {
//                ketQua = true;
//            }
//        }
//        catch (Exception ex)
//        {
//            //If session is not opened but still have transaction, the transaction will be rolled back
//            if(tx != null)
//            {
//                tx.rollback();
//            }
//
//            //Print errors
//            ex.printStackTrace();
//        }
//
//        //Return result
//        return ketQua;

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
//        //Declare transaction
//        Transaction tx = null;
//
//        //Use try-catch to avoid errors related session
//        try(Session session = HibernateUtil.getSessionFactory().openSession())
//        {
//            //Begin the transaction
//            tx = session.beginTransaction();
//
//            //Update the information of object into database
//            session.merge(objSach);
//
//            //Commit the transaction, if failed, can be rolled back to keep the original state
//            tx.commit();
//
//            //If update is successful, return true
//            return true;
//        }
//        catch (Exception ex)
//        {
//            //If session is not opened but still have transaction, the transaction will be rolled back
//            if(tx != null)
//            {
//                tx.rollback();
//            }
//
//            //Log the error (recommended over printing stack trace)
//            Logger logger = LoggerFactory.getLogger(getClass());
//            logger.error("Error updating Sach entity", ex);
//        }
//
//        //Return result
//        return false;

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        session.update(obj);

        tx.commit();

        return true;
    }

    @Override
    public boolean delete(String id) {
        //Declare transaction
//        Transaction tx = null;
//
//        //Use try-catch to avoid errors related session
//        try(Session session = HibernateUtil.getSessionFactory().openSession())
//        {
//            //Begin the transaction
//            tx = session.beginTransaction();
//
//            //Get object by id
//            Sach objSach = session.get(Sach.class, maSach);
//
//            //If the object exists, delete it
//            if(objSach != null)
//            {
//                //Delete the object
//                session.delete(objSach);
//
//                //Commit the transaction, if failed, can be rolled back to keep the original state
//                tx.commit();
//
//                //If delete is successful, return true
//                return true;
//            }
//            else
//            {
//                //Log when the entity is not found
//                Logger logger = LoggerFactory.getLogger(getClass());
//                logger.warn("Sach with ID {} not found, unable to delete", maSach);
//                return false;
//            }
//        }
//        catch (Exception ex)
//        {
//            //If session is not opened but still have transaction, the transaction will be rolled back
//            if(tx != null)
//            {
//                tx.rollback();
//            }
//
//            //Log the error (recommended over printing stack trace)
//            Logger logger = LoggerFactory.getLogger(getClass());
//            logger.error("Error deleting Sach entity with ID {}", maSach, ex);
//        }
//
//        //Return result
//        return false;

        String strDelete = "Delete from Sach where MaSach = ?";

        boolean ketQua = false;
        ketQua = jdbcTemplate.update(strDelete, id) > 0;

        return ketQua;
    }
}
