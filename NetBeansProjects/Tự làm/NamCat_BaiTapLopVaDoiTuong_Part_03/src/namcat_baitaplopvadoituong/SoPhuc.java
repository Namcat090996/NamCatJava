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
    
    private double phanThuc = 0;
    
    private double phanAo = 0;
    
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
     * Initialization function has 02 arguments
     * @param phanThuc
     * @param phanAo 
    */
    public SoPhuc(double phanThuc, double phanAo)
    {
	this.phanThuc = phanThuc;
	this.phanAo = phanAo;
    }
    
    /**
     * Method to enter the information from the keyboard
    */
    public void nhapSoPhuc()
    {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Nhập phần thực: ");
	
	this.phanThuc = sc.nextDouble();
	
	System.out.print("Nhập phần ảo: ");
	
	this.phanAo = sc.nextDouble();	
    }
    
    public void inSoPhuc()
    {
	System.out.printf("%.1f + %.1fi\n",phanThuc, phanAo);
    }
   
}


