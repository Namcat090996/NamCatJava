 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackageTemp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell Precision 7550
 */
public class TinhToan {
    
    /**
     * Equalize the length of two sequences
     * @param chuoiLon
     * @param chuoiBe
     * @return 
     */
    public static String canBangChuoi(String chuoiLon, String chuoiBe)
    {
	int chenhLech = chuoiLon.length() - chuoiBe.length();
	
	for(int i = 1; i <= chenhLech; i++)
	{
	    chuoiBe = "0" + chuoiBe;
	}	    

	return chuoiBe;
    }
    
    /**
     * Calculate addition of two sequences of numbers
     * @param chuoi1
     * @param chuoi2
     * @return 
     */
    public static List<Integer> tinhToanCongChuoi(String chuoi1, String chuoi2)
    {
	int soDu = 0, tongSo = 0, soChuoi1 = 0, soChuoi2 = 0;
	
	List<Integer> ketQua = new ArrayList<Integer>();
	
	for(int i = chuoi1.length()-1; i >= 0; i--)
	{
	    soChuoi1 = chuoi1.charAt(i) - '0';
	    soChuoi2 = chuoi2.charAt(i) - '0';
	    tongSo = soChuoi1 + soChuoi2 + soDu;
	    soDu = tongSo/10;
	    ketQua.add(tongSo%10);
	}
	
	if(soDu != 0)
	{
	    ketQua.add(soDu);
	}
	
	return ketQua;
	
    }           
}
