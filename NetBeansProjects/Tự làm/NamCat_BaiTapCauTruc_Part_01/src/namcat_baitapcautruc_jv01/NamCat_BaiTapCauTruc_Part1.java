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
    
    //Bài tập 10: In ra trung bình cộng, trung bình nhân của 3 số được nhập vào từ bàn phím:
    
    //Declare variables:	
    double a = 0, b = 0, c = 0, trungBinhCong = 0, trungBinhNhan = 0;
		
    System.out.print("Nhập số a = ");
		
    a = sc.nextDouble();
		
    System.out.print("Nhập số b = ");
		
    b = sc.nextDouble();
		
    System.out.print("Nhập số c = ");
		
    c = sc.nextDouble();
    
    //Computational processing	
    trungBinhCong = (a+b+c)/3;
		
    trungBinhNhan = Math.cbrt(a+b+c);
    
    //Print results	
    System.out.printf("Trung bình cộng của %.2f, %.2f và %.2f là: %.2f\n", a, b, c, trungBinhCong);
		
    System.out.printf("Trung bình nhân của %.2f, %.2f và %.2f là: %.2f\n", a, b, c, trungBinhNhan);
    
    //Bài tập 11:Viết chương trình nhập cạnh, bán kính và in ra diện tích, chu vi của các hình: hình vuông, hình chữ nhật, hình tròn.
    
    //Declare variables	
    double canhVuong = 0 , chieuDaiChuNhat = 0, chieuRongChuNhat = 0, banKinh = 0, chuViVuong = 0, chuViChuNhat = 0, chuViTron = 0, dienTichVuong = 0, dienTichChuNhat = 0, dienTichTron = 0;
    
    //Take user information entered from the keyboard			
    System.out.print("Nhập chiều dài cạnh hình vuông = ");
		
    canhVuong = sc.nextDouble();
		
    System.out.print("Nhập chiều dài hình chữ nhật = ");
		
    chieuDaiChuNhat = sc.nextDouble();
		
    System.out.print("Nhập chiều rộng hình chữ nhật = ");
		
    chieuRongChuNhat = sc.nextDouble();
    
    System.out.print("Nhập chiều dài bán kính = ");
		
    banKinh = sc.nextDouble();
    
    //Computational processing	
    chuViVuong = 4*canhVuong;
		
    chuViChuNhat = 2*(chieuDaiChuNhat+chieuRongChuNhat);
		
    chuViTron = 2*Math.PI*banKinh;
		
    dienTichVuong = Math.pow(canhVuong, 2);
				
    dienTichChuNhat = chieuDaiChuNhat*chieuRongChuNhat;
		
    dienTichTron = Math.PI*Math.pow(banKinh, 2);
    
    //Print results	
    System.out.printf("Chu vi hình vuông là = %.2f\n", chuViVuong);
		
    System.out.printf("Chu vi hình chữ nhật là = %.2f\n", chuViChuNhat);
		
    System.out.printf("Chu vi hình tròn là = %.2f\n", chuViTron);
		
    System.out.printf("Diện tích hình vuông là = %.2f\n", dienTichVuong);
		
    System.out.printf("Diện tích hình chữ nhật là = %.2f\n", dienTichChuNhat);
		
    System.out.printf("Diện tích hình tròn là = %.2f\n", dienTichTron);   
    
    //Bài tập 12: Nhập a, b, c là độ dài 3 cạnh của tam giác (chú ý đảm bảo tổng 2 cạnh phải lớn hơn cạnh còn lại). Tính chu vi, diện tích, độ dài 3 đường cao, 3 đường trung tuyến, 3 đường phân giác, bán kính đường tròn nội tiếp, ngoại tiếp lần lượt theo các công thức sau:
    
    //Declare variables	
    double a = 0, b = 0, c = 0, p = 0, chuVi = 0, dienTich = 0, ha = 0, hb = 0, hc = 0, ma = 0, mb = 0, mc = 0, ga = 0, gb = 0, gc = 0, banKinhNoiTiep = 0, banKinhNgoaiTiep = 0;
    
    //Take user information entered from the keyboard	
    System.out.print("Nhập chiều dài cạnh a = ");
		
    a = sc.nextDouble();
		
    System.out.print("Nhập chiều dài cạnh b = ");
		
    b = sc.nextDouble();
		
    System.out.print("Nhập chiều dài cạnh c = ");
		
    c = sc.nextDouble();
    
    //Computational processing and print results	
    if(a+b>c && a+c>b && b+c>a)
    {
	p = (a+b+c)/2;
			
	chuVi = 2*p;
			
	dienTich = p*(p-a)*(p-b)*(p-c);
			
	dienTich = Math.sqrt(dienTich);
			
	ha = (2*dienTich)/a; hb = (2*dienTich)/b; hc = (2*dienTich)/c;
	
	ma = 2*Math.pow(b, 2) + 2*Math.pow(c, 2) - Math.pow(a, 2); ma = 0.5*Math.sqrt(ma);
			
	mb = 2*Math.pow(a, 2) + 2*Math.pow(c, 2) - Math.pow(b, 2); mb = 0.5*Math.sqrt(mb);
			
	mc = 2*Math.pow(a, 2) + 2*Math.pow(b, 2) - Math.pow(c, 2); mc = 0.5*Math.sqrt(mc);
			
	ga = b*c*p*(p-a); ga = (2/(b+c))*Math.sqrt(ga);
			
	gb = a*c*p*(p-b); gb = (2/(a+c))*Math.sqrt(gb);
			
	gc = b*a*p*(p-c); gc = (2/(b+a))*Math.sqrt(gc);
			
	banKinhNoiTiep = dienTich/p;
			
	banKinhNgoaiTiep = (a*b*c)/(4*dienTich);
			
	System.out.printf("Chu vi hình tam giác C = %.2f\n", chuVi);			
	System.out.printf("Diện tích hình tam giác S = %.2f\n", dienTich);
			
	System.out.printf("Độ dài đường cao ha = %.2f\n", ha);
        System.out.printf("Độ dài đường cao hb = %.2f\n", hb);
        System.out.printf("Độ dài đường cao hc = %.2f\n", hc);
			
	System.out.printf("Độ dài đường trung tuyến ma = %.2f\n", ma);
        System.out.printf("Độ dài đường trung tuyến mb = %.2f\n", mb);
        System.out.printf("Độ dài đường trung tuyến mc = %.2f\n", mc);
			
	System.out.printf("Độ dài đường phân giác ga = %.2f\n", ga);
        System.out.printf("Độ dài đường phân giác gb = %.2f\n", gb);	
        System.out.printf("Độ dài đường phân giác gc = %.2f\n", gc);	
			
	System.out.printf("Bán kính đường tròn nội tiếp r = %.2f\n", banKinhNoiTiep);
	System.out.printf("Bán kính đường tròn ngoại tiếp R = %.2f\n", banKinhNgoaiTiep);			
    }
    else
    {
	System.err.println("Bạn cần phải nhập lại độ dài 3 cạnh của tam giác đảm bảo điều kiện: Tổng 2 cạnh phải lớn hơn cạnh còn lại");
    }    
    
    //Bài tập 13: Tính diện tích và thể tích của hình cầu bán kính R theo công thức:
		
    //Declare varibles
    double banKinh = 0, dienTich = 0, theTich = 0;
    
    //Take user information entered from the keyboard	
    System.out.print("Nhập bán kính R = ");
    banKinh = sc.nextDouble();
    
    //Computational processing and print results	
    if (banKinh>0)
    {
	dienTich = 4*Math.PI*Math.pow(banKinh, 2);
					
	theTich = (banKinh*dienTich)/3;
			
	System.out.printf("Diện tích của hình cầu là = %.2f\n", dienTich);
			
	System.out.printf("Thể tích của hình cầu là = %.2f\n", theTich);
    }
    else
    {
	System.out.println("Bạn cần nhập lại bán kính R phù hợp với điều kiện = R > 0");
    } 
    
    //Bài tập 14: Nhập vào 4 chữ số. In ra tổng của 4 chữ số này và chữ số hàng chục, hàng đơn vị của tổng (ví dụ 4 chữ số 3, 1, 8, 5 có tổng là 17 và chữ số hàng chục là 1 và hàng đơn vị là 7, cần in ra 17, 1, 7).
    
    //Declare variables
    int a = 0, b = 0, c = 0, d = 0, tongSo = 0, soHangChuc = 0, soHangDonVi = 0; 
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số a = ");	
    a = sc.nextInt();
    System.out.print("Nhập số b = ");
    b = sc.nextInt();
    System.out.print("Nhập số c = ");
    c = sc.nextInt();
    System.out.print("Nhập số d = ");
    d = sc.nextInt();  
    
    //Computational processing
    tongSo = a + b + c + d;
    soHangChuc = tongSo/10;
    soHangDonVi = tongSo%10;
    
    //Print results
    System.out.println("Tổng số là = " + (int)tongSo);
    System.out.println("Chữ số hàng chục là = " + soHangChuc);
    System.out.println("Chữ số hàng đơn vị là = " + soHangDonVi); 
 
    //Bài tập 15: Nhập vào một số nguyên (có 4 chữ số). In ra tổng của 4 chữ số này và chữ số đầu, chữ số cuối (ví dụ số 3185 có tổng các chữ số là 17, đầu và cuối là 3 và 5, kết quả in ra là: 17, 3, 5).
    
    //Declare variables
    int soNguyen = 0, tongSo = 0, hangDonVi = 0, hangChuc = 0, hangTram = 0, hangNghin = 0, temp = 0;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập số nguyên = ");	
    soNguyen = sc.nextInt(); 
    
    //Computational processing
    if(soNguyen <= 9999 && soNguyen > 999)
    {
        hangNghin = soNguyen/1000;
        temp = soNguyen%1000;
        hangTram = temp/100;
        temp = temp%100;
        hangChuc = temp/10;
        hangDonVi = temp%10;
        tongSo = hangChuc + hangDonVi + hangTram + hangNghin;
        System.out.println("Tổng số là = " + tongSo);
        System.out.println("Chữ số đầu = " + hangNghin);
        System.out.println("Chữ số cuối = " + hangDonVi);
    }
    else
    {
        System.err.println("Bạn cần phải nhập lại số nguyên có 04 chữ số");
    }
    
    */
            
    //Bài tập 16: Hãy nhập 2 số a và b. Viết chương trình đổi giá trị của a và b theo 2 cách:
    //Declare variables
    
    //Use auxiliary variables	
    int a = 30, b = 50;		
    int t = a; 			
    a = b;	
    b = t;	
    System.out.printf("Giá trị sau khi đổi:\n a = %d\n b = %d\n", a, b);
    
    //Not use auxiliary variables  
    int c = 30, d = 50;		
    c = c + d;		
    d = c - d;  
    c = c - d;
    System.out.printf("Giá trị sau khi đổi:\n c = %d\n d = %d\n", c, d);  
    
    /*
    
    //Bài tập 17: Một sinh viên gồm có các thông tin: họ tên, tuổi, điểm toán (hệ số 2), điểm tin (hệ số 1). Hãy nhập các thông tin trên cho 2 sinh viên. In ra bảng điểm gồm các chi tiết nêu trên và điểm trung bình của mỗi sinh viên:
    
    //Declare variables	
    String hoTen1 = "Huỳnh Nam Cát", hoTen2 = "Huỳnh Nam Đài";	
    int tuoi1 = 27, tuoi2 = 31;	
    double diemToan1 = 0, diemToan2 = 0, diemTin1 = 0, diemTin2 = 0;
    
    //Take user information entered from the keyboard
    System.out.print("Nhập điểm toán của sinh viên thứ nhất = ");	
    diemToan1 = sc.nextDouble();
    System.out.print("Nhập điểm toán của sinh viên thứ hai = ");
    diemToan2 = sc.nextDouble();
    System.out.print("Nhập điểm tin của sinh viên thứ nhất = ");
    diemTin1 = sc.nextDouble();
    System.out.print("Nhập điểm tin của sinh viên thứ hai = ");
    diemTin2 = sc.nextDouble();;      

    //Computational processing and Print results
    if(diemToan1 >= 0 && diemToan2 >= 0 && diemTin1 >= 0 && diemTin2 >= 0)
    {
    System.out.printf("Tên của sinh viên thứ nhất: %s\n", hoTen1);		
    System.out.printf("Tuổi của sinh viên thứ nhất = %d\n", tuoi1);		
    System.out.printf("Điểm toán của sinh viên thứ nhất = %.2f\n", diemToan1);		
    System.out.printf("Điểm tin của sinh viên thứ nhất = %.2f\n", diemTin1);		
    System.out.printf("Điểm trung bình của sinh viên thứ nhất = %.2f\n", ((diemToan1*2)+diemTin1)/2);
    
    System.out.printf("Tên của sinh viên thứ hai = %s\n", hoTen2);		
    System.out.printf("Tuổi của sinh viên thứ hai = %d\n", tuoi2);		
    System.out.printf("Điểm toán của sinh viên thứ hai = %.2f\n", diemToan2);		
    System.out.printf("Điểm tin của sinh viên thứ hai = %.2f\n", diemTin2);		
    System.out.printf("Điểm trung bình của sinh viên thứ hai = %.2f\n", ((diemToan2*2)+diemTin2)/2);        
    }
    else
    {
        System.err.println("Bạn cần nhập lại điểm toán và điểm tin phù hợp với điều kiện >= 0");
    }
    
    */


    
  }  
}
