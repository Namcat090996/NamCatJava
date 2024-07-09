/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.com.stanford.j0424.tinhtoanlib;

/**
 *
 * @author dangquang16
 */
public class Common {
    
    /**
     * Hàm chuyển 1 chuỗi các số ngăn cách bằng dấu ,
     * @param strData, Chuỗi số ngăn cách các số bằng dấu ,
     * @return Mảng số nguyên
     */
    public static int[] chuyenTuChuoiVeMangSo(String strData)
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
