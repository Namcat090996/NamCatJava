package vn.com.stanford.servlet.model;

import java.util.ArrayList;
import java.util.List;

public class SachBusiness {
	
	//Khai báo 1 danh sách
	List<Sach> lstSach = new ArrayList<Sach>();
	
	public List<Sach> layDanhSach()
	{
		return lstSach;
	}
}
