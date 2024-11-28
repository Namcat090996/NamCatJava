package vn.com.stanford.workingrestfulapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.stanford.workingrestfulapi.entities.ChuDe;
import vn.com.stanford.workingrestfulapi.model.ChuDeDao;

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

    public ChuDe layChiTiet(String maChuDe) {
        return chuDeDao.getById(maChuDe);
    }

    public boolean themMoi(ChuDe objChuDe)
    {
        return chuDeDao.add(objChuDe);
    }

    public boolean capNhat(ChuDe objChuDe)
    {
        return chuDeDao.update(objChuDe);
    }

    public boolean xoa(String maChuDe)
    {
        return chuDeDao.delete(maChuDe);
    }
}
