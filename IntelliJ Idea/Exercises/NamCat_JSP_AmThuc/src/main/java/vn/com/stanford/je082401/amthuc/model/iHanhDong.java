package vn.com.stanford.je082401.amthuc.model;

import java.util.List;

public interface iHanhDong<T, idT> {

    List<T> layDanhSach();

    T layChiTiet(idT id);

    boolean themMoi(T obj);

    boolean capNhat(T obj);

    boolean xoa(idT id);
}
