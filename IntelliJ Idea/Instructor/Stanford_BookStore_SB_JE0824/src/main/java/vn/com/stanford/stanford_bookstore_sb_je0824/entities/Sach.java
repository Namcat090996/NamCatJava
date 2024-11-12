package vn.com.stanford.stanford_bookstore_sb_je0824.entities;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class Sach {
    /**
     * Hàm khởi tạo không có đối số
     */
    public Sach()
    {

    }

    /**
     * Hàm khởi tạo có 1 đối số
     * @param tenSach
     */
    public Sach(String tenSach)
    {
        this.tenSach = tenSach;
    }

    /**
     * Hàm khởi tạo có 5 tham số
     * @param tenSach
     * @param anhSach
     * @param moTa
     * @param giaSach
     */
    public Sach(String tenSach, String anhSach, String moTa, String tacGia, int giaSach)
    {
        this.tenSach = tenSach;
        this.anhSach = anhSach;
        this.moTa = moTa;
        this.tacGia = tacGia;
        this.giaSach = giaSach;
    }

    @NotBlank(message = "Bạn cần phải nhập mã sách")
    private String maSach;

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    @NotEmpty(message = "Bạn cần phải nhập tên sách")
    private String tenSach;
    private String moTa;
    private String anhSach;
    private String tacGia;

    @NotNull(message = "Bạn cần phải nhập giá sách")
    @Min(value = 0, message = "Bạn phải nhập giá sách lớn hơn 0")
    private double giaSach;
    private Date ngayTao;
    private Date ngayCapNhat;
    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }


    private String maChuDe;

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
    public double getGiaSach() {
        return giaSach;
    }
    public void setGiaSach(double giaSach) {
        this.giaSach = giaSach;
    }
    public Date getNgayTao() {
        return ngayTao;
    }
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    public String getMaChuDe() {
        return maChuDe;
    }
    public void setMaChuDe(String maChuDe) {
        this.maChuDe = maChuDe;
    }

    private int daDuyet = 0;

    public int getDaDuyet() {
        return daDuyet;
    }

    public void setDaDuyet(int daDuyet) {
        this.daDuyet = daDuyet;
    }
}
