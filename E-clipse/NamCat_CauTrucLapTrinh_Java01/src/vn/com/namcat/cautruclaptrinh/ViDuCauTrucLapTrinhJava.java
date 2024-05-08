/**
 * 
 */
package vn.com.namcat.cautruclaptrinh;

import java.util.Scanner;

/**
 * 
 */
public class ViDuCauTrucLapTrinhJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Khai báo đối tượng để hỗ trợ nhập thông tin từ bàn phím
		
		Scanner sc = new Scanner(System.in);
		
		/*
		
		//Ví dụ 1: Nhập chiều cao của A và B xem ai cao hơn?
		
		//Khai báo biến
		
		double chieuCaoA = 0 , chieuCaoB = 0;
		
		System.out.print("Nhập chiều cao của A: ");
		
		chieuCaoA = sc.nextDouble();
		
		System.out.print("Nhập chiều cao của B: ");
		
		chieuCaoB = sc.nextDouble();
		
		if(chieuCaoA == chieuCaoB)
		{
			System.out.println("A và B cao bằng nhau");
		}
		else
		{
			if(chieuCaoA > chieuCaoB)
			{
				System.out.println("A cao hơn B");
			}
			else
			{
				System.out.println("A thấp hơn B");
			}
		}
		
				//Ví dụ 2: Nhập vào 02 số thực sau đó tính thương của 02 số
		
		double a = 0, b = 0, thuong = 0;
		
		System.out.print("Nhập số a: ");
		
		a = sc.nextDouble();
		
		System.out.print("Nhập số b: ");
		
		b = sc.nextDouble();	
		
		if(b != 0)
		{
			thuong = a/b;
			
			System.out.printf("Thương của %.2f và %f là: %.2f\n", a, b, thuong);
		}
		else
		{
			System.out.println("Bạn cần phải nhập số b khác 0");
		}
		
		//Ví dụ 3: Giải phương trình bậc nhất ax + b = c với a # 0
		
		//Khai báo biến
		
		double a = 0, b = 0, c = 0, x = 0;
		
		System.out.print("Nhập hệ số a: ");
		
		a = sc.nextDouble();
		
		if(a != 0)
		{
			System.out.print("Nhập hệ số b: ");
			
			b = sc.nextDouble();
			
			System.out.print("Nhập hệ số c: ");
			
			c = sc.nextDouble();
			
			//Giải nghiệm
			
			x = (c-b)/a;
			
			System.out.printf("Nghiệm của phương trình x = %.2f\n", x);
		}
		else
		{
			System.out.println("Bạn cần nhập hệ số a khác");
		}
		
		//Bài tập 11:
		
		//Khai báo biến
				
		double r = 0, chuVi = 0, dienTich = 0;
		
		//Khai báo 1 hằng số
		
		final double PI = 3.14;
		
		System.out.print("Nhập bán kính hình tròn r = ");
		
		r = sc.nextDouble();
		
		//Tính toán
		
		chuVi = 2*PI*r;
		
		dienTich = PI*r*r;
		
		System.out.printf("Chu vi hình tròn là: %.2f\n", chuVi);
				
		System.out.printf("Diện tích hình tròn là: %.2f\n", dienTich);
		
		/*
		
		//Bài tập 14:
		
		//Khai báo biến
				
		int a = 0, b = 0, c = 0, d = 0;
				
		int tongSo = 0, soHangChuc = 0, soHangDonVi = 0;
				
		System.out.print("Nhập số a: ");	
				
		a = sc.nextInt();
				
		System.out.print("Nhập số b: ");
				
		b = sc.nextInt();
				
		System.out.print("Nhập số c: ");
				
		c = sc.nextInt();
				
		System.out.print("Nhập số d: ");
				
		d = sc.nextInt();
				
		tongSo = a+b+c+d;
			
		soHangChuc = (tongSo/10)%10;
				
		soHangDonVi = tongSo%10;
				
		System.out.println("Tổng số là: "+ (int)tongSo);
				
		System.out.println("Chữ số hàng chục là: "+ soHangChuc);
				
		System.out.println("Chữ số hàng đơn vị là: "+ soHangDonVi);	

		//Bài tập 15:
				
		//Khai báo biến
				
		int so4ChuSo = 0, temp = 0, nghin = 0, tram = 0, chuc = 0, donVi = 0, tong = 0;
		
		System.out.printf("Nhập số có 4 chữ số: ");
		
		so4ChuSo = sc.nextInt();
		
		if(so4ChuSo >= 1000 && so4ChuSo <= 9999)
		{
			nghin = so4ChuSo/1000;
			
			temp = so4ChuSo%1000;
			
			tram = temp/100;
			
			temp = temp%100;
			
			chuc = temp/10;
			
			donVi = temp%10;
			
			tong = nghin + tram + chuc + donVi;
			
			System.out.println("Tổng các số là: " + tong);
			
			System.out.println("Chữ số đầu là: " + nghin);
			
			System.out.println("Chữ số cuối là " + donVi);
		
		}
		else
		{
			System.out.println("Bạn cần phải nhập lại số 4 chữ số trong dãy từ 1000-9999");
		}
		
		*/
		
	}
}
