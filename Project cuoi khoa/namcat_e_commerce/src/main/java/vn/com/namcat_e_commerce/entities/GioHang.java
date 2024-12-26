package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class GioHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "username", nullable = false, length = 50)
    private String tenNguoiDung;
    
    @Column(name = "product_id", nullable = false, length = 50)
    private String maSanPham;
    
    @Column(name = "quantity", nullable = true)
    private int soLuong;
    
    @Column(name = "price", nullable = true)
    private int giaSanPham;
    
    @Column(name = "total_price", nullable = true)
    private int tongTien = 0;
    
    @Column(name = "image", nullable = true, length = 255)
    private String anhSanPham;
    
    @Column(name = "product_name", nullable = true, length = 255)
    private String tenSanPham;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTenNguoiDung() {
        return tenNguoiDung;
    }
    
    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }
    
    public String getMaSanPham() {
        return maSanPham;
    }
    
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public int getGiaSanPham() {
        return giaSanPham;
    }
    
    public void setGiaSanPham(int giaSanPham) {
        this.giaSanPham = giaSanPham;
    }
    
    public int getTongTien() {
        return tongTien;
    }
    
    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
    public String getAnhSanPham() {
        return anhSanPham;
    }
    
    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }
    
    public String getTenSanPham() {
        return tenSanPham;
    }
    
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
}
