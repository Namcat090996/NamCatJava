package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class DonHangChiTiet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "order_id", nullable = false)
    private int maDonHang;
    
    @Column(name = "product_id", nullable = false)
    private int maSanPham;
    
    @Column(name = "quantity", nullable = false)
    private int soLuong;
    
    @Column(name = "price", nullable = false)
    private int giaSanPham;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getMaDonHang() {
        return maDonHang;
    }
    
    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }
    
    public int getMaSanPham() {
        return maSanPham;
    }
    
    public void setMaSanPham(int maSanPham) {
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
