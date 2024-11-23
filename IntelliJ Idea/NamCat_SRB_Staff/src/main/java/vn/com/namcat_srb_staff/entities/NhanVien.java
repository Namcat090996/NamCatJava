package vn.com.namcat_srb_staff.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
    
    //Declare attributes
    @Id
    @Column(name = "MaNV", nullable = false, unique = true, length = 10)
    @NotBlank(message = "Bạn cần phải nhập mã nhân viên")
    private String maNV;
    
    @Column(name = "HoTen", nullable = true, length = 30)
    @NotEmpty(message = "Bạn cần phải nhập họ tên nhân viên")
    private String hoTen;
    
    @Column(name = "GioiTinh", nullable = true)
    private int gioiTinh;
    
    @Column(name = "NgaySinh", nullable = true)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngaySinh;
    
    @Column(name = "DienThoai", nullable = true, length = 20)
    private String dienThoai;
    
    @Column(name = "Email", nullable = true, length = 50)
    private String email;
    
    @Column(name = "DiaChi", nullable = true, length = 50)
    private String diaChi;
    
    @Column(name = "SoCMT", nullable = true, length = 15)
    private String soCMT;
    
    @Column(name = "NgayCap", nullable = true)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngayCap;
    
    @Column(name = "NoiCap", nullable = true, length = 100)
    private String noiCap;
    
    @Column(name = "HeSoId", nullable = true)
    private int heSoId;
    
    @Column(name = "MaChucVu", nullable = true, length = 10)
    private String maChucVu;
    
    @Column(name = "MaPhong", nullable = true, length = 10)
    private String maPhong;
    
    //Call the getter and setter function
    public String getMaNV() {
        return maNV;
    }
    
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
    public String getHoTen() {
        return hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public int getGioiTinh() {
        return gioiTinh;
    }
    
    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public Date getNgaySinh() {
        return ngaySinh;
    }
    
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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
    
    public String getSoCMT() {
        return soCMT;
    }
    
    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }
    
    public Date getNgayCap() {
        return ngayCap;
    }
    
    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }
    
    public String getNoiCap() {
        return noiCap;
    }
    
    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }
    
    public int getHeSoId() {
        return heSoId;
    }
    
    public void setHeSoId(int heSoId) {
        this.heSoId = heSoId;
    }
    
    public String getMaChucVu() {
        return maChucVu;
    }
    
    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }
    
    public String getMaPhong() {
        return maPhong;
    }
    
    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }
}
