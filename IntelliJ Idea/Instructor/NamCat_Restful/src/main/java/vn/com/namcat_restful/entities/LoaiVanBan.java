package vn.com.namcat_restful.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "loaivanban")
public class LoaiVanBan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "TenLoaiVanBan", nullable = false, unique = true, length = 100)
    @NotBlank(message = "Bạn phải nhập loại văn bản")
    private String tenLoaiVanban;
    
    @Column(name = "MoTa", nullable = true, length = 500)
    private String moTa;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTenLoaiVanban() {
        return tenLoaiVanban;
    }
    
    public void setTenLoaiVanban(String tenLoaiVanban) {
        this.tenLoaiVanban = tenLoaiVanban;
    }
    
    public String getMoTa() {
        return moTa;
    }
    
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
