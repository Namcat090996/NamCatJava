package vn.com.namcat.bookstore.entities;

import javax.validation.constraints.*;
import java.util.Date;

public class Sach {

    //Declare attributes
    @NotBlank(message = "Bạn phải chọn mã sách")
    private String maSach;
    @NotEmpty(message = "Bạn phải nhập tên sách")
    private String tenSach;
    private String moTa;
    private String anhSach;
    private String tacGia;
    @Digits(integer = 10, fraction = 0, message = "Giá sách phải là số nguyên dương")
    @Min(value = 0, message = "Giá sách phải là số nguyên dương")
    private int giaSach;
    private Date ngayTao;
    private Date ngayCapNhat;
    @NotEmpty(message = "Bạn phải chọn mã chủ đề")
    private String maChuDe;
    private int soLuong = 0;

    //Call the getter and setter function
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
