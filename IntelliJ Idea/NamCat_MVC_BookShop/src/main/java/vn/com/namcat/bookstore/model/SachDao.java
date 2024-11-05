package vn.com.namcat.bookstore.model;

import vn.com.namcat.bookstore.entities.*;

import java.util.List;

public interface SachDao extends iHanhDong<Sach, String>{

    //Declare extension functions if needed

    /**
     * Function to search book
     * @param tuKhoa
     * @param maCD
     * @return
     */
    public List<Sach> timKiemSach(String tuKhoa, String maCD);
}
