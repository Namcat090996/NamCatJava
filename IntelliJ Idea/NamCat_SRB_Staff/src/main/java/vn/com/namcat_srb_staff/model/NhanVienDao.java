package vn.com.namcat_srb_staff.model;

import vn.com.namcat_srb_staff.entities.NhanVien;
import vn.com.namcat_srb_staff.entities.NhanVienModel;

import java.util.List;

public interface NhanVienDao extends IHanhDong<NhanVien, String> {
    
    /**
     *Function to get total salary list of staff
     * @param tuKhoa
     * @param maPhong
     * @param maChucVu
     * @return
     */
    public List<NhanVienModel> layBangLuongNhanVien(String tuKhoa, String maPhong, String maChucVu);
}
