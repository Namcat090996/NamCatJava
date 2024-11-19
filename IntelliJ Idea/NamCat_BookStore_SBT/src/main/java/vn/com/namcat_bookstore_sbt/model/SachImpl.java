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

@Repository("sachDao")
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
        Sach objSach = null;

        //Get object by id
        objSach = sachRepository.findById(maSach).get();

        //Return result
        return objSach;
    }

    @Override
    public boolean add(Sach objSach) {
        if(objSach != null)
        {
            Sach obj = sachRepository.save(objSach);
        }
    }

    @Override
    public boolean update(Sach objSach) {

    }

    @Override
    public boolean delete(String maSach) {

    }
}
