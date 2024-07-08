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
	
	//Prin results
	if(giaTri != 1)
	{
	    System.out.printf("Giá trị đầu tiên nằm trong khoảng [%d,%d] là = %d\n", x, y, giaTri);
	}
	else
	{
	    System.out.println("Không có giá trị nào thỏa mãn điều kiện");
	}
	
	//Bài 8: Cho mảng 1 chiều các số thực. Hãy viết hàm tìm một vị trí trong mảng thỏa 2 điều kiện: có 2 giá trị lân cận và giá trị tại đó bằng tích 2 giá trị lân cận. Nếu mảng không tồn tại giá trị như vậy thì trả về giá trị -1
	
	//Use loop for computing 
	for(int i = 1; i < arr.length-1; i++)
	{
	    if(arr[i] == (arr[i-1]*arr[i+1]))
	    {
		giaTri = arr[i];
		x = arr[i-1];
		y = arr[i+1];
	    }
	}
	
	//Print result
	if(giaTri != -1)
	{
	    System.out.printf("Vị trí trong mảng có tích bằng 2 giá trị lân cận (%d*%d) là = %d\n", x, y, giaTri);
	}
	else
	{
	    System.out.println("Không có giá trị nào thỏa mãn điều kiện");
	}
	
	//Bài 9: Tìm số chính phương đầu tiên trong mảng 1 chiều các số nguyên.
	
	//Use loop for computing
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
	
	//Print results
	if(soChinhPhuong > 0)
	{
	    System.out.println("Số chính phương đầu tiên trong mảng là = " + soChinhPhuong);
	}
	else
	{
	    System.out.println("Không có giá trị nào thỏa mãn điều kiện");
	}	
	
	//Bài 10: Cho mảng 1 chiều các số nguyên. Hãy tìm giá trị đầu tiên thỏa mãn tính chất số gánh.
	//Declare variables needed to find
	int dn = 0, dv = 0, temp = 0;
	
	int arr2[] = new int[arr.length];
	
	//Usee loop to reverse the value
	for(int i = 0; i < arr.length-1; i++)
	{
	    dn = 0; dv = 0; temp = arr[i];
	    while(temp != 0)
	    {
		arr2[i] = temp%10;
		temp /= 10;
		i++;
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
	
	//Declare varibles needed to find
	String strTemp = "", strChuSoDauTien = "";
	int chuSoDauTien = 0, temp = 0;
	
	//Computational processing
	for(int i = 0; i < arr.length; i++)
	{
	    temp = arr[i];
	    if(arr[i] > 9 || arr[i] < -9)
	    {
		do
		{
		    chuSoDauTien = temp;
		    temp /= 10;
		}
		while(temp != 0);
	    }
	    if(chuSoDauTien%2 != 0)
	    {
		giaTri = arr[i];
		break;
	    }
	}
	
	/*
	//Use loop for computing
	for (int i = 0; i < arr.length; i++) {
	    strTemp = "" + arr[i];//Conver Interger to String
	    if (strTemp.startsWith("-")) {//In case of negative values
		strChuSoDauTien = strTemp.substring(1, 2);
		chuSoDauTien = Integer.parseInt(strChuSoDauTien);
		if (chuSoDauTien % 2 != 0) {
		    giaTri = arr[i];
		    break;

		}
	    }
	    else//In case of positive values
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
	
	//Print results
	if(giaTri != -1)
	{
	    System.out.printf("Giá trị đầu tiên trong mảng có chữ số đầu tiên là số lẻ là = %d\n", giaTri);
	}
	else
	{
	    System.out.println("Không có giá trị nào trong mảng thỏa mãn");
	}
	
	//Bài 12: Cho mảng 1 chiều các số nguyên. Hãy viết hàm tìm giá trị đầu tiên trong mảng có dạng 2^k. Nếu mảng không có giá trị dạng 2k thì hàm sẽ trả về 0.
	//Declare varibles needed to find
	int soMu = 0;
	
	//Use loop for computing
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
	
	//Print results
	if(giaTri != -1)
	{
	    System.out.println("Giá trị đầu tiên trong mảng có dạng 2^k là = " + giaTri);
	}
	else
	{
	    System.out.println("Không có giá trị nào trong mảng thỏa mãn điều kiện");
	}
	
	//Bài 13: Cho mảng 1 chiều các số nguyên. Hãy viết hàm tìm giá trị lớn nhất trong mảng có dạng 5^k. Nếu mảng khong tồn tại giá trị 5^k thì hàm sẽ trả về 0
	
	//Declare varibles needed to find
	int temp = 0;
	
	//Use loop for computing
	for(int i = 0; i < arr.length-1; i++)//Sort the array in ascending order
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
	
	//Print results
	if(giaTri != -1)
	{
	    System.out.println("Giá trị lớn nhất trong mảng có dạng 5^k là = " + giaTri);
	}
	else
	{
	    System.out.println("Không có giá trị thỏa mãn");
	}
	
	//Bài 14: Cho mảng 1 chiều các số nguyên. Hãy viết hàm tìm số chẵn nhỏ nhất lớn hơn mọi giá trị có trong mảng.
	int giaTriLonNhat = 0;
	
	//Declare varibles needed to find
	giaTriLonNhat = arr[0];
	
	//Use loop for computing
	for(int i = 1; i < arr.length; i++)
	{
	    if(arr[i] > giaTriLonNhat)
	    {
		giaTriLonNhat = arr[i];
	    }
	}
	
	if(giaTriLonNhat%2 != 0)
	{
	    giaTriLonNhat++;
	}
	else
	{
	    giaTriLonNhat += 2;
	}
	
	//Print results
	System.out.println("Số chẵn nhỏ nhất lớn hơn mọi giá trị có trong mảng là = " + giaTriLonNhat);
	
	//Bài tập 15: Cho mảng 1 chiều các số nguyên. Hãy viết hàm tìm số nguyên tố nhỏ nhất lớn hơn mọi giá trị có trong mảng.
	
	//Declare varibles needed to find
	int soNguyenToLonNhat = 0, giaTriCanTim = 0, count = 0;
	
	//Set default value
	soNguyenToLonNhat = arr[0];
	
	for(int i = 0; i < arr.length; i++)
	{
	    if(arr[i] > soNguyenToLonNhat)
	    {
		soNguyenToLonNhat = arr[i];
	    }
	}
	
	//Use loop for computing
	do
	{
	    soNguyenToLonNhat++;
	    for(int i = 1; i <= soNguyenToLonNhat; i++)
	    {
		if(soNguyenToLonNhat%i == 0)
		{
		    count++;
		    if(count > 2)
		    {
			break;
		    }
		}
	    }
	    if(soNguyenToLonNhat > 1 && count == 2)
	    {
		giaTriCanTim = soNguyenToLonNhat;
		break;
	    }
	    count = 0;	    
	}
	while(soNguyenToLonNhat < 0 || soNguyenToLonNhat >= 0);

	//Print results
	System.out.println("Số nguyên tố nhỏ nhất lớn hơn mọi giá trị có trong mảng là = " + giaTriCanTim);
	
	*/
		
	//Bài tập 16: Cho mảng 1 chiều các số nguyên. Hãy viết hàm tìm ước chung lớn nhất của tất cả các phần tử trong mảng.
	
	//Declare variables
	int uocChungLonNhat = 0, temp = 0, soNho = 0;
	
	//Use loop for sorting the array in ascending order
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
	
	//Use loop for computing greatest common divisor
	for(int i = arr[0]; i <= arr[arr.length-1]; i--)
	{
	    for(int j = 0; j < arr.length; j++)
	    {
		soNho += arr[j]%i;
	    }
	    if(soNho == 0)
	    {
		uocChungLonNhat = i;
		break;
	    } 
	    else
	    {
		soNho = 0;
	    }
	}
	
	//Print results
	System.out.println("Ước chung lớn nhất của dãy là = " + uocChungLonNhat);
	int detA1[] = new int[arr.length];
	int n = 0;
	for(int gt: arr)
	{
	    detA1[n] = arr[n];
	    n++;
	}	
	
	/*

	//Bài tập 17: Cho mảng 1 chiều các số nguyên. Hãy viết hàm tìm bội chung nhỏ nhất của tất cả các phần tử trong mảng.
	
	//Declare variables
	int boiChungNhoNhat = 0, max = 0, soNho = 0, temp = 0;
	
	//Default
	max = arr[0];
	
	//Use loop for sorting the array in descending order
	for(int i = 0; i < arr.length-1; i++)
	{
	    for(int j = i+1; j < arr.length; j++)
	    {
		if(arr[i] < arr[j])
		{
		    temp = arr[i];
		    arr[i] = arr[j];
		    arr[j] = temp;
		}
	    }
	}
	
	//Use loop for computing the least common multiple
	
	for (int i = 1; i >= 1; i++) {
	    for (int j = 1; j < arr.length; j++) {
		soNho += (arr[0] * i) % arr[j];
	    }
	    if (soNho == 0) {
		boiChungNhoNhat = arr[0]*i;
		break;
	    } else {
		soNho = 0;
	    }
	}
	
	//Print results
	System.out.println("Bội chung nhỏ nhất của dãy là = " + boiChungNhoNhat);
    
	//Bài 18: Cho mảng 1 chiều các số nguyên. Hãy viết hàm tìm chữ số xuất hiện ít nhất trong mảng.
	
	//Declare variables
	String strNhap = "";
	
	//Declare array
	int ketQua[] = new int[10];
	List<Integer> lstKetQua = new ArrayList<>();
	
	//Convert Integer[] to String
	for(int i = 0; i < arr.length; i++)
	{
	    strNhap += "" + arr[i];
	}
	
	//Convert String to Char[]
	char chuoiNhap[] = strNhap.toCharArray();
	
	//Use for to count the characters
	for(int i = 0; i < chuoiNhap.length; i++)
	{
	    if(chuoiNhap[i] == '0')
	    {
		ketQua[0]++;
	    }
	    if(chuoiNhap[i] == '1')
	    {
		ketQua[1]++;
	    }
	    if(chuoiNhap[i] == '2')
	    {
		ketQua[2]++;
	    }
	    if(chuoiNhap[i] == '3')
	    {
		ketQua[3]++;
	    }
	    if(chuoiNhap[i] == '4')
	    {
		ketQua[4]++;
	    }
	    if(chuoiNhap[i] == '5')
	    {
		ketQua[5]++;
	    }
	    if(chuoiNhap[i] == '6')
	    {
		ketQua[6]++;
	    }
	    if(chuoiNhap[i] == '7')
	    {
		ketQua[7]++;
	    }
	    if(chuoiNhap[i] == '8')
	    {
		ketQua[8]++;
	    }
	    if(chuoiNhap[i] == '9')
	    {
		ketQua[9]++;
	    }	    
	}
	
	//Set default value
	int min = 0;
	
	//Use for to find the lowest value
	for(int i = 0; i < ketQua.length; i++)
	{
	    if(ketQua[i] != 0)
	    {
		min = ketQua[i];
		break;
	    }
	}
	
	for(int i = 0; i < ketQua.length; i++)
	{
	    if(ketQua[i] != 0)
	    {
		if(ketQua[i] < min)
		{
		    min = ketQua[i];
		}
	    }
	}

	for(int i = 0; i < ketQua.length; i++)
	{
	    if(ketQua[i] == min)
	    {
		lstKetQua.add(i);
	    }
	    
	}
	
	//Print results
	System.out.println("Các chữ số xuất hiện ít nhất trong dãy là = ");
	for(int i = 0; i < lstKetQua.size(); i++)
	{
	    System.out.print(lstKetQua.get(i) + "\t");    
	}
	System.out.println("");
	
	System.out.printf("Với số lần xuất hiện là = %d (lần)\n", min);
	
	//Bài 19: Cho mảng số thực có nhiều hơn 2 giá trị và các giá trị trong mảng khác nhau từng đôi một. Hãy viết hàm liệt kê tất cả các cặp giá trị (a, b) trong mảng thỏa điều kiện a <= b.
	
	//Declare variables
	int temp = 0;
	
	//Declare array list
	List<Integer> lstChuoiMoi = new ArrayList<Integer>();	
	
	//Use loop for sorting the array in ascending order
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
	
	//Assign the value to the arrray list
	for(int gt: arr)
	{
	    lstChuoiMoi.add(gt);
	}	
	
	//Use loop to remove the equal values in the array
	for(int i = 0; i < lstChuoiMoi.size()-1; i++)
	{
	    for(int j = i+1; j < lstChuoiMoi.size(); j++)
	    {
		if(lstChuoiMoi.get(i) == lstChuoiMoi.get(j))
		{
		    lstChuoiMoi.remove(j);
		    j = i;
		}
	    }
	}	
	
	//Declare array list
	List<String> lstCapSo = new ArrayList<>();
	
	//Use loop to find pairs of values that satisfy the condition in the array
	for(int i = 0; i < lstChuoiMoi.size()-1; i++)
	{
	    for(int j = i+1; j < lstChuoiMoi.size(); j++)
	    {
		if(lstChuoiMoi.get(i) != lstChuoiMoi.get(j))
		{
		    lstCapSo.add(lstChuoiMoi.get(i) + "," + lstChuoiMoi.get(j));
		}
	    }
	}
	System.out.println("Tất cả các cặp giá trị (a, b) trong mảng thỏa điều kiện a <= b là: ");
	for(String gt: lstCapSo)
	{
	    System.out.print("" + gt + "\t");
	}
	System.out.println("");
	
	//Bài 20: Cho mảng số thực có nhiều hơn 2 giá trị và các giá trị trong mảng khác nhau từng đôi một. Hãy viết hàm tìm 2 giá trị gần nhau nhất trong mảng (Lưu ý: Mảng có các giá trị khác nhau từng đôi một còn có tên là mảng phân biệt).

	//Declare variables
	int temp = 0;
	
	//Declare array list
	List<Integer> lstChuoiMoi = new ArrayList<Integer>();	
	
	//Use loop for sorting the array in ascending order
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
	
	//Assign the value to the arrray list
	for(int gt: arr)
	{
	    lstChuoiMoi.add(gt);
	}	
	
	//Use loop to remove the equal values in the array
	for(int i = 0; i < lstChuoiMoi.size()-1; i++)
	{
	    for(int j = i+1; j < lstChuoiMoi.size(); j++)
	    {
		if(lstChuoiMoi.get(i) == lstChuoiMoi.get(j))
		{
		    lstChuoiMoi.remove(j);
		    j = i;
		}
	    }
	}	
	
	//Declare array list
	List<Integer> lstCapSo = new ArrayList<Integer>();
	List<String> lstCapSo2 = new ArrayList<String>();
	
	//Use loop to find pairs of numbers that satisfy the condition in the array
	for(int i = 0; i < lstChuoiMoi.size()-1; i++)
	{
	    for(int j = i+1; j < lstChuoiMoi.size(); j++)
	    {
		lstCapSo.add(lstChuoiMoi.get(j) - lstChuoiMoi.get(i));
		lstCapSo2.add(lstChuoiMoi.get(i) + "," + lstChuoiMoi.get(j));
	    }
	}
	
	//Set default value
	int min = lstCapSo.get(0);

	//Use loop to find the lowest values
	for(int i = 0; i < lstCapSo.size(); i++)
	{
	    if(lstCapSo.get(0) < min)
	    {
		min = lstCapSo.get(i);
	    }
	}
	
	//Use loop to find pair of values that satisfy the condition in the array
	System.out.println("Các cặp giá trị gần nhau nhất trong mảng là: ");
	for(int i = 0; i < lstCapSo.size(); i++)
	{
	    if(lstCapSo.get(i) == min)
	    {
		System.out.print(lstCapSo2.get(i) + "\t");
	    }
	}
	System.out.println("");
	
	*/
	
	
    }
}
