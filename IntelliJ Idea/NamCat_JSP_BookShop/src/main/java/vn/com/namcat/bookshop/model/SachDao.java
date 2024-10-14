package vn.com.namcat.bookshop.model;

import vn.com.namcat.bookshop.entities.Sach;

import java.util.List;

public interface SachDao extends IHanhDong<Sach, String> {

    //Declare extension function of Sach object if needed
    List<Sach> timKiemSach(String tuKhoa, String maChuDe);
}
