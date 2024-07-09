/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baitapcautruc_jv01;

import java.util.HexFormat;
import java.util.Scanner;

/**
 *
 * @author Dell Precision 7550
 */
public class NamCat_BaiTapCauTruc_Part2 {

 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
    
    //Declare an object to enter information from the keyboard
    Scanner sc = new Scanner(System.in);
    
    /*
    
    //Bài tập 1: Viết chương trình nhập vào một số thực. Đơn vị tính cho số này là centimet (cm). Hãy in ra số tương đương tính bằng foot (số thực, có 2 số lẻ thập phân) và inch (số thực, có 2 số lẻ thập phân:
    //Declare variables	
    double cm = 0, inch = 0, foot = 0;
	
    //Take user information entered from the keyboard
    System.out.print("Nhập số thực (cm) = ");	
    cm = sc.nextDouble();
    
    //Computational processing
    inch = cm/2.54;
    foot = inch/12;
	
    //Print results
    System.out.printf("Số tương đương đơn vị inch là: %.2f (inch)\n", inch);		
    System.out.printf("Số tương đương đơn vị foot là: %.2f (foot)\n", foot);
    
    //Bài tập 2: Viết chương trình nhập vào 1 số nguyên, hiển thị số đó dưới hệ 8 và hệ 16:
    //Declare variables
    int soNguyen = 0;
    String heSo8 = "", heSo16 = "";
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số nguyên = ");	
    soNguyen = sc.nextInt();
    
    //Computational processing
    heSo8 = Integer.toString(soNguyen, 8);
    heSo16 = Integer.toString(soNguyen, 16);
    
    //Print results
    System.out.println("Hệ 8 của số nguyên là: " + heSo8);
    System.out.println("Hệ 16 của số nguyên là: " + heSo16);
    
    //Bài tập 3: Viết chương trình nhập vào số giây từ 0 tới 68399, đổi số giây này thành dạng [giờ:phút:giây], mỗi thành phần là một số nguyên có 2 chữ số.
    //Declare variables
    int giay = 0, phut = 0, gio = 0, temp = 0;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số giây = ");	
    giay = sc.nextInt();
    
    //Computational processing
    if(giay >= 0 && giay <= 68399)
    {
	gio = giay/3600;
	temp = giay%3600;
	phut = temp/60;
	giay = temp%60;
	if(gio < 10)
	{
	    System.out.print("0"); 
	}
	System.out.print(gio + ":");
	if(phut < 10)
	{
	    System.out.print("0");
	}
	System.out.print(phut + ":");
	if(giay < 10)
	{
	    System.out.print("0");
	}
	System.out.print(giay);
    }
    else
    {
	System.out.println("Bạn cần phải nhập số giây thỏa mãn điều kiện 0<= số giây <= 68399");
    }
	    
    //Bài tập 4: Viết chương trình nhập vào 4 số nguyên, Hiển thị ra số lớn nhất và nhỏ nhất. Ví dụ: nhập vào 4 số 1,2,3,4 thì kết quả là: Số lớn nhất là: 4 - Số nhỏ nhất là: 1:
    //Declare variables
    int so1 = 0, so2 = 0, so3 = 0, so4 = 0, max = 0, min = 0;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số nguyên thứ 1 = ");
    so1 = sc.nextInt();
    System.out.print("Nhập số nguyên thứ 2 = ");
    so2 = sc.nextInt();
    System.out.print("Nhập số nguyên thứ 3 = ");
    so3 = sc.nextInt();    
    System.out.print("Nhập số nguyên thứ 4 = ");
    so4 = sc.nextInt();  
    
    //Computational processing
    max = so1;
    min = so1;
    if(so2 > max)
    {
	max = so2;
    }
    if(so3 > max)
    {
	max = so3;
    }
    if(so4 > max)
    {
	max = so4;
    }
    if(so2 < min)
    {
	min = so2;
    }
    if(so3 < min)
    {
	min = so3;
    }
    if(so4 < min)
    {
	min = so4;
    }
    
    //Print results
    System.out.printf("Số lớn nhất là = %d\n", max);
    System.out.printf("Số nhỏ nhất là = %d\n", min);
    
    //Bài tập 5:  Nhập vào hai số tự nhiên a và b. Tính hiệu của hai số đó. Nếu hiệu số nhỏ hơn 0 thì in ra dòng chữ [Số thứ nhất bé hơn số thứ hai]. Nếu hiệu số lớn hơn 0 thì in ra dòng chữ [số thứ nhất nhỏ hơn số thứ hai]:
    //Declare variables
    double a = 0, b = 0, hieu = 0;
        
    //Take user information entered from the keyboard
    System.out.print("Nhập số tự nhiên a = ");
    a = sc.nextDouble();
    System.out.print("Nhập số tự nhiên b = ");
    b = sc.nextDouble();
        
    //Computational processing
    hieu = a - b;
    System.out.println("Hiệu của a và b là = " + hieu);

    if(hieu < 0)
    {
        System.out.println("Số thứ nhất nhỏ hơn số thứ hai");
    }
    else
    {
        System.out.println("Số thứ nhất lớn hơn số thứ hai");
    }    
    
    //Bài tập 6: 
    //Declare variables
    int a = 0, b = 0, thuong = 0;
        
    //Take user information entered from the keyboard
    System.out.print("Nhập số tự nhiên a = ");
    a = sc.nextInt();
    System.out.print("Nhập số tự nhiên b = ");
    b = sc.nextInt();
        
    //Computational processing
    thuong = a / b;
    System.out.println("Thương của a và b là = " + thuong); 
        
    if(thuong%2 == 0)
    {
        System.out.println("Số tự nhiên a chia hết cho b");
    }
    else
    {
        System.out.println("Số tự nhiên a không chia hết cho b");
    }    
    
    //Bài tập 7: 
    //Declare variables
    double diemToan = 0, diemLy = 0, diemHoa = 0, diemTrungBinh = 0;
	    
    //Take user information entered from the keyboard
    System.out.print("Nhập điểm Toán = ");
    diemToan = sc.nextDouble();
    System.out.print("Nhập điểm Lý = ");
    diemLy = sc.nextDouble();
    System.out.print("Nhập điểm Hóa = ");
    diemHoa = sc.nextDouble();
    
    //Computational processing
    //7b
    diemTrungBinh = ((diemToan)*2 + diemLy + diemHoa)/4;
    System.out.printf("Điểm trung bình là = %.2f\n", diemTrungBinh);
    
    //7d
    if(diemTrungBinh >= 9.0)
    {
	System.out.println("Loại xuất sắc");
    }
    if (8.0 <= diemTrungBinh && diemTrungBinh < 9.0)
    {
	System.out.println("Loại giỏi");
    }
    if (7.0 <= diemTrungBinh && diemTrungBinh < 8.0)
    {
	System.out.println("Loại khá");
    }
    if (6.0 <= diemTrungBinh && diemTrungBinh < 7.0)
    {
	System.out.println("Loại trung bình khá");
    }
    if (5.0 <= diemTrungBinh && diemTrungBinh < 6.0)
    {
	System.out.println("Loại trung bình");
    }
    if (5.0 > diemTrungBinh)
    {
	System.out.println("Loại kém");
    }
    
    */
    
