package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Table
@Entity(name = "role")
public class VaiTro {
    
    @Id
    @Column(name = "role", nullable = false, unique = true, length = 20)
    @NotBlank(message = "Bạn phải nhập mã vai trò")
    private String maVaiTro;
    
    @Column(name = "name", nullable = false, unique = true, length = 200)
    @NotBlank(message = "Bạn phải nhập tên vai trò")
    private String tenVaiTro;
    
    public String getMaVaiTro() {
        return maVaiTro;
    }
    
    public void setMaVaiTro(String maVaiTro) {
        this.maVaiTro = maVaiTro;
    }
    
    public String getTenVaiTro() {
        return tenVaiTro;
    }
    
    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }
}
