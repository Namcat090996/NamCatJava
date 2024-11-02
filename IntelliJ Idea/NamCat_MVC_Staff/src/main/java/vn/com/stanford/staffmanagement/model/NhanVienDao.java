package vn.com.stanford.staffmanagement.model;

import vn.com.stanford.staffmanagement.entities.NhanVien;
import vn.com.stanford.staffmanagement.entities.NhanVienModel;

import java.util.List;

public interface NhanVienDao extends IHanhDong<NhanVien, String> {

    //Declare extension function if needed

    /**
     * Function to get total salary list of staff
     * @return
     */
    List<NhanVienModel> danhSachTongLuongNV(String tuKhoa, String maPhong, String maChucVu);

}
