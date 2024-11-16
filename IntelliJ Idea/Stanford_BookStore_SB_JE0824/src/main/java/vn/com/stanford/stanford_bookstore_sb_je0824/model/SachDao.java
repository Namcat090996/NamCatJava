package vn.com.stanford.stanford_bookstore_sb_je0824.model;

import vn.com.stanford.stanford_bookstore_sb_je0824.entities.Sach;

import java.util.List;

public interface SachDao extends IHanhDong<Sach, String> {
    List<Sach> timKiemSach(String tuKhoa, String maCD);
}
