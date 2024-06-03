/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_lopvadoituong2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell Precision 7550
 */
public class SinhVienBusiness {
    
    private List<SinhVien> lstSV = new ArrayList<SinhVien>();
    
    public List<SinhVien> layDanhSach()
    {
	if(lstSV.isEmpty())
	{
	    taoDuLieuBanDau();
	}
	return lstSV;
    }
    
    private void taoDuLieuBanDau()
    {
	SinhVien objManh = new SinhVien();
	
	objManh.setMaSV("123456");
	objManh.setHoTen("Mạnh lõ");
	
	lstSV.add(objManh);
	
	SinhVien objCat = new SinhVien("Đà Nẵng");
	
	lstSV.add(objCat);
	
	SinhVien objLy = new SinhVien("123132", "Ly lỏ", "loglfdy", "fnasuidonbfo");
	
	lstSV.add(objLy);
	
    }
    

    
    
    
}
