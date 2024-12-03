package vn.com.namcat_qlvanban.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "vanban")
public class VanBan {
    
    @Id
    @Column(name = "MaVanBan", nullable = false, unique = true, length = 30)
    @Pattern(regexp = "^SF\\d{4,}$", message = "Mã văn bản phải bắt đầu bằng 'SF' và theo sau ít nhất 04 chữ số")
    private String maVanBan;
    
    @Column(name = "TieuDe", nullable = false, length = 200)
    @NotEmpty(message = "Bạn phải nhập tiêu đề văn bản")
    private String tieuDe;
    
    @Column(name = "MoTa", nullable = true, length = 500)
    private String moTa;
    
    @Column(name = "NoiDung", nullable = true, length = 1000)
    private String noiDung;
    
    @Column(name = "NgayTao", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayTao;
    
    @Column(name = "NgayCapNhat", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayCapNhat;
    
    @Column(name = "TenFile", nullable = true, length = 255)
    private String tenFile;
    
    @Column(name = "DuongDan", nullable = true, length = 255)
    private String duongDan;
    
    @Column(name = "DinhDang", nullable = true, length = 45)
    private String dinhDang;
    
    @Column(name = "SoTrang", nullable = true)
    private int soTrang;
    
    @Column(name = "LoaiVanBanId", nullable = false, length = 100)
    @NotEmpty(message = "Bạn phải chọn loại văn bản")
    private String loaiVanBan;
    
    @Column(name = "DonViId", nullable = false, length = 100)
    @NotEmpty(message = "Bạn phải chọn đơn vị")
    private String donVi;
    
    public String getMaVanBan() {
        return maVanBan;
    }
    
    public void setMaVanBan(String maVanBan) {
        this.maVanBan = maVanBan;
    }
    
    public String getTieuDe() {
        return tieuDe;
    }
    
    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
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
    
    public LocalDate getNgayCapNhat() {
        return ngayCapNhat;
    }
    
    public void setNgayCapNhat(LocalDate ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }
    
    public String getTenFile() {
        return tenFile;
    }
    
    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
    }
    
    public String getDuongDan() {
        return duongDan;
    }
    
    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }
    
    public String getDinhDang() {
        return dinhDang;
    }
    
    public void setDinhDang(String dinhDang) {
        this.dinhDang = dinhDang;
    }
    
    public int getSoTrang() {
        return soTrang;
    }
    
    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }
    
    public String getLoaiVanBan() {
        return loaiVanBan;
    }
    
    public void setLoaiVanBan(String loaiVanBan) {
        this.loaiVanBan = loaiVanBan;
    }
    
    public String getDonVi() {
        return donVi;
    }
    
    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }
}
