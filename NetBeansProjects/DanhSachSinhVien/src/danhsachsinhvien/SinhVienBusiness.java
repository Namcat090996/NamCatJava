/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danhsachsinhvien;

import java.util.ArrayList;
import java.util.Collections;
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
	SinhVien objHoan = new SinhVien("SF003", "Hoàng Văn Hoan", "0708085058", "Nam", "vanhoan@gmail.com", "Hà Nam");
	SinhVien objTruc = new SinhVien("SF002", "Hư Trúc", "0708095059", "Nam", "hutruc@gmail.com", "Hà Nam");
	SinhVien objPhuong = new SinhVien("SF001", "Nguyễn Phương", "0703039948", "Nam", "nguyenphuong@gmail.com", "Biên Hòa");
	SinhVien objDuyen = new SinhVien("SF004", "Nguyễn Thị Duyên", "0909034056", "Nữ", "thiduyen@gmail.com", "Sài Gòn");	
	
	//Assign value to object
	objManh.setMaSV("SF005");
	objManh.setHoTen("Nguyễn Văn Mạnh");
	objManh.setDienThoai("0123455678");
	objManh.setGioiTinh("Nam");
	objManh.setEmail("vanmanh@gmail.com");
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
    public boolean kiemTraTrungMaSV(String maSV)
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
	    if(lstSinhVien.get(i).getMaSV().equals(objSV.getMaSV()))
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
    
    /**
     * Function to sort the list in ascending order
     * @return 
     */
    public List<SinhVien> sapXepMaTangDan()
    {
	List<Integer> lstSV = new ArrayList<Integer>();
	List<SinhVien> lstSinhVienAscending = new ArrayList<SinhVien>();  
	
	for(int i = 0; i < lstSinhVien.size(); i++)
	{
	    int n = Integer.parseInt(lstSinhVien.get(i).getMaSV().substring(4)); 
	    lstSV.add(n);
	}

	Collections.sort(lstSV);
	
 	for(int i = 0; i < lstSinhVien.size(); i++)
	{
	    for(int j = 0; j < lstSinhVien.size(); j++)
	    {
		if(Integer.parseInt(lstSinhVien.get(j).getMaSV().substring(4)) == lstSV.get(i))
		{
		    lstSinhVienAscending.add(lstSinhVien.get(j));
		    break;
		}		
	    }	
	}
	return lstSinhVienAscending;
    }
    
    /**
     * Function to search values
     * @param giaTri
     * @return 
     */
    public List<SinhVien> timKiem(String giaTri)
    {
	List<SinhVien> lstTimKiem = new ArrayList<SinhVien>();
	List<Integer> lstSV = new ArrayList<Integer>();
	List<SinhVien> lstSinhVienAscending = new ArrayList<SinhVien>(); 
	
	for(int i = 0; i < lstSinhVien.size(); i++)
	{
	    if(lstSinhVien.get(i).getMaSV().contains(giaTri) || lstSinhVien.get(i).getHoTen().contains(giaTri) || lstSinhVien.get(i).getDienThoai().contains(giaTri) || lstSinhVien.get(i).getGioiTinh().contains(giaTri) || lstSinhVien.get(i).getEmail().contains(giaTri) || lstSinhVien.get(i).getDiaChi().contains(giaTri))
	    {
		lstTimKiem.add(lstSinhVien.get(i));		
	    }
	}
	
	//Sort the list in ascending order
	for(int i = 0; i < lstTimKiem.size(); i++)
	{
	    int n = Integer.parseInt(lstTimKiem.get(i).getMaSV().substring(4)); 
	    lstSV.add(n);
	}

	Collections.sort(lstSV);
	
 	for(int i = 0; i < lstTimKiem.size(); i++)
	{
	    for(int j = 0; j < lstTimKiem.size(); j++)
	    {
		if(Integer.parseInt(lstTimKiem.get(j).getMaSV().substring(4)) == lstSV.get(i))
		{
		    lstSinhVienAscending.add(lstTimKiem.get(j));
		    break;
		}		
	    }	
	}
	return lstSinhVienAscending;
    }
     
}
