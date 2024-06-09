/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danhsachsinhvien;

/**
 *
 * @author ADMIN
 */
public class DataProvider {
    
    private static SinhVienBusiness SinhVienBus;
    
    public static SinhVienBusiness getSinhVienBus()
    {
	if(SinhVienBus == null)
	{
	    SinhVienBus = new SinhVienBusiness();
	}
	return SinhVienBus;
    }
    
    
    
    
}
