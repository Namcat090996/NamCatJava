package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.model.GioHangDao;
import vn.com.namcat_e_commerce.model.SanPhamDao;
import vn.com.namcat_e_commerce.model.SanPhamRepository;

@Service
public class GioHangService {
    
    @Autowired
    GioHangDao gioHangDao;
    
    @Autowired
    SanPhamDao sanPhamDao;
    
    public boolean add(GioHang objGH) {
        
        if (objGH == null || objGH.getMaSanPham() == null) {
            return false;
        }
        
        String maSanPham = objGH.getMaSanPham();
        SanPham objSP = sanPhamDao.findById(maSanPham);
        
        if(objSP == null)
        {
            return false;
        }
        
        int tonKho = objSP.getTonKho();
        
        if(tonKho == 0)
        {
            return false;
        }
        
        return gioHangDao.add(objGH);
    }
}
