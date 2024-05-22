/**
 * 
 */
package vn.com.namcat.lamviecvoimangjava;

import java.util.Scanner;

/**
 * 
 */
public class NamCat_BaiTapMangJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declare an object to enter information from the keyboard
		Scanner sc = new Scanner(System.in);
		
		/*
		
		//Bài tập 1: Nhập vào dãy n số thực. Tính tổng dãy, trung bình dãy, tổng các số âm, dương và tổng các số ở vị trí chẵn, vị trí lẻ trong dãy:
		
		//Khai báo số phần tử n của mảng
		int  n = 0;
		System.out.print("Nhập mảng số thực gồm n phần tử với n = ");
		n = sc.nextInt();
		
		//Khai báo mảng và các giá trị cần tìm
		double arr[] = new double[n];
		double tongDay = 0, trungBinhDay = 0, tongSoAm = 0, tongSoDuong = 0, tongSoChan = 0, tongSoLe = 0;
		
		//Nhập giá trị cho các phần tử của mảng
		System.out.println("Nhập giá trị cho các phần tử = ");
		
		for(int i = 0; i < n; i++)
		{
			System.out.print("arr["+ i +"] = ");
			arr[i] = sc.nextDouble();
		}
		
		//Tính toán
		for(int i = 0; i < arr.length; i++)
		{
			tongDay += arr[i];
			trungBinhDay += arr[i];
		}
		
		trungBinhDay = trungBinhDay/arr.length;
		System.out.printf("Tổng dãy của mảng là là = %.2f\n", tongDay);
		System.out.printf("Trung bình dãy của mảng là là = %.2f\n", trungBinhDay);
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] >= 0)
			{
				tongSoDuong += arr[i];
			}
			else
			{
				tongSoAm += arr[i];
			}

		}
		
		System.out.printf("Tổng số dương của mảng là là = %.2f\n", tongSoDuong);
		System.out.printf("Tổng số âm của mảng là là = %.2f\n", tongSoAm);
		
		
		for(int i = 0; i < arr.length; i++)
		{
			if(i%2 == 0)
			{
				tongSoChan += arr[i];
			}
			else
			{
				tongSoLe += arr[i];
			}

		}

		
		System.out.printf("Tổng các số ở vị trí chẵn của mảng là là = %.2f\n", tongSoChan);
		System.out.printf("Tổng các số ở vị trí lẽ của mảng là là = %.2f\n", tongSoLe);
		
		//Bài tập 2: Tìm và chỉ ra vị trí xuất hiện đầu tiên của phần tử x trong dãy:
		
		//Khai báo mảng
		String arr2[] = new String[3];
		
		arr2[0] = "Stanxfordx1";
		arr2[1] = "Dạy lập trình";
		arr2[2] = "J0424";
		
		System.out.println("arr2[0] = " + arr2[0]);
		System.out.println("arr2[1] = " + arr2[1]);
		System.out.println("arr2[1] = " + arr2[2]);
		
		int idx = arr2[0].indexOf('x');
		
		System.out.println("Vị trí đầu tiên của kí tự 'x' trong dãy arr[0] là = " + idx);
		
		int lidx = arr2[0].lastIndexOf('x');
		
		System.out.println("Vị trí cuối cùng của kí tự 'x' trong dãy arr[0] là = " + lidx);

		//Bài tập 3: Nhập vào dãy n số. Hãy in ra số lớn nhất, bé nhất của dãy:
		
		//Khai báo số phần tử của mảng
		int n = 0;
		System.out.print("Nhập mảng gồm n phần tử với n = ");
		n = sc.nextInt();
		
		//Khai báo mảng và các giá trị cần tìm
		double arr[] = new double[n];
		double min = 0, max = 0;
		
		//Nhập giá trị cho các phần tử của mảng
		System.out.println("Nhập giá trị cho các phần tử trong mảng = ");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print("arr["+ i +"] = ");
			arr[i] = sc.nextDouble();
		}
		
		System.out.println("");
		
		//Mặc định
		max = arr[0];
		min = arr[0];
		
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] > max)
			{
				max = arr[i];
			}

		}
		
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] < min)
			{
				min = arr[i];
			}

		}
		
		System.out.println("Số lớn nhất trong dãy là = " + max);
		System.out.println("Số nhỏ nhất trong dãy là = " + min);
		
		*/
		
		//Bài tập 4: Nhập vào dãy số. In ra dãy đã được sắp xếp tăng dần, giảm dần:
		
		//Khai báo số phần tử n của mảng
		int n = 0;
		System.out.print("Nhập mảng gồm n phần tử với n = ");
		n = sc.nextInt();
		
		//Khai báo mảng 
		double arr[] = new double[n];
		double temp = 0;
		
		//Nhập giá trị cho các phần tử của mảng
		System.out.println("Nhập giá trị cho các phần tử của mảng: ");
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print("arr[" + i + "] = ");
			arr[i] = sc.nextDouble();
		}
		
		System.out.println("");
		
		//Dùng vòng lặp for để sắp xếp thứ tự tăng dần
		for(int i = 0; i <= arr.length - 1; i++)
		{
			for(int j = i + 1; j < arr.length; j++)
			{
				if(arr[i] > arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.print("Dãy đã được sắp xếp tăng dần là = ");
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("");
		
		//Dùng vòng lặp for để sắp xếp thứ tự giảm dần
		for(int x = 0; x < arr.length - 1; x++)
		{
			for(int y = x + 1; y < arr.length; y++)
			{
				if(arr[x] < arr[y])
				{
					temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
			}
		}
		
		System.out.print("Dãy đã được sắp xếp giảm dần là = ");
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		
		/*

		//Bài tập 5: Hãy nhập vào 16 số nguyên. In ra thành 4 dòng, 4 cột:
		
		/*
		 * Cấu trúc 4x4:
		 * [a00]	[a01]	[a02]	[a03]
		 * [a10]	[a11]	[a12]	[a13]
		 * [a20]	[a21]	[a22]	[a23]
		 * [a30]	[a31]	[a32]	[a33]
		 */
		
		/*
		
		//Khai báo mảng
		int arr[][] = new int[4][4];
		
		//Gán giá trị cho các phần tử
		//Dòng 1:
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[0][3] = 4;
		
		//Dòng 2:
		arr[1][0] = 5;
		arr[1][1] = 6;
		arr[1][2] = 7;
		arr[1][3] = 8;		
		
		//Dòng 3:
		arr[2][0] = 9;
		arr[2][1] = 10;
		arr[2][2] = 11;
		arr[2][3] = 12;	
		
		//Dòng 4:
		arr[3][0] = 13;
		arr[3][1] = 14;
		arr[3][2] = 15;
		arr[3][3] = 16;
		
		System.out.println("Các giá trị thuộc các phần tử của mảng 4x4 bao gồm: ");
		
		//Duyệt dòng
		for(int i = 0; i < 4; i++)
		{
			//Duyệt cột
			for(int j = 0; j < 4; j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println("");
		}
		
		//Bài tập 6: Cho một chuỗi ký tự như sau: “Cong ty Stanford – Dao tao va phat trien cong nghe”. Hãy chuyển chuỗi này thành một mảng, trong đó mỗi phần tử là một từ. Ví dụ a[0] = Cong, a[1] = ty, a[2] = Stanford,…Sau đó in kết quả ra màn hình:
		
		//Khai báo chuỗi
		String strChuoi = "Cong ty Stanford – Dao tao va phat trien cong nghe";
		
		String arr[] = strChuoi.split(" ");
		
		System.out.println("Các từ lấy được sau khi chia chuỗi: ");
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
		
		//Bài tập 8:Nhập ma trận 4x4, báo ra: -Số các phần tử lớn hơn 0, liệt kê các phần tử lớn hơn 0 đó, tính tổng của chúng. -Số các phần tử nhỏ hơn 0, liệt kê các phần tử nhỏ hơn 0 đó, tính tổng của chúng.
		
		//Khai báo mảng
		int arr[][] = new int[4][4];
		
		System.out.println("Nhập giá trị cho các phần tử: ");
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				System.out.print("arr2[" + i + "][" + j + "] = " );
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Các phần tử của mảng 4x4 là: ");
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			
			System.out.println("");
		}
		
		//Khai báo biến
		int duong = 0, am = 0, tongDuong = 0, tongAm = 0;
		int arrDuong[] = new int[16];
		int arrAm[] = new int[16];
		
		//Duyệt để phần loại các phần tử dương, âm
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
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
		
		System.out.println("Các phần tử dương: ");
		
		for(int i = 0; i < duong; i++)
		{
			System.out.print(arrDuong[i] + "\t");
			tongDuong += arrDuong[i];
		}
		
		System.out.printf("\n Tổng dương %d\n", tongDuong);
		
		for(int i = 0; i < am; i++)
		{
			System.out.print(arrAm[i] + "\t");
			tongAm += arrAm[i];
		}
		
		System.out.printf("\n Tổng âm %d\n", tongAm);		
		
		/*
		
		//Gán giá trị cho các phần tử
		//Dòng 1:
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[0][3] = 4;
		
		//Dòng 2:
		arr[1][0] = 5;
		arr[1][1] = 6;
		arr[1][2] = 7;
		arr[1][3] = 8;		
		
		//Dòng 3:
		arr[2][0] = 9;
		arr[2][1] = 10;
		arr[2][2] = 11;
		arr[2][3] = 12;	
		
		//Dòng 4:
		arr[3][0] = -13;
		arr[3][1] = 14;
		arr[3][2] = 15;
		arr[3][3] = 16;
			
		System.out.println("Các giá trị thuộc các phần tử của mảng 4x4 bao gồm: ");
		
		System.out.println("Các phần tử lớn hơn 0 là: ");
		//Duyệt dòng
		for(int i = 0; i < 4; i++)
		{
			//Duyệt cột
			for(int j = 0; j < 4; j++)
			{
				if(arr[i][j] > 0)
				{
					System.out.println(arr[i][j]+ "\t");
				}
			}
			System.out.println("");
		}		
				
		*/
		
		
	}

}
