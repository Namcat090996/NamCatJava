package vn.com.namcat_srb_staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_srb_staff.entities.ChucVu;
import vn.com.namcat_srb_staff.entities.HeSoLuong;
import vn.com.namcat_srb_staff.model.ChucVuDao;
import vn.com.namcat_srb_staff.model.HeSoLuongDao;

import java.util.List;

@Service
public class HeSoLuongService {
    
    @Autowired
    HeSoLuongDao heSoLuongDao;
    
    public List<HeSoLuong> layDanhSachHSLuong()
    {
        return heSoLuongDao.getList();
    }
}
