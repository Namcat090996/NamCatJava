/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j0424_kethuavadahinh;

/**
 *
 * @author Dell Precision 7550
 */
public class HinhTron extends Hinh {
    
    private double banKinh = 0;
    private final double PI = 3.14f;

    public double getBanKinh() {
	return banKinh;
    }

    public void setBanKinh(double banKinh) {
	this.banKinh = banKinh;
    }

    @Override
    public double chuVi() {
	return 2*PI*banKinh;
    }

    @Override
    public double dienTich() {
	return PI*Math.pow(banKinh, 2);
    }
    
    
    
    
}
