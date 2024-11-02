package vn.com.stanford.staffmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.stanford.staffmanagement.entities.ChucVu;
import vn.com.stanford.staffmanagement.entities.PhongBan;
import vn.com.stanford.staffmanagement.model.ChucVuDao;
import vn.com.stanford.staffmanagement.model.PhongBanDao;

import java.util.List;

@Service
public class PhongBanService {

    @Autowired
    PhongBanDao phongBanDao;

    /**
     * Function to get list
     * @return
     */
    public List<PhongBan> layDanhSach()
    {
        return phongBanDao.getList();
    }
}
