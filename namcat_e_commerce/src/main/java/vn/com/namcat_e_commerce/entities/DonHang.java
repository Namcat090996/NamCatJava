package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "order")
public class DonHang {
    
    @Id
    @Column(name = "order_code", nullable = false, length = 50, unique = true)
    private String maDonHang;
    
    @Column(name = "username", nullable = false, length = 50)
    private String tenNguoiDung;
    
    @Column(name = "create", nullable = false)
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
}
