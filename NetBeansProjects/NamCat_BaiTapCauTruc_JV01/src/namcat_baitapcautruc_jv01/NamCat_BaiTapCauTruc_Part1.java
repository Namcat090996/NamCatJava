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
public class NamCat_BaiTapCauTruc_Part1 {

 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
    
    //Declare an object to enter information from the keyboard
    Scanner sc = new Scanner(System.in);
    
    /*
    
    //Bài tập 1: Viết câu lệnh khai báo biến để lưu các giá trị sau:   
    //Declare variables
    //Tuổi của một người
    int tuoiNguoi = 30; 
    //Độ dài cạnh một tam giác
    double canhTamGiac = 3.2; 
    //Một chữ số
    char chuSo = '5'; 
    //Một chữ cái
    char chuCai = 'A';
    //Số lượng cây trong thành phố
    int soLuongCay = 31; 
    //Khoảng cách giữa các hành tinh
    double khoangCach = 5444.54;
    //Nghiệm x của phương trình bậc 1
    double x = 25.2;
    //Nghiệm x của phương trình bậc 2
    double delta = 34.5;
    
    //Print results
    System.out.println("Tuổi người: " + tuoiNguoi);
    System.out.printf("Cạnh tam giác = %.1f\n", canhTamGiac);
    System.out.printf("Chữ số = %s\nChữ cái = %s\n", chuSo, chuCai);
    System.out.printf("Số lượng cây = %d\n", soLuongCay);
    System.out.printf("Khoảng cách = %.2f\n", khoangCach);
    System.out.printf("Nghiệm x = %.2f\n", x);
    System.out.printf("Biệt thức delta = %.2f\n", delta);
        
    //Bài tập 2: Viết câu lệnh nhập vào 4 giá trị lần lượt là số thực, nguyên, nguyên dài và kí tự. In ra màn hình các giá trị này để kiểm tra:
    //Declare variables
    double soThuc = 0;
    int soNguyen = 0;
    long soNguyenDai = 0;
    char kiTu;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số thực = ");
    soThuc = sc.nextDouble();
    System.out.print("Nhập số nguyên = ");
    soNguyen = sc.nextInt();
    System.out.print("Nhập số nguyên dài = ");
    soNguyenDai = sc.nextLong();
    System.out.print("Nhập kí tự = ");
    kiTu = sc.next().charAt(0);    
    
    //Print results
    System.out.printf("Số thực là = %.2f\n", soThuc);
    System.out.printf("Số nguyên là = %d\n", soNguyen);
    System.out.printf("Số nguyên dài là = %d\n", soNguyenDai);
    System.out.printf("Kí tự là = %s\n", kiTu);
    
    //Bài tập 3: Viết câu lệnh in ra màn hình các dòng sau (không kể các số thứ tự và dấu: ở đầu mỗi dòng):
    //Declare variables
    //- 1: Bộ Giáo dục	
    String a = "Bộ Giáo dục";	
    //- 2: Đào tạo Cộng hoà xã hội chủ nghĩa Việt Nam		
    String b = "Đào tạo Cộng hoà xã hội chủ nghĩa Việt Nam";		
    //- 3: Sở Giáo dục Hà Nội Độc lập - Tự do - Hạnh phúc				
    String c = "Sở Giáo dục Hà Nội Độc lập - Tự do - Hạnh phúc";		
    System.out.printf("1: %s\n" + "2: %s\n" + "3: %s\n", a, b, c); 

    //Bài tập 4: Viết chương trình nhập vào một kí tự. In ra kí tự đó và mã ascii của nó:
    //Declare variables
    char kiTu;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập kí tự = ");
    kiTu = sc.next().charAt(0);
    
    //Print results
    System.out.printf("Kí tự %s có mã ASCII là: %d\n", kiTu, (int)kiTu);
    
    //Bài tập 5: Viết chương trình nhập vào hai số thực. In ra hai số thực đó với 2 số lẻ và cách nhau 5 cột:
    //Declare variables
    double soThuc1 = 0, soThuc2 = 0;

    //Take user information entered from the keyboard
    System.out.print("Nhập số thực thứ nhất = ");
    soThuc1 = sc.nextDouble();
    System.out.print("Nhập số thực thứ hai = ");
    soThuc2 = sc.nextDouble();    
    
    //Print results
    System.out.printf("Số thực thứ nhất là: %.2f\tSố thực thứ hai là = %.2f\n", soThuc1, soThuc2);
    
    //Bài tập 6: Nhập a, b, c. In ra màn hình dòng chữ phương trình có dạng ax^2 + bx + c = 0. Trong đó các giá trị a, b, c chỉ in ra 2 số lẻ (ví dụ với a = 5.141, b = −2, c = 0.8 in ra 5.14 x^2 −2.00 x + 0.80):
    
    //Declare variables
    double a = 0, b = 0, c = 0;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số a = ");
    a = sc.nextDouble();
    System.out.print("Nhập số b = ");
    b = sc.nextDouble();    
    System.out.print("Nhập số c = ");
    c = sc.nextDouble();       
    
    //Print results
    System.out.printf("Phương trình có dạng là %.2fx^2 + %.2fx + %.2f = 0", a, b, c);
    
    //Bài tập 7: Viết chương trình tính và in ra giá trị các biểu thức sau với 2 số lẻ:
    //Declare variables
    double cau7a = 0, cau7b = 0;
    
    //Computational processing
    cau7a = Math.sqrt(3+Math.sqrt(3+Math.sqrt(3)));
    cau7b = 2 + (1/(2+0.5));
    cau7b = 1/cau7b;
    
    //Print results
    System.out.printf("Đáp án câu 7a = %.3f\n", cau7a);
    System.out.printf("Đáp án câu 7b = %.3f\n", cau7b);
    
    //Bài tập 8: Nhập a, b, c là các số thực. In ra giá trị của các biểu thức sau với 3 số lẻ:
    //Declare variables
    double a = 0, b = 0, c = 0, cau8a = 0, cau8b = 0, cau8c = 0, cau8d = 0;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số a = ");
    a = sc.nextDouble();
    System.out.print("Nhập số b = ");
    b = sc.nextDouble();    
    System.out.print("Nhập số c = ");
    c = sc.nextDouble(); 
    
    //Computational processing
    cau8a = Math.pow(a, 2) - 2*b + (a*b/c);
    cau8b = (Math.pow(b, 2) - (4*a*c))/(2*a);
    cau8c = 3*a - Math.pow(b, 3) - 2*Math.sqrt(c);
    cau8d = (a*a)/(b) - (4*a)/(b*c) + 1;
    cau8d = Math.sqrt(cau8d);
    
    //Print results
    System.out.printf("Đáp án câu 8a là = %.3f\n", cau8a);
    System.out.printf("Đáp án câu 8b là = %.3f\n", cau8b);
    System.out.printf("Đáp án câu 8c là = %.3f\n", cau8c);
    System.out.printf("Đáp án câu 8d là = %.3f\n", cau8d);
    
    //Câu 9: In ra tổng, tích, hiệu và thương của 2 số được nhập vào từ bàn phím:
    //Declare variables	
    double a = 0, b = 0, tong = 0, tich = 0, hieu = 0, thuong = 0;
    
    //Take user information entered from the keyboard	
    System.out.print("Nhập số a = ");	
    a = sc.nextDouble();	
    System.out.print("Nhập số b = ");
    b = sc.nextDouble();
    
    //Computational processing
    tong = a+b; tich = a*b; hieu = a-b; 	
    System.out.printf("Tổng của %.2f và %.2f là: %.2f\n", a, b, tong);		
    System.out.printf("Tích của %.2f và %.2f là: %.2f\n", a, b, tich);		
    System.out.printf("Hiệu của %.2f và %.2f là: %.2f\n", a, b, hieu);
		
    if(b != 0)
    {
        thuong = a/b;
			
        System.out.printf("Thương của %.2f và %.2f là: %.2f\n", a, b, thuong);
    }
    else
    {
        System.out.println("Nhập số b khác không");
    }    

    */
    
    //Bài tập 10: In ra trung bình cộng, trung bình nhân của 3 số được nhập vào từ bàn phím:
    
            
  }  
}
