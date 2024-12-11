package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "money_range")
public class KhoangTien {
    
    @Id
    @Column(name = "value", nullable = false, unique = true)
    private int giaTri;
    
    public int getGiaTri() {
        return giaTri;
    }
    
    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }
}
