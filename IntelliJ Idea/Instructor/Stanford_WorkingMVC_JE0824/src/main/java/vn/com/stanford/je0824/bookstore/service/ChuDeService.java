package vn.com.stanford.je0824.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.stanford.je0824.bookstore.entities.ChuDe;
import vn.com.stanford.je0824.bookstore.model.ChuDeDao;

import java.util.List;

@Service
public class ChuDeService {

    @Autowired
    ChuDeDao chuDeDao;

    /**
     * Lấy danh sách chủ đề
     * @return
     */
    public List<ChuDe> layDanhSach()
    {
        return  chuDeDao.getList();
    }
}
