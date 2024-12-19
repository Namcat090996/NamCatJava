package vn.com.stanford.stanford_bookstore_sb_je0824.model;

import vn.com.stanford.stanford_bookstore_sb_je0824.entities.NguoiDung;

public interface NguoiDungDao extends IHanhDong<NguoiDung, Integer>{

    NguoiDung layNguoiDungTheoTenDangNhap(String tenDangNhap);

}
