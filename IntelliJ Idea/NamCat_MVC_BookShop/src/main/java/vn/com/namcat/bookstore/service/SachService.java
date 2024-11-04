package vn.com.namcat.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat.bookstore.entities.Sach;
import vn.com.namcat.bookstore.model.SachDao;

import java.util.List;

@Service
public class SachService {

    @Autowired
    SachDao sachDao;

    /**
     * Function to get list
     * @return
     */
    public List<Sach> layDanhSach()
    {
        return sachDao.getList();
    }

    /**
     * Function to get detailed object by id
     * @param maSach
     * @return
     */
    public Sach layChiTiet(String maSach)
    {
        return sachDao.findById(maSach);
    }

    /**
     * Function to insert a new object
     * @param objSach
     * @return
     */
    public boolean themMoi(Sach objSach)
    {
        return sachDao.add(objSach);
    }

    /**
     * Function update info of selected object
     * @param objSach
     * @return
     */
    public boolean capNhat(Sach objSach)
    {
        return sachDao.update(objSach);
    }

    /**
     * Function to delete object by id
     * @param maSach
     * @return
     */
    public boolean xoa(String maSach)
    {
        return sachDao.delete(maSach);
    }

}
