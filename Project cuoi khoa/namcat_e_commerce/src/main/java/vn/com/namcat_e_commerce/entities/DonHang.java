package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "p_order")
public class DonHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "order_code", nullable = false, length = 50, unique = true)
    private String maDonHang;
    
    @Column(name = "username", nullable = false, length = 50)
    private String tenNguoiDung;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_date", nullable = false)
    private LocalDate ngayTao;
    
    @Column(name = "status", nullable = false, length = 50)
    private String trangThai;
    
    @Column(name = "total_price", nullable = false)
    private int tongTien = 0;
    
    @Column(name = "order_name", nullable = true, length = 255)
    private String tenDonHang;
    
    @Column(name = "description", nullable = true, length = 300)
    private String moTa;
    
    @Column(name = "user_create", nullable = true, length = 50)
    private String tenNguoiTao;
    
    @Column(name = "p_fullname", nullable = true, length = 255)
    @Pattern(regexp = "^[\\p{L}]+(\\s[\\p{L}]+)*$", message = "Họ và tên người đặt hàng không hợp lệ")
    private String hoTen;
    
    @Column(name = "p_phone", nullable = true, length = 10)
    @Pattern(regexp = "\\d{10}", message = "SĐT phải bao gồm 10 chữ số")
    private String dienThoai;
    
    @Column(name = "p_address", nullable = true, length = 300)
    @NotEmpty(message = "Bạn cần phải nhập địa chỉ nhận hàng")
    private String diaChi;
    
    @Column(name = "p_email", nullable = true, length = 1005)
    private String email;
    
    @Column(name = "p_note", nullable = true, length = 500)
    private String ghiChu;
    
    public String getTenNguoiDung() {
        return tenNguoiDung;
    }
    
    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }
    
    public LocalDate getNgayTao() {
        return ngayTao;
    }
    
    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    public String getTrangThai() {
        return trangThai;
    }
    
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    public int getTongTien() {
        return tongTien;
    }
    
    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
    public String getMaDonHang() {
        return maDonHang;
    }
    
    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }
    
    public String getTenDonHang() {
        return tenDonHang;
    }
    
    public void setTenDonHang(String tenDonHang) {
        this.tenDonHang = tenDonHang;
    }
    
    public String getMoTa() {
        return moTa;
    }
    
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public String getTenNguoiTao() {
        return tenNguoiTao;
    }
    
    public void setTenNguoiTao(String tenNguoiTao) {
        this.tenNguoiTao = tenNguoiTao;
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
    
    public String getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getGhiChu() {
        return ghiChu;
    }
    
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
