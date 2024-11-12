package vn.com.namcat_bookstore_sbt.model;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import vn.com.namcat_bookstore_sbt.entities.Sach;

import java.util.ArrayList;
import java.util.List;

@Repository("sachDao")
public class SachImpl implements SachDao {

    @Override
    public List<Sach> getList() {
        //Declare list
        List<Sach> lstSach = null;

        //Use try-catch to avoid errors related session
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            //Create queries from database and specify the return type as Sach
            TypedQuery<Sach> query = session.createQuery("from Sach", Sach.class);

            //Execute queries and get result
            lstSach = query.getResultList();
        }
        catch (Exception ex)
        {
            //Print errors
            ex.printStackTrace();
        }

        //Return result
        return lstSach == null ? new ArrayList<Sach>() : lstSach;
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
        //Declare boolean
        boolean ketQua = false;

        //Declare transaction
        Transaction tx = null;

        //Use try-catch to avoid errors related session
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            //Begin the transaction
            tx = session.beginTransaction();

            //Save the object to database and obj will return the primary key(maSach)
            Object obj = session.save(objSach);

            //Commit the transaction, if failed, can be rolled back to keep the original state
            tx.commit();

            //If returned object is not null, return true
            if(obj != null)
            {
                ketQua = true;
            }
        }
        catch (Exception ex)
        {
            //If session is not opened but still have transaction, the transaction will be rolled back
            if(tx != null)
            {
                tx.rollback();
            }

            //Print errors
            ex.printStackTrace();
        }

        //Return result
        return ketQua;
    }

    @Override
    public boolean update(Sach objSach) {
        //Declare transaction
        Transaction tx = null;

        //Use try-catch to avoid errors related session
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            //Begin the transaction
            tx = session.beginTransaction();

            //Update the information of object into database
            session.merge(objSach);

            //Commit the transaction, if failed, can be rolled back to keep the original state
            tx.commit();

            //If update is successful, return true
            return true;
        }
        catch (Exception ex)
        {
            //If session is not opened but still have transaction, the transaction will be rolled back
            if(tx != null)
            {
                tx.rollback();
            }

            //Log the error (recommended over printing stack trace)
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Error updating Sach entity", ex);
        }

        //Return result
        return false;
    }

    @Override
    public boolean delete(String maSach) {
        //Declare transaction
        Transaction tx = null;

        //Use try-catch to avoid errors related session
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            //Begin the transaction
            tx = session.beginTransaction();

            //Get object by id
            Sach objSach = session.get(Sach.class, maSach);

            //If the object exists, delete it
            if(objSach != null)
            {
                //Delete the object
                session.delete(objSach);

                //Commit the transaction, if failed, can be rolled back to keep the original state
                tx.commit();

                //If delete is successful, return true
                return true;
            }
            else
            {
                //Log when the entity is not found
                Logger logger = LoggerFactory.getLogger(getClass());
                logger.warn("Sach with ID {} not found, unable to delete", maSach);
                return false;
            }
        }
        catch (Exception ex)
        {
            //If session is not opened but still have transaction, the transaction will be rolled back
            if(tx != null)
            {
                tx.rollback();
            }

            //Log the error (recommended over printing stack trace)
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Error deleting Sach entity with ID {}", maSach, ex);
        }

        //Return result
        return false;
    }
}
