package vn.com.stanford.staffmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.stanford.staffmanagement.entities.ChucVu;
import vn.com.stanford.staffmanagement.model.ChucVuDao;

import java.util.List;

@Service
public class ChucVuService {

    @Autowired
    ChucVuDao chucVuDao;

    /**
     * Function to get list
     * @return
     */
    public List<ChucVu> layDanhSach()
    {
        return chucVuDao.getList();
    }
}
