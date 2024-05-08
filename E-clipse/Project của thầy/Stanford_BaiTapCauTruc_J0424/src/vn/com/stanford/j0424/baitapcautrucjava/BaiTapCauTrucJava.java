/**
 * 
 */
package vn.com.stanford.j0424.baitapcautrucjava;

import java.util.Scanner;

/**
 * 
 */
public class BaiTapCauTrucJava {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//Bài tập 1: Viết câu lệnh khai báo biến để lưu các giá trị sau:
		//	− Tuổi của một người
		short tuoiNguoi = 25;
		//	− Độ dài cạnh một tam giác
		float canhTamGiac = 12.4556f;
		//	− Một chữ số
		char chuSo = '6';
		//	− Một chữ cái
		char chuCai = 'A';
		//	− Số lượng cây trong thành phố
		int soLuongCay = 1000;
		//	− Khoảng cách giữa các hành tinh
		double khoangCach = 23546546.457564;
		//	− Nghiệm x của phương trình bậc 1 
		float x = 25.675f;
		//− Biệt thức Δ của phương trình bậc 2
		float delta = 34.5654f;
		
		System.out.println("Tuổi người: " + tuoiNguoi);
		System.out.printf("Cạnh tam giác = %f\n", canhTamGiac);
		System.out.printf("Chữ số = %s\n Chữ cái = %s\n", chuSo, chuCai);
		System.out.printf("Số lượng cây = %d\n", soLuongCay);
		System.out.printf("Khoảng cách = %.2f\n", khoangCach);
		System.out.printf("Nghiệm x = %.2f\n", x);
		System.out.printf("Biệt thức delta = %.2f\n", delta);
		*/
		//Khai báo 1 đối tượng để lấy thông tin từ bàn phím
		Scanner sc = new Scanner(System.in);
		
		//Bài tập 2: Viết câu lệnh nhập vào 4 giá trị lần lượt là số thực, nguyên, nguyên dài và kí
		//tự. In ra màn hình các giá trị này để kiểm tra.
	    /*			
		//Khai báo biến
		
		 float soThuc = 0; 
		 int soNguyen = 0; 
		 long soNguyenDai = 0; 
		 char kiTu;

		System.out.print("Nhập số thực = ");
		
		soThuc = sc.nextFloat();
		
		System.out.print("Nhập số nguyên = ");
		
		soNguyen = sc.nextInt();
		
		System.out.print("Nhập số nguyên dài = ");
		
		soNguyenDai = sc.nextLong();
		
		System.out.print("Nhập kí tự = ");
		
		kiTu = sc.next().charAt(0);
		
		//In thông tin ra màn hình
		System.out.printf("Số thực là: %f\n", soThuc);
		System.out.printf("Số thực là: %d\n", soNguyen);
		System.out.printf("Số thực là: %d\n", soNguyenDai);
		System.out.printf("Số thực là: %s\n", kiTu);
		
		//Bài tập 4: Viết chương trình nhập vào một kí tự. 
		//In ra kí tự đó và mã ascii của nó.
		System.out.printf("Kí tự %s có mã ascii là: %d\n", kiTu, 
				(int)kiTu);
		
		//Bài tập 5: Viết chương trình nhập vào hai số thực. 
		//In ra hai số thực đó với 2 số lẻ và cách nhau 5 cột.
		
		float soThuc1 = 0, soThuc2 = 0;
		
		System.out.print("Nhập số thực 1 = ");
		
		soThuc1 = sc.nextFloat();
		
		System.out.print("Nhập số thực 2 = ");
		
		soThuc2 = sc.nextFloat();
		
		System.out.printf("Số thực 1 = %f\tSố thực 2 = %f", soThuc1, soThuc2);*/
		
		//Bài tập 7
		
		//Khai báo biến
		double cau7a = 0, cau7b = 0;
		
		cau7a = Math.sqrt(3.0 + Math.sqrt(3.0 + Math.sqrt(3.0)));
		
		cau7b = 1/(2.0 + 1/(2.0 + 1/2.0));
		
		System.out.printf("Câu 7a = %.3f\nCâu 7b = %.3f", cau7a, cau7b);
		
		//Bài tập 8
		//Khai báo biến
		double a = 0, b = 0, c = 0, cau8a = 0, cau8b = 0, cau8c = 0, cau8d = 0;
		
		System.out.print("Nhập giá trị a = ");
		
		a = sc.nextDouble();
		
		System.out.print("Nhập giá trị b = ");
		
		b = sc.nextDouble();
		
		System.out.print("Nhập giá trị c = ");
		
		c = sc.nextDouble();
		
		//Tính toán
		cau8a = Math.pow(a, 2) -2*b + (a*b)/c;
		cau8b = (Math.pow(b, 2) - 4*a*c)/(2*a);
		cau8c = 3*a - Math.pow(b, 3) - 2*Math.sqrt(c);
		cau8d = (a*a)/b - 4*a/(b*c) + 1;
		cau8d = Math.sqrt(cau8d);
		
		System.out.printf("Câu 8a = %.2f\n", cau8a);
		System.out.printf("Câu 8b = %.2f\n", cau8b);
		System.out.printf("Câu 8c = %.2f\n", cau8c);
		System.out.printf("Câu 8d = %.2f\n", cau8d);
	}

}
