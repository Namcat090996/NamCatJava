/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danhsachsinhvien;

/**
 *
 * @author ADMIN
 */
public class SinhVien {
    
    //Declare varibles
    private String maSV = "", hoTen = "", dienThoai = "", gioiTinh = "", email = "", diaChi = "";
    
    /**
     * Initialization function has no parameter
     */
    public SinhVien()
    {
	
    }
    
    /**
     * Initialization function has 5 parameters
     * @param maSV
     * @param hoTen
     * @param dienThoai
     * @param email
     * @param diaChi 
     */
    public SinhVien(String maSV, String hoTen, String dienThoai, String gioiTinh, String email, String diaChi)
    {
	this.maSV = maSV;
	this.hoTen = hoTen;
	this.dienThoai = dienThoai;
	this.gioiTinh = gioiTinh;
	this.email = email;
	this.diaChi = diaChi;
    }
    
    /**
     * Method of object
     * @return 
     */
    public String getMaSV()
    {
	return maSV;
    }
    
    /**
     * Method of object
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
    
    public String getGioiTinh() {
	return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
	this.gioiTinh = gioiTinh;
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
