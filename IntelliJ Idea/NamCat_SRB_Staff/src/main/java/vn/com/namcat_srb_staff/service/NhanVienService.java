package vn.com.namcat_srb_staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_srb_staff.entities.NhanVien;
import vn.com.namcat_srb_staff.entities.NhanVienModel;
import vn.com.namcat_srb_staff.model.NhanVienDao;

import java.util.List;

@Service
public class NhanVienService {
    
    @Autowired
    NhanVienDao nhanVienDao;
    
    public List<NhanVienModel> layBangLuongNhanVien(String tuKhoa, String maPhong, String maChucVu)
    {
        return nhanVienDao.layBangLuongNhanVien(tuKhoa, maPhong, maChucVu);
    }
    
    public NhanVien layChiTiet(String maNV)
    {
        return nhanVienDao.findById(maNV);
    }
    
    public boolean themMoi(NhanVien objNV)
    {
        return nhanVienDao.add(objNV);
    }
    
    public boolean capNhat(NhanVien objNV)
    {
        return nhanVienDao.update(objNV);
    }
    
    public boolean xoa(String maNV)
    {
        return nhanVienDao.delete(maNV);
    }
}
