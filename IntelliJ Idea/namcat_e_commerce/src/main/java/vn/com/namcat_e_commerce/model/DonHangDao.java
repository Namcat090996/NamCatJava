package vn.com.namcat_e_commerce.model;

import vn.com.namcat_e_commerce.entities.DonHang;
import vn.com.namcat_e_commerce.entities.NguoiDung;

import java.util.List;

public interface DonHangDao extends IHanhDong<DonHang, Integer>{
    
    public List<DonHang> timDonHang(String tuKhoa, String trangThai);
    
    public long soLuongDHBoiNguoiDung(String tenNguoiDung);
    
    public List<DonHang> findAllByTenNguoiDung(String tenNguoiDung);
}
