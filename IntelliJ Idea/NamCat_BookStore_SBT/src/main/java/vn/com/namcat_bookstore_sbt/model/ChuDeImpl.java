package vn.com.namcat_bookstore_sbt.model;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_bookstore_sbt.entities.ChuDe;

import java.util.List;

@Repository
public class ChuDeImpl implements ChuDeDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<ChuDe> getList() {
        return entityManager.createQuery("from ChuDe").getResultList();
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
        }

        return objCD;
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
