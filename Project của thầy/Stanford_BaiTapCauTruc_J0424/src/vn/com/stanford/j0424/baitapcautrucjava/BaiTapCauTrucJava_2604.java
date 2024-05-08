package vn.com.stanford.j0424.baitapcautrucjava;

import java.util.Scanner;

public class BaiTapCauTrucJava_2604 {

	public static void main(String[] args) {
		
		//Khai báo đối tượng
		Scanner sc = new Scanner(System.in);
		/*
		//Bài tập 11: Viết chương trình nhập cạnh, 
		//bán kính và in ra diện tích, chu vi của các hình:
		//hình vuông, hình chữ nhật, hình tròn.
		//Khai báo biến
		double r = 0, chuVi = 0, dienTich = 0;
		
		//Khai báo 1 hằng số
		final double PI = 3.14;
		
		System.out.print("Nhập bán kính hình tròn r = ");
		
		r = sc.nextDouble();
		
		//Tính toán
		chuVi = 2*PI * r;
		dienTich = PI * r * r;
		
		System.out.printf("Chu vi hình tròn là: %f\n", chuVi);
		System.out.printf("Diện tích hình tròn là: %f\n", dienTich);
		
		//Bàitập14: Nhập vào 4 chữ số. In ra tổng của 4 chữ số này và chữ số hàng chục, hàng đơn vị của tổng 
		//(ví dụ 4 chữ số 3, 1, 8, 5 có tổng là 17 và chữ số hàng chục là 1 và hàng đơn vị là 7, cần in ra 17, 1, 7).
		
		//Khai báo biến
		int so1 = 0, so2 = 0, so3 = 0, so4 = 0, tong = 0, chuc = 0, donVi = 0;
		
		System.out.print("Nhập số thứ 1 = ");
		
		so1 = sc.nextInt();
		
		System.out.print("Nhập số thứ 2 = ");
		
		so2 = sc.nextInt();
		
		System.out.print("Nhập số thứ 3 = ");
		
		so3 = sc.nextInt();
		
		System.out.print("Nhập số thứ 4 = ");
		
		so4 = sc.nextInt();
		
		tong = so1 + so2 + so3 + so4;
		
		chuc = tong/10;
		donVi = tong%10;
		
		System.out.println("Tổng 4 số là: " + tong);
		System.out.printf("Hàng chục là: %d\n", chuc);
		System.out.printf("Hàng đơn vị là: %d\n", donVi);
		*/
		//Bàitập15: Nhậpvàomộtsốnguyên(có4chữsố).Inratổngcủa4chữsốnàyvàchữsố đầu, chữ số cuối (ví dụ số 3185 có tổng các chữ số là 17, đầu và cuối là 3 và 5, kết quả in ra là: 17, 3, 5).
		//3185
		//nghin = 3185/1000 = 3
		//temp = 3185%1000 = 185
		//tram = temp/100 = 185/100 = 1
		//temp = temp%100 = 85
		//chuc = temp/10 = 85/10 = 8
		//donVi = temp%10 = 85%10 = 5
		//Khai báo biến
		int so4ChuSo = 0, temp = 0, nghin = 0, tram = 0, chuc = 0, donVi = 0, tong = 0;
		
		System.out.printf("Nhập số 4 chữ số = ");
		
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
			System.out.printf("Hàng nghìn: %d\n", nghin);
			System.out.printf("Hàng đơn vị: %d\n", donVi);
		}
		else
		{
			System.out.println("Bạn cần phải nhập số gồm 4 chữ số");
		}
	}

}
