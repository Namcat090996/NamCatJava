package vn.com.stanford.stanford_bookstore_sb_je0824.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.ChuDe;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.Sach;

import java.util.ArrayList;
import java.util.List;

@Repository("sachDao")
public class SachImpl implements SachDao{

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    SachRepository sachRepository;

    /**
     * Tìm kiếm thông tin sách theo nhiều tiêu chí
     * @param tuKhoa
     * @param maCD
     * @return
     */
    @Override
    public List<Sach> timKiemSach(String tuKhoa, String maCD)
    {
        maCD = (maCD == null) ? "" : maCD;
        tuKhoa = (tuKhoa == null) ? "" : tuKhoa;

        return sachRepository.timKiemSach("%" + tuKhoa + "%", maCD);
    }

    @Override
    public List<Sach> getList() {

        return sachRepository.findAll();
    }

    @Override
    public Sach getById(String maSach) {
        Sach objSach = null;

        objSach = (Sach) entityManager.createQuery("FROM Sach s WHERE s.maSach = :ma").setParameter("ma", maSach).getSingleResult();

        return objSach;
    }

    @Override
    public boolean add(Sach objSach) {

        entityManager.persist(objSach);

        return false;
    }

    @Override
    public boolean update(Sach obj) {
        Sach objSach = sachRepository.getById(obj.getMaSach());
        if(objSach != null)
        {
            objSach.setTenSach(obj.getTenSach());
            objSach.setMoTa(obj.getMoTa());
            objSach.setAnhSach(obj.getAnhSach());
            objSach.setGiaSach(obj.getGiaSach());
            objSach.setTacGia(obj.getTacGia());
            objSach.setNgayCapNhat(obj.getNgayCapNhat());
            objSach.setMaChuDe(obj.getMaChuDe());
            sachRepository.save(objSach);
            return true;
        }
        return  false;
    }
    @Override
    public boolean delete(String id) {
        Sach objSach = sachRepository.getById(id);
        if(objSach != null) {
            entityManager.remove(objSach);
            return true;
        }
        return false;
    }
}
