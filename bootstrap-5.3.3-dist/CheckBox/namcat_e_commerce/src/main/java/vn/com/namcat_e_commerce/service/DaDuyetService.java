package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.DaDuyet;
import vn.com.namcat_e_commerce.entities.GiaTien;
import vn.com.namcat_e_commerce.model.DaDuyetDao;
import vn.com.namcat_e_commerce.model.GiaTienDao;

import java.util.List;

@Service
public class DaDuyetService {
    
    @Autowired
    DaDuyetDao daDuyetDao;
    
    public List<DaDuyet> getList() {
        return daDuyetDao.getList();
    }
}
