package vn.com.namcat.lamviecvoimangjava;

import java.util.Scanner;

public class NamCat_LamViecVoiMangJava2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		//Khai báo một mảng 2 chiều kiểu số nguyên gồm 3 dòng và 2 cột
		//Declare a 2-dimensional array of integer type with 3 rows and 2 columns
		/*
		 * a00	a01
		 * a10	a11
		 * a20	a21
		 */
		
		
		
		//Declare an array
		int arr[][] = new int[3][2];
		
		//Gán tri cho các phần tử
		
		//Row 1
		arr[0][0] = 2;
		arr[0][1] = 3;
		
		//Row 2
		arr[1][0] = 4;
		arr[1][1] = 5;
		
		//Row 3
		arr[2][0] = 6;
		arr[2][1] = 7;		
		
		System.out.println("Giá trị mảng ở dòng 2 cột 1 là = " + arr[1][0]);
		
		System.out.println("Giá trị mảng ở dòng 3 cột 2 là = " + arr[2][1]);
		
		System.out.println("Các phần tử của mảng 3x2 là = ");
		
		//Browse the rows
		for(int i = 0; i < 3; i++)
		{
			//Browse the columns
			for(int j = 0; j < 2; j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			//Next
			System.out.println("");
		}
		
		/*
		
		//Ví dụ 4: Khai báo mảng 2 chiều kiểu số thực gồm m dòng và n cột nhập từ bàn phím sau đó in thông tin ra màn hình
		int m = 0, n = 0;
		
		System.out.print("Nhập mảng gồm m dòng với m = ");
		m = sc.nextInt();
		
		System.out.print("Nhập mảng gồm n cột với n = ");
		n = sc.nextInt();		
		
		double arr2[][] = new double[m][n];
		System.out.printf("Nhập các phần tử cho mảng %dx%d: \n", m, n);
		
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print("arr2["+ i +"]["+ j +"] = ");
				arr2[i][j] = sc.nextDouble();
			}
		}
		
		System.out.printf("Các phần tử của mảng %dx%d là = \n", m, n);
		
		//Browse the rows
		for(int i = 0; i < m; i++)
		{
			//Browse the columns
			for(int j = 0; j < n; j++)
			{
				System.out.print(arr2[i][j] + "\t");
			}
			
			//Next
			System.out.println("");
		}
	
		*/
		
	}

}
