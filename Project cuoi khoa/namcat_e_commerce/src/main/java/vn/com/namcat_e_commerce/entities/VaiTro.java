package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "role")
public class VaiTro {
    
    @Id
    @Column(name = "name", nullable = false, unique = true, length = 70)
    @NotBlank(message = "Bạn phải nhập tên vai trò")
    private String tenVaiTro;
    
    public String getTenVaiTro() {
        return tenVaiTro;
    }
    
    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }
}
