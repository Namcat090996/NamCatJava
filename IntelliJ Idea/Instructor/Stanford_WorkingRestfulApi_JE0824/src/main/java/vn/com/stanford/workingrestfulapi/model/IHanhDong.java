package vn.com.stanford.workingrestfulapi.model;

import java.util.List;

public interface IHanhDong<T, idT> {

    List<T> getList();

    T getById(idT id);

    boolean add(T obj);

    boolean update(T obj);

    boolean delete(idT id);
}