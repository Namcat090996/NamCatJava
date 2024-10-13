package vn.com.namcat.bookshop.model;

import vn.com.namcat.bookshop.entities.Sach;

import java.util.List;

public interface IHanhDong<T, idT> {

    /**
     * Function to get the list
     * @return
     */
    List<T> layDanhSach();

    /**
     * Function to get the detailed info
     * @param id
     * @return
     */
    T layChiTiet(idT id);

    /**
     * Function to insert a new object
     * @param obj
     * @return
     */
    boolean themMoi(T obj);

    /**
     * Function to update a selected object
     * @param obj
     * @return
     */
    boolean capNhat(T obj);

    /**
     * Function to delete a selected object
     * @param id
     * @return
     */
    boolean xoa(idT id);
}
