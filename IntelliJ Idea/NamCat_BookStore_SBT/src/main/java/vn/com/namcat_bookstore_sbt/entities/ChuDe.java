package vn.com.namcat_bookstore_sbt.entities;

import jakarta.validation.constraints.NotBlank;

public class ChuDe {

    //Declare attribute
    @NotBlank(message = "Ban phai nhap ma chu de")
    private String maChuDe;
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
