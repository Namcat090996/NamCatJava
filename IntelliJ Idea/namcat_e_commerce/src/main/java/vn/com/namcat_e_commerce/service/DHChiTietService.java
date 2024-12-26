package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.DonHang;
import vn.com.namcat_e_commerce.entities.DonHangChiTiet;
import vn.com.namcat_e_commerce.model.DHChiTietDao;

import java.util.List;

@Service
public class DHChiTietService {
    
    @Autowired
    DHChiTietDao dhChiTietDao;
    
    public List<DonHangChiTiet> getList() {
        return dhChiTietDao.getList();
    }
    
    public DonHangChiTiet findById(Integer id) {
        return dhChiTietDao.findById(id);
    }
    
    public boolean add(DonHangChiTiet objDHCT) {
        return dhChiTietDao.add(objDHCT);
    }
    
    public boolean update(DonHangChiTiet objDHCT) {
        return dhChiTietDao.update(objDHCT);
    }
    
    public boolean delete(Integer id) {
        return dhChiTietDao.delete(id);
    }
    
    public List<DonHangChiTiet> layDSDonHangCTByMaDH(String maDonHang) {
        return dhChiTietDao.findAllByMaDonHang(maDonHang);
    }
}
