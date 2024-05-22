/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package namcat_baitapvoimang_part1;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class NamCat_BaiTapVoiMang_Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
	//Declare an object to enter information from the keyboard
	Scanner sc = new Scanner(System.in);
	
	//Declare number of elements in the array
	int n = 0;
	System.out.print("Nhập mảng gồm n phần tử với n = ");
	n = sc.nextInt();
	
	//Declare array
	double arr[] = new double[n];
	System.out.println("Nhập giá trị cho các phần tử của mảng: ");
	for(int i = 0; i < n; i++)
	{
	    System.out.print("arr["+ i +"] = ");
	    arr[i] = sc.nextDouble();
	}
	
	//Print results
	System.out.println("Các phần tử của mảng gồm: ");
	for(int i = 0; i < arr.length; i++)
	{
	    System.out.printf("%.1f \t", arr[i]);
	}
	System.out.println("");
	
	/*
	
	//Bài tập 1: Nhập vào dãy n số thực. Tính tổng dãy, trung bình dãy, tổng các số âm, dương và tổng các số ở vị trí chẵn, vị trí lẻ trong dãy.
	
	//Declare variables
	double tongDay = 0, trungBinhDay = 0, tongSoAm = 0, tongSoDuong = 0, tongChan = 0, tongLe = 0;
	
	//Computational processing
	for(int i = 0; i < n; i++)
	{
	    tongDay += arr[i];
	    if(arr[i] >= 0)
	    {
		tongSoDuong += arr[i];
	    }
	    else
	    {
		tongSoAm += arr[i];
	    }
	    if(i%2 ==0)
	    {
		tongChan += arr[i];
	    }
	    else
	    {
		tongLe += arr[i];
	    }
	}
	
	trungBinhDay = tongDay/n;
	
	//Print results
	System.out.printf("Tổng dãy của mảng là = %.1f\n", tongDay);
	System.out.printf("Trung bình dãy của mảng là = %.1f\n", trungBinhDay);
	System.out.printf("Tổng các số dương của mảng là = %.1f\n", tongSoDuong);
	System.out.printf("Tổng các số âm của mảng là = %.1f\n", tongSoAm);
	System.out.printf("Tổng các số ở vị trí chẵn của mảng là = %.1f\n", tongChan);
	System.out.printf("Tổng các số ở vị trí lẻ của mảng là = %.1f\n", tongLe);
	System.out.println("");
	
	//Bài tập 2: Tìm và chỉ ra vị trí xuất hiện đầu tiên của phần tử x trong dãy.
	//Declare varibles
	double x = 0;
	System.out.print("Nhập giá trị x cần tìm = ");
	x = sc.nextDouble();
	
	//Go through the loop to find 'x'
	for(int i = 0; i < n; i++)
	{
	    if(arr[i] == x)
	    {
		System.out.printf("Vị trí xuất hiện đầu tiên của %.2f trong dãy là: %d\n", x, i+1);
		break;
	    }
	}
	System.out.println("");
	
	//Bài tập 3: Nhập vào dãy n số. Hãy in ra số lớn nhất, bé nhất của dãy.
	//Declare variables
	double max = 0, min = 0;
	
	//Set the default value
	max = arr[0];
	min = arr[0];
	
	//Go through the loop to find the max, min
	for(int i = 1; i < n; i++)
	{
	    if(arr[i] > max)
	    {
		max = arr[i];
	    }
	    if(arr[i] < min)
	    {
		min = arr[i];
	    }
	}
	
	//Print results
	System.out.printf("Giá trị lớn nhất của dãy là: %.2f\n", max);
	System.out.printf("Giá trị nhỏ nhất của dãy là: %.2f\n", min);
		
	//Bài tập 4: Nhập vào dãy số. In ra dãy đã được sắp xếp tăng dần, giảm dần.
	//Declare variables
	double temp = 0;
	//Go through the loop to sort the array in ascending order
	for(int i = 0; i < n-1; i++)
	{
	    for(int j = i+1; j < n; j++)
	    {
		if(arr[i] > arr[j])
		{
		    //Perform value swaps
		    temp = arr[j];
		    arr[j] = arr[i];
		    arr[i] = temp; 		    
		}
	    }
	}
	
	//Print results
	System.out.println("Dãy được sắp xếp tăng dần như sau: ");
	for(int i = 0; i < n; i++)
	{
	    System.out.printf("%.1f \t", arr[i]);
	}
			
	//Go through the loop to sort the array in descending order
	for(int i = 0; i < n-1; i++)
	{
	    for(int j = i+1; j < n; j++)
	    {
		if(arr[i] < arr[j])
		{
		    //Perform value swaps
		    temp = arr[j];
		    arr[j] = arr[i];
		    arr[i] = temp; 		    
		}
	    }
	}
	
	//Print results
	System.out.println("Dãy được sắp xếp giảm dần như sau: ");
	for(int i = 0; i < n; i++)
	{
	    System.out.printf("%.1f \t", arr[i]);
	}

	*/

	//Bài tập 5: Hãy nhập vào 16 số nguyên. In ra thành 4 dòng, 4 cột.
	

	
	
	
    } 
}
