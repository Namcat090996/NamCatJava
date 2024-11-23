package vn.com.namcat_srb_staff.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "phongban")
public class PhongBan {
    
    //Declare attributes
    @Id
    @Column(name = "MaPhong", nullable = false, length = 10, unique = true)
    @NotBlank(message = "Bạn phải nhập mã phòng")
    private String maPhong;
    
    @Column(name = "TenPhong", nullable = true, length = 150)
    @NotEmpty(message = "Bạn phải nhập tên phòng")
    private String tenPhong;
    
    @Column(name = "DienThoai", nullable = true, length = 20)
    private String dienThoai;
    
    //Call the getter and setter function
    public String getMaPhong() {
        return maPhong;
    }
    
    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }
    
    public String getTenPhong() {
        return tenPhong;
    }
    
    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }
    
    public String getDienThoai() {
        return dienThoai;
    }
    
    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
}
