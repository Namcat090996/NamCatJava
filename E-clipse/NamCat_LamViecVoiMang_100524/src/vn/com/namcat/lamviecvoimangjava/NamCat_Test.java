/**
 * 
 */
package vn.com.namcat.lamviecvoimangjava;

import java.util.Scanner;

/**
 * 
 */
public class NamCat_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi số thứ nhất = ");
        String chuoiThuNhat = sc.nextLine();
        System.out.print("Nhập chuỗi số thứ hai = ");
        String chuoiThuHai = sc.nextLine();

        StringBuilder ketQua = new StringBuilder();
        //Kiểm tra độ dài chuỗi
        int doDaiChuoi1 = chuoiThuNhat.length();
        int doDaiChuoi2 = chuoiThuHai.length();

        if (doDaiChuoi1 < doDaiChuoi2) {
            chuoiThuNhat = "0".repeat(doDaiChuoi2 - doDaiChuoi1) + chuoiThuNhat;
        } else if (doDaiChuoi2 < doDaiChuoi1) {
            chuoiThuHai = "0".repeat(doDaiChuoi1 - doDaiChuoi2) + chuoiThuHai;
        }

        //Tính tổng 2 chuỗi số
        int soDu = 0;
        for (int i = chuoiThuNhat.length() - 1; i >= 0; i--) {
            int temp1 = chuoiThuNhat.charAt(i) - '0';
            int temp2 = chuoiThuHai.charAt(i) - '0';
            int tong = temp1 + temp2 + soDu;
            soDu = tong / 10;
            ketQua.append(tong % 10);
        }

        if (soDu > 0) {
            ketQua.append(soDu);
        }
        ketQua.reverse().toString();
        System.out.println("Tổng của 2 chuỗi số = " + ketQua);

	}

}
