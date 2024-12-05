package vn.com.namcat_e_commerce.entities;

public class SanPhamModel {
    
    private String tuKhoa;
    
    private String tenLoaiSP;
    
    private double tuGia;
    
    private double denGia;
    
    public String getTuKhoa() {
        return tuKhoa;
    }
    
    public void setTuKhoa(String tuKhoa) {
        this.tuKhoa = tuKhoa;
    }
    
    public String getTenLoaiSP() {
        return tenLoaiSP;
    }
    
    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }
    
    public double getTuGia() {
        return tuGia;
    }
    
    public void setTuGia(double tuGia) {
        this.tuGia = tuGia;
    }
    
    public double getDenGia() {
        return denGia;
    }
    
    public void setDenGia(double denGia) {
        this.denGia = denGia;
    }
}
