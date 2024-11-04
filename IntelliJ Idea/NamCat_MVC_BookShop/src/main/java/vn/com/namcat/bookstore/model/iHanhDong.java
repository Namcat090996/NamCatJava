package vn.com.namcat.bookstore.model;

import java.util.List;

public interface iHanhDong<T, idT> {

    /**
     * Function to get list
     * @return
     */
    public List<T> getList();

    /**
     * Function to get detailed object by id
     * @param id
     * @return
     */
    public T findById(idT id);

    /**
     * Function to insert a new object
     * @param t
     * @return
     */
    public boolean add(T t);

    /**
     * Function update info of selected object
     * @param t
     * @return
     */
    public boolean update(T t);

    /**
     * Function to delete object by id
     * @param id
     * @return
     */
    public boolean delete(idT id);
}
