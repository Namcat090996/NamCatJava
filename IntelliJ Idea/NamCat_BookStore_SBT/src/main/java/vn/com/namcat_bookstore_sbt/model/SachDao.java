package vn.com.namcat_bookstore_sbt.model;

import vn.com.namcat_bookstore_sbt.entities.Sach;

import java.util.List;

public interface SachDao extends IHanhDong<Sach, String> {

    //Declare extension function if needed
    public List<Sach> timKiemSach(String tuKhoa, String maChuDe);
}
