package vn.com.namcat_e_commerce.service;

import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.model.GioHangDao;
import vn.com.namcat_e_commerce.model.SanPhamDao;
import vn.com.namcat_e_commerce.model.SanPhamRepository;

import java.util.List;

@Service
public class GioHangService {
    
    @Autowired
    GioHangDao gioHangDao;
    
    @Autowired
    SanPhamDao sanPhamDao;
    
    public List<GioHang> layDSGioHangTheoTenNguoiDung(String tenNguoiDung) {
        return gioHangDao.layDSGioHangTheoNguoiDung(tenNguoiDung);
    }
    
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
    
    public boolean kiemTraGH_TND_MSP(String tenNguoiDung, String maSanPham)
    {
        return gioHangDao.kiemTraGH_TND_MSP(tenNguoiDung, maSanPham);
    }
    
    public GioHang layChiTietGH_TND_MSP(String tenNguoiDung, String maSanPham)
    {
        return gioHangDao.layChiTietGH_TND_MSP(tenNguoiDung, maSanPham);
    }
    
    public boolean xoa(Integer id)
    {
        return gioHangDao.delete(id);
    }
    
    public GioHang timGioHang(Integer id)
    {
        return gioHangDao.findById(id);
    }
}
