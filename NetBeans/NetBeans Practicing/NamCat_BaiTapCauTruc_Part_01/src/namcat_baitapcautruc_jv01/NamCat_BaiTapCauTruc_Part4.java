/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baitapcautruc_jv01;

import java.util.Scanner;

/**
 *
 * @author Dell Precision 7550
 */
public class NamCat_BaiTapCauTruc_Part4 {

 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
    
    //Declare an object to enter information from the keyboard
    Scanner sc = new Scanner(System.in);
    
    /*
    
    //Bài tập 1: Nhập một kí tự. Cho biết kí tự đó có phải là chữ cái hay không:
    //Declare variables
    char kiTu;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập kí tự: ");
    kiTu = sc.next().charAt(0);
    
    //Print results
    if(Character.isAlphabetic(kiTu))
    {
	System.out.println("Bạn đã nhập kí tự là chữ cái");
    }
    else
    {
	System.out.println("Bạn đã nhập kí tự không phải là chữ cái");
    }

    //Bài tập 2a: Tính giá trị hàm:
    //Declare variables
    double x = 0, fx = 0;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số x = ");
    x = sc.nextDouble();
    
    //Computational processing
    if(x > 0)
    {
	fx = 3*x + Math.sqrt(x);
	System.out.printf("Giá trị của hàm là = %.2f\n", fx);
    }
    else
    {
	fx = Math.pow((Math.E),x) + 4;
	System.out.printf("Giá trị của hàm là = %.2f\n", fx);
    }
        
    //Bài tập 2b: Tính giá trị hàm:
    //Declare variables
    double x = 0, fx = 0;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số x = ");
    x = sc.nextDouble();
    
    //Computational processing
    if(x >= 1)
    {
    fx = x*x + 1;
    fx = Math.sqrt(fx);
    System.out.printf("Giá trị của hàm là = %.2f\n", fx);
    }
    if(-1 < x && x < 1)
    {
    fx = 3*x + 5;
    System.out.printf("Giá trị của hàm là = %.2f\n", fx);
    }
    if(x <= -1)
    {
	fx = x*x + 2*x + 1;
	System.out.printf("Giá trị của hàm là = %.2f\n", fx);
    }    
        
    //Bài tập 3: Nhập vào tuổi cha và tuổi con hiện nay sao cho tuổi cha lớn hơn 2 lần tuổi con. Tìm xem bao nhiêu năm nữa tuổi cha sẽ bằng đúng 2 lần tuổi con (ví dụ 30 và 12, sau 6 năm nữa tuổi cha là 36 gấp đôi tuổi con là 18).
    
    //Declare variables
    int tuoiCon = 0, tuoiCha = 0, soNam = 0;
    
    //Computational processing
    do
    {
	System.out.print("Nhập số tuổi cha = ");
	tuoiCha = sc.nextInt();
	System.out.print("Nhập số tuổi con = ");
	tuoiCon = sc.nextInt();
    }
    while(tuoiCha <= 2*tuoiCon);
    
    soNam = tuoiCha - 2*tuoiCon;
    tuoiCha += soNam;
    tuoiCon += soNam;
    
    System.out.println("Số năm mà tuổi cha gấp 2 lần tuổi con là = " + soNam);
    System.out.printf("Tuổi cha = %d\n", tuoiCha);
    System.out.printf("Tuổi con = %d\n", tuoiCon);
    
    //Bài tập 3: Nhập vào tuổi cha và tuổi con hiện nay sao cho tuổi cha lớn hơn 2 lần tuổi con. Tìm xem bao nhiêu năm nữa tuổi cha sẽ bằng đúng 2 lần tuổi con (ví dụ 30 và 12, sau 6 năm nữa tuổi cha là 36 gấp đôi tuổi con là 18).
    //Declare variables
    int tuoiCha = 0, tuoiCon = 0;
    
    for(int soNam = 0; soNam >= 0; soNam++)
    {	
	System.out.print("Nhập tuổi cha = ");
	tuoiCha = sc.nextInt();
	System.out.print("Nhập tuổi con = ");
	tuoiCon = sc.nextInt();
	if(tuoiCha > 2*tuoiCon)
	{
	    soNam = tuoiCha - 2*tuoiCon;
	    tuoiCha += soNam;
	    tuoiCon += soNam;
	    System.out.println("Số năm mà tuổi cha gấp 2 lần tuổi con = " + soNam);
	    System.out.println("Số tuổi cha = " + tuoiCha);
	    System.out.println("Số tuổi con = " + tuoiCon);
	    break;
	}
	else
	{
	    System.err.println("Bạn cần phải nhập tuổi cha và tuổi con phù hợp với yêu cầu đề bài");
	}
    }
    
    //Bài tập 4: Nhập số nguyên dương N. Tính:
    //Declare variables
    int N = 0;
    double S1 = 0, S2 = 0;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số nguyên N = ");
    N = sc.nextInt();
    
    //Use loop for computing
    for(int i = 1; i <= N; i++)
    {
	S1 = S1 + i;
	S2 += Math.pow(i,2);
    }
	
    S1 = S1/N;
    S2 = Math.sqrt(S2);
    
    //Print results
    System.out.printf("Giá trị của S1 = %.2f\n", S1);
    System.out.printf("Giá trị của S2 = %.2f\n", S2); 
    
    //Bài 5: In ra màn hình các số có 2 chữ số sao cho tích của 2 chữ số này bằng 2 lần tổng của 2 chữ số đó (ví dụ số 36 có tích 3*6 = 18 gấp 2 lần tổng của nó là 3 + 6 = 9).
    
    //Declare variables
    int chuc = 0, donVi = 0, tich = 0, tong = 0;
    
    System.out.println("Các số có 2 chữ số thỏa mãn điều kiện đề bài là = ");
    
    //Use loop for computing
    for(int i = 10; i <= 99; i++)
    {
	chuc = i/10;
	donVi = i%10;
	tong = chuc+donVi;
	tich = chuc*donVi;
	if(tich == 2*tong)
	{
	    System.out.println(i);
	}
    }
    
    //Bài tập 6: Tìm số nguyên dương n lớn nhất thoả mãn điều kiện:
    //Method 1
    //Declare variables
    double S1 = 0, S2 = 0;
    
    //Use For 
    //Computational processing and Print results
    for(int i = 1; i > 0; i++)
    {
	S1 += 1/(2.0*i-1);
	if(S1 < 2.101999)
	{
	    System.out.printf("Giá trị N1 thỏa mãn điều kiện là = %d\n", i);
	}
	else
	{
	    break;
	}
    }
    System.out.println("\n");
    
    for (int x = 1; x > 0; x++)
    {
	S2 = Math.exp(x) - (1999*Math.log10(x));
	if(S2 < 2000)
	{
	    System.out.printf("Giá trị N2 thỏa mãn điều kiện là = %d\n", x);
	}
	else
	{
	    break;
	}
    }
    
    */
    
    //Use do ... while
    //Declare variables
    int N = 0;
    double S1 = 0, S2 = 0;
    
    //Computational processing and Print results (6a)
    do
    {
	N++;
	S1 += 1/(2.0*N-1);
    }
    while(S1 < 2.1099999);
    
    System.out.printf("Giá trị N thỏa mãn điều kiện là = %d\n", N-1);
    
    //Computational processing and Print results (6b)
    N = 0;
    do
    {
	N++;
	S2 = Math.pow(Math.E, N) - 1999*Math.log10(N);
    }
    while(S2 < 2000);
    
    System.out.printf("Giá trị N thỏa mãn điều kiện là = %d\n", N-1);
    
    System.out.println("");
    
  }  
}
