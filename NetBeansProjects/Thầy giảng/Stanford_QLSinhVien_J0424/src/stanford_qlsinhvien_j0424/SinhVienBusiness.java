/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_qlsinhvien_j0424;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dangquang16
 */
public class SinhVienBusiness {
    
    /**
     * Khai báo danh sách sinh viên
     */
    private List<SinhVien> lstSinhVien = new ArrayList();
    
    public List<SinhVien> layDanhSach() {
	
	//Khai báo danh sách
	List<SinhVien> lstSinhVien = new ArrayList<>();

	String strSQL = "Select MaSV, HoTen, DienThoai, Email, DiaChi from SinhVien";
	//Khai báo kết nối
	Connection conn = null;

	try {

	    //Kết nối đến db cần làm việc
	    conn = DataProvider.ketNoi();

	    //Tạo công việc
	    Statement stm = conn.createStatement();

	    //Thực hiện và trả về kết quả
	    ResultSet rs = stm.executeQuery(strSQL);

	    //Duyệt từng dòng để đưa về object SinhVien
	    SinhVien objSV;
	    while (rs.next()) {
		objSV = new SinhVien();
		objSV.setMaSV(rs.getString("MaSV"));
		objSV.setHoTen(rs.getString("HoTen"));
		objSV.setDienThoai(rs.getString("DienThoai"));
		objSV.setEmail(rs.getString("Email"));
		objSV.setDiaChi(rs.getString("DiaChi"));

		//Thêm vào danh sách
		lstSinhVien.add(objSV);
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		if (conn != null) {
		    conn.close();
		}
	    } catch (SQLException ex) {
		Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}

	return lstSinhVien;
	
    }
    
    /**
     * Hàm lấy thông tin chi tiết sinh viên
     * @param maSV, Mã sv
     * @return Đối tượng sv chứa tất cả thông tin sv cần lấy được theo mã sv
     */
    public SinhVien layChiTiet(String maSV)
    {
        SinhVien objSV = null;
        
        //Duyệt từng phần tử để tìm sv trùng mã
        for(SinhVien sv : lstSinhVien)
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
     * Hàm thực hiện thêm thông tin sinh viên vào hệ thống
     * 
     * @param objSV, Đối tượng sinh viên
     * @return True nếu thêm thành công, False nếu thêm không thành công
     */
    public boolean themMoi(SinhVien objSV)
    {

	    boolean ketQua = false;
	    
	    Connection conn = null;
	    
	    conn = DataProvider.ketNoi();
	    
	    String strInsert = "Insert into SinhVien(MaSV, HoTen, DienThoai, Email, DiaChi) values(?, ?, ?, ?, ?)";
	try {
	    
	    //Khai báo công việc
	    PreparedStatement preStatement = conn.prepareStatement(strInsert);
	    
	    //Thiết lập giá trị cho các tham số
	    preStatement.setString(1, objSV.getMaSV());
	    preStatement.setString(2, objSV.getHoTen());
	    preStatement.setString(3, objSV.getDienThoai());
	    preStatement.setString(4, objSV.getEmail());
	    preStatement.setString(5, objSV.getDiaChi());
	    
	    //Thực hiện công việc
	    ketQua = preStatement.executeUpdate() > 0;
	    
	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		if (conn != null) {
		    conn.close();
		}
	    } catch (SQLException ex) {
		Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;
	
    }
    
    /**
     * Hàm cập nhật thông tin sv
     * @param objSV, Đối tượng sv chứa các thông tin mới cần cập nhật
     * @return True nếu cập nhật thành công, False nếu thất bại
     */
    public boolean capNhat(SinhVien objSV)
    {
        //Duyệt sinh viên để tìm sv trùng mã và cập nhật giá trị mới cần sửa
        for(int i = 0; i < lstSinhVien.size(); i++)
        {
            //Nếu có sv trùng mã
            if(lstSinhVien.get(i).getMaSV().equals(objSV.getMaSV()))
            {
                lstSinhVien.set(i, objSV);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Hàm xóa thông tin sinh viên trong hệ thống
     * @param maSV, mã sv cần xóa
     * @return true nếu xóa thành công, false nếu không xóa thành công
     */
    public boolean xoa(String maSV)
    {
        //Lấy thông tin sv cần xóa
        SinhVien objSV = layChiTiet(maSV);
        
        if(objSV != null)
        {
            lstSinhVien.remove(objSV);
            
            return true;
        }
        
        return false;
    }
}
