package vn.com.namcat_bookstore_sbt.entities;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class Sach {

    //Declare attributes
    @NotBlank(message = "Ban phai nhap ma sach")
    private String maSach;
    @NotEmpty(message = "Ban phai nhap ten sach")
    private String tenSach;
    private String moTa;
    private String anhSach;
    private String tacGia;
    @Digits(integer = 10, fraction = 0, message = "Gia sach phai la so nguyen duong")
    @Min(value = 0, message = "Gia sach phai la so nguyen duong")
    private int giaSach;
    private Date ngayTao;
    private Date ngayCapNhat;
    @NotEmpty(message = "Ban phai chon ma chu de")
    private String maChuDe;
    private int daDuyet = 0;
    private int soLuong = 0;

    //Call getter and setter function
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnhSach() {
        return anhSach;
    }

    public void setAnhSach(String anhSach) {
        this.anhSach = anhSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(int giaSach) {
        this.giaSach = giaSach;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public String getMaChuDe() {
        return maChuDe;
    }

    public void setMaChuDe(String maChuDe) {
        this.maChuDe = maChuDe;
    }

    public int getDaDuyet() {
        return daDuyet;
    }

    public void setDaDuyet(int daDuyet) {
        this.daDuyet = daDuyet;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}


