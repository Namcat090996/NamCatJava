/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_lopvadoituong2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell Precision 7550
 */
public class SinhVien {
    
    private String maSV;
    
    private String hoTen;
    
    private String email;
    
    private String diaChi;

    public SinhVien()
    {
	this.diaChi = "Hà Nội";
    }
    
    public SinhVien(String diaChi)
    {
	this.diaChi = diaChi;
    }
    
    public String getMaSV() {
	return maSV;
    }
    
    public SinhVien(String maSV, String hoTen, String email, String diaChi)
    {
	this.maSV = maSV;
	this.hoTen = hoTen;
	this.email = email;
	this.diaChi = diaChi;
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
