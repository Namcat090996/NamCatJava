package vn.com.namcat_e_commerce.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.GioHang;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GioHangImpl implements GioHangDao {
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    GioHangRepository gioHangRepository;
    
    @Override
    public List<GioHang> layDSGioHangTheoNguoiDung(String tenNguoiDung) {
        return gioHangRepository.findAllByTenNguoiDung(tenNguoiDung);
    }
    
    @Override
    public List<GioHang> getList() {
        return gioHangRepository.findAll();
    }
    
    /**
     * Hàm lấy số lượng giỏ hàng theo tên người dùng
     * @param tenNguoiDung
     * @return
     */
    @Override
    public long soLuongGH_TND(String tenNguoiDung)
    {
        String strSQL = "Select count(gh) from GioHang gh where gh.tenNguoiDung = :tenNguoiDung";
        
        TypedQuery<Long> query = entityManager.createQuery(strSQL, Long.class);
        
        query.setParameter("tenNguoiDung", tenNguoiDung);
        
        return query.getSingleResult();
    }
    
    /**
     * Hàm lấy chi tiết đối tượng giỏ hàng thông qua tên người dùng & mã sản phẩm
     * @param tenNguoiDung
     * @param maSanPham
     * @return
     */
    @Override
    public GioHang layChiTietGH_TND_MSP(String tenNguoiDung, String maSanPham)
    {
        String strSQL = "Select gh from GioHang gh where gh.tenNguoiDung = :tenNguoiDung and gh.maSanPham = :maSanPham";
        
        TypedQuery<GioHang> query = entityManager.createQuery(strSQL, GioHang.class);
        
        query.setParameter("tenNguoiDung", tenNguoiDung);
        query.setParameter("maSanPham", maSanPham);
        
        GioHang objGH;
        
        try {
            //Lấy đối tượng giỏ hàng trả về
            objGH = query.getSingleResult();
        }
        catch (NoResultException ex) {
            objGH = null;
        }
        catch (NonUniqueResultException ex) {
            ex.printStackTrace();
            objGH = null;
        }
        
        return objGH;
    }
    
    @Override
    public GioHang findById(Integer id) {
        //Declare object
        GioHang objGH = null;
        
        //Check if object has already existed
        boolean existed = gioHangRepository.existsById(id);
        
        if(existed)
        {
            objGH = gioHangRepository.findById(id).get();
        }
        
        return objGH;
    }
    
    @Override
    public boolean add(GioHang objGH) {
        //Check if object is null
        if(objGH == null)
        {
            return false;
        }
        
        //Add object to db
        gioHangRepository.save(objGH);
        return true;
    }
    
    @Override
    public boolean update(GioHang objGH) {
        //Check if object is null
        if(objGH == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = gioHangRepository.existsById(objGH.getId());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                gioHangRepository.save(objGH);
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
        GioHang objGH;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objGH = findById(id);
            
            //Check if
            if(objGH != null)
            {
                //Update object
                gioHangRepository.delete(objGH);
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
    public int xoaGHByTenNguoiDung(String tenNguoiDung) {
        
        return gioHangRepository.deleteByTenNguoiDung(tenNguoiDung);
    }
}
