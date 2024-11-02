package vn.com.stanford.staffmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.stanford.staffmanagement.entities.HeSoLuong;
import vn.com.stanford.staffmanagement.entities.PhongBan;
import vn.com.stanford.staffmanagement.model.HeSoLuongDao;

import java.util.List;

@Service
public class HeSoLuongService {

    @Autowired
    HeSoLuongDao heSoLuongDao;

    /**
     * Function to get list
     * @return
     */
    public List<HeSoLuong> layDanhSach()
    {
        return heSoLuongDao.getList();
    }
}
