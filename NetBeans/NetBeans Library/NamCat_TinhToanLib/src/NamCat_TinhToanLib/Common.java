/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NamCat_TinhToanLib;

/**
 *
 * @author Dell Precision 7550
 */
public class Common {
    
    public static int[] chuyenTuMangVeChuoiSoNguyen(String strData)
    {
	String strArr[] = strData.split(",");
	
	int arr[] = new int[strArr.length];
	
	for(int i = 0; i < strArr.length; i++)
	{
	    arr[i] = Integer.parseInt(strArr[i]);
	}
	return arr;
    }
    
}
