package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "color")
public class MauSac {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "color", unique = true, nullable = false, length = 50)
    private String mauSac;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getMauSac() {
        return mauSac;
    }
    
    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
}
