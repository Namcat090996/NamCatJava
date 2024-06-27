/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_qlsinhvien_j0424;

import com.mysql.cj.xdevapi.Result;
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
     * 
     * @return 
     */
    public List<SinhVien> layDanhSach() {

	//Declare a list to contain student data
	List<SinhVien> lstSinhVien = new ArrayList<>();

	//Declare a command by MySQL language
	String strSQL = "Select MaSV, HoTen, NgaySinh, DienThoai, Email, DiaChi from SinhVien";

	//Declare a connection
	Connection conn = null;

	try {

	    //Call the connection function to database needed to work
	    conn = DataProvider.ketNoi();

	    //Declare a statement
	    Statement stm = conn.createStatement();

	    //Return results
	    ResultSet rs = stm.executeQuery(strSQL);

	    //Declare an object to get student data
	    SinhVien objSV = null;

	    while (rs.next()) {
		objSV = new SinhVien();
		objSV.setMaSV(rs.getString("MaSV"));
		objSV.setHoTen(rs.getString("HoTen"));
		objSV.setDienThoai(rs.getString("DienThoai"));
		objSV.setEmail(rs.getString("Email"));
		objSV.setDiaChi(rs.getString("DiaChi"));
		objSV.setNgaySinh(rs.getDate("NgaySinh"));

		//Add object to list
		lstSinhVien.add(objSV);
	    }

	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		if (conn != null) {
		    //Close the connection
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
    public SinhVien layChiTiet(String maSV) {
	
	/*
	
	//Declare a connection
	Connection conn = null;

	//Declare a command by MySQL language
	String strSQL = String.format("Select * from sinhvien where MaSV = '%s'", maSV);

	//Declare an object to get student data
	SinhVien objSV = null;

	try {
	    //Call the connection function to database needed to work
	    conn = DataProvider.ketNoi();

	    //Declare a statement
	    Statement stm = conn.createStatement();

	    //Return results
	    ResultSet rs = stm.executeQuery(strSQL);

	    //Assign data to object
	    if (rs.next()) {
		objSV = new SinhVien();
		objSV.setMaSV(rs.getString("MaSV"));
		objSV.setHoTen(rs.getString("HoTen"));
		objSV.setDienThoai(rs.getString("DienThoai"));
		objSV.setEmail(rs.getString("Email"));
		objSV.setDiaChi(rs.getString("DiaChi"));
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		if (conn != null) {
		    //Close the connection
		    conn.close();
		}
	    } catch (SQLException ex) {
		Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}

	return objSV;
	
	*/
	
	//Declare a list to contain student data
	SinhVien objSV = null;

	//Declare a command by MySQL language
	String strSQL = "Select * from SinhVien where MaSV = '" + maSV + "'";

	//Declare a connection
	Connection conn = null;

	try {

	    //Call the connection function to database needed to work
	    conn = DataProvider.ketNoi();

	    //Declare a statement
	    Statement stm = conn.createStatement();

	    //Return results
	    ResultSet rs = stm.executeQuery(strSQL);

	    while (rs.next()) {
		objSV = new SinhVien();
		//Gán giá trị cho các thuộc tính lấy được từ các cột tương ứng với dòng dữ liệu lấy dược
		objSV.setMaSV(rs.getString("MaSV"));
		objSV.setHoTen(rs.getString("HoTen"));
		objSV.setDienThoai(rs.getString("DienThoai"));
		objSV.setEmail(rs.getString("Email"));
		objSV.setDiaChi(rs.getString("DiaChi"));
		objSV.setGioiTinh(rs.getInt("GioiTinh"));
		objSV.setNgaySinh(rs.getDate("NgaySinh"));
		objSV.setMaKhoa(rs.getString("MaKhoa"));
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		if (conn != null) {
		    //Close the connection
		    conn.close();
		}
	    } catch (SQLException ex) {
		Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}

	return objSV;	
    }
    
    /**
     * Hàm thực hiện thêm thông tin sinh viên vào hệ thống
     * @param objSV, Đối tượng sinh viên
     * @return True nếu thêm thành công, False nếu thêm không thành công
     */
    public boolean themMoi(SinhVien objSV) {
	//Declare a boolean
	boolean ketQua = false;

	//Declare a connection
	Connection conn = null;

	//Call the connection function to database needed to work
	conn = DataProvider.ketNoi();

	//Declare a command by MySQl language
	String strInsert = "Insert into SinhVien(MaSV, HoTen, DienThoai, Email, DiaChi) values (?, ?, ?, ?, ?)";
	try {

	    //Khai báo công việc - Declare a prepare statement
	    PreparedStatement preStatement = conn.prepareStatement(strInsert);

	    //Thiết lập giá trị cho các tham số
	    preStatement.setString(1, objSV.getMaSV());
	    preStatement.setString(2, objSV.getHoTen());
	    preStatement.setString(3, objSV.getDienThoai());
	    preStatement.setString(4, objSV.getEmail());
	    preStatement.setString(5, objSV.getDiaChi());
	    preStatement.setInt(6, objSV.getGioiTinh());
	    preStatement.setDate(7, new Date(objSV.getNgaySinh().getTime()));

	    //Thực hiện công việc - Execute the work// Báo số dòng thực hiện thành công
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
    public boolean capNhat(SinhVien objSV) {
	
	/*
	
	//Declare a boolean
	boolean ketQua = false;

	//Declare a connection
	Connection conn = null;

	try {

	    //Call the connection function to database needed to work
	    conn = DataProvider.ketNoi();

	    //Declare a statement
	    Statement stm = conn.createStatement();

	    //Declare a command by MySQL language
	    String strUpdate = String.format("Update sinhvien set HoTen = '%s', DienThoai = '%s', Email = '%s', DiaChi = '%s' where MaSV = '%s'", objSV.getHoTen(), objSV.getDienThoai(), objSV.getEmail(), objSV.getDiaChi(), objSV.getMaSV());

	    //Execute the work
	    ketQua = stm.executeUpdate(strUpdate) > 0;

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
	
	*/
	
	//Declare a boolean
	boolean ketQua = false;

	//Declare a connection
	Connection conn = null;

	//Call the connection function to database needed to work
	conn = DataProvider.ketNoi();

	//Declare a command by MySQl language
	String strInsert = "Update SinhVien set HoTen = ?, DienThoai = ?, Email = ?, DiaChi = ?, GioiTinh = ?, NgaySinh = ? where MaSV = ?";
	try {

	    //Khai báo công việc - Declare a prepare statement
	    PreparedStatement preStatement = conn.prepareStatement(strInsert);

	    //Thiết lập giá trị cho các tham số
	    preStatement.setString(1, objSV.getHoTen());
	    preStatement.setString(2, objSV.getDienThoai());
	    preStatement.setString(3, objSV.getEmail());
	    preStatement.setString(4, objSV.getDiaChi());
	    preStatement.setInt(5, objSV.getGioiTinh());
	    preStatement.setDate(6, new Date(objSV.getNgaySinh().getTime()));
	    preStatement.setString(7, objSV.getMaSV());

	    //Thực hiện công việc - Execute the work// Báo số dòng thực hiện thành công
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
     * Hàm xóa thông tin sinh viên trong hệ thống
     * @param maSV, mã sv cần xóa
     * @return true nếu xóa thành công, false nếu không xóa thành công
     */
    public boolean xoa(String maSV) {
	
	/*

	//Declare a boolean
	boolean ketQua = false;

	//Declare a connection
	Connection conn = null;

	try {

	    //Call the connection function to db needed to work
	    conn = DataProvider.ketNoi();

	    //Declare a command by MySQL language
	    String strDelete = String.format("Delete from sinhvien where MaSV = '%s'", maSV);

	    //Declare a statement
	    Statement stm = conn.createStatement();

	    //Execute the work
	    ketQua = stm.executeUpdate(strDelete) > 0;

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
	
	*/
	
	//Declare a boolean
	boolean ketQua = false;

	//Declare a connection
	Connection conn = null;

	//Call the connection function to database needed to work
	conn = DataProvider.ketNoi();

	//Declare a command by MySQl language
	String strDelete = "Delete from SinhVien where MaSV = '" + maSV + "'";
	
	//SQL Innjection -> Tấn công vô hiệu hóa chương trình, tìm hiểu thêm
	try {

	    //Declare a statement
	    Statement stm = conn.createStatement();

	    //Thực hiện công việc - Execute the work// Báo số dòng thực hiện thành công
	    ketQua = stm.executeUpdate(strDelete) > 0;

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
    
    public boolean timKiem(String thongTin)
    {
	boolean ketQua = false;
	
	Connection conn = null;
	
	SinhVien objSV = null;
	
	String strTimKiem = String.format("Select * from SinhVien where MaSV like '%s' or HoTen like '%s' or DienThoai like '%s' or Email like '%s' or DiaChi like '%s'", thongTin, thongTin, thongTin, thongTin, thongTin);
	
	try {
	    
	    conn = DataProvider.ketNoi();
	    
	    Statement stm = conn.createStatement();
	    
	    //Return results
	    ResultSet rs = stm.executeQuery(strTimKiem);

	    //Assign data to object
	    while (rs.next()) {
		
		objSV = new SinhVien();
		objSV.setMaSV(rs.getString("MaSV"));
		objSV.setHoTen(rs.getString("HoTen"));
		objSV.setDienThoai(rs.getString("DienThoai"));
		objSV.setEmail(rs.getString("Email"));
		objSV.setDiaChi(rs.getString("DiaChi"));
		
	    }

	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return ketQua;		
    }
}
