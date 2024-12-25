package vn.com.namcat_e_commerce.model;

import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.List;

public interface SanPhamDao extends IHanhDong<SanPham, String> {
    
    public List<SanPham> timSPTheoTuKhoa(String tuKhoa);
    
    public List<SanPham> timSPTheoLoaiVaGiaDaDuyet(List<String> loaiSanPham, String order, List<String> mauSac, int tuGia, int denGia);
    
    public List<SanPham> timSPTheoLoaiVaGiaKhongDuyet(String tuKhoa, String loaiSanPham, String mauSac, int tuGia, int denGia, int daDuyet);
    
    public List<SanPham> layDSHangMoi();
    
    public List<SanPham> layDSHangHot();
    
    public List<SanPham> layDSSlider();
    
    public List<SanPham> layDSDienThoai();
    
    public List<SanPham> layDSManHinh();
    
    public List<SanPham> layDSLaptop();
    
    public List<SanPham> timSPTheoLoai(String loaiSP);

}
