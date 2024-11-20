package vn.com.namcat_bookstore_sbt.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_bookstore_sbt.entities.Sach;

import java.util.List;

@Repository
public class SachImpl implements SachDao {

    @Autowired
    SachRepository sachRepository;

    @Override
    public List<Sach> timKiemSach(String tuKhoa, String maChuDe) {
        //Ternary operator


        //Declare list
        List<Sach> lstSach = sachRepository.timKiemSach(tuKhoa, maChuDe);

        return lstSach;
    }

    @Override
    public List<Sach> getList() {
        //Return result
        return sachRepository.findAll();
    }

    @Override
    public Sach getById(String maSach) {
        //Declare an object
        Sach objSach = null;

        //Check if object has already existed
        boolean existed = sachRepository.existsById(maSach);

        if(existed)
        {
            objSach = sachRepository.findById(maSach).get();
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

        //Use try-catch if update fails (foreign key, constrain violations)
        try {
            if (existed) {
                //Update object
                sachRepository.save(objSach);
                return true;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;

//        // Check if the object is null
//        if (objSach == null) {
//            return false;
//        }
//
//        try {
//            // Attempt to save the object
//            sachRepository.save(objSach); //It can handle the ID violates constraints automatically
//            return true;
//        } catch (Exception ex) {
//            // Handle cases where the ID violates constraints
//            ex.printStackTrace();
//            return false;
//        }
    }

    @Override
    public boolean delete(String maSach) {
//        //Declare an object
//        Sach objSach;
//
//        //Use try-catch if id not found
//        try {
//            //Get object by ID to delete
//            objSach = getById(maSach);
//
//            //Check if object is null
//            if(objSach != null)
//            {
//                sachRepository.delete(objSach);
//                return true;
//            }
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return false;

        //Check if the object has already existed
        boolean existed = sachRepository.existsById(maSach);

        //Use try-catch if deletion fails (foreign key, constrain violations)
        try {
            if(existed)
            {
                sachRepository.deleteById(maSach);
                return true;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return false;
    }
}
