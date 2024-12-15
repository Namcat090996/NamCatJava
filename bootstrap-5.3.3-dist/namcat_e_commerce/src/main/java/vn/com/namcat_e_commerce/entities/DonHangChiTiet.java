package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class DonHangChiTiet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "order_code", nullable = false, length = 50)
    private String maDonHang;
    
    @Column(name = "product_id", nullable = false, length = 50)
    private String maSanPham;
    
    @Column(name = "quantity", nullable = true)
    private int soLuong;
    
    @Column(name = "price", nullable = true)
    private int giaSanPham;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getMaDonHang() {
        return maDonHang;
    }
    
    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
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
}
