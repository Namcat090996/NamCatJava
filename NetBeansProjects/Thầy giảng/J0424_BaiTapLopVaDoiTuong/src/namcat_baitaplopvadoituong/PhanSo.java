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
public class PhanSo {
    
    private int tuSo;
    
    private int mauSo;
    
    public int getTuSo() {
	return tuSo;
    }

    public void setTuSo(int tuSo) {
	this.tuSo = tuSo;
    }

    public int getMauSo() {
	return mauSo;
    }

    public void setMauSo(int mauSo) {
	this.mauSo = mauSo;
    }
    
    public void nhapThongTin()
    {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Nhập tử số = ");
	tuSo = sc.nextInt();
	
	System.out.print("Nhập mẫu số = ");
	mauSo = sc.nextInt();
    }
    
    public void inThongTin()
    {
	System.out.printf("%d/%d\n", tuSo, mauSo);
    }
}
