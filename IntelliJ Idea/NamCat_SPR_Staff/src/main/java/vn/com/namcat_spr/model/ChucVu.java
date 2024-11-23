package vn.com.namcat_spr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "chucvu")
public class ChucVu {
    
    //Declare attributes
    @Id
    @Column(name = "MaChucVu", nullable = false, unique = true, length = 10)
    @NotBlank(message = "Bạn phải nhập mã chức vụ")
    private String maChucVu;
    
    @Column(name = "TenChucVu", nullable = true, length = 100)
    @NotEmpty(message = "Bạn phải nhập tên chức vụ")
    private String tenChucVu;
    
    //Call the getter and setter function
    public String getMaChucVu() {
        return maChucVu;
    }
    
    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }
    
    public String getTenChucVu() {
        return tenChucVu;
    }
    
    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }
}
