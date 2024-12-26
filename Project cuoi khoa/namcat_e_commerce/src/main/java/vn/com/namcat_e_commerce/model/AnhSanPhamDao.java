package vn.com.namcat_e_commerce.model;

import vn.com.namcat_e_commerce.entities.AnhSanPham;

import java.util.List;

public interface AnhSanPhamDao extends IHanhDong<AnhSanPham, Integer> {
    
    public List<AnhSanPham> layAnhTheoMaSP(String maSP);
    
    public List<AnhSanPham> layDanhSachAnh(String tuKhoa);
}
