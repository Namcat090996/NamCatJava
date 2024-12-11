package vn.com.namcat_e_commerce.entities;

public class SanPhamModel {
    
    private String tuKhoa;
    
    private String loaiSP;
    
    private String order;
    
    private String mauSac;
    
    private double tuGia = 0;
    
    private double denGia = 0;
    
    public String getMauSac() {
        return mauSac;
    }
    
    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    
    public String getOrder() {
        return order;
    }
    
    public void setOrder(String order) {
        this.order = order;
    }
    
    public String getTuKhoa() {
        return tuKhoa;
    }
    
    public void setTuKhoa(String tuKhoa) {
        this.tuKhoa = tuKhoa;
    }
    
    public String getLoaiSP() {
        return loaiSP;
    }
    
    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
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
