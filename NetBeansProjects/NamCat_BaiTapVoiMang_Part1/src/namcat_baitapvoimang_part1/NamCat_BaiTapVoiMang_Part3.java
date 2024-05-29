/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baitapvoimang_part1;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class NamCat_BaiTapVoiMang_Part3 {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
   
	//Declare the number of rows and columns in the array
	int n = 0, m = 0;
	System.out.print("Nhập mảng gồm n dòng với n = ");
	n = sc.nextInt();
 	System.out.print("Nhập mảng gồm m cột với m = ");
	m = sc.nextInt();  
	
	//Declare array
	int arr[][] = new int[n][m];
	
	//Declare array
	System.out.println("Nhập giá trị cho các phần tử của mảng: ");
	for(int i = 0; i < n; i++)
	{
	    for(int j = 0; j < m; j++)
	    {
		System.out.printf("arr[%d][%d] = ", i, j);
		arr[i][j] = sc.nextInt();
	    }
	}
	
	//Show the array
	System.out.println("Các phần tử của mảng là: ");
	for(int i = 0; i < n; i++)
	{
	    for(int j = 0; j < m; j++)
	    {
		System.out.printf("arr[%d][%d] = %d\t", i, j,arr[i][j]);
	    }
	    System.out.println("");
	}	
	
	//Bài tập 1: Cho một ma trận nguyên kích thước m*n. Tính:
	
	//Tổng tất cả các phần tử của ma trận.
	int tong = 0, tongDuong = 0, tongAm = 0, tongChan = 0, tongLe = 0;
	for(int i = 0; i < n; i++)
	{
	    for(int j = 0; j < m; j++)
	    {
		tong += arr[i][j];
		if(arr[i][j] > 0)
		{
		    tongDuong += arr[i][j];
		}
		else
		{
		    tongAm += arr[i][j];
		}
		if(arr[i][j]%2 == 0)
		{
		    tongChan += arr[i][j];
		}
		else
		{
		    tongLe += arr[i][j];
		}
	    }
	}
	
	System.out.println("Tổng dãy = " + tong);
	System.out.println("Tổng dương = " + tongDuong);
	System.out.println("Tổng âm = " + tongAm);
	System.out.println("Tổng chẵn = " + tongChan);
	System.out.println("Tổng lẻ = " + tongLe);

	//Bài tập 2: Phương pháp Cramer:
	
	
	
	
	
	
	
    }	
}
