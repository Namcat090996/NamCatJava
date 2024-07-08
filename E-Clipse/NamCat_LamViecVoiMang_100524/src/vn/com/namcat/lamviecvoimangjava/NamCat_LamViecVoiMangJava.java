/**
 * 
 */
package vn.com.namcat.lamviecvoimangjava;

import java.util.Scanner;

/**
 * 
 */
public class NamCat_LamViecVoiMangJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		/*
		
		//Ví dụ 1: Khai báo 1 mảng số nguyên gồm 3 phần tử:
		//Declare array
		int arr[] = new int[3];
		
		//Assign values to elements
		arr[0] = 2;
		arr[1] = 3;
		arr[2] = 5;
		
		System.out.println("Giá trị của phần tử 2 là = " + arr[1]);
		
		System.out.println("Giá trị của phần tử 3 là = " + arr[2]);
		
		System.out.println("Các phần tử của mảng là = ");
		
		for(int i = 0; i < 3; i++)
		{
			System.out.print(arr[i]+ "\t");
		}
		
		System.out.println("");
		
		*/
		
		//Ví dụ 2: Khai báo 1 mảng số thực gồm n phần tử với n và các phần tử nhập từ bàn phím sau đó in ra màn hình
		int n = 0;
		System.out.print("Nhập mảng gồm n phần tử với n = ");
		n = sc.nextInt();
		
		//Declare an array of real numbers with n elements
		float arr2[] = new float[n];
		
		System.out.println("Nhập giá trị cho các phần tử = ");
		for(int i = 0; i < n; i++)
		{
			System.out.print("arr2["+ i +"] = ");
			arr2[i] = sc.nextFloat();
		}
		
		System.out.printf("Các phần tử của mảng %d là = \n", n);
		
		for(int i = 0; i < arr2.length; i++)
		{
			System.out.print(arr2[i] + "\t");
		}


	}

}
