package vn.com.stanford.bst.model;

import java.util.List;

public interface iHanhDong<T, idT> {

    /**
     * Function to get the book list
     * @return
     */
    List<T> layDanhSach();

    /**
     * Function to get the detailed book info
     * @param id
     * @return
     */
    T layChiTiet(idT id);

    /**
     * Funnction to add a new book
     * @param obj
     * @return
     */
    boolean themMoi(T obj);

    /**
     * Function to update book info
     * @param obj
     * @return
     */
    boolean capNhat(T obj);

    /**
     * Function to delete the book
     * @param id
     * @return
     */
    boolean xoa(idT id);
}
