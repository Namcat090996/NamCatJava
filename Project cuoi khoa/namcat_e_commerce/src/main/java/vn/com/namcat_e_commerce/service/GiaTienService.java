package vn.com.namcat_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_e_commerce.entities.GiaTien;
import vn.com.namcat_e_commerce.entities.VaiTro;
import vn.com.namcat_e_commerce.model.GiaTienDao;
import vn.com.namcat_e_commerce.model.VaiTroDao;

import java.util.List;

@Service
public class GiaTienService {
    
    @Autowired
    GiaTienDao giaTienDao;
    
    public List<GiaTien> getList() {
        return giaTienDao.getList();
    }
}
