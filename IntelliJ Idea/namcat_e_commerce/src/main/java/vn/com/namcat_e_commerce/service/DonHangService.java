package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.DonHang;
import vn.com.namcat_e_commerce.model.DonHangDao;

import java.util.List;

@Service
public class DonHangService {
    
    @Autowired
    DonHangDao donHangDao;
    
    public List<DonHang> timDonHang(String tuKhoa, String trangThai) {
        return donHangDao.timDonHang(tuKhoa, trangThai);
    }
    
    public List<DonHang> getList() {
        return donHangDao.getList();
    }
    
    public DonHang findById(String id) {
        return donHangDao.findById(id);
    }
    
    public boolean add(DonHang objDH) {
        return donHangDao.add(objDH);
    }
    
    public boolean update(DonHang objDH) {
        return donHangDao.update(objDH);
    }
    
    public boolean delete(String id) {
        return donHangDao.delete(id);
    }
}
