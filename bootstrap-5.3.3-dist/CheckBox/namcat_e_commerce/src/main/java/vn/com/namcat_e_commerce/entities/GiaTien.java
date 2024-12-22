package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "money_range")
public class GiaTien {
    
    @Id
    @Column(name = "value", nullable = false, unique = true)
    @NotBlank(message = "Bạn phải nhập giá tiền")
    private int giaTien;
    
    public int getGiaTien() {
        return giaTien;
    }
    
    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }
}
