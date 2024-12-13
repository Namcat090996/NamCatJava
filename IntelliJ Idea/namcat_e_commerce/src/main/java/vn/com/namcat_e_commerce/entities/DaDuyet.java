package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "approved")
public class DaDuyet {
    
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "approved", nullable = false, unique = true, length = 45)
    private String daDuyetName;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDaDuyetName() {
        return daDuyetName;
    }
    
    public void setDaDuyetName(String daDuyetName) {
        this.daDuyetName = daDuyetName;
    }
}
