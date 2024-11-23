package vn.com.namcat_srb_staff.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.namcat_srb_staff.entities.NhanVien;
import vn.com.namcat_srb_staff.entities.NhanVienModel;
import vn.com.namcat_srb_staff.entities.NhanVienModelMapper;

import java.util.List;

@Repository
public class NhanVienImpl implements NhanVienDao {
    
    @Autowired
    NhanVienRepository nhanVienRepository;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public List<NhanVienModel> layBangLuongNhanVien(String tuKhoa, String maPhong, String maChucVu) {
        //Declare SQL command
        String strSalary = "Select * from vBangLuongNhanVien where 1=1";
        
        if(tuKhoa != null && !tuKhoa.trim().isEmpty())
        {
            strSalary += " and (MaNV = '" + tuKhoa + "' OR HoTen like '%" + tuKhoa + "%')";
        }
        
        if(maPhong!= null && !maPhong.isEmpty())
        {
            strSalary += " and MaPhong = '" + maPhong + "'";
        }
        
        if(maChucVu!= null && !maChucVu.isEmpty())
        {
            strSalary += " and MaChucVu = '" + maChucVu + "'";
        }
        
        strSalary += " order by MaNV ASC";
        
        //Execute the queries and return list
        return jdbcTemplate.query(strSalary, new NhanVienModelMapper());
    }
    
    @Override
    public List<NhanVien> getList() {
        return nhanVienRepository.findAll();
    }
    
    @Override
    public NhanVien findById(String maNV) {
        //Declare object
        NhanVien objNV = null;
        
        //Check if object has already existed
        boolean existed = nhanVienRepository.existsById(maNV);
        
        if(existed)
        {
            objNV = nhanVienRepository.findById(maNV).get();
        }
        
        return objNV;
    }
    
    @Override
    public boolean add(NhanVien objNV) {
        //Check if object is null
        if(objNV == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = nhanVienRepository.existsById(objNV.getMaNV());
        
        if(!existed)
        {
            //Add object to db
            nhanVienRepository.save(objNV);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(NhanVien objNV) {
        //Check if object is null
        if(objNV == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = nhanVienRepository.existsById(objNV.getMaNV());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                nhanVienRepository.save(objNV);
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
    public boolean delete(String maNV) {
        //Declare object
        NhanVien objNV;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objNV = findById(maNV);
            
            //Check if
            if(objNV != null)
            {
                //Update object
                nhanVienRepository.delete(objNV);
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
