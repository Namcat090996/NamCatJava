package vn.com.namcat_srb_staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_srb_staff.entities.NhanVien;
import vn.com.namcat_srb_staff.entities.NhanVienModel;
import vn.com.namcat_srb_staff.entities.PhongBan;
import vn.com.namcat_srb_staff.model.NhanVienDao;
import vn.com.namcat_srb_staff.model.PhongBanDao;

import java.util.List;

@Service
public class PhongBanService {
    
    @Autowired
    PhongBanDao phongBanDao;
    
    public List<PhongBan> layDanhSachPhongBan()
    {
        return phongBanDao.getList();
    }
    
}
