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
	ThiSinh objQuangHai = new ThiSinh("TLA001", "Bùi Quang Hải", "0", "08/11/90", "Hà Nội", 21.0, 7.0, 8.0, 6.0);
	
	ThiSinh objThiAnh = new ThiSinh("TLA002", "Nguyễn Thị Anh", "1", "27/11/88", "Hải Phòng", 19.0, 5.0, 8.0, 6.0);
	
	ThiSinh objVanAnh = new ThiSinh("TLA003", "Nguyễn Văn Anh", "0", "21/11/89", "Nam Định", 15.0, 5.0, 4.0, 6.0);
	
	ThiSinh objThaiHoa = new ThiSinh("TLA004", "Trần Thái Hòa", "0", "08/10/90", "Hải Dương", 19.0, 6.0, 8.0, 5.0);
	
	ThiSinh objHaiHa = new ThiSinh("TLA005", "Lê Hải Hà", "0", "12/11/90", "Hà Nam", 15.0, 5.0, 7.0, 3.0);
	
	ThiSinh objDangThuc = new ThiSinh("TLA006", "Đỗ Đăng Thức", "0", "07/11/90", "Bắc Giang", 14.0, 4.0, 9.0, 1.0);
	
	ThiSinh objLanAnh = new ThiSinh("TLA007", "Nguyễn Lan Anh", "1", "15/07/90", "Bắc Ninh", 21.0, 7.0, 8.0, 6.0);
	
	ThiSinh objMinhHai = new ThiSinh("TLA008","Trịnh Minh Hải","0","06/08/88","Hải Dương",18.0,6.0,6.0,6.0);
	
	ThiSinh objNguyenTheNam = new ThiSinh("TLA009","Nguyễn Thế Nam","0","09/10/90","Hà Nội",20.0,7.0,7.0,6.0);
	
	ThiSinh objAnhTuan = new ThiSinh("TLA010","Hoàng Anh Tuấn","0","24/11/90","Thanh Hóa",15.0,5.0,4.0,6.0);
	
	ThiSinh objThuHuyen = new ThiSinh("TLA011","Đặng Thu Huyền","1","18/12/89","Hải Dương",11.0,5.0,1.0,6.0);
	
	ThiSinh objBuiHaiNam = new ThiSinh("TLA012","Bùi Hải Nam","0","08/10/90","Thanh Hóa",16.0,7.0,3.0,6.0);
	
	ThiSinh objThanhAn = new ThiSinh("TLA013","Trần Thanh An","0","08/05/90","Nam Định",24.0,9.0,8.0,7.0);
	
	ThiSinh objThiTham = new ThiSinh("TLA014","Vũ Thị Thắm","1","25/06/88","Hải Phòng",25.0,8.0,8.0,9.0);
	
	ThiSinh objHaiAnh = new ThiSinh("TLA015","Phan Hải Anh","0","12/10/90","Hải Dương",17.0,2.0,8.0,7.0);
	
	ThiSinh objAnhQuang = new ThiSinh("TLA016","Phạm Anh Quang","0","20/07/90","Hà Nội",24.0,10.0,8.0,6.0);
	
	ThiSinh objMinhDuc = new ThiSinh("TLA017","Lê Minh Đức","0","04/08/90","Thái Bình",28.0,9.0,9.0,10.0);
	
	ThiSinh objLaiTheNam = new ThiSinh("TLA018","Lại Thế Nam","0","06/12/88","Yên Bái",15.0,5.0,4.0,6.0);
	
	ThiSinh objThiTuoi = new ThiSinh("TLA019","Nguyễn Thị Tươi","1","05/02/90","Hưng Yên",15.0,1.0,8.0,6.0);
	
	ThiSinh objThanhTam = new ThiSinh("TLA020","Trần Thanh Tâm","1","09/08/88","Hà Nam",17.0,5.0,6.0,6.0);
	
	ThiSinh objAnhHung = new ThiSinh("TLA021","Phạm Anh Hùng","0","20/09/90","Hà Nội",24.0,10.0,8.0,6.0);
	
	ThiSinh objMinhAnh = new ThiSinh("TLA022","Lê Minh Anh","0","08/09/90","Thái Bình",15.0,2.0,7.0,6.0);
	
	ThiSinh objLaiHaiNam = new ThiSinh("TLA023","Lại Hải Nam","0","06/11/90","Yên Bái",16.0,5.0,5.0,6.0);
	
	ThiSinh objThiThanh = new ThiSinh("TLA025","Nguyễn Thị Thành","1","08/04/90","Hưng Yên",15.0,1.0,8.0,6.0);
	
	ThiSinh objThanhHai = new ThiSinh("TLA026","Trần Thanh Hải","1","09/08/88","Hà Nam",12.0,5.0,1.0,6.0);
	
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
    
    public boolean kiemTraTrung(String soBaoDanh)
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
