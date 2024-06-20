/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j0424_kethuavadahinh;

import java.util.Scanner;

/**
 *
 * @author Dell Precision 7550
 */
public class J0424_KeThuaVaDaHinh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	//Khai báo 1 đối tượng mèo Tom
	Cat tom = new Cat();
	
	//Gán giá trị cho các thuộc tính
	tom.setSoMat(2);
	tom.setSoChan(4);
	tom.setMauLong("Màu xám");
	
	System.out.println("Thông tin của mèo Tom là: ");
	tom.inThongTin();
	
	//Khai báo 1 đối tượng chó Minu
	Dog minu = new Dog();
	
	//Gán giá trị
	minu.setSoMat(2);
	minu.setSoChan(4);
	minu.setMauLong("Màu đen");
	
	System.out.println("Thông tin của chó Minu là: ");
	minu.inThongTin();
	
	int tong = TinhToan.tongHaiSo(4, 5);
	
	System.out.printf("Tổng hai số 5 và 4 là: %d\n", tong);
	
	double tong1 = TinhToan.tongHaiSo(3.2, 5.3);
	
	System.out.printf("Tổng hai số 3.2 và 5.3 là: %.2f\n", tong1);
	
	//Khai báo đối tượng để nhập từ bàn phím
	Scanner sc = new Scanner(System.in);
	
	//Khai báo biến
	double r = 0, dai = 0, rong = 0, chuVi = 0, dienTich = 0, chuViHCN = 0, dienTichHCN = 0;
	
	System.out.print("Nhập bán kính hình tròn r = ");
	
	r = sc.nextDouble();
	
	//Khai báo đối tượng
	HinhTron ht = new HinhTron();
	ht.setBanKinh(r);
	
	//Gọi hàm tính toán
	chuVi = ht.chuVi();
	dienTich = ht.dienTich();
	System.out.println("Chu vi hình tròn là: " + chuVi);
	System.out.println("Diện tích hình tròn là: " + dienTich);
	System.out.println("Cách 2: ");
	ht.inThongTin();
	
	System.out.print("Nhập chiều dài HCN = ");
	dai  = sc.nextDouble();
	
	System.out.print("Nhập chiều rộng HCN = ");
	rong = sc.nextDouble();
	
	//Khai báo đối tượng
	HinhChuNhat hcn = new HinhChuNhat();
	
	hcn.setChieuDai(dai);
	hcn.setChieuRong(rong);
	
	//Gọi hàm tính toán
	chuVi = hcn.chuVi();
	dienTich = hcn.dienTich();
	
	System.out.println("Hình chữ nhật: ");
	hcn.inThongTin();
	
	//Animal a = new Animal();
	
	/**
	 * Không dùng trực tiếp với abstract được
	 */
	//Animal1 a1 = new Animal1();
	
	//Trường hợp a
	DataProvider.thucHien(new VietNamese());
	
	//Trường hợp b
	DataProvider.thucHien(new English());
    }   
}
