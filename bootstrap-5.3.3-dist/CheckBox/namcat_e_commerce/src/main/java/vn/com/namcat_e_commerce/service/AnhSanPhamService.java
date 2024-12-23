package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.AnhSanPham;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.model.AnhSanPhamDao;

import java.util.List;

@Service
public class AnhSanPhamService {
    
    @Autowired
    AnhSanPhamDao anhSanPhamDao;
    
    public List<AnhSanPham> timTheoMaSP(String maSP)
    {
        return anhSanPhamDao.layAnhTheoMaSP(maSP);
    }
    
    public List<AnhSanPham> layDanhSachAnh(String tuKhoa)
    {
        return anhSanPhamDao.layDanhSachAnh(tuKhoa);
    }
    
    public AnhSanPham findById(Integer id) {
        return anhSanPhamDao.findById(id);
    }
    
    public boolean add(AnhSanPham objAnhSP) {
        return anhSanPhamDao.add(objAnhSP);
    }
    
    public boolean update(AnhSanPham objAnhSP) {
        return anhSanPhamDao.update(objAnhSP);
    }
    
    public boolean delete(Integer id) {
        return anhSanPhamDao.delete(id);
    }
}
