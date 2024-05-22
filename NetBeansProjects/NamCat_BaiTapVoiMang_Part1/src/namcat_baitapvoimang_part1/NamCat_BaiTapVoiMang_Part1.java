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
	
	/*
	
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

	//Bài tập 5: Hãy nhập vào 16 số nguyên. In ra thành 4 dòng, 4 cột.
	//Declara number of elements in the array
	int r = 0, c = 0;
	System.out.print("Nhập số dòng của mảng = ");//Rows
	r = sc.nextInt();
	System.out.print("Nhập số cột của mảng = ");//Colums
	c = sc.nextInt();
	
	//Declare array
	int arr[][] = new int[r][c];
	
	//Enter the value for elements in the array
	System.out.println("Nhập giá trị cho các phần tử của mảng: ");
	for(int i = 0; i < r; i++)
	{
	    for(int j = 0; j < c; j++)
	    {
		System.out.printf("arr[%d][%d] = ", i,j);
		arr[i][j] = sc.nextInt();
	    }
	}
	System.out.println("");
	
	//Print results
	System.out.printf("Các phần tử của mảng %dx%d là: \n", r, c);
	for(int i = 0; i < r; i++)
	{
	    for(int j = 0; j < c; j++)
	    {
		System.out.printf("arr[%d][%d] = %d\t", i , j, arr[i][j]);
	    }
	    System.out.println("");
	}
	
	//Bài tập 6: Cho một chuỗi ký tự như sau: “Cong ty Stanford – Dao tao va phat trien cong nghe”. Hãy chuyển chuỗi này thành một mảng, trong đó mỗi phần tử là một từ. Ví dụ a[0] = Cong, a[1] = ty, a[2] = Stanford,…Sau đó in kết quả ra màn hình.
	
	//Declare String
	String strData = "Cong ty Stanford – Dao tao va phat trien cong nghe";
	
	//Convert String to Array
	String arr[] = strData.split(" ");
	
	//Print results
	System.out.println("Các từ lấy được từ chuỗi đã chia là: ");
	for(String gt: arr)
	{
	    System.out.println(gt);		    
	}
	
	//Bài tập 8: Nhập ma trận 4x4, báo ra: Số các phần tử lớn hơn 0, liệt kê các phần tử lớn hơn 0 đó, tính tổng của chúng.- Số các phần tử nhỏ hơn 0, liệt kê các phần tử nhỏ hơn 0 đó, tính tổng của chúng.
	//Declare number of elements in the array
	int r = 0, c = 0;
	System.out.print("Nhập số dòng của mảng = ");
	r = sc.nextInt();
	System.out.print("Nhập số cột của mảng = ");
	c = sc.nextInt();
	
	//Declare array
	int arr[][] = new int[r][c];
	
	//Enter the value for elements in the array
	System.out.println("Nhập giá trị cho các phần tử của mảng: ");
	for(int i = 0; i < r; i++)
	{
	    for(int j = 0; j < c; j++)
	    {
		System.out.printf("arr[%d][%d] = ",i,j);
		arr[i][j] = sc.nextInt();
	    }
	}
	
	//Print array
	System.out.printf("Các giá trị của mảng %dx%d là: \n",r,c);
	for(int i = 0; i < r; i++)
	{
	    for(int j = 0; j < c; j++)
	    {
		System.out.printf("arr[%d][%d] = %d\t",i,j,arr[i][j]);
	    }
	    System.out.println("");
	}	
	
	//Computational processing
	int duong = 0, am = 0, tongDuong = 0, tongAm = 0;
	int arrDuong[] = new int[16];
	int arrAm[] = new int[16];
	
	//Use loop to find positive and negative elements
	for(int i = 0; i < r; i++)
	{
	    for(int j = 0; j < c; j++)
	    {
		if(arr[i][j] >= 0)
		{
		    arrDuong[duong] = arr[i][j];
		    duong++;
		}
		else
		{
		    arrAm[am] = arr[i][j];
		    am++;		    
		}
	    }
	}	
	
	//Print results
	System.out.println("Các phần tử dương là: ");
	for(int i = 0; i < duong; i++)
	{
	    System.out.printf("arr[%d] = %d\t", i, arrDuong[i]);
	    tongDuong += arrDuong[i];
	}
	System.out.println("");
	
	System.out.println("Các phần tử âm là: ");
	for(int i = 0; i < am; i++)
	{
	    System.out.printf("arr[%d] = %d\t", i, arrAm[i]);
	    tongAm += arrAm[i];
	}	
	System.out.println("");
	
	System.out.printf("Tổng giá trị của các phần tử dương = %d\n", tongDuong);
	System.out.printf("Tổng giá trị của các phần tử âm = %d\n", tongAm);
	
	*/
	
	//Bài tập 11:  Hãy nhập một xâu kí tự. In ra màn hình đảo ngược của xâu đó.
	//Declare String
	String strData = "";
	System.out.print("Nhập vào 1 chuỗi: ");
	strData = sc.nextLine();
	
	//Convert String to Char[] and reverse the Char[]
	char arr[] = strData.toCharArray();
	System.out.print("Chuỗi đảo ngược là: ");
	for(int i = arr.length-1; i >= 0; i--)
	{
	    System.out.print(arr[i]);
	}
	System.out.println("");
	
	//Bài tập 13: Nhập xâu. In ra tất các các vị trí của chữ ‘a’ trong xâu và tổng số lần xuất hiện của nó.
	//Declare variables
	char a;
	System.out.print("Nhập kí tự cần tìm trong xâu: ");
	a = sc.next().charAt(0);
	int soLan = 0;
	
	//Use for to find number of occurrences
	System.out.printf("Vị trí của kí tự %s trong xâu là: \n",a);
	for(int i = 0; i < arr.length; i++)
	{
	    if(arr[i] == 'a')
	    {
		soLan++;
		System.out.print(i + "\t");
	    }
	}
	System.out.println("");
	
	//Print results
	System.out.printf("Số lần xuất hiện của kí tự %s trong xâu là: %d\n", a,soLan);
    } 
}
