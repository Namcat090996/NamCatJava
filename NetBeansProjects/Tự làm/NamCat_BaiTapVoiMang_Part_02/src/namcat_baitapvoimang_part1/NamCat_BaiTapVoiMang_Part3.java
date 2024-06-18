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
   
	/*
	
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

	/*
	
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

	*/

	//Bài tập 2: Phương pháp Cramer:
	
	//Declare variables
	double a = 0, b = 0, c = 0;
	double det0A = 0, det1A = 0, det2A = 0, det3A = 0;
	double x1 = 0, x2 = 0, x3 = 0;
	
	//Take user information entered from the keyboard
	System.out.print("Nhập a = ");
	a = sc.nextDouble();
	System.out.print("Nhập b = ");
	b = sc.nextDouble();	
	System.out.print("Nhập c = ");
	c = sc.nextDouble();
	
	//Declare array
	double arr2[][] = new double[3][3];
	double cotTuDo[] = new double[3];
	double detA[][] = new double[3][3];
	double detA1[][] = new double[3][3];
	double detA2[][] = new double[3][3];
	double detA3[][] = new double[3][3];
	
	//Assign value for elements in the array
	//arr2[][]
	arr2[0][0] = a;
	arr2[0][1] = b;
	arr2[0][2] = 0;
	arr2[1][0] = 0;
	arr2[1][1] = c;
	arr2[1][2] = a;	
	arr2[2][0] = c;
	arr2[2][1] = 0;
	arr2[2][2] = b;
	
	//cotTuDo[]
	cotTuDo[0] = c;
	cotTuDo[1] = b;
	cotTuDo[2] = a;
	
	//Assign values for detA1, detA2 & detA3 array
	for(int j = 0; j < 3; j++)
	{
	    for(int i = 0; i < 3; i++)
	    {
		detA[i][j] = arr2[i][j];
		detA1[i][j] = arr2[i][j];	
		detA2[i][j] = arr2[i][j];
		detA3[i][j] = arr2[i][j];
	    }

	}
	
	//Replace the column values of detA1, detA2 & detA3 array
	for(int j = 0; j < 3; j++)
	{
	    for(int i = 0; i < 3; i++)
	    {
		if(j == 0)
		{
		    detA1[i][j] = cotTuDo[i];		    
		}
		if(j == 1)
		{
		    detA2[i][j] = cotTuDo[i];		    
		}		
		if(j == 2)
		{
		    detA3[i][j] = cotTuDo[i];		    
		}	
	    }
	}
	
	//Computational processing
	det0A = detA[0][0]*detA[1][1]*detA[2][2] + detA[0][1]*detA[1][2]*detA[2][0] + detA[0][2]*detA[1][0]*detA[2][1] - detA[2][0]*detA[1][1]*detA[0][2] - detA[2][1]*detA[1][2]*detA[0][0] - detA[2][2]*detA[1][0]*detA[0][1];	
		
	det1A = detA1[0][0]*detA1[1][1]*detA1[2][2] + detA1[0][1]*detA1[1][2]*detA1[2][0] + detA1[0][2]*detA1[1][0]*detA1[2][1] - detA1[2][0]*detA1[1][1]*detA1[0][2] - detA1[2][1]*detA1[1][2]*detA1[0][0] - detA1[2][2]*detA1[1][0]*detA1[0][1];
	
	det2A = detA2[0][0]*detA2[1][1]*detA2[2][2] + detA2[0][1]*detA2[1][2]*detA2[2][0] + detA2[0][2]*detA2[1][0]*detA2[2][1] - detA2[2][0]*detA2[1][1]*detA2[0][2] - detA2[2][1]*detA2[1][2]*detA2[0][0] - detA2[2][2]*detA2[1][0]*detA2[0][1];
	
	det3A = detA3[0][0]*detA3[1][1]*detA3[2][2] + detA3[0][1]*detA3[1][2]*detA3[2][0] + detA3[0][2]*detA3[1][0]*detA3[2][1] - detA3[2][0]*detA3[1][1]*detA3[0][2] - detA3[2][1]*detA3[1][2]*detA3[0][0] - detA3[2][2]*detA3[1][0]*detA3[0][1];
	
	x1 = det1A/det0A;   x2 = det2A/det0A;	x3 = det3A/det0A;  
	
	//Print results
	System.out.println("Nghiệm của phương trình là: ");
	System.out.printf("x1 = %.2f\n", x1);
	System.out.printf("x2 = %.2f\n", x2);
	System.out.printf("x3 = %.2f\n", x3);

	


	
    }	
}
