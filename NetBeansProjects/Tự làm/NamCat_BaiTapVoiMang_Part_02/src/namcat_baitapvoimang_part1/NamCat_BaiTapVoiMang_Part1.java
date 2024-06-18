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
	
	//Declare number of rows and columns in the array
	int r = 0, c = 0;
	System.out.print("Nhập số dòng của mảng: ");
	r = sc.nextInt();
	System.out.print("Nhập số cột của mảng: ");
	c = sc.nextInt();
	
	//Declare array
	double arr[][] = new double[r][c];
	
	//Enter the value for elements in the array
	System.out.println("Nhập giá trị cho các phần tử của mảng: ");
	for(int i = 0; i < r; i++)
	{
	    for(int j = 0; j < c; j++)
	    {
		System.out.printf("arr[%d][%d] = ",i,j);
		arr[i][j] = sc.nextDouble();
	    }
	}
	
	//Print results
	System.out.println("Giá trị các phần tử của mảng gồm: ");
	for(int i = 0; i < r; i++)
	{
	    for(int j = 0; j < c; j++)
	    {
		System.out.printf(arr[i][j] + "\t");
	    }
	    System.out.println("");
	}
	
	//Declare variables
	int duong = 0, am = 0; double tongSoDuong = 0, tongSoAm = 0;
	double tongDuong[] = new double[16];
	double tongAm[] = new double[16];
	
	//Use loop to find positive and negative elements
	for(int i = 0; i < r; i++)
	{
	    for(int j = 0; j < c; j++)
	    {
		if(arr[i][j] >= 0)
		{
		    tongDuong[duong] = arr[i][j]; 
		    duong++;
		}
		else
		{
		    tongAm[am] = arr[i][j]; 
		    am++;
		}
	    }
	}
	
	//Print results	
	System.out.println("Các phần tử lớn hơn 0 gồm: ");
	for(int i = 0; i < duong; i++)
	{
	    System.out.printf("%.2f \t", tongDuong[i]);
	    tongSoDuong += tongDuong[i];
	}
	System.out.println("");
	
	System.out.println("Các phần tử bé hơn 0 gồm: ");
	for(int i = 0; i < am; i++)
	{
	    System.out.printf("%.2f \t", tongAm[i]);
	    tongSoAm += tongAm[i];
	}
	System.out.println("");
	
	System.out.printf("Tổng các số dương là = %.2f\n", tongSoDuong);
	System.out.printf("Tổng các số âm là = %.2f\n", tongSoAm);
	
	*/
	
	//Bài tập 11: Hãy nhập một xâu kí tự. In ra màn hình đảo ngược của xâu đó.
	//Declare variables
	String strData = "", strDaoNguoc = "";
	System.out.print("Nhập xâu: ");
	strData = sc.nextLine();
	
	//Convert String to Array
	char arr[] = strData.toCharArray();
	
	/*
	
	//Reverse the charater array
	System.out.print("Đảo ngược của xâu là: ");
	for(int i = arr.length-1; i >= 0; i--)
	{
	    System.out.print(arr[i]);
	}
	System.out.println("");
	
	//Bài tập 12: Nhập xâu. Thống kê số các chữ số ‘0’, số chữ số ‘1’, …, số chữ số ‘9’ trong xâu.
	//Declare Array
	int tk[] = new int[]{0,0,0,0,0,0,0,0,0,0};
	for(int i = 0; i < arr.length; i++)
	{
	    if(arr[i] == '0')
	    {
		tk[0]++;
	    }
	    if(arr[i] == '1')
	    {
		tk[1]++;
	    }
	    if(arr[i] == '2')
	    {
		tk[2]++;
	    }
	    if(arr[i] == '3')
	    {
		tk[3]++;
	    }
	    if(arr[i] == '4')
	    {
		tk[4]++;
	    }
	    if(arr[i] == '5')
	    {
		tk[5]++;
	    }
	    if(arr[i] == '6')
	    {
		tk[6]++;
	    }
	    if(arr[i] == '7')
	    {
		tk[7]++;
	    }
	    if(arr[i] == '8')
	    {
		tk[8]++;
	    }
	    if(arr[i] == '9')
	    {
		tk[9]++;
	    }	    
	}
	
	System.out.println("Kết quả thống kê: ");
	for(int i = 0; i < tk.length; i++)
	{
	    System.out.printf("Số các chữ số %d = %d\n", i, tk[i]);
	}
	
	//Bài tập 13: Nhập xâu. In ra tất các các vị trí của chữ ‘a’ trong xâu và tổng số lần xuất hiện của nó.
	//Declare variables
	char kiTu; int soLan = 0;
	System.out.print("Nhập kí tự cần tìm trong xâu: ");
	kiTu = sc.next().charAt(0);
	
	//Print results
	System.out.printf("Vị trí xuất hiện của kí tự %s trong xâu là: \n", kiTu);
	for(int i = 0; i < arr.length; i++)
	{
	    if(arr[i] == kiTu)
	    {
		soLan++;
		System.out.print((i+1) + "\t");
	    }
	}
	System.out.println("");
		
	System.out.printf("Số lần xuất hiện của kí tự %s trong xâu là = %d\n", kiTu, soLan);
	
	//Bài tập 14: Thay kí tự x trong xâu s bởi kí tự y (s, x, y được đọc vào từ bàn phím).
	//Declare variables
	char kiTuDuocThay, kiTuThayThe;
	System.out.print("Nhập kí tự được thay: ");
	kiTuDuocThay = sc.next().charAt(0);
	System.out.print("Nhập kí tự thay thế: ");
	kiTuThayThe = sc.next().charAt(0);
	
	//Replace charater
	System.out.println("Chuỗi sau khi thay là: " + strData.replace(kiTuDuocThay, kiTuThayThe));
	
	//Bài tập 15: Bài tập 15: Cho một chuỗi có tên như sau: “Cong ty Stanford – Dao tao va phat trien cong nghe” - ✓ Hãy lấy chữ Stanford từ chuỗi trên. - ✓ Hiển thị vị trí đầu tiên của chữ “t”. - ✓ Hiển thị vị trí cuối cùng của chữ “t”

	String strData1 = "Cong ty Stanford – Dao tao va phat trien cong nghe";
	int tdau = 0, tcuoi = 0;
	
	//Hãy lấy chữ Stanford từ chuỗi trên.
	System.out.println(strData1.substring(8, 16));
	String arr2[] = strData1.split(" ");
	for(int i = 0; i < arr2.length; i++)
	{
	    if(arr2[i].equals("Stanford"))
	    {
		System.out.println(arr2[i]);
	    }
	}
	
	//Hiển thị vị trí đầu tiên và cuối cùng của chữ “t”.
	tdau = strData1.indexOf('t');
	tcuoi = strData1.lastIndexOf('t');
	
	//Print results
	System.out.printf("Vị trí đầu và cuối của 't' là: %d, %d\n", tdau, tcuoi);
	
	*/
	
    } 
}
