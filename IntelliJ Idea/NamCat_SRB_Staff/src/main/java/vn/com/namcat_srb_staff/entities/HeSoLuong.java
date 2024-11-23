package vn.com.namcat_srb_staff.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "hesoluong")
public class HeSoLuong {
    
    //Declare attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "HeSo", nullable = true)
    private float heSo;
    
    @Column(name = "PhuCap", nullable = true)
    private int phuCap;
    
    @Column(name = "MoTa", nullable = true, length = 500)
    private String moTa;
    
    //Call the getter and setter function
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public float getHeSo() {
        return heSo;
    }
    
    public void setHeSo(float heSo) {
        this.heSo = heSo;
    }
    
    public int getPhuCap() {
        return phuCap;
    }
    
    public void setPhuCap(int phuCap) {
        this.phuCap = phuCap;
    }
    
    public String getMoTa() {
        return moTa;
    }
    
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
