package vn.com.namcat.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat.bookstore.entities.ChuDe;
import vn.com.namcat.bookstore.model.ChuDeDao;

import java.util.List;

@Service
public class ChuDeService {

    @Autowired
    ChuDeDao chuDeDao;

    /**
     * Function to get list
     * @return
     */
    public List<ChuDe> layDanhSach()
    {
        return chuDeDao.getList();
    }
}
