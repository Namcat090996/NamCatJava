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
    @Column(name = "name", nullable = false, unique = true, length = 50)
    @NotBlank(message = "Bạn phải nhập loại sản phẩm")
    private String loaiSanPham;
    
    public String getLoaiSanPham() {
        return loaiSanPham;
    }
    
    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
    
}
