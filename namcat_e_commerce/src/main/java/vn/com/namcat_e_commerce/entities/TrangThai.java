package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "status")
public class TrangThai {
    
    @Id
    @Column(name = "name", nullable = false, unique = true, length = 50)
    @NotBlank(message = "Bạn phải nhập tên trạng thái")
    private String tenTrangThai;
    
    public String getTenTrangThai() {
        return tenTrangThai;
    }
    
    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }
}
