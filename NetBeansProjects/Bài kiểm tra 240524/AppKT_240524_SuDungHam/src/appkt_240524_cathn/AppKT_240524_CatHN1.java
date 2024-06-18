/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appkt_240524_cathn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import NamCat_TinhToanLib2.TinhToan;

/**
 *
 * @author Dell Precision 7550
 */
public class AppKT_240524_CatHN1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	//Declare variables
	String strChuoiA = "", strChuoiB = "";
	System.out.print("Nhập chuỗi A = ");
	strChuoiA = sc.nextLine();
	System.out.print("Nhập chuỗi B = ");
	strChuoiB = sc.nextLine();

	int tongSo = 0, soNho = 0;
	
	//Equalize the lengths of 2 sequences
	if(strChuoiA.length() > strChuoiB.length())
	{
	    strChuoiB = TinhToan.canBangChuoi(strChuoiA, strChuoiB);
	}
	if(strChuoiA.length() < strChuoiB.length())
	{
	    strChuoiA = TinhToan.canBangChuoi(strChuoiB, strChuoiA);
	}
	
	//Calculate addition of two sequences of numbers
	List<Integer> ketQua = TinhToan.tinhToanCongChuoi(strChuoiA, strChuoiB);
	
	//Print results
	System.out.print("Tổng của 2 chuỗi là = ");
	
	for(int i = ketQua.size()-1; i >= 0; i--)
	{
	    System.out.print(ketQua.get(i));
	}
	System.out.println("");
    }
}
