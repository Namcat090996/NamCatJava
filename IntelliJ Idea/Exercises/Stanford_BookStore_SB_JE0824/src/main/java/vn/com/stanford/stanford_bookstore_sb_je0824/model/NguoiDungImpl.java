package vn.com.stanford.stanford_bookstore_sb_je0824.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.NguoiDung;

import java.util.List;

@Repository("nguoiDungDao")
public class NguoiDungImpl implements NguoiDungDao{

    @Autowired
    NguoiDungRepository nguoiDungRepository;
    @Override
    public List<NguoiDung> getList() {
        return nguoiDungRepository.findAll();
    }

    @Override
    public NguoiDung getById(Integer id) {
        return nguoiDungRepository.getById(id.intValue());
    }

    @Override
    public boolean add(NguoiDung obj) {
        return false;
    }

    @Override
    public boolean update(NguoiDung obj) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public NguoiDung layNguoiDungTheoTenDangNhap(String tenDangNhap) {
        return nguoiDungRepository.findByTenDangNhap(tenDangNhap);
    }
}
