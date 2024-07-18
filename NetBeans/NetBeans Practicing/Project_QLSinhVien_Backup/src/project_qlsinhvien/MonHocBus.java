/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_qlsinhvien;

import java.sql.Connection;
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
public class MonHocBus {
    
    /**
     * Hàm lấy danh sách môn học
     * @return 
     */
    public List<MonHoc> layDanhSachMH()
    {
	//Khai báo danh sách
	List<MonHoc> lstMH = new ArrayList<MonHoc>();
	
	//Khai báo object
	MonHoc objMH = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strShowData = "Select * from monhoc";
	
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
		objMH = new MonHoc();
		objMH.setMaMH(rs.getString("MaMH"));
		objMH.setTenMonHoc(rs.getString("TenMonHoc"));
                objMH.setSoTiet(rs.getInt("SoTiet"));
		
		//Thêm vào danh sách
		lstMH.add(objMH);
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return lstMH;
    } 
    
    /**
     * Hàm lấy chi tiết thông tin môn học
     * @param maMH
     * @return 
     */
    public MonHoc layChiTietMH(String maMH)
    {
	//Khai báo object 
	MonHoc objMH = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDetail = String.format("Select * from monhoc where MaMH = '%s'", maMH);
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strDetail);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    //Gán giá trị cho object và add object vào list
	    while(rs.next())//Duyệt từng dòng trong database
	    {
		objMH = new MonHoc();
		
		//Gán giá trị cho các thuộc tính lấy được từ các cột tương ứng với dòng dữ liệu lấy được
		objMH.setMaMH(rs.getString("MaMH"));
		objMH.setTenMonHoc(rs.getString("TenMonHoc"));
                objMH.setSoTiet(rs.getInt("SoTiet"));
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return objMH;	
    }
    
    /**
     * Hàm tìm kiếm môn học
     * @return 
     */
    public List<MonHoc> timKiemMH(String tuKhoa)
    {
	//Khai báo danh sách
	List<MonHoc> lstMH = new ArrayList<MonHoc>();
	
	//Khai báo object 
	MonHoc objMH = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strFind = "Select * from monhoc where 1=1";
	
	//Nhập thông tin ô từ khóa
	if(!tuKhoa.isEmpty() && tuKhoa.length() > 0)
	{
	    strFind += " AND (MaMH = '" + tuKhoa + "' OR TenMonHoc like '%" + tuKhoa + "%' OR SoTiet like '%" + tuKhoa + "%')";
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
		objMH = new MonHoc();
		objMH.setMaMH(rs.getString("MaMH"));
		objMH.setTenMonHoc(rs.getString("TenMonHoc"));
                objMH.setSoTiet(rs.getInt("SoTiet"));
		
		//Thêm vào danh sách
		lstMH.add(objMH);
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return lstMH;
    }

    /**
     * Hàm thêm mới thông tin môn học
     * @param objMH
     * @return 
     */
    public boolean themMoiMH(MonHoc objMH)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strInsert = "Insert into monhoc(MaMH, TenMonHoc, SoTiet) values (?, ?, ?)";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strInsert);
	    
	    //Gán giá trị cho các tham số
	    preStm.setString(1, objMH.getMaMH());
            preStm.setString(2, objMH.getTenMonHoc());
            preStm.setInt(3, objMH.getSoTiet());
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    } 
    
    /**
     * Hàm kiểm tra trùng mã môn học
     * @param maMH
     * @return 
     */
    public boolean kiemTraTrungMaMH(String maMH)
    {
	//Khai báo boolean
	boolean ketQua = true;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDuplicate = "Select * from monhoc";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strDuplicate);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    String maKiemTra;
	    
	    while(rs.next())
	    {
		maKiemTra = rs.getString("MaMH");
		if(maMH.equals(maKiemTra))
		{
		    ketQua = false;
		    break;
		}
	    }    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }    
    
    /**
     * Hàm cập nhật thông tin môn học
     * @param objMH
     * @return 
     */
    public boolean capNhatMH(MonHoc objMH)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strUpdate = "Update monhoc set TenMonHoc = ?, SoTiet = ? where MaMH = ?";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strUpdate);
	    
	    //Gán giá trị cho các tham số
	    preStm.setString(1, objMH.getTenMonHoc());
	    preStm.setInt(2, objMH.getSoTiet());
	    preStm.setString(3, objMH.getMaMH());
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }   
    
    /**
     * Hàm xóa thông tin môn học
     * @param maMH
     * @return 
     */
    public boolean xoaMH(String maMH)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDelete = "Delete from monhoc where MaMH = '" + maMH + "'";
	
	try {
	    
	    //Kết nối vớiDatabase cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strDelete);
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(MonHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }    
    
}
