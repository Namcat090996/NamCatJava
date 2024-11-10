package vn.com.stanford.je0824.bookstore.model;

import java.util.List;

public interface IHanhDong<T, idT> {

    List<T> getList();

    T getById(idT id);

    boolean add(T obj);

    boolean update(T obj);

    boolean delete(idT id);
}
