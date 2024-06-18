/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stanford_lopvadoituong_j0424;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dangquang16
 */
public class Stanford_LopVaDoiTuong_J0424 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Khai báo 1 đối tượng thuộc lớp TinhToan
        TinhToan tt = new TinhToan();
        
        //Gọi các thành phần để sử dụng
        //System.out.println("Giá trị a = " + tt.a);
        
        System.out.println("Giá trị b = " + tt.b);
        

        System.out.println("Giá trị của c = " + tt.c);
        
        //Gọi các hàm để sử dụng
        tt.inThongTin();
        
        //Gọi lần 2
        tt.inThongTin();
        
        //In 10 câu I Love You
        tt.inThongTin(10);
        
        System.out.println("Tên công ty là: " + tt.layTenCongTy());
        
        double x = 10, y = 5, tong = 0;
        
        tong = tt.tongHaiSo(x, y);
        
        System.out.printf("Tổng hai số %.1f và %.1f là: %.1f\n", x, y, tong);
        
        //Khai báo 1 đối tượng thuộc lớp HinhTron
        HinhTron ht = new HinhTron(3);
        
        ht.inThongTin();
        
        //Khai báo biến
        Scanner sc = new Scanner(System.in);
        
        double r = 0, chuVi = 0, dienTich = 0;
        
        System.out.print("Nhập bán kính hình tròn là r = ");
        
        r = sc.nextDouble();
        
        HinhTron ht2 = new HinhTron(r);
        
        //Gọi hàm tính toán
        chuVi = ht2.chuVi();
        
        dienTich = ht2.dienTich();
        
        System.out.println("Chu vi là: " + chuVi);
        System.out.println("Diện tích là: " + dienTich);
        ht2.inThongTin();
        
        //Khai báo đối tượng
        SinhVienBusiness bus = new SinhVienBusiness();
        
        List<SinhVien> lstSV = bus.layDanhSach();
        
        System.out.println("Danh sách sinh viên là: ");
        
        System.out.println("Mã SV\t Họ tên");
        for(SinhVien sv : lstSV)
        {
            System.out.println(sv.getMaSV() + "\t" + sv.getHoTen());
        }
    }
    
}
