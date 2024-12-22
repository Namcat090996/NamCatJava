package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "product")
public class SanPham {
    
    @Id
    @Column(name = "product_id", nullable = false, unique = true, length = 50)
    private String maSanPham;
    
    @Column(name = "name", nullable = false, unique = true, length = 255)
    private String tenSanPham;
    
    @Column(name = "price", nullable = false)
    private int giaSanPham;
    
    @Column(name = "stock", nullable = false)
    private int tonKho;
    
    @Column(name = "category", nullable = false, length = 50)
    private String loaiSanPham;
    
    @Column(name = "image", nullable = true, length = 255)
    private String anhSanPham;
    
    @Column(name = "description", nullable = true, length = 500)
    private String moTa;
    
    @Column(name = "p_content", nullable = true, length = 1000)
    private String noiDung;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_day", nullable = true)
    private LocalDate ngayTao;
    
    @Column(name = "user_create", nullable = true, length = 50)
    private String tenNguoiTao;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "update_date", nullable = true)
    private LocalDate ngayCapNhap;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "approved_date", nullable = true)
    private LocalDate ngayDuyet;
    
    @Column(name = "user_approved", nullable = true, length = 50)
    private String tenNguoiDuyet;
    
    @Column(name = "p_approved", nullable = true)
    private int daDuyet = 0;
    
    @Column(name = "color", nullable = true, length = 50)
    private String mauSac;
    
    private String giaTienFormat;
    
    public String getGiaTienFormat() {
        return giaTienFormat;
    }
    
    public void setGiaTienFormat(String giaTienFormat) {
        this.giaTienFormat = giaTienFormat;
    }
    
    public String getMaSanPham() {
        return maSanPham;
    }
    
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
    
    public String getTenSanPham() {
        return tenSanPham;
    }
    
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    
    public int getGiaSanPham() {
        return giaSanPham;
    }
    
    public void setGiaSanPham(int giaSanPham) {
        this.giaSanPham = giaSanPham;
    }
    
    public int getTonKho() {
        return tonKho;
    }
    
    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }
    
    public String getLoaiSanPham() {
        return loaiSanPham;
    }
    
    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
    
    public String getAnhSanPham() {
        return anhSanPham;
    }
    
    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }
    
    public String getMoTa() {
        return moTa;
    }
    
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public String getNoiDung() {
        return noiDung;
    }
    
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    
    public LocalDate getNgayTao() {
        return ngayTao;
    }
    
    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    public String getTenNguoiTao() {
        return tenNguoiTao;
    }
    
    public void setTenNguoiTao(String tenNguoiTao) {
        this.tenNguoiTao = tenNguoiTao;
    }
    
    public LocalDate getNgayCapNhap() {
        return ngayCapNhap;
    }
    
    public void setNgayCapNhap(LocalDate ngayCapNhap) {
        this.ngayCapNhap = ngayCapNhap;
    }
    
    public LocalDate getNgayDuyet() {
        return ngayDuyet;
    }
    
    public void setNgayDuyet(LocalDate ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
    }
    
    public String getTenNguoiDuyet() {
        return tenNguoiDuyet;
    }
    
    public void setTenNguoiDuyet(String tenNguoiDuyet) {
        this.tenNguoiDuyet = tenNguoiDuyet;
    }
    
    public int getDaDuyet() {
        return daDuyet;
    }
    
    public void setDaDuyet(int daDuyet) {
        this.daDuyet = daDuyet;
    }
    
    public String getMauSac() {
        return mauSac;
    }
    
    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
}
