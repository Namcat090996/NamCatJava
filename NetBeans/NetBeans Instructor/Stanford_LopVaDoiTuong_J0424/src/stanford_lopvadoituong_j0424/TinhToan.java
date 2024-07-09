/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_lopvadoituong_j0424;

/**
 *
 * @author dangquang16
 */
public class TinhToan {
    
    private int a = 10;
    
    public int b = 15;
    
    int c = 20;
    
    /**
     * Dạng 1: Hàm không có giá trị trả về và không có tham số truyền vào
     */
    public void inThongTin()
    {
        System.out.println("Hôm nay trời đẹp quá !");
        
        System.out.println("Giá trị của a = " + a);
    }
    
    /**
     * Dạng 2: Hàm không có giá trị trả về và có tham số truyền vào
     * @param n 
     */
    public void inThongTin(int n)
    {
        for(int i = 1; i<=n; i++)
        {
            System.out.println("I Love You - " + i);
        }
    }
    
    /**
     * Dạng 3: Hàm có giá trị trả về và không có tham số truyền vào
     * @return 
     */
    public String layTenCongTy()
    {
        return "Stanford - Đào tạo và phát triển công nghệ";
    }
    
    /**
     * Dạng 4: Hàm có giá trị trả về và có tham số truyền vào
     * @param a, Số thứ 1
     * @param b, Số thứ 2
     * @return Tổng hai số thực
     */
    public double tongHaiSo(double a, double b)
    {
        double tongSo = 0;
        
        tongSo = a + b;
        
        return tongSo;
    }
}
