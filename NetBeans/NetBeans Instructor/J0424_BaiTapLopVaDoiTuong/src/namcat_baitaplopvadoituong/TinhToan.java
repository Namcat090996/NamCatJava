/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baitaplopvadoituong;

/**
 *
 * @author Dell Precision 7550
 */
public class TinhToan {
    
    private static final double PI = 3.14;
    
    /**
     * Function to calculate the perimeter of rectangle
     * @param chieuDai
     * @param chieuRong
     * @return 
     */
    public static double chuViHCN(double chieuDai, double chieuRong)
    {
	return 2*(chieuDai + chieuRong);
    }
    
    /**
     * Function to calculate the area of rectangle
     * @param chieuDai
     * @param chieuRong
     * @return 
     */
    public static double dienTichHCN(double chieuDai, double chieuRong)
    {
	return chieuDai*chieuRong;
    }
    
    /**
     * Function to calculate the circumference of circle
     * @param r
     * @return 
     */
    public static double chuViHinhTron(double r)
    {
	return 2*r*PI ;
    }
    
    /**
     * Function to calculate the area of circle
     * @param r
     * @return 
     */
    public static double dienTichHinhTron(double r)
    {
	return r*r*PI;
    }
    
    public static double dienTichHinhThang(double dayLon, double dayNho, double chieuCao)
    {
	return (chieuCao*(dayLon + dayNho))/2;
    }
    
    /**
     * Function to calculate the factorial value
     * @param n
     * @return 
     */
    public static int giaiThua(int n)
    {
	int ketQua = 1;
	
	for(int i = n; i >= 1; i--)
	{
	    ketQua *= i;
	    
	}
	return (int)ketQua;
    }
    
}
