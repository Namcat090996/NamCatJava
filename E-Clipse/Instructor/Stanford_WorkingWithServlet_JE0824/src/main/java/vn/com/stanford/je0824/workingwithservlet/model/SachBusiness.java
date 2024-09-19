package vn.com.stanford.je0824.workingwithservlet.model;

import java.util.ArrayList;
import java.util.List;

public class SachBusiness {

	//Khai báo 1 danh sách
	List<Sach> lstSach = new ArrayList<Sach>();
	
	public List<Sach> layDanhSach()
	{
		if(lstSach.isEmpty())
		{
			//Tạo dữ liệu
			taoDuLieuBanDau();
		}
		return lstSach;
	}
	
	/**
	 * Hàm tạo dữ liệu ban đầu
	 */
	private void taoDuLieuBanDau() {
		Sach obj = new Sach();

		// Gán giá trị
		obj.setId(1);
		obj.setTenSach("Lập trình java cơ bản");
		obj.setAnhSach("java_beginner.jpg");
		obj.setTacGia("Thomsons");
		obj.setMoTa("Sách dành cho những người mới học lập trình java những kiến thức trọng tâm, cơ bản");
		// Thêm sách vào danh sách
		lstSach.add(obj);

		Sach obj2 = new Sach("Lập trình java nâng cao");
		obj2.setId(2);
		obj2.setAnhSach("java1.jpg");
		obj2.setTacGia("Steven");
		obj2.setMoTa("Sách dành cho những người đã có kiến thức lập trình java cơ bản học để chuyên sâu về java");
		obj2.setGiaSach(150000);
		// Thêm sách vào danh sách
		lstSach.add(obj2);

		Sach obj3 = new Sach(3, "Cơ sở dữ liệu Oracle", "oracle_book.jpg",
				"Dành cho các bạn muốn tìm hiểu về hệ quản trị cơ sở dữ liệu oracle", "Tom hat", 200000);

		lstSach.add(obj3);

		Sach obj4 = new Sach(4, "Lập trình c# cơ bản", "csharp1.jpg",
				"Dành cho các bạn mới tìm hiểu về ngôn ngữ lập trình c#", "Lê Thành Nam", 250000);

		lstSach.add(obj4);

		Sach obj5 = new Sach(5, "Cơ sở dữ liệu SQL Server", "co-so-du-lieu-sql.jpg",
				"Dành cho các bạn mới tìm hiểu về cơ sở dữ liệu", "Hoàng Nhung", 100000);

		lstSach.add(obj5);
	}
	
	/**
	 * Hàm lấy thông tin chi tiết của sách theo id sách
	 * @param sachId, Id sách
	 * @return Đối tượng sách chứa đầy đủ thông tin theo id sách cần lấy nếu có
	 */
	public Sach layChiTietTheoMa(int sachId)
	{
		Sach objSach = null;
		
		for(Sach obj : lstSach)
		{
			if(obj.getId()== sachId)
			{
				objSach = obj;
				break;
			}
		}
		
		return objSach;
	}
	
	/**
	 * Hàm thêm mới thông tin sách
	 * @param objSach
	 * @return
	 */
	public boolean themMoi(Sach objSach)
	{
		if(objSach != null)
		{
			lstSach.add(objSach);
			return true;
		}
		
		return false;
	}
}
