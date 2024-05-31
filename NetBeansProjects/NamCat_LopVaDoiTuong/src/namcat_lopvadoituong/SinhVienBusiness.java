/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_lopvadoituong;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell Precision 7550
 */
public class SinhVienBusiness {
    
    private List<SinhVien> lstSinhVien = new ArrayList<SinhVien>();
    
    public List<SinhVien> layDanhSach()
    {
	if(lstSinhVien.isEmpty())
	{
	    taoDuLieuBanDau();
	}
	return lstSinhVien;
    }
    
    /**
     * Hàm tạo dữ liệu ban đầu
     */
    private void taoDuLieuBanDau()
    {
	//Khai báo các đối tượng
	SinhVien objManh = new SinhVien();
	
	//Gán giá trị
	objManh.setMaSV("SF001");
	objManh.setHoTen("Nguyễn Thế Mạnh");
	objManh.setDienThoai("0123456789");	
	objManh.setEmail("themanh@gmail.com");	
	
	//Thêm vào danh sách
	lstSinhVien.add(objManh);
	
	SinhVien objTruc = new SinhVien("Hà Nam");
	
	objTruc.setMaSV("SF002");
	objTruc.setHoTen("Bạch Văn Trúc");
	objTruc.setDienThoai("0123456789");	
	objTruc.setEmail("vantruc@gmail.com");	
	
	//Thêm vào danh sách
	lstSinhVien.add(objTruc);
	
	SinhVien objHoan = new SinhVien("SF003","Hoàng Văn Hoan","0123456789","vanhoan@gmail.com","Hà Nam");
	
	//Thêm vào danh sách
	lstSinhVien.add(objHoan);	
	
	SinhVien objPhuong = new SinhVien("SF004","Nguyễn Duy Phương","0123456789","duyphuong@gmail.com","Hồ Chí Minh");
	
	//Thêm vào danh sách
	lstSinhVien.add(objPhuong);

	SinhVien objDuyen = new SinhVien("SF005","Nguyễn Thị Duyên","0123456789","thiduyen@gmail.com","Hồ Chí Minh");
	
	//Thêm vào danh sách
	lstSinhVien.add(objDuyen);

	
    }
    
}
