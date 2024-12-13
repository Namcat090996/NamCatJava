package vn.com.namcat_e_commerce.entities;

public class SanPhamModel {
    
    private String tuKhoa;
    
    private String loaiSP;
    
    private String order;
    
    private String mauSac;
    
    private int tuGia;
    
    private int denGia;
    
    private int daDuyet;
    
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
    
    public int getTuGia() {
        return tuGia;
    }
    
    public void setTuGia(int tuGia) {
        this.tuGia = tuGia;
    }
    
    public int getDenGia() {
        return denGia;
    }
    
    public void setDenGia(int denGia) {
        this.denGia = denGia;
    }
    
    public int getDaDuyet() {
        return daDuyet;
    }
    
    public void setDaDuyet(int daDuyet) {
        this.daDuyet = daDuyet;
    }
}
