package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "user")
public class NguoiDung {
    
    @Id
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String tenNguoiDung;
    
    @Column(name = "password", nullable = false, length = 255)
    private String matKhau;
    
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name = "fullname", nullable = false, length = 255)
    private String hoTen;
    
    @Column(name = "phone", nullable = false, unique = true, length = 10)
    private String dienThoai;
    
    @Column(name = "role", nullable = false, length = 70)
    private String vaiTro;
    
    @Column(name = "address", nullable = true, length = 300)
    private String diaChi;
    
    public String getTenNguoiDung() {
        return tenNguoiDung;
    }
    
    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }
    
    public String getMatKhau() {
        return matKhau;
    }
    
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getHoTen() {
        return hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public String getDienThoai() {
        return dienThoai;
    }
    
    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
    
    public String getVaiTro() {
        return vaiTro;
    }
    
    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
    
    public String getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
