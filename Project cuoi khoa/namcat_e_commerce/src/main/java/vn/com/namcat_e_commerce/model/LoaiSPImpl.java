package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.LoaiSanPham;

import java.util.List;

@Repository
public class LoaiSPImpl implements LoaiSPDao {
    
    @Autowired
    LoaiSPRepository loaiSPRepository;
    
    @Override
    public List<LoaiSanPham> getList() {
        return loaiSPRepository.findAll();
    }
    
    @Override
    public LoaiSanPham findById(String id) {
        //Declare object
        LoaiSanPham objLSP = null;
        
        //Check if object has already existed
        boolean existed = loaiSPRepository.existsById(id);
        
        if(existed)
        {
            objLSP = loaiSPRepository.findById(id).get();
        }
        
        return objLSP;
    }
    
    @Override
    public boolean add(LoaiSanPham objLSP) {
        //Check if object is null
        if(objLSP == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = loaiSPRepository.existsById(objLSP.getLoaiSanPham());
        
        if(!existed)
        {
            //Add object to db
            loaiSPRepository.save(objLSP);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(LoaiSanPham objLSP) {
        //Check if object is null
        if(objLSP == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = loaiSPRepository.existsById(objLSP.getLoaiSanPham());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                loaiSPRepository.save(objLSP);
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
        LoaiSanPham objLSP;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objLSP = findById(id);
            
            //Check if
            if(objLSP != null)
            {
                //Update object
                loaiSPRepository.delete(objLSP);
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
