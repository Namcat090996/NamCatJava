package vn.com.stanford_workingapi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.com.stanford_workingapi.entities.ChuDe;

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
        //Khai báo danh sách
        //List<ChuDe> lstChuDe = new ArrayList<>();

        //Kết nối đến db qua hibernate
        //Session session = HibernateUtil.getSessionFactory().openSession();

        //Bắt đầu phiên làm việc
        //Transaction tx = session.beginTransaction();

        //Query<ChuDe> query = session.createQuery("from ChuDe", ChuDe.class);

        //lstChuDe = query.list();

        //tx.commit();

       /* CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ChuDe> criteriaQuery = criteriaBuilder.createQuery(ChuDe.class);
        Root<ChuDe> cdRoot = criteriaQuery.from(ChuDe.class);

        criteriaQuery.select(cdRoot);

        Query query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();*/

        //String jpqlQuery = "SELECT c FROM ChuDe c";
        ///TypedQuery<ChuDe> query = entityManager.createQuery(jpqlQuery, ChuDe.class);

        //lstChuDe = query.getResultList();

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
