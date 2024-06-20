/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j0424_kethuavadahinh;

/**
 *
 * @author Dell Precision 7550
 */
public class HinhChuNhat extends Hinh {
    
    private double chieuDai = 0;
    
    private double chieuRong = 0;

    public double getChieuDai() {
	return chieuDai;
    }

    public void setChieuDai(double chieuDai) {
	this.chieuDai = chieuDai;
    }

    public double getChieuRong() {
	return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
	this.chieuRong = chieuRong;
    }

    @Override
    public double chuVi() {
	return 2*(chieuDai+chieuRong);
    }

    @Override
    public double dienTich() {
	return chieuDai * chieuRong;
    }
    
    
    
    
    
}
