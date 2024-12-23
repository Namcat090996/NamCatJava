package vn.com.namcat_srb_staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_srb_staff.entities.ChucVu;
import vn.com.namcat_srb_staff.entities.PhongBan;
import vn.com.namcat_srb_staff.model.ChucVuDao;
import vn.com.namcat_srb_staff.model.ChucVuRepository;

import java.util.List;

@Service
public class ChucVuService {
    
    @Autowired
    ChucVuDao chucVuDao;
    
    public List<ChucVu> layDanhSachChucVu()
    {
        return chucVuDao.getList();
    }
}
