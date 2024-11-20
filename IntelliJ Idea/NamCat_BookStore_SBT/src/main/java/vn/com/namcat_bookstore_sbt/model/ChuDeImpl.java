package vn.com.namcat_bookstore_sbt.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.com.namcat_bookstore_sbt.entities.ChuDe;

import java.util.List;

@Repository
public class ChuDeImpl implements ChuDeDao {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ChuDeRepository chuDeRepository;

    @Override
    public List<ChuDe> getList() {
        //Get list
        return entityManager.createQuery("from ChuDe", ChuDe.class).getResultList();
    }

    @Override
    public ChuDe getById(String maCD) {
        //Declare object
        ChuDe objCD;

        //Use try-catch if id not found
        try {
            //Get object by id
            objCD = (ChuDe) entityManager.createQuery("from ChuDe c where c.maChuDe = :maCD").setParameter("maCD", maCD).getSingleResult();
            //objCD = entityManager.find(ChuDe.class, objCD);
        }
        catch (Exception ex) {
            objCD = null;
            ex.printStackTrace();
        }

        return objCD;
    }

    @Override
    @Transactional//To roll-back transaction if transaction is fail, persist can't handle this fail automatically like save()
    public boolean add(ChuDe objCD) {
        //Check if object is null
        if (objCD == null) {
            return false;
        }

        //Check if the object has already existed
        boolean existed = chuDeRepository.existsById(objCD.getMaChuDe());

        if (!existed)
        {
            entityManager.persist(objCD);
            return true;
        }

        return false;
    }

    @Override
    @Transactional
    public boolean update(ChuDe objCD) {
        //Check if object is null
        if(objCD == null)
        {
            return false;
        }

        //Check if the object has already existed
        boolean existed = chuDeRepository.existsById(objCD.getMaChuDe());

        if(existed)
        {
            try {
                entityManager.merge(objCD);
                return true;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }

        return false;
    }

    @Override
    @Transactional
    public boolean delete(String maCD) {
        //Use try-catch if id not found
        try {
            //Get object by ID to delete
            ChuDe objCD = entityManager.find(ChuDe.class, maCD);

            //Check if object is null
            if(objCD != null)
            {
                entityManager.remove(objCD);
                return true;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
