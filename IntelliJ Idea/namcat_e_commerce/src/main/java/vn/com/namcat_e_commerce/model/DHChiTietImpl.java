package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.DonHangChiTiet;

import java.util.List;

@Repository
public class DHChiTietImpl implements DHChiTietDao {
    
    @Autowired
    DHChiTietRepository dhChiTietRepository;
    
    @Override
    public List<DonHangChiTiet> getList() {
        return dhChiTietRepository.findAll();
    }
    
    @Override
    public List<DonHangChiTiet> findAllByMaDonHang(String maDonHang) {
        return dhChiTietRepository.findAllByMaDonHang(maDonHang);
    }
    
    @Override
    public DonHangChiTiet findById(Integer id) {
        //Declare object
        DonHangChiTiet objDHCT = null;
        
        //Check if object has already existed
        boolean existed = dhChiTietRepository.existsById(id);
        
        if(existed)
        {
            objDHCT = dhChiTietRepository.findById(id).get();
        }
        
        return objDHCT;
    }
    
    @Override
    public boolean add(DonHangChiTiet objDHCT) {
        //Check if object is null
        if(objDHCT == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = dhChiTietRepository.existsById(objDHCT.getId());
        
        if(!existed)
        {
            //Add object to db
            dhChiTietRepository.save(objDHCT);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(DonHangChiTiet objDHCT) {
        //Check if object is null
        if(objDHCT == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = dhChiTietRepository.existsById(objDHCT.getId());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                dhChiTietRepository.save(objDHCT);
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
        DonHangChiTiet objDHCT;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objDHCT = findById(id);
            
            //Check if
            if(objDHCT != null)
            {
                //Update object
                dhChiTietRepository.delete(objDHCT);
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
