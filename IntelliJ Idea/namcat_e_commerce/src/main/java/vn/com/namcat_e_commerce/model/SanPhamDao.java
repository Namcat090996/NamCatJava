package vn.com.namcat_e_commerce.model;

import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.List;

public interface SanPhamDao extends IHanhDong<SanPham, Integer> {
    
    public List<SanPham> hienThiSanPhamDaDuyet();
    
    public List<SanPham> timSPTheoTen(String tuKhoa);
    
    public List<SanPham> timSPTheoLoai(String loaiSanPham, String order, String mauSac, int tuGia, int denGia);
}
