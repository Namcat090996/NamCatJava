/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package namcat_lopvadoituong;

import java.util.List;

/**
 *
 * @author Dell Precision 7550
 */
public class NamCat_LopVaDoiTuong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
	
	TinhToan tt = new TinhToan();
	
	System.out.println("" + tt.b);
	
	System.out.println("" + tt.c);
	
	tt.inThongTin();
	
	tt.inThongTin(3);
	
	System.out.println("" + tt.layTenCongTy());
	
	System.out.println("" + tt.tongSo(3, 5));
	
	SinhVienBusiness sv = new SinhVienBusiness();
	
	List<SinhVien> lstSV = sv.layDanhSach();
	
	SinhVien objSV = DataProvider.getSinhVienBus().layChiTiet("SF001");

    }  
}
