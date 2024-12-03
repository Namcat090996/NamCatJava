package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "category")
public class LoaiSanPham {
    
    @Id
    @Column(name = "categoryid", nullable = false, unique = true, length = 20)
    @NotBlank(message = "Bạn phải nhập mã sản phẩm")
    private String loaiSanPham;
    
    @Column(name = "name", nullable = false, unique = true, length = 200)
    @NotBlank(message = "Bạn phải nhập tên sản phẩm")
    private String tenSanPham;
    
    public String getLoaiSanPham() {
        return loaiSanPham;
    }
    
    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
    
    public String getTenSanPham() {
        return tenSanPham;
    }
    
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    
}