    //Bài tập 8: Hãy sử dụng kiến thức đã được học về Java để giải phương trình bậc 2 có dạng ax2 + bx + c = 0 (a # 0).
    //Declare variables
    double a = 0, b = 0, c = 0, x1 = 0, x2 = 0, delta = 0;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số a = ");
    a = sc.nextDouble();
    System.out.print("Nhập số b = ");
    b = sc.nextDouble();
    System.out.print("Nhập số c = ");
    c = sc.nextDouble();
    
    //Computational processing
    if(a != 0)
    {
	delta = Math.pow(b, 2)-(4*a*c);
	if(delta > 0)
	{
	    x1 = (-b + Math.sqrt(delta))/(2*a);
	    x2 = (-b - Math.sqrt(delta))/(2*a);
	    System.out.printf("Phương trình bậc 2 có 2 nghiệm x1 = %.2f và x2 =%.2f", x1, x2);
	}
	if(delta == 0)
	{
	    x1 = x2 = -b/(2*a);
	    System.out.printf("Phương trình bậc 2 có nghiệm kép x1 = x2 =%.2f/n", x1);
	}
	if(delta < 0)
	{
	    System.out.println("Phương trình vô nghiệm");
	}
    }
    else 
    {
	System.out.println("Bạn phải nhập lại số a khác 0");
    }
    
    
  }  
}
