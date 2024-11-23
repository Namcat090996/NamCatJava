package vn.com.namcat_bookstore_sbt.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_bookstore_sbt.entities.Sach;

import java.util.List;

@Repository
public class SachImpl implements SachDao {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    SachRepository sachRepository;

    /**
     * Function to find book by keyword and subject code
     * @param tuKhoa
     * @param maChuDe
     * @return
     */
    public List<Sach> timKiemSach2(String tuKhoa, String maChuDe) {
        //Declare SQL command
        String sqlList = "Select s from Sach s where 1=1";

        //Check if keyword and subject code is empty/null
        if(tuKhoa != null && !tuKhoa.trim().isEmpty())
        {
            sqlList += " and (s.maSach = '" + tuKhoa + "' or s.tenSach like '%" + tuKhoa + "%' or s.tacGia like '%" + tuKhoa + "%')";
        }

        if(maChuDe != null && !maChuDe.trim().isEmpty())
        {
            sqlList += " and (s.maChuDe = '" + maChuDe + "'";
        }

        //Execute the query and return the list
        TypedQuery<Sach> query = entityManager.createQuery(sqlList, Sach.class);

        return query.getResultList();
    }

    /**
     * Function to find book by keyword and subject code
     * @param tuKhoa
     * @param maChuDe
     * @return
     */
    @Override
    public List<Sach> timKiemSach(String tuKhoa, String maChuDe) {
        //Ternary operator/Check if the keyword & subject code is null
        tuKhoa = tuKhoa == null ? "" : tuKhoa;
        maChuDe = maChuDe == null ? "" : maChuDe;

        //Return list
        return sachRepository.timKiemSach(tuKhoa, maChuDe);
    }

    @Override
    public List<Sach> getList() {
        //Return list
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
