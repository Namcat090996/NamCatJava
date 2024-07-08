package vn.com.namcat.lamviecvoimangjava;

import java.util.Scanner;

public class NamCat_LamViecVoiChuoiJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		
		String strChuoiA = "Stanforf";
		String strChuoiB = "Stanrford";
		
		//So sánh chuỗi

		int soSanh = strChuoiA.compareTo(strChuoiB);
		
		System.out.println("Kết quả so sánh chuỗi = " + soSanh);
		
		//Nối chuỗi
		strChuoiA = strChuoiB.concat(" - Dạy học");
		
		System.out.println(strChuoiA);
		
		System.out.println("Chữ thường = " + strChuoiA.toLowerCase());
		
		System.out.println("Chữ hoa = " + strChuoiA.toUpperCase());
		
		System.out.println("Stanford " + "         dạy lập trình" + ",   công nghệ".trim());
		
		//Lấy chuỗi con
		String tenVietTat = strChuoiA.substring(0,8);
		
		System.out.println("Tên viết tắt: " + tenVietTat);
		
		int idx1 = strChuoiA.indexOf('r');
		
		System.out.println("Vị trí đầu tiên của kí tự r là = " + idx1);
		
		int ldx = strChuoiA.lastIndexOf('r');
		
		System.out.println("Vị trí cuối cùng của kí tự r là = " + ldx);
		
		String strData = "10;50;60;80";
		
		String arr[] = strData.split(";");
		
		System.out.println("Các số lấy được từ chia chuỗi = ");
		
		for(String gt: arr)
		{
			System.out.println(gt);
		}
		
		char arr2[] = tenVietTat.toCharArray();
		
		System.out.println("Các kí tự là: ");
		
		for(char ch: arr2)
		{
			System.out.println(ch);
		}
		
		*/
		
		Scanner sc = new Scanner(System.in);
		String ketQua = "";
		
		System.out.print("Nhap chuoi so 1: ");
		String chuoi1 = sc.next();
		
		System.out.print("Nhap chuoi so 2: ");
		String chuoi2 = sc.next();
		
		char[] charArray1 = chuoi1.toCharArray();
		char[] charArray2 = chuoi2.toCharArray();
		
		int arr1[] = new int[charArray1.length];
		int arr2[] = new int[charArray2.length];
		int n = 0, m = 0;
		for(char c : charArray1) {
			arr1[n] = Integer.parseInt("" + c);
			n++;
		}
		
		for(char c : charArray2) {
			arr2[m] = Integer.parseInt("" + c);
			m++;
		}
		
		if (n >= m) {
			int arr[] = new int[100];
			int tongcot = 0;
			int soNho = 0;
			int chenh = n - m;
			int j = m;
			boolean flag = false;
			for(int i = n; i >= 0; i-- ) {
				
				if(flag == true && arr[0] == 0) {
					arr[i] = arr1[i];
				}
				
				while(j + chenh == i && j >= -1) {
					if(j >= 0) {
						tongcot = arr1[i] + arr2[j] + soNho;
					}
					else if (j == -1) {
						tongcot = arr1[i]  + soNho;
						flag = true;
					}
					
					if(tongcot < 10) {
						arr[i] = tongcot;
						soNho = 0;
					}
					else {
						arr[i] = tongcot % 10;
						soNho = (tongcot / 10);
					}
					j--;
				}
				
				
				
			}
			
			for(int i = 0; i < n; i++) {
				ketQua += arr[i] + "";
			}
			
			System.out.println("Ket qua cong hai chuoi so 1 va chuoi so 2 la: " + ketQua);
		}
		else {
			int arr[] = new int[100];
			int tongcot = 0;
			int soNho = 0;
			int chenh = m - n;
			int j = n - 1;
			boolean flag = false;
			for(int i = m - 1; i >= 0; i-- ) {
				
				if(flag == true && arr[0] == 0) {
					arr[i] = arr2[i];
				}
				
				while(j + chenh == i && j >= -1) {
					if(j >= 0) {
						tongcot = arr2[i] + arr1[j] + soNho;
					}
					else if (j == -1) {
						tongcot = arr2[i]  + soNho;
						flag = true;
					}
					
					if(tongcot < 10) {
						arr[i] = tongcot;
						soNho = 0;
					}
					else {
						arr[i] = tongcot % 10;
						soNho = (tongcot / 10);
					}
					j--;
				}
				
			}
			
			for(int i = 0; i < m; i++) {
				ketQua += arr[i] + "";
			}
			
			System.out.println("Ket qua cong hai chuoi so 1 va chuoi so 2 la: " + ketQua);
		}
		
	
		
		
	}

}
