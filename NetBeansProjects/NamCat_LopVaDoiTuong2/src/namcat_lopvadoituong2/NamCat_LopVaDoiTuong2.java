/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package namcat_lopvadoituong2;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell Precision 7550
 */
public class NamCat_LopVaDoiTuong2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
	
	//Declare an object in TinhToan class
	TinhToan tt = new TinhToan();
	
	tt.inThongTin();
	
	tt.inThongTin(2);
	
	tt.layTenCongTy();

	
	System.out.println("Tổng số là = " + tt.tongSo(3, 5));
	
	System.out.println("" + tt.b);
	
	System.out.println("" + tt.c);
	
	//Declare an object
	HinhTron ht = new HinhTron(3);
	
	ht.inThongTin();
	
	Scanner sc = new Scanner(System.in);
	
	double r = 0;
	
	System.out.print("Nhập r = ");
	
	r = sc.nextDouble();
	
	HinhTron ht2 = new HinhTron(r);
	
	System.out.println("Chu vi là = " + ht2.chuVi());
	
	System.out.println("Chu vi là = " + ht2.dienTich());
		    
	ht2.inThongTin();
	
	SinhVienBusiness lstSV = new SinhVienBusiness();
	
	List<SinhVien> list = lstSV.layDanhSach();
	
	for(SinhVien sv: list)
	{
	    System.out.println(sv.getDiaChi() + "\t" + sv.getHoTen());
	}
	
	
	
	
	
	
    }  
}
