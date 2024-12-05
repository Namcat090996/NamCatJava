package vn.com.namcat_qlvanban.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "donvi")
public class DonVi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "MaDonVi", nullable = false, unique = true, length = 100)
    @NotBlank(message = "Bạn phải nhập mã đơn vị")
    private String maDonVi;
    
    @Column(name = "TenDonVi", nullable = false, length = 300)
    @NotBlank(message = "Bạn phải nhập tên đơn vị")
    private String tenDonVi;
    
    @Column(name = "DonViCapTrenId", nullable = true, length = 300)
    private String donViCapTrenId;
    
    @Column(name = "DienThoai", nullable = true, length = 45)
    private String dienThoai;
    
    @Column(name = "Email", nullable = true, length = 45)
    private String email;
    
    @Column(name = "DiaChi", nullable = true, length = 45)
    private String diaChi;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getMaDonVi() {
        return maDonVi;
    }
    
    public void setMaDonVi(String maDonVi) {
        this.maDonVi = maDonVi;
    }
    
    public String getTenDonVi() {
        return tenDonVi;
    }
    
    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }
    
    public String getDonViCapTrenId() {
        return donViCapTrenId;
    }
    
    public void setDonViCapTrenId(String donViCapTrenId) {
        this.donViCapTrenId = donViCapTrenId;
    }
    
    public String getDienThoai() {
        return dienThoai;
    }
    
    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
