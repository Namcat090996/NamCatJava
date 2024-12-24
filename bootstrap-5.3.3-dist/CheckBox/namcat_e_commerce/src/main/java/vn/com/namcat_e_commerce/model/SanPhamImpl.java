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
    public List<SanPham> timSPTheoLoai(String loaiSP) {
        return sanPhamRepository.findByLoaiSanPham(loaiSP);
    }
    
    @Override
    public List<SanPham> layDSManHinh() {
        
        String strSQL = "Select s from SanPham s where s.daDuyet = 1 and s.loaiSanPham = :loaiSP";
        
        //Khai báo danh sách
        List<SanPham> lstSP = new ArrayList<>();
        
        TypedQuery<SanPham> query = entityManager.createQuery(strSQL, SanPham.class);
        
        query.setParameter("loaiSP", "Màn hình");
        
        lstSP = query.getResultList();
        
        return lstSP;
    }
    
    @Override
    public List<SanPham> layDSLaptop() {
        
        String strSQL = "Select s from SanPham s where s.daDuyet = 1 and s.loaiSanPham = :loaiSP";
        
        //Khai báo danh sách
        List<SanPham> lstSP = new ArrayList<>();
        
        TypedQuery<SanPham> query = entityManager.createQuery(strSQL, SanPham.class);
        
        query.setParameter("loaiSP", "Laptop");
        
        lstSP = query.getResultList();
        
        return lstSP;
    }
    
    @Override
    public List<SanPham> layDSDienThoai() {
        
        String strSQL = "Select s from SanPham s where s.daDuyet = 1 and s.loaiSanPham = :loaiSP";
        
        //Khai báo danh sách
        List<SanPham> lstSP = new ArrayList<>();
        
        TypedQuery<SanPham> query = entityManager.createQuery(strSQL, SanPham.class);

        query.setParameter("loaiSP", "Điện thoại");
        
        lstSP = query.getResultList();
        
        return lstSP;
    }
    
    @Override
    public List<SanPham> layDSSlider() {
        
        String strSQL = "Select s from SanPham s where s.daDuyet = 1 order by s.tonKho desc";
        
        //Khai báo danh sách
        List<SanPham> lstSP = new ArrayList<>();
        
        TypedQuery<SanPham> query = entityManager.createQuery(strSQL, SanPham.class);
        
        query.setMaxResults(3);
        
        lstSP = query.getResultList();
        
        return lstSP;
    }
    
    @Override
    public List<SanPham> layDSHangMoi() {
        
        String strSQL = "Select s from SanPham s where s.daDuyet = 1 order by s.tonKho desc";
        
        //Khai báo danh sách
        List<SanPham> lstSP = new ArrayList<>();
        
        TypedQuery<SanPham> query = entityManager.createQuery(strSQL, SanPham.class);
        
        query.setMaxResults(6);
        
        lstSP = query.getResultList();
        
        return lstSP;
    }
    
    @Override
    public List<SanPham> layDSHangHot() {
        
        String strSQL = "Select s from SanPham s where s.daDuyet = 1 order by s.tonKho asc";
        
        //Khai báo danh sách
        List<SanPham> lstSP = new ArrayList<>();
        
        TypedQuery<SanPham> query = entityManager.createQuery(strSQL, SanPham.class);
        
        query.setMaxResults(6);
        
        lstSP = query.getResultList();
        
        return lstSP;
    }
    
    @Override
    public List<SanPham> timSPTheoTenVaLoai(String tuKhoa, String loaiSP, String mauSac) {
        return sanPhamRepository.timSPTheoTenVaLoai(tuKhoa, loaiSP, mauSac);
    }
    
    @Override
    public List<SanPham> timSPTheoTen(String tuKhoa) {
        return sanPhamRepository.timTheoTenSanPham(tuKhoa);
    }
    
    @Override
    public List<SanPham> timSPTheoLoaiVaGiaKhongDuyet(String tuKhoa, String loaiSanPham, String mauSac, int tuGia, int denGia, int daDuyet) {
        
        String strSQL = "Select s from SanPham s where 1=1";
        
        if(tuKhoa!= null && !tuKhoa.isEmpty())
        {
            strSQL += " and (s.tenSanPham like :tuKhoa or s.moTa like :tuKhoa or s.maSanPham like :tuKhoa)";
        }
        
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
        
        if(daDuyet == 1)
        {
            strSQL += " and s.daDuyet = 1";
        }
        
        if(daDuyet == 0)
        {
            strSQL += " and s.daDuyet = 0";
        }
        
        //Khai báo danh sách
        List<SanPham> lstSP = new ArrayList<>();
        
        TypedQuery<SanPham> query = entityManager.createQuery(strSQL, SanPham.class);
        
        if(tuKhoa!= null && !tuKhoa.isEmpty())
        {
            query.setParameter("tuKhoa","%" + tuKhoa + "%");
        }
        
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
    public List<SanPham> timSPTheoLoaiVaGia(String loaiSanPham, String order, String mauSac, int tuGia, int denGia) {
        
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
        
        strSQL += " and s.daDuyet = 1";
        
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
        
        String strSQL = "Select s from SanPham s";
        
        //Khai báo danh sách
        List<SanPham> lstSP = new ArrayList<>();
        
        TypedQuery<SanPham> query = entityManager.createQuery(strSQL, SanPham.class);
        
        lstSP = query.getResultList();
        
        return lstSP;
    }
    
    @Override
    public SanPham findById(String id) {
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
        boolean existed = sanPhamRepository.existsById(objSP.getMaSanPham());
        
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
        boolean existed = sanPhamRepository.existsById(objSP.getMaSanPham());
        
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
    public boolean delete(String id) {
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
