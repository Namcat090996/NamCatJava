package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Table
@Entity(name = "status")
public class TrangThai {

    @Id
    @Column(name = "status", nullable = false, unique = true, length = 20)
    @NotBlank(message = "Bạn phải nhập mã trạng thái")
    private String maTrangThai;
    
    @Column(name = "name", nullable = false, unique = true, length = 100)
    @NotBlank(message = "Bạn phải nhập tên trạng thái")
    private String tenTrangThai;
    
    public String getMaTrangThai() {
        return maTrangThai;
    }
    
    public void setMaTrangThai(String maTrangThai) {
        this.maTrangThai = maTrangThai;
    }
    
    public String getTenTrangThai() {
        return tenTrangThai;
    }
    
    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }
}
