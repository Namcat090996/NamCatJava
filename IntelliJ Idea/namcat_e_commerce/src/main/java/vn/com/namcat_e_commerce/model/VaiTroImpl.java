package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.VaiTro;

import java.util.List;

@Repository
public class VaiTroImpl implements VaiTroDao {
    
    @Autowired
    VaiTroRepository vaiTroRepository;
    
    @Override
    public List<VaiTro> getList() {
        return vaiTroRepository.findAll();
    }
    
    @Override
    public VaiTro findById(String id) {
        //Declare object
        VaiTro objVT = null;
        
        //Check if object has already existed
        boolean existed = vaiTroRepository.existsById(id);
        
        if(existed)
        {
            objVT = vaiTroRepository.findById(id).get();
        }
        
        return objVT;
    }
    
    @Override
    public boolean add(VaiTro objVT) {
        //Check if object is null
        if(objVT == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = vaiTroRepository.existsById(objVT.getMaVaiTro());
        
        if(!existed)
        {
            //Add object to db
            vaiTroRepository.save(objVT);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(VaiTro objVT) {
        //Check if object is null
        if(objVT == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = vaiTroRepository.existsById(objVT.getMaVaiTro());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                vaiTroRepository.save(objVT);
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
        VaiTro objVT;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objVT = findById(id);
            
            //Check if
            if(objVT != null)
            {
                //Update object
                vaiTroRepository.delete(objVT);
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
