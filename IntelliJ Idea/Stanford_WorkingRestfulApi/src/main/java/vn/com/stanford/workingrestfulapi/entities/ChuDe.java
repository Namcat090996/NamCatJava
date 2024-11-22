package vn.com.stanford.workingrestfulapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChuDe")
public class ChuDe {
    @Id
    @Column(name="MaChuDe", nullable = false, length = 10)
    private String maChuDe;
    
    @Column(name="TenChuDe", nullable = true, length = 255)
    private String tenChuDe;
    
    public String getTenChuDe() {
        return tenChuDe;
    }
    
    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }
    
    public String getMaChuDe() {
        return maChuDe;
    }
    
    public void setMaChuDe(String maChuDe) {
        this.maChuDe = maChuDe;
    }
}
