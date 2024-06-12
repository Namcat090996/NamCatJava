/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appkt_240524_cathn;

/**
 *
 * @author Dell Precision 7550
 */
public class nhapThongTin {
    
    public static int[] chuyenTuChuoiVeMangSoNguyen(String strData)
    {
	String strArr[] = strData.split(",");
	
	int arr[] = new int[strArr.length];
	
	for(int i = 0; i < strArr.length; i++)
	{
	    arr[i] = Integer.parseInt(strArr[i]);
	}	
	return arr;	
    }
    
    public static int[] sapXepGiamDan(int arr[])
    {
	int temp = 0;
	
	for(int i = 0; i < arr.length-1; i++)
	{
	    for(int j = i+1; j < arr.length; j++)
	    {
		if(arr[i] < arr[j])
		{
		    temp = arr[i];
		    arr[i] = arr[j];
		    arr[j] = temp;    
		}
	    }
	}	
	return arr;	
    }
    
    public static String hienThiSoLe(int arr[])
    {
	String strSoLe = "";
	
	for(int i = 0; i < arr.length; i++)
	{
	    if(arr[i]%2 != 0)
	    {
		strSoLe += arr[i] + "-";
	    }
	}
	return strSoLe;
    }
    
    public static int tongCacSoLe(int arr[])
    {
	int tongSo = 0;
	
	for(int i = 0; i < arr.length; i++)
	{
	    if(arr[i]%2 != 0)
	    {
		tongSo += arr[i];
	    }
	}
	return tongSo;
    }
    
    public static
    
}
