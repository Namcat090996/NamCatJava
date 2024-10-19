package vn.com.stanford.je0824.bookstore.model;

import vn.com.stanford.je0824.bookstore.entities.NhanVien;
import vn.com.stanford.je0824.bookstore.entities.NhanVienModel;
import java.util.List;

public interface NhanVienDao extends IHanhDong<NhanVien, String> {

    List<NhanVienModel> layBangLuongNhanVien();
}
