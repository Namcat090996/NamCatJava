package vn.com.stanford_workingapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ChuDe")
public class ChuDe {
    
    @Id
    @Column(name="MaChuDe", nullable = false, length = 10)
    @NotBlank(message = "Ban phai nhap ma chu de")
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
