package vn.com.namcat_qlvanban.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class VanBanModel {
    
    private String tuKhoa;
    
    private String loaiVanBan;
    
    private String donVi;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tuNgay;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate denNgay;
    
    public String getTuKhoa() {
        return tuKhoa;
    }
    
    public void setTuKhoa(String tuKhoa) {
        this.tuKhoa = tuKhoa;
    }
    
    public String getLoaiVanBan() {
        return loaiVanBan;
    }
    
    public void setLoaiVanBan(String loaiVanBan) {
        this.loaiVanBan = loaiVanBan;
    }
    
    public String getDonVi() {
        return donVi;
    }
    
    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }
    
    public LocalDate getTuNgay() {
        return tuNgay;
    }
    
    public void setTuNgay(LocalDate tuNgay) {
        this.tuNgay = tuNgay;
    }
    
    public LocalDate getDenNgay() {
        return denNgay;
    }
    
    public void setDenNgay(LocalDate denNgay) {
        this.denNgay = denNgay;
    }
}
