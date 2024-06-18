/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baitapcautruc_jv01;

import java.awt.im.InputContext;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Dell Precision 7550
 */
public class NamCat_BaiTapCauTruc_Part5 {
    
    //Check whether the input value is number or not
    public static int giaTriNhap(){
	Scanner sc = new Scanner(System.in);
	int n = 0;
	boolean check = false;
	while(!check)
	{   
	    try
	    {
		n = sc.nextInt();
		check = true;
	    }
	    catch(Exception ex)
	    {
		System.out.print("Giá trị bạn đã nhập không hợp lệ. Hãy nhập lại = ");
		sc.nextLine();
	    }
	}
	return (n);
    }
    
    //Check the prime
    public static boolean CheckSoNguyenTo(int n){
	for(int i = 2; i <= Math.sqrt(n); i++)
	{
	    if(n%i == 0)
	    {
		return false;
	    }
	}
	return true;
    }
    
    //Check the sum value condition
    public static int giaTriTong(int n){
	int tong = 0;
	while(n > 0)
	{
	    tong += n%10;
	    n /= 10;
	}
	return (tong);
    }

 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
    
    //Declare an object to enter information from the keyboard
    Scanner sc = new Scanner(System.in);
    
    /*
    
    //Bài tập 1: Sử dụng for, while, do while để cho ra kết quả a, b, c, d như ảnh:
    //1a
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            System.out.print("#");
        }
        System.out.println("");
    }

    //1a
    //Declare variables
    String strA = "";
    for(int i = 0; i < 8; i++)
    {
	strA += "#";
	System.out.println(strA);
    }    
    
    //1b
    String chuoi = "";
    chuoi = "#########";
    for (int i = 9; i > 0; i--)
    {
        for (int j = chuoi.length(); j >= i; j--)
        {
        chuoi = chuoi.substring(0, j-1);
        System.out.print(chuoi);
        }
        System.out.println("");
    }

    //1b
    //Declare varibles

    for(int j = 0; j < 8; j++)
    {
	String strB = "########";
	strB = strB.substring(0, strB.length()-j);
	System.out.println(strB);
    }     
    
    //1c
    String khoangTrang = "", kq = "", chuoi = "#########";
    for (int i = 9; i > 1; i--)
    {
        for (int j = chuoi.length(); j >= i; j--)
        {
            chuoi = chuoi.substring(0, j-1);   
            khoangTrang = khoangTrang + " ";
            kq = khoangTrang + chuoi;
            System.out.print(kq);
        }
        System.out.println("");
    }  
    
    //1c
    //Declare variables
    String strA = "", strC = "########";
    System.out.println("" + strC);
    for(int i = 0; i < 7; i++)
    {
	String strB = "#######";
	strB = strB.substring(0, strB.length()-i);
	strA += " ";
	System.out.println(strA + strB);	    	
    }    

    //1d
    String khoangTrang = "         ", kq = "", chuoi = "";
    for (int i = 9; i > 1; i--)
    {
        for (int j = khoangTrang.length(); j >= i; j--)
        {
            khoangTrang = khoangTrang.substring(0, j-1);   
            chuoi = chuoi + "#";
            kq = khoangTrang + chuoi;
            System.out.print(kq);
        }
        System.out.println("");
    }   
    
    //1d
    //Declare variables
    String strB = "";
    for(int i = 0; i < 8; i++)
    {
	String strA = "       ";
	strA = strA.substring(0, strA.length()-i);
	strB += "#";
	System.out.println(strA + strB);
    }   
 
    //Bài tập 4:
    System.out.print("Nhập giá trị tổng S = ");
    int S = giaTriNhap();
    int count = 0;
    System.out.println("Các số nguyên tố có tổng bằng " + S + " là: ");
    for(int i = 10000; i <= 99999; i++)
    {
	if(CheckSoNguyenTo(i))
	{
	    if(giaTriTong(i) == S)
	    {
		System.out.println(i);
		count++;
	    }
	}
    }
    System.out.println("Có " + count + " số thỏa mãn điều kiện.");

    //Bài tập 6: Viết chương trình tính n! với n là số tự nhiên không âm nhập vào từ bàn phím. Trong đó: 0! = 1, n! = 1.2.3…n
    System.out.print("Nhập giá trị n = ");
    int n = giaTriNhap(), a = 1;
    
    //Computational processing
    if (n >= 0) {
	    for (int i = 1; i <= n; i++) {
		a *= i;
	    }
	} else {
	    System.out.println("Bạn phải nhập lại số tự nhiên n phù hợp");
	    return;
	}
    
    //Print results
    System.out.println("Kết quả của " + n + "! là = " + a);
    
    //Bài tập 7: Viết chương trình kiểm tra mật khẩu người dùng khi đăng nhập. Người dùng phải đăng nhập khi đến khi nào đúng username và password thì thôi. (username và password được định nghĩa trước trong chương trình).
    
    //Declare variables
    String username = "", password = "";
    boolean check = false;
    
    //Take user information and use Try - Catch to catch the error

    while(!check)
    {
	System.out.print("Nhập username: ");
	username = sc.next();
	System.out.print("Nhập password: ");
	password = sc.next();	
	if(username.equals("admin") && password.equals("123"))
	{
	    System.out.print("Đăng nhập thành công ");
	    check = true;		
	}	
	else
	{
	    System.out.println("Đăng nhập thất bại. Vui lòng nhập lại username và password");
	    sc.nextLine();
	    check = false;
	}
    }	
    
    */
  
   
  }
}
