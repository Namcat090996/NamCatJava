/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_lopvadoituong;

/**
 *
 * @author Dell Precision 7550
 */
public class NamCat_LopVaDoiTuong {
    
    /**
     *@param arg the command line argument
     */
    public static void main(String[] args) {
    //Khai báo 1 đối tượng thuộc lớp TinhToan
    TinhToan tt = new TinhToan();
    
    //Gọi các thành phần để sử dụng
    //System.out.println("Giá trị a = " + tt.a);	
    
    System.out.println("Giá trị b = " + tt.b);
    
    System.out.println("Giá trị c = " + tt.c);
    
    //Gọi các hàm để sử dụng
    tt.inThongTin();
    
    //Gọi lần 2
    tt.inThongTin();
    
    //In 10 câu I Love You
    tt.inThongTin(10);
    
    System.out.println("Tên công ty là: " + tt.layTenCongTy());
    
    double x = 10, y = 5, tong = 0;
    
    tong = tt.tongHaiSo(x, y);
    
    System.out.printf("Tổng 2 số %.1f và %.1f là = %.1f", x, y, tong);
	    
    
    
    
    
	    
    }   
}
