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
    
    private static SinhVienBusiness sinhVienBus = null;
    
    /**
     * Declare the property creating object in SinhVienBusiness class to use in everywhere
     * @return 
     */
    public static SinhVienBusiness getSinhVienBus()
    {
	if(sinhVienBus == null)
	{
	    sinhVienBus = new SinhVienBusiness();
	}
	
	return sinhVienBus;	
    }
    
    
}
