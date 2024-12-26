package vn.com.namcat_e_commerce.model;

import vn.com.namcat_e_commerce.entities.DonHangChiTiet;

import java.util.List;

public interface DHChiTietDao extends IHanhDong<DonHangChiTiet, Integer> {
    
    public List<DonHangChiTiet> findAllByMaDonHang(String maDonHang);
}
