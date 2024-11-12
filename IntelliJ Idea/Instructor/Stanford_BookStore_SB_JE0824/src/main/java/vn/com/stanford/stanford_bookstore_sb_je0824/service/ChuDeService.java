package vn.com.stanford.stanford_bookstore_sb_je0824.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.stanford.stanford_bookstore_sb_je0824.entities.ChuDe;
import vn.com.stanford.stanford_bookstore_sb_je0824.model.ChuDeDao;

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
