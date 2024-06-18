/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.com.stanford.j0424.tinhtoanlib;

/**
 *
 * @author dangquang16
 */
public class TinhToan {
    private static final double PI = 3.14f;
    
    /**
     * Hàm tính chu vi hình chữ nhật
     * @param chieuDai, chiều dai hcn
     * @param chieuRong, chiều rộng hcn
     * @return Chu vi HCN
     */
    public static double chuViHCN(double chieuDai, double chieuRong)
    {
        return 2*(chieuDai + chieuRong);
    }
    
    public static double dienTichHCN(double chieuDai, double chieuRong)
    {
        return chieuDai*chieuRong;
    }
    
    public static double chuViHT(double r)
    {
        return 2*PI*r;
    }
    
    public static double dienTichHT(double r)
    {
        return PI*r*r;
    }
    
    public static double dienTichHinhThang(double dayLon, double dayNho, double chieuCao)
    {
        return (chieuCao*(dayLon + dayNho))/2;
    }
    
    /**
     * Hàm tính giai thừa của 1 số ví dụ 5!
     * @param n, Giá trị cần tính
     * @return Giai thừa của 1 số tự nhiên
     */
    public static int giaiThua(int n)
    {
        long ketQua = 1;
        
        for(int i = n; i>= 1; i--)
        {
            ketQua *= i;
            
            if(ketQua >= Integer.MAX_VALUE)
            {
                return -1;
            }
        }
        
        return (int)ketQua;
    }
}
