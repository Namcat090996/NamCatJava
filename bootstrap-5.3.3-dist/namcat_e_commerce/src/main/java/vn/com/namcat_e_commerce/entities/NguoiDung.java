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
    @NotBlank(message = "Bạn phải nhập tên người dùng")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+$", message = "Tên người dùng không hợp lệ")
    private String tenNguoiDung;
    
    @Column(name = "password", nullable = false, length = 255)
    @NotBlank(message = "Bạn phải nhập mật khẩu")
    private String matKhau;
    
    @Column(name = "email", nullable = false, unique = true, length = 100)
    @NotBlank(message = "Bạn phải nhập địa chỉ email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Địa chỉ email không hợp lệ")
    private String email;
    
    @Column(name = "fullname", nullable = false, length = 255)
    @NotBlank(message = "Bạn phải nhập họ tên")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$", message = "Họ tên không hợp lệ")
    private String hoTen;
    
    @Column(name = "phone", nullable = false, unique = true, length = 10)
    @NotBlank(message = "Bạn phải nhập số điện thoại")
    @Size(min = 10, max = 10, message = "Số điện thoại phải bao gồm 10 chữ số")
    @Pattern(regexp = "\\d{10}", message = "Số điện thoại phải bao gồm 10 chữ số")
    private String dienThoai;
    
    @Column(name = "role", nullable = false, length = 70)
    @NotEmpty(message = "Bạn phải chọn vai trò cho người dùng")
    private String vaiTro;
    
    @Column(name = "address", nullable = true, length = 300)
    @NotEmpty(message = "Bạn phải nhập địa chỉ")
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
