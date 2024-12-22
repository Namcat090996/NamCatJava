package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class AnhSanPham {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "product_id", nullable = false,  length = 50)
    private String maSanPham;
    
    @Column(name = "image", nullable = true,  length = 255  )
    private String anhSanPham;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getMaSanPham() {
        return maSanPham;
    }
    
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
    
    public String getAnhSanPham() {
        return anhSanPham;
    }
    
    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }
}
