package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.TrangThai;

import java.util.List;

@Repository
public class TrangThaiImpl implements TrangThaiDao {
    
    @Autowired
    TrangThaiRepository trangThaiRepository;
    
    @Override
    public List<TrangThai> getList() {
        return trangThaiRepository.findAll();
    }
    
    @Override
    public TrangThai findById(String id) {
        //Declare object
        TrangThai objTT = null;
        
        //Check if object has already existed
        boolean existed = trangThaiRepository.existsById(id);
        
        if(existed)
        {
            objTT = trangThaiRepository.findById(id).get();
        }
        
        return objTT;
    }
    
    @Override
    public boolean add(TrangThai objTT) {
        //Check if object is null
        if(objTT == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = trangThaiRepository.existsById(objTT.getMaTrangThai());
        
        if(!existed)
        {
            //Add object to db
            trangThaiRepository.save(objTT);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(TrangThai objTT) {
        //Check if object is null
        if(objTT == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = trangThaiRepository.existsById(objTT.getMaTrangThai());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                trangThaiRepository.save(objTT);
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
    public boolean delete(String id) {
        //Declare object
        TrangThai objTT;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objTT = findById(id);
            
            //Check if
            if(objTT != null)
            {
                //Update object
                trangThaiRepository.delete(objTT);
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
