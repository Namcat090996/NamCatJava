package vn.com.namcat_bookstore_sbt.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "ChuDe")
public class ChuDe {

    //Declare attribute
    @Id
    @Column(name = "MaChuDe", nullable = false, length = 10)
    @NotBlank(message = "Ban phai nhap ma chu de")
    private String maChuDe;

    @Column(name = "TenChuDe", nullable = true, length = 255)
    @NotEmpty(message = "Ban phai nhap ten chu de")
    private String tenChuDe;

    //Call getter and setter function
    public String getMaChuDe() {
        return maChuDe;
    }

    public void setMaChuDe(String maChuDe) {
        this.maChuDe = maChuDe;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }
}
