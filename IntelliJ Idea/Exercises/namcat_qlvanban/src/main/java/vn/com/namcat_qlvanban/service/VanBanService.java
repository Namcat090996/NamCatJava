package vn.com.namcat_qlvanban.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.namcat_qlvanban.entities.VanBan;
import vn.com.namcat_qlvanban.entities.VanBanModel;
import vn.com.namcat_qlvanban.model.VanBanDao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class VanBanService {
    
    @Autowired
    VanBanDao vanBanDao;
    
    public List<VanBan> timKiemVanBan(String tuKhoa, String loaiVanBan, String donVi)
    {
        return vanBanDao.timKiemVanBang(tuKhoa, loaiVanBan, donVi);
    }
    
    public List<VanBan> timKiemVanBanTheoNgay(String tuKhoa, String loaiVanBan, String donVi, LocalDate tuNgay, LocalDate denNgay)
    {
        return vanBanDao.timKiemVanBanTheoNgay(tuKhoa, loaiVanBan, donVi, tuNgay, denNgay);
    }
    
    public VanBan layChiTiet(String maVanban)
    {
        return vanBanDao.findById(maVanban);
    }
    
    public boolean themVanBan(VanBan objVB)
    {
        return vanBanDao.add(objVB);
    }
    
    public boolean suaVanban(VanBan objVB)
    {
        return vanBanDao.update(objVB);
    }
    
    public boolean xoaVanBan(String maVanBan)
    {
        return vanBanDao.delete(maVanBan);
    }
}
