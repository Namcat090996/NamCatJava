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
public class NamCat_BaiTapLop_1206 {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {	
	
	/*
	
	//Khai báo biến
	SoPhuc a = new SoPhuc(0, 0);
	
	SoPhuc b = new SoPhuc(0, 0);
	
	System.out.println("Nhập số phức a = ");
	a.nhapThongTin();
	System.out.print("Số phức a = ");
	a.inThongTin();
	
	System.out.println("Nhập số phức b = ");
	b.nhapThongTin();
	System.out.print("Số phức b = ");
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
	
	//In kết quả
	System.out.print("Tổng hai số phức = ");
	tong.inThongTin();
	
	System.out.print("Hiệu hai số phức = ");
	hieu.inThongTin();

	System.out.print("Tích hai số phức = ");
	tich.inThongTin();

	System.out.print("Thương hai số phức = ");
	thuong.inThongTin();	
	
	System.out.print("Bình phương số phức = ");
	binhPhuong.inThongTin();	

	*/
	System.out.println("Ngày tháng: " + new Date());
	
	PhanSo a = new PhanSo();
	PhanSo b = new PhanSo();
	
	System.out.println("Nhập phân số a = ");
	a.nhapThongTin();
	
	System.out.print("Phân số a = ");
	a.inThongTin();
	
	System.out.println("Nhập phân số b = ");
	b.nhapThongTin();
	
	System.out.print("Phân số b = ");
	b.inThongTin();	
	
	//Khai báo đối  tượng
	PhanSoBusiness bus = new PhanSoBusiness();
	
	//Khai báo biến
	PhanSo tong, hieu, tich, thuong, rutGon;
	
	//Tính toán
	tong = bus.tongHaiSo(a, b);
	hieu = bus.hieuHaiSo(a, b);
	tich = bus.tichHaiSo(a, b);
	thuong = bus.thuongHaiSo(a, b);
	rutGon = bus.rutGon(a);
	
	//In kết quả
	System.out.print("Tổng của hai phân số là = ");
	tong.inThongTin();
	
	System.out.print("Hiệu của hai phân số là = ");
	hieu.inThongTin();
	
	System.out.print("Tích của hai phân số là = ");
	tich.inThongTin();
	
	System.out.print("Thương của hai phân số là = ");
	thuong.inThongTin();
	
	System.out.print("Rút gọn phân số = ");
	rutGon.inThongTin();	
	
	System.out.println("Ngày tháng: " + new Date());
    }     
}
