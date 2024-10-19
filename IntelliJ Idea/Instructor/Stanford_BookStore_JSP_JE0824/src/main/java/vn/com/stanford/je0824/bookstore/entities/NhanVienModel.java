package vn.com.stanford.je0824.bookstore.entities;

public class NhanVienModel extends NhanVien {
    private String tenPhong;
    private String tenChucVu;
    private  int tongLuong;

    public int getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(int tongLuong) {
        this.tongLuong = tongLuong;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

}
