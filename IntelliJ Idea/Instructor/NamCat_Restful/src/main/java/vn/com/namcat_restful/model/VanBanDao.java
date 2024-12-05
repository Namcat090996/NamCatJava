package vn.com.namcat_restful.model;

import vn.com.namcat_restful.entities.VanBan;

import java.time.LocalDate;
import java.util.List;

public interface VanBanDao extends IHanhDong<VanBan, String> {
    
    public List<VanBan> timKiemVanBang(String tuKhoa, String loaiVanBan, String donVi);
    
    public List<VanBan> timKiemVanBanTheoNgay(String tuKhoa, String loaiVanBan, String donVi, LocalDate tuNgay, LocalDate denNgay);
}
