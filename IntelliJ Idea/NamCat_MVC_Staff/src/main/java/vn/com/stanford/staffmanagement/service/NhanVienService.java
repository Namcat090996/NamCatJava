package vn.com.stanford.staffmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.stanford.staffmanagement.entities.NhanVien;
import vn.com.stanford.staffmanagement.entities.NhanVienModel;
import vn.com.stanford.staffmanagement.model.NhanVienDao;

import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    NhanVienDao nhanVienDao;

    /**
     * Function to get total salary list of staff
     * @param tuKhoa
     * @param maPhong
     * @param maChucVu
     * @return
     */
    public List<NhanVienModel> layDanhSachLuongNV(String tuKhoa, String maPhong, String maChucVu)
    {
        return nhanVienDao.danhSachTongLuongNV(tuKhoa, maPhong, maChucVu);
    }

    /**
     * Function to get detailed object by id
     * @param maNV
     * @return
     */
    public NhanVien layChiTietNV(String maNV)
    {
        return nhanVienDao.findById(maNV);
    }

    /**
     * Function to insert a new object
     * @param objNV
     * @return
     */
    public boolean themNV(NhanVien objNV)
    {
        return nhanVienDao.add(objNV);
    }

    /**
     * Function to update info of selected object
     * @param objNV
     * @return
     */
    public boolean suaNV(NhanVien objNV)
    {
        return nhanVienDao.update(objNV);
    }

    /**
     * Function to delete object by id
     * @param maNV
     * @return
     */
    public boolean xoaNV(String maNV)
    {
        return nhanVienDao.delete(maNV);
    }
}
