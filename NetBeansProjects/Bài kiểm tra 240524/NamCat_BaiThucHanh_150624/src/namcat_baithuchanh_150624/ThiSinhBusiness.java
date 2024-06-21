/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baithuchanh_150624;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell Precision 7550
 */
public class ThiSinhBusiness {
    
    //Khai báo List chứa dữ liệu thí sinh
    private List<ThiSinh> lstThiSinh = new ArrayList<ThiSinh>();
    
    /**
     * Hàm hỗ trợ gán thông tin cho object
     * @param soBaoDanh
     * @param hoTen
     * @param gioiTinh
     * @param ngaySinh
     * @param queQuan
     * @param tongDiem
     * @param diemToan
     * @param diemLy
     * @param diemHoa
     * @return 
     */
    public ThiSinh ganThongTin(String soBaoDanh, String hoTen, String gioiTinh, String ngaySinh, String queQuan, double tongDiem, double diemToan, double diemLy, double diemHoa)
    {
	ThiSinh objTS = new ThiSinh();
	
	objTS.setSoBaoDanh(soBaoDanh);
	objTS.setHoTen(hoTen);
	objTS.setGioiTinh(gioiTinh);
	objTS.setNgaySinh(ngaySinh);
	objTS.setQueQuan(queQuan);
	objTS.setTongDiem(tongDiem);
	objTS.setDiemToan(diemToan);
	objTS.setDiemLy(diemLy);
	objTS.setDiemHoa(diemHoa);
	
	return objTS;
    }    
    
    /**
     * Hàm lấy danh sách thí sinh
     * @return 
     */
    public List<ThiSinh> layDanhSach(String duongDan)
    {
	if(lstThiSinh.isEmpty())
	{
	    docDuLieuFile(duongDan);
	}
	
	return lstThiSinh;
    }
   /**
    * Hàm đọc dữ liệu từ file
    * @param duongDan
    * @return 
    */
    public List<ThiSinh> docDuLieuFile(String duongDan)
    {	
	FileReader fileReader = null;
	
	try {
	    fileReader = new FileReader(duongDan);
	    BufferedReader buffer = new BufferedReader(fileReader);
	    
	    String dong = "";
	    
	    while((dong = buffer.readLine()) != null)
	    {
		String objTemp[] = dong.split(";");
		
		double diemToan = Double.parseDouble(objTemp[5]);
		double diemLy = Double.parseDouble(objTemp[6]);
		double diemHoa = Double.parseDouble(objTemp[7]);
		double tongDiem = diemToan + diemLy + diemHoa;
		
		lstThiSinh.add(ganThongTin(objTemp[0], objTemp[1], objTemp[2], objTemp[3], objTemp[4], tongDiem, diemToan, diemLy, diemHoa));	
	    }
	    
	    //Đóng bộ đệm
	    buffer.close();
	    fileReader.close();
	    
	} catch (FileNotFoundException ex) {
	    System.err.println("Không tìm thấy file. Chi tiết lỗi: " + ex.getMessage());
	} catch (IOException ex) {
	    System.err.println("Lỗi quá trình đọc file. Chi tiết lỗi: " + ex.getMessage());
	} 
	
	return lstThiSinh;
    }  
    
    public void ghiDuLieuFile(String noiDung, String duongDan)
    {
	FileWriter writer = null;
	try {
	    writer = new FileWriter(duongDan, true);
	    
	    //Ghi thông tin ra file
	    writer.write(noiDung + "\n");
	    
	    //Đẩy ra file để ghi
	    writer.flush();
	    
	    //Đóng luồng ghi
	    writer.close();
	    
	} catch (IOException ex) {
	    System.out.println("Lỗi khi ghi thông tin ra file. Chi tiết lỗi " + ex.getMessage());
	}	
    }
 
    /**
     * Hàm kiểm tra trùng số báo danh
     * @param soBaoDanh
     * @return 
     */
    public boolean kiemTraTrungSoBD(String soBaoDanh)
    {
	for(ThiSinh ts: lstThiSinh)
	{
	    if(ts.getSoBaoDanh().equals(soBaoDanh))
	    {
		return false;
	    }
	}
	
	return true;
    }
    
    /**
     * Hàm thêm mới thí sinh
     * @param objTS
     * @return 
     */
    public List<ThiSinh> themMoi(ThiSinh objTS)
    {
	if(objTS != null)
	{
	    lstThiSinh.add(objTS);
	}
	
	return lstThiSinh;
    }
    
    /**
     * Hàm sửa thông tin thí sinh
     * @param objTS
     * @return 
     */
    public List<ThiSinh> sua(ThiSinh objTS)
    {
	for(int i = 0; i < lstThiSinh.size(); i++)
	{
	    if(lstThiSinh.get(i).getSoBaoDanh().equals(objTS.getSoBaoDanh()))
	    {
		lstThiSinh.set(i, objTS);
	    }
	}
	
	return lstThiSinh;
    }
    
    /**
     * Hàm hiển thị chi tiết thông tin thí sinh
     * @param soBaoDanh
     * @return 
     */
    public ThiSinh layChiTiet(String soBaoDanh)
    {
	ThiSinh objTS = null;
	
	for(ThiSinh ts: lstThiSinh)
	{
	    if(ts.getSoBaoDanh().equals(soBaoDanh))
	    {
		objTS = ts;
		break;
	    }
	}
	
	return objTS;
    }
    
    /**
     * Hàm xóa thông tin thí sinh
     * @param soBaoDanh
     * @return 
     */
    public List<ThiSinh> xoa(String soBaoDanh)
    {
	ThiSinh objTS = layChiTiet(soBaoDanh);
	
	for(int i = 0; i < lstThiSinh.size(); i++)
	{
	    if(lstThiSinh.get(i).getSoBaoDanh().equals(soBaoDanh))
	    {
		lstThiSinh.remove(objTS);
	    }
	}	
	
	return lstThiSinh;
    }
    
    /**
     * Hàm sắp xếp số báo danh tăng dần
     * @return 
     */
    public List<ThiSinh> sapXepSBDTangDan()
    {
	List<Integer> lstSoBD = new ArrayList<Integer>();
	List<ThiSinh> lstThiSinhAscending = new ArrayList<ThiSinh>();
	
	for(int i = 0; i < lstThiSinh.size(); i++)
	{
	    int n = Integer.parseInt(lstThiSinh.get(i).getSoBaoDanh().substring(3));
	    lstSoBD.add(n);
	}
	
	Collections.sort(lstSoBD);
	
	for(int i = 0; i < lstThiSinh.size(); i++)
	{
	    for(int j = 0; j < lstThiSinh.size(); j++)
	    {
		if(Integer.parseInt(lstThiSinh.get(j).getSoBaoDanh().substring(3)) == lstSoBD.get(i))
		{
		    lstThiSinhAscending.add(lstThiSinh.get(i));
		    break;
		}
	    }
	}
	
	return lstThiSinhAscending;
    }
    
    
    

    
    
}
