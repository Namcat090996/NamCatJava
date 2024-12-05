package vn.com.namcat_restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_restful.entities.DonVi;
import vn.com.namcat_restful.model.DonViDao;

import java.util.List;

@Service
public class DonViService {
    
    @Autowired
    DonViDao donViDao;
    
    public List<DonVi> layDSDonVi()
    {
        return donViDao.getList();
    }
}
