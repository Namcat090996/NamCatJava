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
import java.util.List;

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
    
    public List<ThiSinh> top5DiemCaoNhat()
    {	
	List<ThiSinh> lstThiSinhs = new ArrayList<>();
	
	List<ThiSinh> lstTop5 = new ArrayList<ThiSinh>();
	
	ThiSinh objTS;
	
	for(ThiSinh ts: lstThiSinh)
	{
	    lstThiSinhs.add(ts);
	}
	
	for(int i = 0; i < lstThiSinhs.size()-1; i++)
	{
	    for(int j = i+1; j < lstThiSinhs.size(); j++)
	    {
		if(lstThiSinhs.get(i).getTongDiem() < lstThiSinhs.get(j).getTongDiem())
		{
		    objTS = lstThiSinhs.get(i);
		    lstThiSinhs.set(i, lstThiSinhs.get(j));
		    lstThiSinhs.set(j, objTS);
		    
		}
	    }
	}
	
	for(int i = 0; i < 4; i++)
	{
	    lstTop5.add(lstThiSinhs.get(i));
	}
	
	double max = lstThiSinhs.get(4).getDiemToan();
	
	for(int i = 4; i < lstThiSinhs.size(); i++)
	{
	    if(lstThiSinhs.get(i).getDiemToan() > max)
	    {
		max = lstThiSinhs.get(i).getDiemToan();
	    }
	}
	
	for(int i = 4; i < lstThiSinhs.size(); i++)
	{
	    if(!lstThiSinhs.get(i).getQueQuan().equals("Hà Nội") && lstThiSinhs.get(i).getDiemToan() == max)
	    {
		lstTop5.add(lstThiSinhs.get(i));
		break;
	    }
	    if(i == lstThiSinhs.size()-1)
	    {
		lstTop5.add(lstThiSinhs.get(4));
	    }
	}

	return lstTop5;
    }
    
    public List<ThiSinh> diemSan()
    {
	List<ThiSinh> lstDiemSan = new ArrayList<>();
	
	for(int i = 0; i < lstThiSinh.size(); i++)
	{
	    if(lstThiSinh.get(i).getTongDiem() >= 15)
	    {
		if(lstThiSinh.get(i).getDiemToan() > 1 && lstThiSinh.get(i).getDiemLy() > 1 && lstThiSinh.get(i).getDiemHoa() > 1)
		{
		    lstDiemSan.add(lstThiSinh.get(i));
		}
	    }
	}
	
	return lstDiemSan;
    }
    
     public List<ThiSinh> diemLiet()
    {
	List<ThiSinh> lstDiemLiet = new ArrayList<>();
	
	for(int i = 0; i < lstThiSinh.size(); i++)
	{
	    if(lstThiSinh.get(i).getDiemToan() <= 1 || lstThiSinh.get(i).getDiemLy() <= 1 || lstThiSinh.get(i).getDiemHoa() <= 1)
	    {
		lstDiemLiet.add(lstThiSinh.get(i));
	    }
	}
	
	return lstDiemLiet;
    }   
    

    
    
}
