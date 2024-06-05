/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_lopvadoituong;

/**
 *
 * @author Dell Precision 7550
 */
public class SinhVien {
    
    private String maSV;
    
    private String hoTen;
    
    private String dienThoai;
    
    private String email;
    
    private String diaChi;
    
    /**
     * 
     */
    public SinhVien()
    {
	this.diaChi = "";
    }
    /**
     * 
     * @param diaChi 
     */
    public SinhVien(String diaChi)
    {
	this.diaChi = diaChi;
    }
    
    public SinhVien(String maSV, String hoTen, String dienThoai, String email, String diaChi)
    {
	this.maSV = maSV;
        this.hoTen = hoTen;
        this.dienThoai = dienThoai;
        this.email = email;
        this.diaChi = diaChi;	
    }
    
    public String getMaSV() {
	return maSV;
    }

    public void setMaSV(String maSV) {
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
