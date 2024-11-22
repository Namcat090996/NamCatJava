package vn.com.stanford.workingrestfulapi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.stanford.workingrestfulapi.entities.ChuDe;

import java.util.List;

@Repository("chuDeDao")
public class ChuDeImpl implements ChuDeDao {
    //@PersistenceContext
    //EntityManager entityManager;

    @Autowired
    ChuDeRepository chuDeRepository;
    /**
     * Hàm lấy danh sách chủ đề
     * @return
     */
    @Override
    public List<ChuDe> getList() {
        return chuDeRepository.findAll();
    }

    @Override
    public ChuDe getById(String id) {
        ChuDe objChuDe = null;

        objChuDe = chuDeRepository.findById(id).get();

        return objChuDe;
    }

    @Override
    public boolean add(ChuDe objCD) {

        ChuDe objChuDe = chuDeRepository.save(objCD);

        if(objChuDe != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(ChuDe obj) {

        ChuDe objChuDe = getById(obj.getMaChuDe());

        if(objChuDe != null)
        {
            //Gán lại giá trị
            objChuDe.setTenChuDe(obj.getTenChuDe());

            chuDeRepository.save(objChuDe);

            return true;
        }
        return  false;
    }

    @Override
    public boolean delete(String id) {
        ChuDe objCD = getById(id);
        if(objCD != null)
        {
            chuDeRepository.delete(objCD);
            return true;
        }

        return false;
    }
}
