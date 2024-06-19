/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baithuchanh_150624;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Dell Precision 7550
 */
public class ThiSinhBusiness {
    
    private List<ThiSinh> lstThiSinh = new ArrayList<ThiSinh>();
    
    public List<ThiSinh> layDanhSach()
    {
	if(lstThiSinh.isEmpty())
	{
	    taoDuLieuBanDau();
	}
	
	return lstThiSinh;
    }
    
    public void taoDuLieuBanDau()
    {
	ThiSinh objQuangHai = new ThiSinh(21.0);
	
	ThiSinh objThiAnh = new ThiSinh(19.0);
	
	ThiSinh objVanAnh = new ThiSinh(15.0);
	
	ThiSinh objThaiHoa = new ThiSinh(19.0);
	
	ThiSinh objHaiHa = new ThiSinh(15.0);
	
	ThiSinh objDangThuc = new ThiSinh(14.0);
	
	ThiSinh objLanAnh = new ThiSinh(21.0);
	
	ThiSinh objMinhHai = new ThiSinh(18.0);
	
	ThiSinh objNguyenTheNam = new ThiSinh(20.0);
	
	ThiSinh objAnhTuan = new ThiSinh(15.0);
	
	ThiSinh objThuHuyen = new ThiSinh(11.0);
	
	ThiSinh objBuiHaiNam = new ThiSinh(16.0);
	
	ThiSinh objThanhAn = new ThiSinh(24.0);
	
	ThiSinh objThiTham = new ThiSinh(25.0);
	
	ThiSinh objHaiAnh = new ThiSinh(17.0);
	
	ThiSinh objAnhQuang = new ThiSinh(24.0);
	
	ThiSinh objMinhDuc = new ThiSinh(28.0);
	
	ThiSinh objLaiTheNam = new ThiSinh(15.0);
	
	ThiSinh objThiTuoi = new ThiSinh(15.0);
	
	ThiSinh objThanhTam = new ThiSinh(17.0);
	
	ThiSinh objAnhHung = new ThiSinh(24.0);
	
	ThiSinh objMinhAnh = new ThiSinh(15.0);
	
	ThiSinh objLaiHaiNam = new ThiSinh(16.0);
	
	ThiSinh objThiThanh = new ThiSinh(15.0);
	
	ThiSinh objThanhHai = new ThiSinh(12.0);
	
	lstThiSinh.add(objQuangHai);
	lstThiSinh.add(objThiAnh);
	lstThiSinh.add(objVanAnh);
	lstThiSinh.add(objThaiHoa);
	lstThiSinh.add(objHaiHa);
	lstThiSinh.add(objDangThuc);
	lstThiSinh.add(objLanAnh);
	lstThiSinh.add(objMinhHai);
	lstThiSinh.add(objNguyenTheNam);
	lstThiSinh.add(objAnhTuan);
	lstThiSinh.add(objThuHuyen);
	lstThiSinh.add(objBuiHaiNam);
	lstThiSinh.add(objThanhAn);
	lstThiSinh.add(objThiTham);
	lstThiSinh.add(objHaiAnh);
	lstThiSinh.add(objAnhQuang);
	lstThiSinh.add(objMinhDuc);
	lstThiSinh.add(objLaiTheNam);
	lstThiSinh.add(objThiTuoi);
	lstThiSinh.add(objThanhTam);
	lstThiSinh.add(objAnhHung);
	lstThiSinh.add(objMinhAnh);
	lstThiSinh.add(objMinhAnh);
	lstThiSinh.add(objLaiHaiNam);
	lstThiSinh.add(objThiThanh);
	lstThiSinh.add(objThanhHai);		
    }
    
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
    
    public List<ThiSinh> themMoi(ThiSinh objTS)
    {
	if(objTS != null)
	{
	    lstThiSinh.add(objTS);
	}
	
	return lstThiSinh;
    }
    
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
    
    public List<ThiSinh> sapXepGiamDan()
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
