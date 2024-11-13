package vn.com.namcat_bookstore_sbt.model;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import vn.com.namcat_bookstore_sbt.entities.ChuDe;

import java.util.ArrayList;
import java.util.List;

public class ChuDeImpl implements ChuDeDao {

    @Override
    public List<ChuDe> getList() {
        //Declare list
        List<ChuDe> lstChuDe = null;

        //Use try-catch to avoid errors related session
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            //Create queries from database and specify the return type as Sach
            TypedQuery<ChuDe> query = session.createQuery("from ChuDe", ChuDe.class);

            //Execute queries and get result
            lstChuDe = query.getResultList();
        }
        catch (Exception ex)
        {
            //Print errors
            ex.printStackTrace();
        }

        //Return result
        return lstChuDe == null ? new ArrayList<ChuDe>() : lstChuDe;
    }

    @Override
    public ChuDe getById(String id) {
        return null;
    }

    @Override
    public boolean add(ChuDe chuDe) {
        return false;
    }

    @Override
    public boolean update(ChuDe chuDe) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
