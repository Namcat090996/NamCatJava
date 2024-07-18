/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_qlsinhvien;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell Precision 7550
 */
public class SinhVienBus {
    
    /**
     * Hàm lấy danh sách sinh viên
     * @return 
     */
    public List<SinhVien> layDanhSachSV()
    {
	//Khai báo danh sách
	List<SinhVien> lstSV = new ArrayList<SinhVien>();
	
	//Khai báo object 
	SinhVien objSV = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strShowData = "Select * from sinhvien";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strShowData);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    //Gán giá trị cho object và add object vào list
	    while(rs.next())//Duyệt từng dòng trong database
	    {
		objSV = new SinhVien();
		objSV.setMaSV(rs.getString("MaSV"));
		objSV.setHoTen(rs.getString("HoTen"));
		objSV.setGioiTinh(rs.getInt("GioiTinh"));
		objSV.setNgaySinh(rs.getDate("NgaySinh"));
		objSV.setDienThoai(rs.getString("DienThoai"));
		objSV.setEmail(rs.getString("Email"));
		objSV.setDiaChi(rs.getString("DiaChi"));
		objSV.setMaKhoa(rs.getString("MaKhoa"));
		
		//Thêm vào danh sách
		lstSV.add(objSV);
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return lstSV;
    }
    
    /**
     * Hàm thêm mới thông tin sinh viên
     * @param objSV
     * @return 
     */
    public boolean themMoiSV(SinhVien objSV)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strInsert = "Insert into sinhvien(MaSV, HoTen, GioiTinh, NgaySinh, DienThoai, Email, DiaChi, MaKhoa) values (?, ?, ?, ?, ?, ?, ?, ?)";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strInsert);
	    
	    //Gán giá trị cho các tham số
	    preStm.setString(1, objSV.getMaSV());
	    preStm.setString(2, objSV.getHoTen());
	    preStm.setInt(3, objSV.getGioiTinh());
	    preStm.setDate(4, new Date(objSV.getNgaySinh().getTime()));
	    preStm.setString(5, objSV.getDienThoai());
	    preStm.setString(6, objSV.getEmail());
	    preStm.setString(7, objSV.getDiaChi());
	    preStm.setString(8, objSV.getMaKhoa());
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }
    
    /**
     * Hàm lấy chi tiết thông tin sinh viên
     * @param maSV
     * @return 
     */
    public SinhVien layChiTietSV(String maSV)
    {
	//Khai báo object 
	SinhVien objSV = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDetail = String.format("Select * from sinhvien where MaSV = '%s'", maSV);
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strDetail);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    //Gán giá trị cho object 
	    while(rs.next())//Duyệt từng dòng trong database
	    {
		objSV = new SinhVien();
		
		//Gán giá trị cho các thuộc tính lấy được từ các cột tương ứng với dòng dữ liệu lấy được
		objSV.setMaSV(rs.getString("MaSV"));
		objSV.setHoTen(rs.getString("HoTen"));
		objSV.setGioiTinh(rs.getInt("GioiTinh"));
		objSV.setNgaySinh(rs.getDate("NgaySinh"));
		objSV.setDienThoai(rs.getString("DienThoai"));
		objSV.setEmail(rs.getString("Email"));
		objSV.setDiaChi(rs.getString("DiaChi"));
		objSV.setMaKhoa(rs.getString("MaKhoa"));
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return objSV;	
    }
    
    /**
     * Hàm cập nhật thông tin sinh viên
     * @param objSV
     * @return 
     */
    public boolean capNhatSV(SinhVien objSV)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strUpdate = "Update sinhvien set HoTen = ?, GioiTinh = ?, NgaySinh = ?, DienThoai = ?, Email = ?, DiaChi = ?, MaKhoa = ? where MaSV = ?";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strUpdate);
	    
	    //Gán giá trị cho các tham số
	    preStm.setString(1, objSV.getHoTen());
	    preStm.setInt(2, objSV.getGioiTinh());
	    preStm.setDate(3, new Date(objSV.getNgaySinh().getTime()));
	    preStm.setString(4, objSV.getDienThoai());
	    preStm.setString(5, objSV.getEmail());
	    preStm.setString(6, objSV.getDiaChi());
	    preStm.setString(7, objSV.getMaKhoa());
	    preStm.setString(8, objSV.getMaSV());
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }
    
    /**
     * Hàm xóa thông tin sinh viên
     * @param maSV
     * @return 
     */
    public boolean xoaSV(String maSV)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDelete = "Delete from sinhvien where MaSV = '" + maSV + "'";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strDelete);
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }
    
    /**
     * Hàm tìm kiếm sinh viên
     * @return 
     */
    public List<SinhVien> timKiemSV(String tuKhoa, String maKhoa)
    {
	//Khai báo danh sách
	List<SinhVien> lstSV = new ArrayList<SinhVien>();
	
	//Khai báo object 
	SinhVien objSV = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strFind = "Select * from sinhvien where 1=1";
	
	//Nhập thông tin ô từ khóa
	if(!tuKhoa.isEmpty() && tuKhoa.length() > 0)
	{
	    strFind += " AND (MaSV = '" + tuKhoa + "' OR HoTen like '%" + tuKhoa + "%' OR DienThoai like '%" + tuKhoa + "%')";
	}
	
	//Nhập thông tin ô mã khoa
	if(!maKhoa.isEmpty() && maKhoa.length() > 0)
	{
	    strFind += " AND sinhvien.MaKhoa = '" + maKhoa + "'";
	}
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strFind);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    //Gán giá trị cho object và add object vào list
	    while(rs.next())//Duyệt từng dòng trong database
	    {
		objSV = new SinhVien();
		objSV.setMaSV(rs.getString("MaSV"));
		objSV.setHoTen(rs.getString("HoTen"));
		objSV.setGioiTinh(rs.getInt("GioiTinh"));
		objSV.setNgaySinh(rs.getDate("NgaySinh"));
		objSV.setDienThoai(rs.getString("DienThoai"));
		objSV.setEmail(rs.getString("Email"));
		objSV.setDiaChi(rs.getString("DiaChi"));
		objSV.setMaKhoa(rs.getString("MaKhoa"));
		
		//Thêm vào danh sách
		lstSV.add(objSV);
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return lstSV;
    }   
    
    /**
     * Hàm kiểm tra trùng mã SV
     * @param maSV
     * @return 
     */
    public boolean kiemTraTrungMaSV(String maSV)
    {
	//Khai báo boolean
	boolean ketQua = true;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDuplicate = "Select * from sinhvien";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strDuplicate);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    String maNhap;
	    
	    while(rs.next())
	    {
		maNhap = rs.getString("MaSV");
		if(maSV.equals(maNhap))
		{
		    ketQua = false;
		    break;
		}
	    }    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(SinhVienBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }
}
