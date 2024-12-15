package vn.com.namcat_e_commerce.model;

import org.springframework.data.repository.query.Param;
import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.List;

public interface SanPhamDao extends IHanhDong<SanPham, String> {
    
    public List<SanPham> timSPTheoTen(String tuKhoa);
    
    public List<SanPham> timSPTheoLoaiVaGia(String loaiSanPham, String order, String mauSac, int tuGia, int denGia);
    
    public List<SanPham> timSPTheoLoaiVaGiaKhongDuyet(String loaiSanPham, String order, String mauSac, int tuGia, int denGia, int daDuyet);
    
    public List<SanPham> timSPTheoTenVaLoai(String tuKhoa, String loaiSP, String mauSac);
    
    public boolean kiemTraTenDaTonTai(String tenSanPham);
}