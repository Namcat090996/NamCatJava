/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_qlsinhvien_j0424;

import java.util.Date;

/**
 *
 * @author dangquang16
 */
public class SinhVien {
    
    private String maSV;
    
    private String hoTen;
    
    private String dienThoai;
    
    private String email;
    
    private String diaChi;
    
    private int gioiTinh;
        
    private Date ngaySinh;
    
    private String maKhoa;
    
    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    
    /**
     * Hàm khởi tạo không có tham số truyền vào
     */
    public SinhVien()
    {
       this.diaChi = "Hà Nội";     
    }

    /**
     * Hàm khởi tạo có 1 tham số truyền vào
     * @param diaChi 
     */
    public SinhVien(String diaChi)
    {
        this.diaChi = diaChi;
    }
    
    /**
     * Hàm khởi tạo có 5 tham số truyền vào
     * @param maSV
     * @param hoTen
     * @param dienThoai
     * @param email
     * @param diaChi 
     */
    public SinhVien(String maSV, String hoTen, String dienThoai, String email, String diaChi)
    {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.dienThoai = dienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }
    /**
     * Hàm lấy thông tin mã sv
     * @return 
     */
    public String getMaSV()
    {
        return maSV;
    }
    
    /**
     * Hàm ghi thông tin cho mã sv
     * @param maSV 
     */
    public void setMaSV(String maSV)
    {
        this.maSV = maSV;
    }
    

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
}
