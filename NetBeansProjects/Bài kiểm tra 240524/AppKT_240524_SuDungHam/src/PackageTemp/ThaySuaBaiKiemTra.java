/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackageTemp;

/**
 *
 * @author Dell Precision 7550
 */
public class ThaySuaBaiKiemTra {
      
    String data = "";
    
    int arr[];
    
    public static int[] chuyenTuChuoiVeMangSo(String data)
    {
	String strArr[] = data.split(";");
	
	int arr[] = new int[strArr.length];
	
	for(int i = 0; i < strArr.length; i++)
	{
	    arr[i] = Integer.parseInt(strArr[i]);
	}
	
	return arr;
    }
    
    public ThaySuaBaiKiemTra(String data)
    {
	this.data = data;
	this.arr = chuyenTuChuoiVeMangSo(data);
    }
    
    public String sapXepGiamDan()
    {
	int temp = 0;
	
	String strGiamDan = "";
	
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
	
	for(int i = 0; i < arr.length; i++)
	{
	    strGiamDan += arr[i] + "-";
	}
	
	strGiamDan = strGiamDan.substring(0, strGiamDan.length()-1);
	
	return strGiamDan;
    }
    
    public String top3GiaTriCaoNhat()
    {
	String strTop3 = "";
	
	for(int i = 0; i < 3; i++)
	{
	    strTop3 += arr[i] + "-";
	}
	
	strTop3 = strTop3.substring(0, strTop3.length()-1);
	
	return strTop3;
    }
    
    private int tongLe = 0;
    
    public int getTongLe()
    {
	return tongLe;
    }
    
    public String layCacSoLe()
    {
	String soLe = "";
	
	for(int i = 0; i < arr.length; i++)
	{
	    if(arr[i]%2 != 0)
	    {
		soLe += arr[i] + "-";
		tongLe += arr[i];		
	    }

	}
	
	soLe = soLe.substring(0, soLe.length()-1);
	
	return soLe;
    }
    
    public int thongKeSoLuongKiTu5()
    {
	int soLuong = 0;
	
	char arrKiTu[] = data.toCharArray();
	
	for(int i = 0; i < arr.length; i++)
	{
	    if(arrKiTu[i] == '5')
	    {
		soLuong++;
	    }
	}
	
	return soLuong;
    }
}
