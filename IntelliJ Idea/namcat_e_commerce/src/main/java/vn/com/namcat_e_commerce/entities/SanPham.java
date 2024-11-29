package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Table
@Entity(name = "product")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "name", nullable = false, length = 255)
    @NotBlank(message = "Bạn phải nhập tên sản phẩm")
    private String tenSanPham;
    
    @Column(name = "price", nullable = false)
    @NotBlank(message = "Bạn phải nhập giá sản phẩm")
    @Digits(integer = 10, fraction = 0, message = "Giá sản phẩm phải là số nguyên dương")
    @Min(value = 1, message = "Giá sản phẩm phải là số nguyên dương")
    private double giaSanPham;
    
    @Column(name = "stock", nullable = false)
    @NotBlank(message = "Bạn phải nhập số lượng hàng còn lại trong kho")
    @Digits(integer = 10, fraction = 0, message = "Số lượng hàng trong kho phải là số nguyên dương")
    @Min(value = 1, message = "Số lượng hàng trong kho phải là số nguyên dương")
    private int tonKho;
    
    @Column(name = "category", nullable = false, length = 20)
    @NotEmpty(message = "Bạn phải chọn loại sản phẩm")
    private String loaiSanPham;
    
    @Column(name = "image", nullable = true, length = 255)
    private String anhSanPham;
    
    @Column(name = "description", nullable = true, length = 1000)
    private String moTa;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTenSanPham() {
        return tenSanPham;
    }
    
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    
    public double getGiaSanPham() {
        return giaSanPham;
    }
    
    public void setGiaSanPham(double giaSanPham) {
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
}
