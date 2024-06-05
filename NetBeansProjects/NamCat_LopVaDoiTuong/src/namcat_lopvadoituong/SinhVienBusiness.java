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
    
    public void taoDuLieuBanDau()
    {
	SinhVien objManh = new SinhVien("Hà Nam");

	
        objManh.setMaSV("SF001");
        objManh.setHoTen("Nguyễn Thế Mạnh");
        objManh.setDienThoai("0988333568");
        objManh.setEmail("themanh@gmail.com");
	
	SinhVien objTruc = new SinhVien("Hà Nam");
        objTruc.setMaSV("SF002");
        objTruc.setHoTen("Bạch Văn Trúc");
        objTruc.setDienThoai("0936548925");
        objTruc.setEmail("trucbv@gmail.com");
	
	SinhVien objHoan = new SinhVien("SF003", "Hoàng Văn Hoan", "0988333556", "hoanghv@outlook.com", "Hà Nam");
	SinhVien objPhuong = new SinhVien("SF004", "Nguyễn Duy Phương", "0988331258", "duyphuong@outlook.com", "Hồ Chí Minh");
	SinhVien objDuyen = new SinhVien("SF005", "Trần Mỹ Duyên", "0986531258", "myduyen@gmail.com", "Hà Nội");
	
	lstSinhVien.add(objManh);
	lstSinhVien.add(objTruc);
	lstSinhVien.add(objHoan);
	lstSinhVien.add(objPhuong);
	lstSinhVien.add(objDuyen);
    }
    
    public SinhVien layChiTiet(String maSV)
    {
	SinhVien objSV = new SinhVien();
	
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
	    
    
    
    
}
