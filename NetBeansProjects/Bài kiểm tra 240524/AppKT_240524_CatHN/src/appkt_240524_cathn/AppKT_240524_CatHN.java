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
	
	Scanner sc = new Scanner(System.in);
	
	//Khai báo chuỗi
	String strChuoiA = "", strChuoiB = "";
	System.out.print("Nhập chuỗi A = ");
	strChuoiA = sc.nextLine();
	System.out.print("Nhập chuỗi B = ");
	strChuoiB = sc.nextLine();

	//Khai báo biến
	int chenhLech = 0, tongSo = 0, soNho = 0;
	
	//Cân bằng độ dài 2 chuỗi
	if(strChuoiA.length() > strChuoiB.length())
	{
	    chenhLech = strChuoiA.length() - strChuoiB.length();
	    for(int i = 1; i <= chenhLech; i++)
	    {
		strChuoiB = "0" + strChuoiB;
	    }
	}
	else
	{
	    chenhLech = strChuoiB.length() - strChuoiA.length();
	    for(int i = 1; i <= chenhLech; i++)
	    {
		strChuoiA = "0" + strChuoiA;
	    }
	}

	//Chuyển chuỗi thành mảng chuỗi
	String arrA[] = strChuoiA.split("");
	String arrB[] = strChuoiB.split("");
	
	//Khai báo chuỗi và list số nguyên
	int arrA1[] = new int[arrA.length];
	int arrB1[] = new int[arrB.length];
	List<Integer> ketQua = new ArrayList<Integer>();
	
	//Chuyển mảng chuỗi thành mảng số nguyên
	for(int i = 0; i < arrA.length; i++)
	{
	    arrA1[i] = Integer.parseInt(arrA[i]);
	}

	for(int i = 0; i < arrB.length; i++)
	{
	    arrB1[i] = Integer.parseInt(arrB[i]);
	}	
	
	//Xử lý tính toán cộng chuỗi
	for(int i = arrA.length-1; i >= 0; i--)
	{
	    tongSo = arrA1[i] + arrB1[i] + soNho;
	    soNho = tongSo/10;
	    ketQua.add(tongSo%10);
	}
	
	if(soNho != 0)
	{
	    ketQua.add(soNho);
	}
	
	System.out.print("Tổng của 2 chuỗi là = ");
	for(int i = ketQua.size()-1; i >= 0; i--)
	{
	    System.out.print(ketQua.get(i));
	}
	System.out.println("");

	/*
	// TODO code application logic here
	Scanner sc = new Scanner(System.in);
	
	//Khai báo biến
	int tongSo = 0, soNho = 0, chenhLech = 0, n = 0;
	int x = 0;
	
	//Khai báo chuỗi
	String stra = "", strb = "";
	System.out.print("Nhập chuỗi a = ");
	stra = sc.next();
	System.out.print("Nhập chuỗi b = ");
	strb = sc.next();
	
	//So sánh độ dài 2 chuỗi để làm cho cân bằng
	if(stra.length() > strb.length())
	{
	    chenhLech = stra.length() - strb.length();
	    for(int i = 1; i <= chenhLech; i++)
	    {
		strb = "0" + strb;
	    }	    
	}
	
	if(strb.length() > stra.length())
	{
	    int ketQua[] = new int[strb.length()+1];
	    chenhLech = strb.length() - stra.length();
	    for(int i = 1; i <= chenhLech; i++)
	    {
		stra = "0" + stra;
	    }	    
	}	

	//Khai báo mảng
	String arra[] = stra.split("");
	String arrb[] = strb.split("");
	int ketQuaCuoi[] = new int[stra.length()];
	
	int ketQua[] = new int[stra.length()+1];
	int soa[] = new int[arra.length];
	int sob[] = new int[arrb.length];
	
	//Chuyển mảng String về dạng Double
	for(int i = arra.length-1; i >= 0; i--)
	{
	    soa[i] = Integer.parseInt(arra[i]);
	    sob[i] = Integer.parseInt(arrb[i]);
	    tongSo = soa[i] + sob[i] + soNho;
	    soNho = tongSo/10;
	    ketQua[x] = (tongSo%10);
	    x++;	    
	}
	
	if(soNho != 0)
	{
	    ketQua[x] = soNho;
	}
	System.out.print("Tổng của 2 chuỗi là = ");
	
	//Loại trừ số 0 đứng đầu kết quả
	if(ketQua[ketQua.length-1] == 0)
	{
	    for(int i = 0; i < ketQua.length()-1; i++)
	    {
		ketQuaCuoi[i] = ketQua[i];
	    }
	
	    for(int i = ketQuaCuoi.length-1; i >= 0; i--)
	    {
		System.out.print(ketQuaCuoi[i]);
	    }
	    
	    System.out.println("");	    
	}
	else
	{
	    for(int i = ketQua.length-1; i >= 0; i--)
	    {
		System.out.print(ketQua[i]);
	    }
	    
	    System.out.println("");	    
	}
	    
	*/

	
    }
    
}
