package vn.com.namcat_qlvanban.model;

import vn.com.namcat_qlvanban.entities.VanBan;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface VanBanDao extends IHanhDong<VanBan, String> {
    
    public List<VanBan> timKiemVanBang(String tuKhoa, String loaiVanBan, String donVi);
    
    public List<VanBan> timKiemVanBanTheoNgay(String tuKhoa, String loaiVanBan, String donVi, LocalDate tuNgay, LocalDate denNgay);
}
