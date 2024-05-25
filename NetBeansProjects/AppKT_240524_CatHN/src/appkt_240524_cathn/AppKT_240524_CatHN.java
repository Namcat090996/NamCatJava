/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appkt_240524_cathn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell Precision 7550
 */
public class AppKT_240524_CatHN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
	Scanner sc = new Scanner(System.in);
	
	//Khai báo biến
	int tongSo = 0, soNho = 0;
	int x = 0;
	
	//Khai báo chuỗi
	String stra = "", strb = "";
	System.out.print("Nhập chuỗi a = ");
	stra = sc.next();
	System.out.print("Nhập chuỗi b = ");
	strb = sc.next();

	//Khai báo mảng
	String arra[] = stra.split("");
	String arrb[] = strb.split("");
	
	int ketQua[] = new int[arra.length];
	int soa[] = new int[arra.length];
	int sob[] = new int[arrb.length];
	
	//Chuyển mảng về dạng Double
	for(int i = arra.length-1; i >= 0; i--)
	{
	    int j = arrb.length-1;
	    if(j >= 0)
	    {
	    sob[j] = Integer.parseInt(arrb[j]);		
	    }
	    soa[i] = Integer.parseInt(arra[i]);
	    tongSo = soa[i] + sob[j] + soNho;
	    soNho = tongSo/10;
	    ketQua[x] = (tongSo%10);
	    x++;
	    j--;
	}
	
	System.out.print("Tổng của 2 chuỗi là = ");
	
	for(int i = ketQua.length-1; i >= 0; i--)
	{
	    System.out.print(ketQua[i]);
	}
	System.out.println("");
	
	
	
	
    }
    
}
