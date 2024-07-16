/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_qlsinhvien;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell Precision 7550
 */
public class NguoiDungBus {
/**
     * Hàm lấy chi tiết thông tin sinh viên
     * @param maSV
     * @return 
     */
    public NguoiDung layThongTinDangNhap(String tenDangNhap)
    {
	//Khai báo object 
	NguoiDung objUser = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDetail = "Select UserId, TenDangNhap, MatKhau, HoTen from nguoidung where TenDangNhap = '" + tenDangNhap + "'";
	
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
		objUser = new NguoiDung();
		
		//Gán giá trị cho các thuộc tính lấy được từ các cột tương ứng với dòng dữ liệu lấy được
		objUser.setUserId(rs.getInt("UserId"));
                objUser.setHoTen(rs.getString("HoTen"));
                objUser.setTenDangNhap(rs.getString("TenDangNhap"));
                objUser.setMatKhau(rs.getString("MatKhau"));
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return objUser;	
    }

    /**
     * Hàm lấy danh sách người dùng
     * @return 
     */
    public List<NguoiDung> layDanhSachUser()
    {
	//Khai báo danh sách
	List<NguoiDung> lstUser = new ArrayList<>();
	
	//Khai báo object 
	NguoiDung objUser = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strShowData = "Select * from nguoidung";
	
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
		objUser = new NguoiDung();
		objUser.setUserId(rs.getInt("UserId"));
		objUser.setTenDangNhap(rs.getString("TenDangNhap"));
		objUser.setMatKhau(rs.getString("MatKhau"));
		objUser.setHoTen(rs.getString("HoTen"));
		objUser.setDienThoai(rs.getString("DienThoai"));
		objUser.setEmail(rs.getString("Email"));
		objUser.setVaiTro(rs.getString("VaiTro"));
	
		//Thêm vào danh sách
		lstUser.add(objUser);
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return lstUser;
    }
    
    /**
     * Hàm thêm mới thông tin người dùng
     * @param objUser 
     * @return 
     */
    public boolean themMoiUser(NguoiDung objUser)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strInsert = "Insert into nguoidung(TenDangNhap, MatKhau, HoTen, DienThoai, Email, VaiTro) values (?, ?, ?, ?, ?, ?)";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strInsert);
	    
	    //Gán giá trị cho các tham số
	    preStm.setString(1, objUser.getTenDangNhap());
	    preStm.setString(2, objUser.getMatKhau());
	    preStm.setString(3, objUser.getHoTen());
	    preStm.setString(4, objUser.getDienThoai());
	    preStm.setString(5, objUser.getEmail());
	    preStm.setString(6, objUser.getVaiTro());

	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }    

    /**
     * Hàm lấy chi tiết thông tin người dùng
     * @param tenDangNhap  
     * @return 
     */
    public NguoiDung layChiTietUser(String tenDangNhap)
    {
	//Khai báo object 
	NguoiDung objUser = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDetail = String.format("Select * from nguoidung where TenDangNhap = '%s'", tenDangNhap);
	
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
		objUser = new NguoiDung();
		
		//Gán giá trị cho các thuộc tính lấy được từ các cột tương ứng với dòng dữ liệu lấy được
		objUser.setTenDangNhap(rs.getString("TenDangNhap"));
		objUser.setMatKhau(rs.getString("MatKhau"));
		objUser.setHoTen(rs.getString("HoTen"));
		objUser.setDienThoai(rs.getString("DienThoai"));
		objUser.setEmail(rs.getString("Email"));
		objUser.setVaiTro(rs.getString("VaiTro"));
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return objUser;	
    } 
    
    /**
     * Hàm cập nhật thông tin người dùng
     * @param objUser 
     * @return 
     */
    public boolean capNhatUser(NguoiDung objUser)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strUpdate = "Update nguoidung set MatKhau = ?, HoTen = ?, DienThoai = ?, Email = ?, VaiTro = ? where TenDangNhap = ?";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strUpdate);
	    
	    //Gán giá trị cho các tham số
	    preStm.setString(1, objUser.getMatKhau());
	    preStm.setString(2, objUser.getHoTen());
	    preStm.setString(3, objUser.getDienThoai());
	    preStm.setString(4, objUser.getEmail());
	    preStm.setString(5, objUser.getVaiTro());
            preStm.setString(6, objUser.getTenDangNhap());
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    } 
    
    /**
     * Hàm xóa thông tin người dùng
     * @param tenDangNhap 
     * @return 
     */
    public boolean xoaUser(String tenDangNhap)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDelete = "Delete from nguoidung where TenDangNhap = '" + tenDangNhap + "'";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strDelete);
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }

    /**
     * Hàm tìm kiếm thông tin người dùng
     * @param tuKhoa
     * @param vaiTro
     * @return 
     */
    public List<NguoiDung> timKiemUser(String tuKhoa, String vaiTro)
    {
	//Khai báo danh sách
	List<NguoiDung> lstUser = new ArrayList<>();
	
	//Khai báo object 
	NguoiDung objUser = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strFind = "Select * from nguoidung where 1=1";
	
	//Nhập thông tin ô từ khóa
	if(!tuKhoa.isEmpty() && tuKhoa.length() > 0)
	{
	    strFind += " AND (TenDangNhap = '" + tuKhoa + "' OR HoTen like '%" + tuKhoa + "%' OR DienThoai like '%" + tuKhoa + "%' OR Email like '%" + tuKhoa + "%')";
	}
	
	//Nhập thông tin ô vai trò
	if(!vaiTro.isEmpty() && vaiTro.length() > 0)
	{
	    strFind += " AND VaiTro = '" + vaiTro + "'";
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
		objUser = new NguoiDung();
		objUser.setTenDangNhap(rs.getString("TenDangNhap"));
		objUser.setMatKhau(rs.getString("MatKhau"));
		objUser.setHoTen(rs.getString("HoTen"));
		objUser.setDienThoai(rs.getString("DienThoai"));
		objUser.setEmail(rs.getString("Email"));
		objUser.setVaiTro(rs.getString("VaiTro"));
		
		//Thêm vào danh sách
		lstUser.add(objUser);
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return lstUser;
    }
    
    /**
     * Hàm kiểm tra trùng tên đăng nhập
     * @param tenDangNhap 
     * @return 
     */
    public boolean kiemTraTrungTenDN(String tenDangNhap)
    {
	//Khai báo boolean
	boolean ketQua = true;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDuplicate = "Select * from nguoidung";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strDuplicate);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    String tenDangNhapBD;
	    
	    while(rs.next())
	    {
		tenDangNhapBD = rs.getString("TenDangNhap");
		if(tenDangNhap.equals(tenDangNhapBD))
		{
		    ketQua = false;
		    break;
		}
	    }    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(NguoiDungBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }    
}
