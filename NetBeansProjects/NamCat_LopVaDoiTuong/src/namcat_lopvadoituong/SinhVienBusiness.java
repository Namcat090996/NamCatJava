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
    
    //Declare list to contain objects
    List<SinhVien> lstSinhVien = new ArrayList<SinhVien>();
    
    public List<SinhVien> layDanhSach()
    {
	if(lstSinhVien.isEmpty())
	{
	    taoDuLieuBanDau();
	}
	return lstSinhVien;
    }
    
    /**
     * The function has no return value and no parameters
     */
    private void taoDuLieuBanDau()
    {
	//Declare object
	SinhVien objManh = new SinhVien("Hà Nội");
	SinhVien objTruc = new SinhVien("SF002", "Hư Trúc", "0703039947", "vantruc@gmail.com", "Hà Nam");
	SinhVien objHoan = new SinhVien("SF003", "Hoạn Văn Hoan", "0703039946", "vanhoan@gmail.com", "Hà Nam");
	SinhVien objPhuong = new SinhVien("SF004", "Vedette Vũ Thu Phương", "0703039945", "thuphuong@gmail.com", "Biên Hòa");
	SinhVien objDuyen = new SinhVien("SF005", "Nguyễn Thị Nam Duyên", "0703039944", "namduyen@gmail.com", "Sài Gòn");
	
	//Assgin values for objects
	objManh.setMaSV("SF001");
	objManh.setHoTen("Mạnh lỏ");
	objManh.setDienThoai("0703039940");
	objManh.setEmail("vanmanh@gmail.com");
	
	//Assign object values to list
	lstSinhVien.add(objManh);
	lstSinhVien.add(objTruc);
	lstSinhVien.add(objHoan);
	lstSinhVien.add(objPhuong);
	lstSinhVien.add(objDuyen);
    }
    
    public List<SinhVien> themMoi(SinhVien objSV)
    {
	if(objSV != null)
	{
	    lstSinhVien.add(objSV);
	}
	return lstSinhVien;
    }
    
    public boolean kiemTraTrung(String maSV)
    {
	for(SinhVien sv: lstSinhVien)
	{
	    if(sv.getMaSV() != maSV)
	    {
		return true;
	    }
	}
	return false;
    }
    
    
}
