/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_lopvadoituong2;

/**
 *
 * @author Dell Precision 7550
 */
public class HinhTron {
    
    //Declare variables
    private double banKinh = 0;
    
    private final double PI = 3.14;
    
    //Initialization function
    public HinhTron(double banKinh)
    {
	this.banKinh = banKinh;
    }
    
    public double chuVi()
    {
	return 2*PI*this.banKinh;
    }
    
    public double dienTich()
    {
	return PI*this.banKinh*this.banKinh;
    }    
    
    public void inThongTin()
    {
	System.out.println("Chu vi là = " + chuVi());
	System.out.println("Diện tích là = " + dienTich());
    }
    
}
