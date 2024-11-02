package vn.com.stanford.je0824.bookstore.model;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.je0824.bookstore.entities.Sach;
import vn.com.stanford.je0824.bookstore.entities.SachMapper;

import java.util.ArrayList;
import java.util.List;

@Repository("sachDao")
public class SachImpl implements SachDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Tìm kiếm thông tin sách theo nhiều tiêu chí
     * @param tuKhoa
     * @param maCD
     * @return
     */
    @Override
    public List<Sach> timKiemSach(String tuKhoa, String maCD)
    {
        String strSQL = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, NgayTao, NgayCapNhat, TacGia, MaChuDe from Sach where 1=1";
        if(tuKhoa!= null && !tuKhoa.isEmpty())
        {
            strSQL += " and (MaSach = '" + tuKhoa + "' OR TenSach like '%" + tuKhoa + "%' OR TacGia like '%" + tuKhoa + "%')";
        }

        if(maCD!= null && !maCD.isEmpty())
        {
            strSQL+= " and MaChuDe = '" + maCD + "'";
        }

        return jdbcTemplate.query(strSQL, new SachMapper());
    }

    @Override
    public List<Sach> getList() {

        //Khai báo danh sách
        List<Sach> lstSach = new ArrayList<>();

        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Bắt đầu phiên làm việc
        Transaction tx = session.beginTransaction();

        TypedQuery<Sach> query = session.createQuery("from Sach", Sach.class);

        lstSach = query.getResultList();

        tx.commit();

        return lstSach;
    }

    @Override
    public Sach getById(String maSach) {
        try
        {
            String strSQL = "Select * from Sach where MaSach = ?";

            return jdbcTemplate.queryForObject(strSQL,new SachMapper(), maSach);
        }
        catch (EmptyResultDataAccessException ex)
        {
            return null;
        }
    }

    @Override
    public boolean add(Sach obj) {

        String strInsert = "Insert into Sach(MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, NgayTao, NgayCapNhat, MaChuDe) values(?,?,?,?,?,?,?,?,?)";

        boolean ketQua = false;
        ketQua = jdbcTemplate.update(strInsert, obj.getMaSach(), obj.getTenSach(), obj.getMoTa(), obj.getAnhSach(), obj.getGiaSach(), obj.getTacGia(), obj.getNgayTao(), obj.getNgayCapNhat(), obj.getMaChuDe()) > 0;

        return ketQua;
    }

    @Override
    public boolean update(Sach obj) {

        String strUpdate = "Update Sach set TenSach=?,MoTa=?,AnhSach=?,GiaSach=?,TacGia=?,NgayCapNhat=?,MaChuDe=? where MaSach = ?";

        boolean ketQua = false;
        ketQua = jdbcTemplate.update(strUpdate, obj.getTenSach(), obj.getMoTa(), obj.getAnhSach(), obj.getGiaSach(), obj.getTacGia(), obj.getNgayCapNhat(), obj.getMaChuDe(), obj.getMaSach()) > 0;

        return ketQua;
    }

    @Override
    public boolean delete(String id) {

        String strDelete = "Delete from Sach where MaSach = ?";

        boolean ketQua = false;
        ketQua = jdbcTemplate.update(strDelete, id) > 0;

        return ketQua;
    }
}
