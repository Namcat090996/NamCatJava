package vn.com.namcat_e_commerce.model;

import java.util.List;

public interface IHanhDong <T, idT> {
    
    /**
     * Function to get list
     * @return
     */
    List<T> getList();
    
    /**
     * Function to get detailed object by id
     * @param id
     * @return
     */
    T findById(idT id);
    
    /**
     * Function to insert a new object
     * @param t
     * @return
     */
    boolean add(T t);
    
    /**
     * Function to update info of selected object
     * @param t
     * @return
     */
    boolean update(T t);
    
    /**
     * Function to delete object by id
     * @param id
     * @return
     */
    boolean delete(idT id);
}
