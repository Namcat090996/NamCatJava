/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baitaplopvadoituong;

import java.util.Date;

/**
 *
 * @author Dell Precision 7550
 */
public class NamCat_BaiTapLopVaDoiTuong {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {	
	
    /*
	
    //Bài 1: 
    
    //Declare variables
    SoPhuc a = new SoPhuc(0, 0);
    
    System.out.println("Nhập số phức a: ");
    
    a.nhapSoPhuc();
    
    SoPhuc b = new SoPhuc(0, 0);
    
    System.out.println("Nhập số phức b: ");
    
    b.nhapSoPhuc();
    
    System.out.print("Số phức a là: ");
    
    a.inSoPhuc();
    
    System.out.print("Số phức b là: ");
    
    b.inSoPhuc();
    
    //Declare objects
    SoPhuc tong, hieu, tich, thuong, binhPhuong;
    
    SoPhucBusiness bus = new SoPhucBusiness();
    
    //Retrieve the function calculation
    tong = bus.tongHaiSo(a, b);
    hieu = bus.hieuHaiSo(a, b);
    tich = bus.tichHaiSo(a, b);
    thuong = bus.thuongHaiSo(a, b);
    binhPhuong = bus.binhPhuong(a);
    
    //Print results
    System.out.print("Tổng của 2 số phức là: ");
    tong.inSoPhuc();
    
    System.out.print("Hiệu của 2 số phức là: ");
    hieu.inSoPhuc();
    
    System.out.print("Tích của 2 số phức là: ");
    tich.inSoPhuc();
	
    System.out.print("Thương của 2 số phức là: ");
    thuong.inSoPhuc();
    
    System.out.print("Bình phương của số phức là: ");
    binhPhuong.inSoPhuc();
    
    */
    
    //Bài 2:
    //Declare objects
    PhanSo c = new PhanSo();
    
    PhanSo d = new PhanSo();
    
    //Print results
    System.out.println("Nhập phân số thứ nhất: ");
    c.nhapPhanSo();
    
    System.out.println("Nhập phân số thứ hai: ");
    d.nhapPhanSo();
    
    System.out.print("Phân số thứ nhất là: ");
    c.inPhanSo();
    
    System.out.print("Phân số thứ hai là: ");
    d.inPhanSo();
    
    //Declare objects
    PhanSo tong, hieu, tich, thuong, rutGon;   
    PhanSoBusiness bus = new PhanSoBusiness();
    
    //Retrieve the calculation function
    tong = bus.tongPhanSo(c, d);
    hieu = bus.hieuPhanSo(c, d);
    tich = bus.tichPhanSo(c, d);
    thuong = bus.thuongPhanSo(c, d);
    rutGon = bus.rutGon(c);
    
    //Print results
    System.out.print("Tổng hai phân số là: ");
    tong.inPhanSo();
    System.out.print("Hiệu hai phân số là: ");
    hieu.inPhanSo();
    System.out.print("Tích hai phân số là: ");
    tich.inPhanSo();
    System.out.print("Thương hai phân số là: ");
    thuong.inPhanSo();
    System.out.print("Rút gọn phân số: ");
    rutGon.inPhanSo();

    
    }     
}
