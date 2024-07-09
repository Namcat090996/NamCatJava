/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_lopvadoituong_j0424;

/**
 *
 * @author dangquang16
 */
public class HinhTron {
    
    private double banKinh = 0;
    
    private final double PI = 3.14;
    
   /**
    * Hàm khởi tạo có 1 đối số
    * @param banKinh 
    */
    public HinhTron(double banKinh)
    {
        this.banKinh = banKinh;
    }
    
    /**
     * 
     * @return 
     */
    public double chuVi()
    {
        return 2*PI*this.banKinh;
    }
    
    public double dienTich()
    {
        return PI * banKinh*banKinh;
    }
    
    public void inThongTin()
    {
        System.out.println("Chu vi hình tròn là: " + chuVi());
        System.out.println("Diện tích hình tròn là: " + dienTich());
    }
}
