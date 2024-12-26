package vn.com.namcat_e_commerce.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.DonHang;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DonHangImpl implements DonHangDao {
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    DonHangRepository donHangRepository;
    
    @Override
    public List<DonHang> getList() {
        return donHangRepository.findAll();
    }
    
    @Override
    public long soLuongDHBoiNguoiDung(String tenNguoiDung) {
        return donHangRepository.countAllByTenNguoiDung(tenNguoiDung);
    }
    
    @Override
    public List<DonHang> timDonHang(String tuKhoa, String trangThai) {
        
        String strSQL = "Select dh from DonHang dh where 1=1";
        
        if(tuKhoa!= null && !tuKhoa.isEmpty())
        {
            strSQL += " and (dh.maDonHang like :tuKhoa or dh.tenNguoiDung like :tuKhoa or dh.tenDonHang like :tuKhoa or dh.moTa like :tuKhoa)";
        }
        
        if(trangThai!= null && !trangThai.isEmpty())
        {
            strSQL += " and dh.trangThai = :trangThai";
        }
        
        //Khai báo danh sách
        List<DonHang> lstDH = new ArrayList<>();
        
        TypedQuery<DonHang> query = entityManager.createQuery(strSQL, DonHang.class);
        
        if(tuKhoa!= null && !tuKhoa.isEmpty())
        {
            query.setParameter("tuKhoa","%" + tuKhoa + "%");
        }
        
        if(trangThai!= null && !trangThai.isEmpty())
        {
            query.setParameter("trangThai",trangThai);
        }
        
        lstDH = query.getResultList();
        
        return lstDH;
    }
    
    @Override
    public DonHang findById(Integer id) {
        //Declare object
        DonHang objDH = null;
        
        //Check if object has already existed
        boolean existed = donHangRepository.existsById(id);
        
        if(existed)
        {
            objDH = donHangRepository.findById(id).get();
        }
        
        return objDH;
    }
    
    @Override
    public boolean add(DonHang objDH) {
        //Check if object is null
        if(objDH == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = donHangRepository.existsById(objDH.getId());
        
        if(!existed)
        {
            //Add object to db
            donHangRepository.save(objDH);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(DonHang objDH) {
        //Check if object is null
        if(objDH == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = donHangRepository.existsById(objDH.getId());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                donHangRepository.save(objDH);
                return true;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    @Override
    public boolean delete(Integer id) {
        //Declare object
        DonHang objDH;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objDH = findById(id);
            
            //Check if
            if(objDH != null)
            {
                //Update object
                donHangRepository.delete(objDH);
                return true;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    @Override
    public List<DonHang> findAllByTenNguoiDung(String tenNguoiDung) {
        return donHangRepository.findAllByTenNguoiDung(tenNguoiDung);
    }
}
