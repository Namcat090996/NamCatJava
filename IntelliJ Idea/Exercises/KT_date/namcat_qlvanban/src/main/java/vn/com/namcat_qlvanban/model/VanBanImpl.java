package vn.com.namcat_qlvanban.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_qlvanban.entities.VanBan;
import vn.com.namcat_qlvanban.entities.VanBanModel;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class VanBanImpl implements VanBanDao {
    
    @Autowired
    VanBanRepository vanBanRepository;
    
    @Override
    public List<VanBan> timKiemVanBang(String tuKhoa, String loaiVanBan, String donVi) {
        tuKhoa = (tuKhoa==null ? "" : tuKhoa);
        loaiVanBan = (loaiVanBan==null ? "" : loaiVanBan);
        donVi = (donVi==null ? "" : donVi);
        return vanBanRepository.timKiemVanBan(tuKhoa, loaiVanBan, donVi);
    }
    
    @Override
    public List<VanBan> timKiemVanBanTheoNgay(String tuKhoa, String loaiVanBan, String donVi, LocalDate tuNgay, LocalDate denNgay) {
        tuKhoa = (tuKhoa==null ? "" : tuKhoa);
        loaiVanBan = (loaiVanBan==null ? "" : loaiVanBan);
        donVi = (donVi==null ? "" : donVi);
        return vanBanRepository.timKiemVanBanTheoNgay(tuKhoa, loaiVanBan, donVi, tuNgay, denNgay);
    }
    
    @Override
    public List<VanBan> getList() {
        return vanBanRepository.findAll();
    }
    
    @Override
    public VanBan findById(String id) {
        //Declare object
        VanBan objVB = null;
        
        //Check if object has already existed
        boolean existed = vanBanRepository.existsById(id);
        
        if(existed)
        {
            objVB = vanBanRepository.findById(id).get();
        }
        
        return objVB;
    }
    
    @Override
    public boolean add(VanBan objVB) {
        //Check if object is null
        if(objVB == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = vanBanRepository.existsById(objVB.getMaVanBan());
        
        if(!existed)
        {
            //Add object to db
            vanBanRepository.save(objVB);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(VanBan objVB) {
        //Check if object is null
        if(objVB == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = vanBanRepository.existsById(objVB.getMaVanBan());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                vanBanRepository.save(objVB);
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
        VanBan objVB;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objVB = findById(id);
            
            //Check if
            if(objVB != null)
            {
                //Update object
                vanBanRepository.delete(objVB);
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
