package vn.com.namcat_bookstore_sbt.model;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_bookstore_sbt.entities.Sach;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class SachImpl implements SachDao {

    @Autowired
    SachRepository sachRepository;

    @Override
    public List<Sach> getList() {
        //Return result
        return sachRepository.findAll();
    }

    @Override
    public Sach getById(String maSach) {
        //Declare an object
        Sach objSach;

        //Use try-catch if id not found
        try {
            //Get object by id
            objSach = sachRepository.findById(maSach).get();
        } catch (Exception ex) {
            objSach = null;
        }

        return objSach;

//        //Return result
//        return sachRepository.findById(maSach).orElse(null);
    }

    @Override
    public boolean add(Sach objSach) {
        //Check if object is null
        if(objSach == null)
        {
            return false;
        }

        //Check if the object has already existed
        boolean existed = sachRepository.existsById(objSach.getMaSach());

        if(!existed)
        {
            //Add object to database
            sachRepository.save(objSach);
            return true;
        }

        return false;
    }

    @Override
    public boolean update(Sach objSach) {
        //Check if the object is null
        if(objSach == null)
        {
            return false;
        }

        //Check if the object has already existed
        boolean existed = sachRepository.existsById(objSach.getMaSach());

        if(existed)
        {
            //Update object
            sachRepository.save(objSach);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String maSach) {
        //Check if the object has already existed
        boolean existed = sachRepository.existsById(maSach);

        if(existed)
        {
            sachRepository.deleteById(maSach);
            return true;
        }

        return false;
    }
}
