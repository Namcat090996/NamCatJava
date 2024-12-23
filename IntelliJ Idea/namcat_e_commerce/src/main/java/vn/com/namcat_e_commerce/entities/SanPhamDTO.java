package vn.com.namcat_e_commerce.entities;

import java.time.LocalDate;
import java.util.List;

public class SanPhamDTO {
    
    private String maSanPham;

    private String tenSanPham;

    private int giaSanPham;

    private int tonKho;

    private String loaiSanPham;

    private String anhSanPham;

    private String moTa;

    private String noiDung;
    
    private LocalDate ngayTao;

    private String tenNguoiTao;

    private LocalDate ngayCapNhap;

    private LocalDate ngayDuyet;

    private String tenNguoiDuyet;

    private int daDuyet = 0;

    private String mauSac;
    
    private String giaTienFormat;
    
    private List<AnhSanPham> lstASP;
    
    public List<AnhSanPham> getLstASP() {
        return lstASP;
    }
    
    public void setLstASP(List<AnhSanPham> lstASP) {
        this.lstASP = lstASP;
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
    
    public String getGiaTienFormat() {
        return giaTienFormat;
    }
    
    public void setGiaTienFormat(String giaTienFormat) {
        this.giaTienFormat = giaTienFormat;
    }
}
