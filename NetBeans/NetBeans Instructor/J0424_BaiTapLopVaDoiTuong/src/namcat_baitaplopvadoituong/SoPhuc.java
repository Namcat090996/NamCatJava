/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baitaplopvadoituong;

import java.util.Scanner;

/**
 *
 * @author Dell Precision 7550
 */
public class SoPhuc {
    
    private double phanThuc;
    
    private double phanAo;
    
    public double getPhanThuc() {
	return phanThuc;
    }

    public void setPhanThuc(double phanThuc) {
	this.phanThuc = phanThuc;
    }

    public double getPhanAo() {
	return phanAo;
    }

    public void setPhanAo(double phanAo) {
	this.phanAo = phanAo;
    }   
    
    /**
     * Hàm khởi tạo có 2 đối số
     * @param phanThuc
     * @param phanAo 
     */
    public SoPhuc(double phanThuc, double phanAo)
    {
	this.phanThuc = phanThuc;
	this.phanAo = phanAo;
    }
    
    public void nhapThongTin()
    {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Nhập phần thực = ");
	
	phanThuc = sc.nextDouble();
	
	System.out.print("Nhập phần ảo = ");
	
	phanAo = sc.nextDouble();
    }
    
    public void inThongTin()
    {
	System.out.printf("%.1f + %.1fi\n", phanThuc, phanAo);
    }
    
    
}
