package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
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
    
    public long soLuongDHByNguoiDung(String tenNguoiDung) {
        return donHangDao.soLuongDHBoiNguoiDung(tenNguoiDung);
    }
    
    public List<DonHang> getList() {
        return donHangDao.getList();
    }
    
    public DonHang findById(Integer id) {
        return donHangDao.findById(id);
    }
    
    public boolean add(DonHang objDH) {
        return donHangDao.add(objDH);
    }
    
    public boolean update(DonHang objDH) {
        return donHangDao.update(objDH);
    }
    
    public boolean delete(Integer id) {
        return donHangDao.delete(id);
    }
    
    public List<DonHang> layDSDonHangByTenND(String tenNguoiDung) {
        return donHangDao.findAllByTenNguoiDung(tenNguoiDung);
    }
    
    public List<DonHang> layDSDonHangTheoTNDvaTT(String tenNguoiDung, String trangThai) {
        return donHangDao.layDSDonHangTheoTNDvaTT(tenNguoiDung, trangThai);
    }
}
