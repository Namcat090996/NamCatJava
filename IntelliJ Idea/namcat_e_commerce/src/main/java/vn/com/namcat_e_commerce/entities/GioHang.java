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
    
    @Column(name = "product_id", nullable = false)
    private int maSanPham;
    
    @Column(name = "quantity", nullable = false)
    private int soLuong;
    
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
}
