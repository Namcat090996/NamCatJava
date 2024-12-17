package vn.com.namcat_e_commerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.entities.NguoiDung;

import java.util.List;

@Repository
public class GioHangImpl implements GioHangDao {
    
    @Autowired
    GioHangRepository gioHangRepository;
    
    @Override
    public List<GioHang> getList() {
        return gioHangRepository.findAll();
    }
    
    @Override
    public GioHang findById(Integer id) {
        //Declare object
        GioHang objGH = null;
        
        //Check if object has already existed
        boolean existed = gioHangRepository.existsById(id);
        
        if(existed)
        {
            objGH = gioHangRepository.findById(id).get();
        }
        
        return objGH;
    }
    
    @Override
    public boolean add(GioHang objGH) {
        //Check if object is null
        if(objGH == null)
        {
            return false;
        }
        
        gioHangRepository.save(objGH);
        return true;
    }
    
    @Override
    public boolean update(GioHang objGH) {
        return false;
    }
    
    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
