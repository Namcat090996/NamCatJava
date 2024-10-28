package vn.com.stanford.je0824.bookstore.model;

import java.util.List;

public interface IHanhDong<T, idT> {

    List<T> getList();

    T getById(idT id);

    boolean add(T t);

    boolean update(T t);

    boolean delete(idT id);
}
