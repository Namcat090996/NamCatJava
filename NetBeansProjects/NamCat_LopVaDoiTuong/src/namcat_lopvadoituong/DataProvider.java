/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_lopvadoituong;

/**
 *
 * @author Dell Precision 7550
 */
public class DataProvider {
    
    private static SinhVienBusiness SinhVienBus = null;
    
    public static SinhVienBusiness getSinhVienBus()
    {
	if(SinhVienBus == null)
	{
	    SinhVienBus = new SinhVienBusiness();
	}
	return SinhVienBus;
    }
    
    
}
