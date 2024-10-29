package vn.com.stanford.je0824.bookstore.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ChuDe {

    @NotBlank(message = "Bạn phải nhập mã chủ để")
    private String maChuDe;

    @NotEmpty(message = "Bạn phải nhập tên chủ đề")
    private String tenChuDe;

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
