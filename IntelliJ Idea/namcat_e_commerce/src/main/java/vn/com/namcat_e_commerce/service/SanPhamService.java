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
    
    public List<SanPham> timSPTheoTenVaLoai(String tuKhoa, String loaiSP, String mauSac)
    {
        return sanPhamDao.timSPTheoTenVaLoai(tuKhoa, loaiSP, mauSac);
    }
    
    public List<SanPham> timSPTheoTen(String tuKhoa) {
        return sanPhamDao.timSPTheoTen(tuKhoa);
    }
    
    public List<SanPham> timSPTheoLoaiVaGia(String loaiSanPham, String order, String mauSac, int tuGia, int denGia) {
        
        return sanPhamDao.timSPTheoLoaiVaGia(loaiSanPham, order, mauSac, tuGia, denGia);
    }
    
    public List<SanPham> timSPTheoLoaiVaGiaKhongDuyet(String loaiSanPham, String order, String mauSac, int tuGia, int denGia, int daDuyet) {
        
        return sanPhamDao.timSPTheoLoaiVaGiaKhongDuyet(loaiSanPham, order, mauSac, tuGia, denGia, daDuyet);
    }
    
    public List<SanPham> getList() {
        return sanPhamDao.getList();
    }
    
    public SanPham findById(Integer id) {
        return sanPhamDao.findById(id);
    }

    public boolean add(SanPham objSP) {
        return sanPhamDao.add(objSP);
    }
    
    public boolean update(SanPham objSP) {
        return sanPhamDao.update(objSP);
    }
    
    public boolean delete(Integer id) {
        return sanPhamDao.delete(id);
    }
}
