package vn.com.namcat_bookstore_sbt.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Sach")
public class Sach {

    //Declare attributes
    @Id
    @Column(name = "MaSach", nullable = false, length = 10)
    @NotBlank(message = "Ban phai nhap ma sach")
    private String maSach;

    @Column(name = "TenSach", nullable = true, length = 255)
    @NotEmpty(message = "Ban phai nhap ten sach")
    private String tenSach;

    @Column(name = "MoTa", nullable = true, length = 500)
    private String moTa;

    @Column(name = "AnhSach", nullable = true, length = 50)
    private String anhSach;

    @Column(name = "TacGia", nullable = true, length = 30)
    private String tacGia;

    @Column(name = "GiaSach", nullable = true)
    @Digits(integer = 10, fraction = 0, message = "Gia sach phai la so nguyen duong")
    @Min(value = 0, message = "Gia sach phai la so nguyen duong")
    private int giaSach;

    @Column(name = "NgayTao", nullable = true)
    private Date ngayTao;

    @Column(name = "NgayCapNhat", nullable = true)
    private Date ngayCapNhat;

    @Column(name = "MaChuDe", nullable = true, length = 10)
    @NotEmpty(message = "Ban phai chon ma chu de")
    private String maChuDe;

    @Column(name = "DaDuyet", nullable = true)
    private int daDuyet = 0;

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

}


