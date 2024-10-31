package vn.com.stanford.staffmanagement.entities;

public class NhanVienModel extends NhanVien {

    //Declare attributes
    private int tongLuong;
    private String tenPhong;
    private String tenChucVu;
    private String tuKhoa;

    //Call the getter and setter function
    public int getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(int tongLuong) {
        this.tongLuong = tongLuong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public String getTuKhoa() {
        return tuKhoa;
    }

    public void setTuKhoa(String tuKhoa) {
        this.tuKhoa = tuKhoa;
    }
}
