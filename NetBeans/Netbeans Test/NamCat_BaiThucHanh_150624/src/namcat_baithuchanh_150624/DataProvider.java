/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baithuchanh_150624;

/**
 *
 * @author Dell Precision 7550
 */
public class DataProvider {
    
    private static ThiSinhBusiness ThiSinhBus;
    
    public static ThiSinhBusiness getThiSinhBus()
    {
	if(ThiSinhBus == null)
	{
	    ThiSinhBus = new ThiSinhBusiness();
	}
	
	return ThiSinhBus;
    }
    
}
