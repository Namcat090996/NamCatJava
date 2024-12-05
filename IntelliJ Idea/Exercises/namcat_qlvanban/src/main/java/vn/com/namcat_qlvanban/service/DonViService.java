package vn.com.namcat_qlvanban.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_qlvanban.entities.DonVi;
import vn.com.namcat_qlvanban.model.DonViDao;
import vn.com.namcat_qlvanban.model.DonViRepository;

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
