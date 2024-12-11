package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.MauSac;

import java.util.List;

@Repository
public class MauSacImpl implements MauSacDao {

    @Autowired
    MauSacRepository mauSacRepository;
    
    @Override
    public List<MauSac> getList() {
        return mauSacRepository.findAll();
    }
    
    @Override
    public MauSac findById(Integer id) {
        //Declare object
        MauSac objMS = null;
        
        //Check if object has already existed
        boolean existed = mauSacRepository.existsById(id);
        
        if(existed)
        {
            objMS = mauSacRepository.findById(id).get();
        }
        
        return objMS;
    }
    
    @Override
    public boolean add(MauSac objMS) {
        //Check if object is null
        if(objMS == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = mauSacRepository.existsById(objMS.getId());
        
        if(!existed)
        {
            //Add object to db
            mauSacRepository.save(objMS);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(MauSac objMS) {
        //Check if object is null
        if(objMS == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = mauSacRepository.existsById(objMS.getId());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                mauSacRepository.save(objMS);
                return true;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    @Override
    public boolean delete(Integer id) {
        //Declare object
        MauSac objMS;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objMS = findById(id);
            
            //Check if
            if(objMS != null)
            {
                //Update object
                mauSacRepository.delete(objMS);
                return true;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        return false;
    }
}
