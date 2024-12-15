package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.NguoiDung;

import java.util.List;

@Repository
public class NguoiDungImpl implements NguoiDungDao {
    
    @Autowired
    NguoiDungRepository nguoiDungRepository;
    
    @Override
    public List<NguoiDung> getList() {
        return nguoiDungRepository.findAll();
    }
    
    @Override
    public NguoiDung findById(String id) {
        //Declare object
        NguoiDung objND = null;
        
        //Check if object has already existed
        boolean existed = nguoiDungRepository.existsById(id);
        
        if(existed)
        {
            objND = nguoiDungRepository.findById(id).get();
        }
        
        return objND;
    }
    
    @Override
    public boolean add(NguoiDung objND) {
        //Check if object is null
        if(objND == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = nguoiDungRepository.existsById(objND.getTenNguoiDung());
        
        if(!existed)
        {
            //Add object to db
            nguoiDungRepository.save(objND);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(NguoiDung objND) {
        //Check if object is null
        if(objND == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = nguoiDungRepository.existsById(objND.getTenNguoiDung());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                nguoiDungRepository.save(objND);
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
        NguoiDung objND;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objND = findById(id);
            
            //Check if
            if(objND != null)
            {
                //Update object
                nguoiDungRepository.delete(objND);
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
