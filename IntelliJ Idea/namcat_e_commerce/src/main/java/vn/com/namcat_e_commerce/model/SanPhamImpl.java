package vn.com.namcat_e_commerce.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SanPhamImpl implements SanPhamDao {
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    SanPhamRepository sanPhamRepository;
    
    @Override
    public List<SanPham> hienThiSanPhamDaDuyet() {
        return sanPhamRepository.hienThiSPDaDuyet();
    }
    
    @Override
    public List<SanPham> timSPTheoTen(String tuKhoa) {
        return sanPhamRepository.timTheoTenSanPham(tuKhoa);
    }
    
    @Override
    public List<SanPham> timSPTheoLoai(String loaiSanPham, String order, String mauSac, int tuGia, int denGia) {
        
        String strSQL = "Select s from SanPham s where 1=1";
        
        if(loaiSanPham!= null && !loaiSanPham.isEmpty())
        {
            strSQL += " and s.loaiSanPham = :loaiSanPham";
        }
        
        if(mauSac != null && !mauSac.isEmpty())
        {
            strSQL += " and s.mauSac like :mauSac";
        }
        
        if(tuGia > 0)
        {
            strSQL += " and s.giaSanPham >= :tuGia";
        }
        
        if(denGia > 0)
        {
            strSQL += " and s.giaSanPham <= :denGia";
        }
        
        if (order != null) {
            if (order.equals("ASC")) {
                strSQL += " order by s.giaSanPham ASC";
                
            } else if (order.equals("DSC")) {
                strSQL += " order by s.giaSanPham DESC";
            }
        }
        
        //Khai báo danh sách
        List<SanPham> lstSP = new ArrayList<>();
        
        TypedQuery<SanPham> query = entityManager.createQuery(strSQL, SanPham.class);
        
        if(loaiSanPham!= null && !loaiSanPham.isEmpty())
        {
            query.setParameter("loaiSanPham",loaiSanPham);
        }
        
        if(mauSac != null && !mauSac.isEmpty())
        {
            query.setParameter("mauSac", "%" + mauSac + "%");
        }
        
        if(tuGia > 0)
        {
            query.setParameter("tuGia",tuGia);
        }
        
        if(denGia > 0)
        {
            query.setParameter("denGia",denGia);
        }
        
        lstSP = query.getResultList();
        
        return lstSP;
    }
    
    @Override
    public List<SanPham> getList() {
        return sanPhamRepository.findAll();
    }
    
    @Override
    public SanPham findById(Integer id) {
        //Declare object
        SanPham objSP = null;
        
        //Check if object has already existed
        boolean existed = sanPhamRepository.existsById(id);
        
        if(existed)
        {
            objSP = sanPhamRepository.findById(id).get();
        }
        
        return objSP;
    }
    
    @Override
    public boolean add(SanPham objSP) {
        //Check if object is null
        if(objSP == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = sanPhamRepository.existsById(objSP.getId());
        
        if(!existed)
        {
            //Add object to db
            sanPhamRepository.save(objSP);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(SanPham objSP) {
        //Check if object is null
        if(objSP == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = sanPhamRepository.existsById(objSP.getId());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                sanPhamRepository.save(objSP);
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
        SanPham objSP;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objSP = findById(id);
            
            //Check if
            if(objSP != null)
            {
                //Update object
                sanPhamRepository.delete(objSP);
                return true;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        return false;
    }
}
