package vn.com.stanford.bst.model;

import vn.com.stanford.bst.entities.Sach;

import java.util.List;

public interface SachDao extends iHanhDong<Sach, String> {

    //Declare the extension functions of book object if needed
    List<Sach> timKiemSach(String tuKhoa, String maChuDe);
}
