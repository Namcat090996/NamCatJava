package vn.com.namcat_bookstore_sbt.model;

import vn.com.namcat_bookstore_sbt.entities.NguoiDung;

public interface NguoiDungDao extends IHanhDong<NguoiDung, Integer> {
    
    NguoiDung layNguoiDungTheoTenDangNhap(String tenDangNhap);
}
