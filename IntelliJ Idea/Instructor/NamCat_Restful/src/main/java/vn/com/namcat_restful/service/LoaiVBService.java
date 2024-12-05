package vn.com.namcat_restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_restful.entities.LoaiVanBan;
import vn.com.namcat_restful.model.LoaiVanBanDao;

import java.util.List;

@Service
public class LoaiVBService {
    
    @Autowired
    LoaiVanBanDao loaiVanBanDao;
    
    public List<LoaiVanBan> layDSLoaiVB()
    {
        return loaiVanBanDao.getList();
    }
    
}
