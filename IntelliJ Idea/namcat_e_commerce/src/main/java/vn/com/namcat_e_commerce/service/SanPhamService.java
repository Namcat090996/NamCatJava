package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.model.SanPhamDao;

import java.util.List;

@Service
public class SanPhamService {
    
    @Autowired
    SanPhamDao sanPhamDao;
    
    public List<SanPham> timTheoLoaiSP(String loaiSP) {
        return sanPhamDao.timSPTheoLoai(loaiSP);
    }
    
    public List<SanPham> layDSLaptop() {
        return sanPhamDao.layDSLaptop();
    }
    
    public List<SanPham> layDSManHinh() {
        return sanPhamDao.layDSManHinh();
    }
    
    public List<SanPham> layDSDienThoai() {
        return sanPhamDao.layDSDienThoai();
    }
    
    public List<SanPham> layDSSlider() {
        return sanPhamDao.layDSSlider();
    }
    
    public List<SanPham> timSPTheoTuKhoa(String tuKhoa) {
        return sanPhamDao.timSPTheoTuKhoa(tuKhoa);
    }
    
    public List<SanPham> timSPTheoLoaiVaGiaDaDuyet(List<String> loaiSanPham, String order, List<String> mauSac, int tuGia, int denGia) {
        
        return sanPhamDao.timSPTheoLoaiVaGiaDaDuyet(loaiSanPham, order, mauSac, tuGia, denGia);
    }
    
    public List<SanPham> timSPTheoLoaiVaGiaKhongDuyet(String tuKhoa, String loaiSanPham, String mauSac, int tuGia, int denGia, int daDuyet) {
        
        return sanPhamDao.timSPTheoLoaiVaGiaKhongDuyet(tuKhoa, loaiSanPham, mauSac, tuGia, denGia, daDuyet);
    }
    
    public List<SanPham> getList() {
        return sanPhamDao.getList();
    }
    
    public List<SanPham> layDSHot() {
        return sanPhamDao.layDSHangHot();
    }
    
    public List<SanPham> layDSNew() {
        return sanPhamDao.layDSHangMoi();
    }
    
    public SanPham findById(String id) {
        return sanPhamDao.findById(id);
    }

    public boolean add(SanPham objSP) {
        return sanPhamDao.add(objSP);
    }
    
    public boolean update(SanPham objSP) {
        return sanPhamDao.update(objSP);
    }
    
    public boolean delete(String id) {
        return sanPhamDao.delete(id);
    }
}
