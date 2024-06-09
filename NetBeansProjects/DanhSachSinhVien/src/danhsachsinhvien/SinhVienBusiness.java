/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danhsachsinhvien;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SinhVienBusiness {
    
    //Declare variables
    private List<SinhVien> lstSinhVien = new ArrayList<SinhVien>();
    private SinhVien objSV = new SinhVien();
    
    public List<SinhVien> layDanhSach()
    {
	if(lstSinhVien.isEmpty())
	{
	    taoDuLieuBanDau();
	}
	return lstSinhVien;
    }
    
    //Create function to assign value to object
    /**
     * Function has no return value and has no parameters
     */
    public void taoDuLieuBanDau()
    {
	//Declare object to get data information
	SinhVien objManh = new SinhVien();
	SinhVien objHoan = new SinhVien("SF002", "Hoạn Văn Hoan", "0708085058", "Nam", "hoanvanhoan@gmail.com", "Hà Nam");
	SinhVien objTruc = new SinhVien("SF003", "Hư Trúc", "0708095059", "Nam", "hutruc@gmail.com", "Hà Nam");
	SinhVien objPhuong = new SinhVien("SF004", "Veddete Vũ Thu Phương", "0703039948", "Nữ", "cavienchien@gmail.com", "Biên Hòa");
	SinhVien objDuyen = new SinhVien("SF005", "Buồi Thị Duyên", "0909034056", "Nữ", "duyenbuoi@gmail.com", "Sài Gòn");	
	
	//Assign value to object
	objManh.setMaSV("SF001");
	objManh.setHoTen("Mạnh Thật");
	objManh.setDienThoai("0123455678");
	objManh.setGioiTinh("Nam");
	objManh.setEmail("yanghomanh@gmail.com");
	objManh.setDiaChi("Hà Nội");
	
	//Assign object values to list
	lstSinhVien.add(objManh);
	lstSinhVien.add(objHoan);
	lstSinhVien.add(objTruc);
	lstSinhVien.add(objPhuong);
	lstSinhVien.add(objDuyen);	
    }
    
    /**
     * Function to get detail information
     * @param maSV
     * @return 
     */
    public SinhVien layChiTiet(String maSV)
    {
	for(SinhVien sv: lstSinhVien)
	{
	    if(sv.getMaSV().equals(maSV))
	    {
		objSV = sv;
		break;
	    }
	}
	return objSV;
    }
    
    /**
     * Function to check entered value is duplicated
     * @param maSV
     * @return 
     */
    public boolean kiemTraTrung(String maSV)
    {
	for(SinhVien sv: lstSinhVien)
	{
	    if(sv.getMaSV().equals(maSV))
	    {
		return false;
	    }
	}
	return true;
    }
    
    /**
     * Function to add new object value
     * @param objSV
     * @return 
     */
    public List<SinhVien> themMoi(SinhVien objSV)
    {
	if(objSV != null)
	{
	    lstSinhVien.add(objSV);
	}
	return lstSinhVien;
    }
    
    /**
     * Function to update the value in the list
     * @param objSV
     * @return 
     */
    public List<SinhVien> capNhat(SinhVien objSV)
    {
	for(int i = 0; i < lstSinhVien.size(); i++)
	{
	    if(lstSinhVien.get(i).getMaSV().equals(objSV))
	    {
		lstSinhVien.set(i, objSV);
	    }
	}
	return lstSinhVien;
    }
    
    /**
     * Function to remove object
     * @param maSV
     * @return 
     */
    public List<SinhVien> xoa(String maSV)
    {
	SinhVien objXoaSV = layChiTiet(maSV);
	
	for(int i = 0; i < lstSinhVien.size(); i++)
	{
	    if(lstSinhVien.get(i).getMaSV().equals(maSV))
	    {
		lstSinhVien.remove(objXoaSV);
	    }
	}
	return lstSinhVien;	
    }
    
    
}
