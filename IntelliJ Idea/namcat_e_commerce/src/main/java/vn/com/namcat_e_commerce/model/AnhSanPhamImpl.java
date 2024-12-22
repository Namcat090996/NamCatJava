package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.AnhSanPham;
import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.List;

@Repository
public class AnhSanPhamImpl implements AnhSanPhamDao {
    
    @Autowired
    AnhSanPhamRepository anhSanPhamRepository;
    
    @Override
    public List<AnhSanPham> layAnhTheoMaSP(String maSP) {
        return anhSanPhamRepository.findAllByMaSanPham(maSP);
    }
    
    @Override
    public List<AnhSanPham> getList() {
        return List.of();
    }
    
    @Override
    public AnhSanPham findById(Integer id) {
        //Declare object
        AnhSanPham objASP = null;
        
        //Check if object has already existed
        boolean existed = anhSanPhamRepository.existsById(id);
        
        if(existed)
        {
            objASP = anhSanPhamRepository.findById(id).get();
        }
        
        return objASP;
    }
    
    @Override
    public boolean add(AnhSanPham objAnhSP) {
        //Check if object is null
        if(objAnhSP == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = anhSanPhamRepository.existsById(objAnhSP.getId());
        
        if(!existed)
        {
            //Add object to db
            anhSanPhamRepository.save(objAnhSP);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(AnhSanPham objAnhSP) {
        //Check if object is null
        if(objAnhSP == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = anhSanPhamRepository.existsById(objAnhSP.getId());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                anhSanPhamRepository.save(objAnhSP);
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
        AnhSanPham objASP;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            //Get object by id
            objASP = findById(id);
            
            //Check if
            if(objASP != null)
            {
                //Update object
                anhSanPhamRepository.delete(objASP);
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
