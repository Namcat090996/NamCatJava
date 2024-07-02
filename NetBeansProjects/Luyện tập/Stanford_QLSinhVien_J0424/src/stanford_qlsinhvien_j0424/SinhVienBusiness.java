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
    
    List<SinhVien> lstSinhVien = new ArrayList<>();
    
    /**
     * Function to get student list
     * @return 
     */
    public List<SinhVien> layDanhSach() {
	//Declare a list
	List<SinhVien> lstSinhVien = new ArrayList();

	//Declare an object
	SinhVien objSV;

	//Declare a connection
	Connection conn = null;

	try {

	    //Declare a connection
	    conn = DataProvider.ketNoi();

	    //Declare a MySQL command
	    String strSQL = "Select * from sinhvien";

	    //Declare a statement
	    Statement stm = conn.createStatement();

	    //Return results
	    ResultSet rs = stm.executeQuery(strSQL);

	    //Browse each row to return it to object SinhVien
	    while (rs.next()) {
		objSV = new SinhVien();
		objSV.setMaSV(rs.getString("MaSV"));
		objSV.setHoTen(rs.getString("HoTen"));
		objSV.setDienThoai(rs.getString("DienThoai"));
		objSV.setEmail(rs.getString("Email"));
		objSV.setDiaChi(rs.getString("DiaChi"));

		//Add object (objSV) to list
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
     * Function to add student information to database
     * 
     * @param objSV, student object
     * @return True if the add is successful, False if the add isn't successful
     */
    public boolean themMoi(SinhVien objSV) {
	//Declare a boolean
	boolean ketQua = false;

	//Declare a MySQL command 
	String strInsert = "Insert into sinhvien(MaSV, HoTen, DienThoai, Email, DiaChi) values (?, ?, ?, ?, ?)";

	//Declare a connection
	Connection conn = null;

	try {

	    //Call the connection function to database needed to work
	    conn = DataProvider.ketNoi();

	    //Declare a PreparedStatement
	    PreparedStatement preparedStatement = conn.prepareStatement(strInsert);

	    //Set values for parameters
	    preparedStatement.setString(1, objSV.getMaSV());
	    preparedStatement.setString(2, objSV.getHoTen());
	    preparedStatement.setString(3, objSV.getDienThoai());
	    preparedStatement.setString(4, objSV.getEmail());
	    preparedStatement.setString(5, objSV.getDiaChi());

	    //Perform the work
	    ketQua = preparedStatement.executeUpdate() > 0;
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
