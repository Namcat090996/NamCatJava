package vn.com.namcat_bookstore_sbt.model;

import java.util.List;

public interface IHanhDong<T, idT> {

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
    public T getById(idT id);

    /**
     * Function to add a new object
     * @param t
     * @return
     */
    public boolean add(T t);

    /**
     * Function to update information of selected object
     * @param t
     * @return
     */
    public boolean update(T t);

    /**
     * Function to delete selected object
     * @param id
     * @return
     */
    public boolean delete(idT id);
}
