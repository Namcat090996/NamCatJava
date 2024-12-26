package vn.com.namcat_e_commerce.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NguoiDungImpl implements NguoiDungDao {
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    NguoiDungRepository nguoiDungRepository;
    
    @Override
    public boolean kiemTraEmailTonTai(String emai) {
        return nguoiDungRepository.findByEmail(emai) != null;
    }
    
    @Override
    public boolean kiemTraSDTTonTai(String dienThoai) {
        return nguoiDungRepository.findByDienThoai(dienThoai) != null;
    }
    
    @Override
    public List<NguoiDung> timNguoiDung(String tuKhoa) {
        
        String strSQL = "Select nd from NguoiDung nd where 1=1";
        
        if(tuKhoa!= null && !tuKhoa.isEmpty())
        {
            strSQL += " and (nd.tenNguoiDung like :tuKhoa or nd.email like :tuKhoa or nd.hoTen like :tuKhoa or nd.dienThoai like :tuKhoa)";
        }
        
        //Khai báo danh sách
        List<NguoiDung> lstND = new ArrayList<>();
        
        TypedQuery<NguoiDung> query = entityManager.createQuery(strSQL, NguoiDung.class);
        
        if(tuKhoa!= null && !tuKhoa.isEmpty())
        {
            query.setParameter("tuKhoa","%" + tuKhoa + "%");
        }
        
        lstND = query.getResultList();
        
        return lstND;
    }
    
    @Override
    public List<NguoiDung> getList() {
        return nguoiDungRepository.findAll();
    }
    
    @Override
    public NguoiDung findById(String id) {
        //Declare object
        NguoiDung objND = null;
        
        //Check if object has already existed
        boolean existed = nguoiDungRepository.existsById(id);
        
        if(existed)
        {
            objND = nguoiDungRepository.findById(id).get();
        }
        
        return objND;
    }
    
    @Override
    public boolean add(NguoiDung objND) {
        //Check if object is null
        if(objND == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = nguoiDungRepository.existsById(objND.getTenNguoiDung());
        
        if(!existed)
        {
            //Add object to db
            nguoiDungRepository.save(objND);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean update(NguoiDung objND) {
        //Check if object is null
        if(objND == null)
        {
            return false;
        }
        
        //Check if object has already existed
        boolean existed = nguoiDungRepository.existsById(objND.getTenNguoiDung());
        
        //Use try-catch if update fails (foreign key, constraint violations)
        try {
            if(existed)
            {
                //Update object
                nguoiDungRepository.save(objND);
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
        NguoiDung objND;
        
        //Use try-catch if delete fails (foreign key, constraint violations) or object hasn't existed
        try {
            
            //Get object by id
            objND = findById(id);
            
            //Check if
            if(objND != null)
            {
                //Update object
                nguoiDungRepository.delete(objND);
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
