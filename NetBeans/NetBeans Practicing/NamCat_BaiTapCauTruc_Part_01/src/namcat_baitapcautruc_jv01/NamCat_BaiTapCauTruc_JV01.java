/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package namcat_baitapcautruc_jv01;

import java.io.PrintStream;
import java.util.Scanner;


/**
 *
 * @author ADMIN
 */
public class NamCat_BaiTapCauTruc_JV01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Declare an object to enter information from keyboard
        Scanner sc = new Scanner(System.in);
        
        /*
        
        //Bài tập 1:
        //Declare variables
        double aCm = 0, bFoot = 0, cInch = 0;
        
        //Take user information entered on the interface
        System.out.print("Nhập số thực a (đơn vị cm): ");
        aCm = sc.nextDouble();
        
        //Computational processing
        cInch = aCm / 2.54;
        bFoot = cInch / 12;
                
        //Print results
        System.out.printf("Số tương đương của a tính bằng đơn vị Foot là: %.2f\n", bFoot);
        System.out.printf("Số tương đương của a tính bằng đơn vị Inch là: %.2f\n", cInch);

        //Bài tập 2:
        
        //Declare variables
        int soNguyen = 0;
        String heSo8 = "", heSo16 = "";
        
        //Take user information entered on the interface
        System.out.print("Nhập số nguyên cần chuyển = ");
        soNguyen = sc.nextInt();
        
        //Computational processing
        heSo8 = Integer.toString(soNguyen, 8);
        heSo16 = Integer.toString(soNguyen, 16);
        
        //Print results
        System.out.println("Hệ 8 của số nguyên là: " + heSo8);
        System.out.println("Hệ 16 của số nguyên là: " + heSo16);
        
        //Bài tập 3:
        
        //Declare variables
        int soGio = 0, soPhut = 0, soGiay = 0, soGiayNhap = 0;
        
        //Take user inf entered on the interface
        System.out.print("Nhập số giây: ");
        soGiayNhap = sc.nextInt();
        
        //Print results
        if(soGiayNhap <= 63899 && 0 <= soGiayNhap)
        {
            soGio = (soGiayNhap/3600)%3600;
            soPhut = (soGiayNhap/60)%60;
            soGiay = (soGiayNhap%60);
            if(soGio < 10)
            {
                System.out.print("0");
            }
            System.out.print(soGio + ":");
            if(soPhut < 10)
            {
                System.out.print("0");
            }
            System.out.print(soPhut + ":");
            if(soGiay < 10)
            {
                System.out.print("0");
            }
            System.out.print(soGiay);
        }
        else
        {
            System.out.println("Bạn cần phải nhập số giây phù hợp");
        }
        
        //Bài tập 4:
        
        //Declare variables
        int so1 = 0, so2 = 0, so3 = 0, so4 = 0, max = 0, min = 0;
        
        //Enter the int from the keyboard
        System.out.print("Nhập số nguyên thứ 1 = ");
        so1 = sc.nextInt();
        System.out.print("Nhập số nguyên thứ 2 = ");
        so2 = sc.nextInt();
        System.out.print("Nhập số nguyên thứ 3 = ");
        so3 = sc.nextInt();
        System.out.print("Nhập số nguyên thứ 4 = ");
        so4 = sc.nextInt();
        
        //Computational processing
        
        if(max < so2)
        {
            max = so2;
            if(max < so3)
            {
                max = so3;
                if(max < so4)
                {
                    max = so4;
                }
            }
        }
        else
        {
            max = so1;
        }
        
        if(min > so2)
        {
            min = so2;
            if(min > so3)
            {
                min = so3;
                if(min > so4)
                {
                    min = so4;
                }
            }
        }
        else
        {
            min = so1;
        }
        
        //Print results
        System.out.printf("Số lớn nhất là: %d\n", max);
        System.out.printf("Số nhỏ nhất là: %d\n", min);
        
        //Bài tập 5:
        //Declare variables
        double a = 0, b = 0, hieu = 0;
        
        //Take user information entered from the keyboard
        System.out.print("Nhập số tự nhiên a = ");
        a = sc.nextDouble();
        System.out.print("Nhập số tự nhiên b = ");
        b = sc.nextDouble();
        
        //Computational processing
        hieu = a - b;
        System.out.println("Hiệu của a và b là = " + hieu);

        if(hieu < 0)
        {
            System.out.println("Số thứ nhất bé hơn số thứ hai");
        }
        else
        {
            System.out.println("Số thứ nhất lớn hơn số thứ hai");
        }
        
        //Bài tập 6:
        //Declare variables
        double a = 0, b = 0, thuong = 0;
        
        //Take user information entered from the keyboard
        System.out.print("Nhập số tự nhiên a = ");
        a = sc.nextDouble();
        System.out.print("Nhập số tự nhiên b = ");
        b = sc.nextDouble();
        
        //Computational processing
        thuong = a / b;
        System.out.println("Thương của a và b là = " + thuong); 
        
        if(thuong %2 == 0)
        {
            System.out.println("Số tự nhiên a chia hết cho b");
        }
        else
        {
            System.out.println("Số tự nhiên a không chia hết cho b");
        }
        
        //Bài tập 7:
        //Declare variables
        double diemToan = 0, diemLy = 0, diemHoa = 0, diemTrungBinh = 0;
        
        //Take user information entered from the keyboard
        System.out.print("Nhập điểm Toán = ");
        diemToan = sc.nextDouble();
        System.out.print("Nhập điểm Lý = ");
        diemLy = sc.nextDouble();
        System.out.print("Nhập điểm Hóa = ");
        diemHoa = sc.nextDouble();
      
        /*Thầy chữa
        //Bài tập 2:
        
        //Declare variables
        int soNguyen = 0;
        String heSo8 = "", heSo16 = "";
        
        System.out.print("Nhập số nguyên cần chuyển = ");
        
        soNguyen = sc.nextInt();
        
        //Convert
        heSo8 = Integer.toOctalString(soNguyen);
        heSo16 = Integer.toHexString(soNguyen);
        
        System.out.printf("Số dạng hệ 8 là: %s\n", heSo8);
        System.out.printf("Số dạng hệ 16 là: %s\n", heSo16);
        
        System.setOut(new PrintStream(System.out, true, "UTF8"));
        */
        
        /*
        16/8 = 2 dư 0
        2/8 = 0 dư 2
        => 20
        16/16 = 1 dư 0
        1/16 = 0 dư 1
        => 10
         */
        
        /*
        //Bài tập 3:
        int soGiay = 0, gio = 0, phut = 0, giay = 0, temp = 0;
        
        System.out.print("Nhập số giây = ");
        
        soGiay = sc.nextInt();
        
        if(soGiay <= 68399 && soGiay >= 0)
        {
            gio = soGiay/3600;
            temp = soGiay%3600;
            
            phut = temp/60;
            giay = temp%60;
            
            if(gio < 10)
            {
                System.out.print("0");
            }
            
            System.out.print(gio + ":");
            
            if(phut < 10)
            {
                System.out.print("0");
            }
            System.out.print(phut + ":");
            
            if(giay < 10)
            {
                System.out.print("0");
            }
            System.out.print(giay);
        }
        else
        {
            System.out.println("Bạn cần nhập số giây phù hợp");
        }
        
        //Bài tập 4:
        //Declare variables
        int so1 = 0, so2 = 0, so3 = 0, so4 = 0, max = 0, min = 0;
        
        System.out.print("Nhập số thứ 1 = ");
        
        so1 = sc.nextInt();
        
        System.out.print("Nhập số thứ 2 = ");
        
        so2 = sc.nextInt();
       
        System.out.print("Nhập số thứ 3 = ");
        
        so3 = sc.nextInt();

        System.out.print("Nhập số thứ 4 = ");
        
        so4 = sc.nextInt();  
        
        //Default
        max = so1;
        min = so1;
        
        if(max < so2)
        {
            max = so2;
        }
        
        if(max < so3)
        {
            max = so3;
        }   
        
        if(max < so4)
        {
            max = so4;
        }

        if(min > so2)
        {
            min = so2;
        }   
        
        if(min > so3)
        {
            min = so3;
        }  

        if(min > so4)
        {
            min = so4;
        }
        
        System.out.printf("Số lớn nhất là: %d\n", max);
        System.out.printf("Số nhỏ nhất là: %d\n", min);
        
        //Bài tập 4 - Part 4:
        
        //Declare variables
        int N = 0;
        double S1 = 0, S2 = 0;
        
        System.out.print("Nhập giá trị N = ");
        
        N = sc.nextInt();
        
        //Use loop use compute
        for(int i = 1; i <= N; i++)
        {
            S1 += i;
            S2 += Math.pow(i,2);
        }
        
        S1 = S1/N;
        S2 = Math.sqrt(S2);
        
        System.out.printf("Giá trị của S1 = %.3f\n", S1);
        System.out.printf("Giá trị của S2 = %.3f\n", S2);

        
        //Bài tập 5 - Part 4:
        //Declare variables
        int chuc = 0, donVi = 0, tich = 0, tong = 0;
        
        System.out.println("Các số có 2 chữ số thỏa mãn tích bằng 2 lần tổng của 2 chữ số đó là: ");
        
        //Computational processing
        for(int i = 10; i <= 99; i++)
        {
            chuc = i/10;
            donVi = i%10;
            tich = chuc*donVi;
            tong = chuc + donVi;
            if(tich == 2*tong)
            {
                System.out.println(i);
            }
        }
        
        */
        
        //Bài tập 3 - Part 4:
        //Declare variables
        int tuoiCha = 0, tuoiCon = 0, soNam = 0;
        
        //Use to catch the satisfied condition
        
        do
        {
            System.out.print("Nhập tuổi cha = ");
            
            tuoiCha = sc.nextInt();
            
            System.out.print("Nhập tuổi con = ");
            
            tuoiCon = sc.nextInt();
        }
        while(tuoiCha <= 2*tuoiCon);
        
        soNam = tuoiCha - 2*tuoiCon;
        
        tuoiCha += soNam;//tuoiCha = tuoiCha + soNam
        tuoiCon += soNam;
        
        System.out.println("Số năm mà tuổi cha gấp 2 lần tuổi con là = " + soNam);
        System.out.printf("Tuổi cha = %d\n", tuoiCha);
        System.out.printf("Tuổi con = %d\n", tuoiCon);
        
        /*
        
        //Bài tập 6 - Part 4:
        
        //Declare variables
        int N = 0;
        
        double S1 = 0, S2 = 0;
        
        //Find N
        do
        {
            N++;
            S1 += 1/(2.0*N - 1);
        }
        while(S1 < 2.101999);
        
        System.out.printf("Giá trị N thỏa mãn là N = %d\n", N-1);
        
        N = 0;
        
        do
        {
            N++;
            S2 = Math.exp(N) - 1999*Math.log10(N);
        }
        while(S2 < 2000);
                
        System.out.printf("6B. Giá trị N thỏa mãn là N = %d\n", N-1); 
        
        */
        
        int i = 5;

        // Hậu tố (i++)
        System.out.println(i++);  // In ra 5, sau đó i tăng lên 6

        // Tiền tố (++i)
        System.out.println(++i);  // i tăng lên 7 rồi in ra 7
    }
}
