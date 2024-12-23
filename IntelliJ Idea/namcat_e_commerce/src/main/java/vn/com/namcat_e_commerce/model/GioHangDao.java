package vn.com.namcat_e_commerce.model;

import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import vn.com.namcat_e_commerce.entities.GioHang;

import java.util.List;

public interface GioHangDao extends IHanhDong<GioHang, Integer> {
    
    public boolean kiemTraGH_TND_MSP(String tenNguoiDung, String maSanPham);
    
    public GioHang layChiTietGH_TND_MSP(String tenNguoiDung, String maSanPham);
    
    public List<GioHang> layDSGioHangTheoNguoiDung(String tenNguoiDung);
}
