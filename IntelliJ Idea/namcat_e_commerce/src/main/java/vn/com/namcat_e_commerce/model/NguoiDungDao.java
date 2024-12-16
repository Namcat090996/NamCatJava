package vn.com.namcat_e_commerce.model;

import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.List;

public interface NguoiDungDao extends IHanhDong<NguoiDung, String> {
    
    public boolean kiemTraEmailTonTai(String emai);
    
    public boolean kiemTraSDTTonTai(String dienThoai);
    
    public List<NguoiDung> timNguoiDung(String tuKhoa);
}
