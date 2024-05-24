/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baitapvoimang_part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class NamCat_BaiTapVoiMang_Part2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
	//Declare an object to enter information from the keyboard
	Scanner sc = new Scanner(System.in);
	
	/*
	
	//Bài 1,2: Hãy tìm giá trị trong mảng các số thực xa, gần giá trị x nhất.
	//Decalre variables
	double x = 0, max = 0, min = 0, temp = 0;
	System.out.print("Nhập x = ");
	x = sc.nextDouble();
	
	//Declare array
	int n = 0, idx1 = 0, idx2 = 0;
	System.out.print("Nhập mảng gồm n số thực với n = ");
	n = sc.nextInt();
	double arr[] = new double[n];
	double arr2[] = new double[n];
	
	System.out.println("Nhập giá trị cho các phần tử của mảng: ");
	for(int i = 0; i < arr.length; i++)
	{
	    System.out.printf("arr[%d] = ",i);
	    arr[i] = sc.nextDouble();
	}
	
	//Computational processing
	for(int i = 0; i < arr.length; i++)
	{
	    arr2[i] = Math.abs(arr[i] - x);
	}
	
	//Default
	max = arr2[0];
	for(int i = 0; i < arr2.length; i++)
	{
	    if(arr2[i] > max)
	    {
		idx1 = i;
	    }
	    else
	    {
		idx1 = 0;
	    }
	}
	
	System.out.printf("Giá trị trong mảng xa %.1f nhất là = %.1f\n",x,arr[idx1]);
	
	//Default
	min = arr2[0];
	for(int i = 0; i < arr2.length; i++)
	{
	    if(arr2[i] < min)
	    {
		idx2 = i;
	    }
	    else
	    {
		idx2 = 0;
	    }
	}	
	
	System.out.printf("Giá trị trong mảng gần %.1f nhất là = %.1f\n",x,arr[idx2]);


	
	//Bài 3: Cho mảng 1 chiều các số thực, hãy tìm đoạn [a, b] sao cho đoạn này chứa tất cả các giá trị trong mảng
	//Default
	max = arr[0];
	min = arr[0];
	for(int i = 0; i < arr.length; i++)
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
	
	System.out.printf("Đoạn [] chứa tất cả các giá trị trong mảng là = [%d,%d]", (int)min, (int)max);		
	
	//Bài 4: Cho mảng 1 chiều các số thực, hãy tìm giá trị x sao cho đoạn [-x, x] chứa tất cả các giá trị trong mảng.
	//Default
	max = arr[0];
	
	for(int i = 0; i < arr.length; i++)
	{
	    if(Math.abs(arr[i]) > max)
	    {
		max = Math.abs(arr[i]);
	    }
	}
	
	System.out.printf("Đoạn [] thỏa mãn điều kiện là = [-%d,%d]", (int)max, (int)max);
	
	//Bài 5: Cho mảng 1 chiều các số thực, hãy tìm giá trị đầu tiên lớn hơn giá trị 2003. Nếu mảng không có giá trị thỏa điều kiện trên thì trả về -1
	double giaTri = -1;
	
	for(int i = 0; i < arr.length; i++)
	{
	    if(arr[i] > 2003.0)
	    {
		giaTri = arr[i];
		break;
	    }
	}	
	
	if(giaTri > 2003.0)
	{
	    System.out.printf("Giá trị đầu tiên trong mảng lớn hơn 2003 là = %.1f\n",giaTri);
	}
	else
	{
	    System.out.println("Không có giá trị nào thỏa mãn điều kiện");
	}
	
	//Bài 6: Cho mảng 1 chiều các số thực, hãy tìm giá trị âm cuối cùng lớn hơn giá trị -1. Nếu mảng không có giá trị thỏa điều kiện trên thì trả về -1.
	double giaTri = -1;	
	
	for(int i = 0; i < arr.length; i++)
	{
	    if(arr[i] > -1 && arr[i] < 0)
	    {
		giaTri = arr[i];
	    }
	}
	
	if(giaTri != -1)
	{
	    System.out.println("Giá trị âm cuối cùng lớn hơn -1 trong dãy là = " + giaTri);	
	}
	else
	{
	    System.out.println("Không có giá trị nào thỏa mãn điều kiện");
	}
	
	*/

	//Bài 7: Cho mảng 1 chiều các số nguyên, hãy tìm giá trị đầu tiên nằm trong khoảng [x, y] cho trước. Nếu mảng không có giá trị thỏa điều kiện trên thì trả về -1
	
	//Enter the number of elements in array
	int m = 0, x = 0, y = 0, giaTri = -1, soChinhPhuong = 0;
	System.out.print("Nhập mảng gồm m phần tử với m = ");
	m = sc.nextInt();
	
	//Declare array
	int arr[] = new int[m];
	
	//Enter the value for elements in the array
	System.out.println("Nhập giá trị cho các phần tử của mảng: ");
	for(int i = 0; i < arr.length; i++)
	{
	    System.out.printf("arr[%d] = ", i);
	    arr[i] = sc.nextInt();
	}
	
	//Show the array
	System.out.println("Các phần tử của mảng là: ");
	for(int i = 0; i < arr.length; i++)
	{
	    System.out.printf("arr[%d] = %d\n", i, arr[i]);
	}
	
	/*
	
	//Enter the range
	do
	{
	    System.out.print("Nhập x = ");
	    x = sc.nextInt();
	    System.out.print("Nhập y = ");
	    y = sc.nextInt();	    
	}
	while(x >= y);
	
	for(int i = 0; i < arr.length; i++)
	{
	    if(arr[i] >= x && arr[i] <= y)
	    {
		giaTri = arr[i];
		break;
	    }
	}
	
	if(giaTri != 1)
	{
	    System.out.printf("Giá trị đầu tiên nằm trong khoảng [%d,%d] là = %d\n", x, y, giaTri);
	}
	else
	{
	    System.out.println("Không có giá trị nào thỏa mãn điều kiện");
	}
	
	//Bài 8: Cho mảng 1 chiều các số thực. Hãy viết hàm tìm một vị trí trong mảng thỏa 2 điều kiện: có 2 giá trị lân cận và giá trị tại đó bằng tích 2 giá trị lân cận. Nếu mảng không tồn tại giá trị như vậy thì trả về giá trị -1
	
	for(int i = 1; i < arr.length-1; i++)
	{
	    if(arr[i] == (arr[i-1]*arr[i+1]))
	    {
		giaTri = arr[i];
		x = arr[i-1];
		y = arr[i+1];
	    }
	}
	
	if(giaTri != 1)
	{
	    System.out.printf("Vị trí trong mảng có tích bằng 2 giá trị lân cận (%d*%d) là = %d\n", x, y, giaTri);
	}
	else
	{
	    System.out.println("Không có giá trị nào thỏa mãn điều kiện");
	}
	
	//Bài 9: Tìm số chính phương đầu tiên trong mảng 1 chiều các số nguyên.
	
	for(int i = 0; i < arr.length; i++)
	{
	    for(int j = 1; j <= arr[i]; j++)
	    {
		if(arr[i] == j*j)
		{
		    soChinhPhuong = arr[i];
		    break;
		}
	    }
	}
	
	if(soChinhPhuong > 0)
	{
	    System.out.println("Số chính phương đầu tiên trong mảng là = " + soChinhPhuong);
	}
	else
	{
	    System.out.println("Không có giá trị nào thỏa mãn điều kiện");
	}	
	
	//Bài 10: Cho mảng 1 chiều các số nguyên. Hãy tìm giá trị đầu tiên thỏa mãn tính chất số gánh.
	int dn = 0, dv = 0, temp = 0;
	for(int i = 0; i < arr.length-1; i++)
	{
	    dn = 0; dv = 0; temp = arr[i];
	    while(temp != 0)
	    {
		dv = temp%10;
		dn = dn*10 + dv;
		temp = temp/10;
	    }
	    if(dn == arr[i+1])
	    {
		System.out.printf("Giá trị đầu tiên trong mảng thỏa mãn tính chất số gánh là arr[%d] = %d\n", i, arr[i]);
		break;
	    }
	    
	}
	
	if(dn != arr[arr.length-1])
	{
	    System.out.println("Không có giá trị nào trong mảng thỏa mãn điều kiện");
	}
	
	//Bài 11: Cho mảng 1 chiều các số nguyên. Hãy tìm giá trị đầu tiên có chữ số đầu tiên là chữ số lẻ.
	
	String strTemp = "", strChuSoDauTien = "";
	
	int chuSoDauTien = 0;
	
	for (int i = 0; i < arr.length; i++) {
	    strTemp = "" + arr[i];
	    if (strTemp.startsWith("-")) {
		strChuSoDauTien = strTemp.substring(1, 2);
		chuSoDauTien = Integer.parseInt(strChuSoDauTien);
		if (chuSoDauTien % 2 != 0) {
		    giaTri = arr[i];
		    break;

		}
	    }
	    else
	    {
		strChuSoDauTien = strTemp.substring(0, 1);
		chuSoDauTien = Integer.parseInt(strChuSoDauTien);
		if(chuSoDauTien % 2 != 0)
		{
		    giaTri = arr[i];
		    break;		    
		}
	    }
	}
	
	if(giaTri != -1)
	{
	    System.out.printf("Giá trị đầu tiên trong mảng có chữ số đầu tiên là số lẻ là = %d\n", giaTri);
	}
	else
	{
	    System.out.println("Không có giá trị nào trong mảng thỏa mãn");
	}
	
	//Bài 12: Cho mảng 1 chiều các số nguyên. Hãy viết hàm tìm giá trị đầu tiên trong mảng có dạng 2^k. Nếu mảng không có giá trị dạng 2k thì hàm sẽ trả về 0.
	
	int soMu = 0;
	for(int i = 0; i < arr.length; i++)
	{
	    for(int j = 0; j < arr[i]; j++)
	    {
		if(arr[i] == Math.pow(2, j))
		{
		    giaTri = arr[i];
		    soMu = j;
		    break;
		}
	    }
	    if(giaTri != -1)
	    {
		break;
	    }
	}
	
	if(giaTri != -1)
	{
	    System.out.println("Giá trị đầu tiên trong mảng có dạng 2^k là = " + giaTri);
	}
	else
	{
	    System.out.println("Không có giá trị nào trong mảng thỏa mãn điều kiện");
	}
	
	//Bài 13: Cho mảng 1 chiều các số nguyên. Hãy viết hàm tìm giá trị lớn nhất trong mảng có dạng 5^k. Nếu mảng khong tồn tại giá trị 5^k thì hàm sẽ trả về 0
	
	int temp = 0;
	
	for(int i = 0; i < arr.length-1; i++)
	{
	    for(int j = i+1; j < arr.length; j++)
	    {
		if(arr[i] > arr[j])
		{
		    temp = arr[i];
		    arr[i] = arr[j];
		    arr[j] = temp;
		}
	    }     
	}
	
	for(int i = 0; i < arr.length; i++)
	{
	    for(int j = 0; j < arr[i]; j++)
	    {
		if(arr[i] == Math.pow(5, j))
		{
		    giaTri = arr[i];
		}
	    }
	}
	
	if(giaTri != -1)
	{
	    System.out.println("Giá trị lớn nhất trong mảng có dạng 5^k là = " + giaTri);
	}
	else
	{
	    System.out.println("Không có giá trị thỏa mãn");
	}
	
	*/
	
	double a = Math.log(25);
	
	System.out.println("" + a);
	
	
    }
}
