/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.com.stanford.j0424.baitaplop;

import java.util.Date;

/**
 *
 * @author dangquang16
 */
public class Stanford_BaiTapLop_J0424_1206 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        //Khai báo biến
        SoPhuc a = new SoPhuc(0, 0);
        
        SoPhuc b = new SoPhuc(0, 0);
        
        System.out.println("Nhập số phức a: ");
        a.nhapThongTin();
        System.out.println("Số phức a: ");
        a.inThongTin();
        
        System.out.println("Nhập số phức b: ");
        b.nhapThongTin();
        System.out.println("Số phức b: ");
        b.inThongTin();
        
        //Khai báo biến
        SoPhuc tong, hieu, tich, thuong, binhPhuong;
        
        //Khai báo đối tượng
        SoPhucBusiness tinhToan = new SoPhucBusiness();
        
        //Gọi hàm xử lý công việc
        tong = tinhToan.tongHaiSo(a, b);
        hieu = tinhToan.hieuHaiSo(a, b);
        tich = tinhToan.tichHaiSo(a, b);
        thuong = tinhToan.thuongHaiSo(a, b);
        binhPhuong = tinhToan.binhPhuong(a);
        
        System.out.println("Tổng hai số phức: ");
        tong.inThongTin();
        
        System.out.println("Hiệu hai số phức: ");
        hieu.inThongTin();
        
        System.out.println("Tích hai số phức: ");
        tich.inThongTin();
        
        System.out.println("Thương hai số phức: ");
        thuong.inThongTin();
        
        System.out.println("Bình phương số phức: ");
        binhPhuong.inThongTin();*/
        
        System.out.println("Ngày tháng: " + new Date());
        PhanSo a = new PhanSo();
        
        System.out.println("Nhập phân số a: ");
        a.nhapThongTin();
        
        System.out.println("Phân số a: ");
        a.inThongTin();
        
        PhanSo b = new PhanSo();
        
        System.out.println("Nhập phân số b: ");
        b.nhapThongTin();
        
        System.out.println("Phân số b: ");
        b.inThongTin();
        
        //Khai báo đối tượng
        PhanSoBusiness bus = new PhanSoBusiness();
        
        //Khai báo biến
        PhanSo tong, hieu, tich, thuong, rutGon;
        
        //Tính toán
        tong = bus.tongHaiSo(a, b);
        hieu = bus.hieuHaiSo(a, b);
        tich = bus.tichHaiSo(a, b);
        thuong = bus.thuongHaiSo(a, b);
        rutGon = bus.rutGon(a);
        
        System.out.println("Tổng hai phân số: ");
        tong.inThongTin();
        
        System.out.println("Hiệu hai phân số: ");
        hieu.inThongTin();
        
        System.out.println("Tích hai phân số: ");
        tich.inThongTin();
        
        System.out.println("Thương hai phân số: ");
        thuong.inThongTin();
        
        System.out.println("Rút gọn phân số: ");
        rutGon.inThongTin();
        System.out.println("Ngày tháng: " + new Date());
    }
}
