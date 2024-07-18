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
public class PhongHocBus {
    
    /**
     * Hàm lấy danh sách phòng học
     * @return 
     */
    public List<PhongHoc> layDanhSachPH()
    {
	//Khai báo danh sách
	List<PhongHoc> lstPH = new ArrayList<PhongHoc>();
	
	//Khai báo object 
	PhongHoc objPH = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strShowData = "Select * from phonghoc";
	
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
		objPH = new PhongHoc();
		objPH.setMaPH(rs.getString("MaPhong"));
		objPH.setTenPH(rs.getString("TenPhong"));
                objPH.setMoTa(rs.getString("MoTa"));
		
		//Thêm vào danh sách
		lstPH.add(objPH);
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return lstPH;
    } 
    
    /**
     * Hàm lấy chi tiết thông tin phòng học
     * @param maPH
     * @return 
     */
    public PhongHoc layChiTietPH(String maPH)
    {
	//Khai báo object 
	PhongHoc objPH = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDetail = String.format("Select * from phonghoc where MaPhong = '%s'", maPH);
	
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
		objPH = new PhongHoc();
		
		//Gán giá trị cho các thuộc tính lấy được từ các cột tương ứng với dòng dữ liệu lấy được
		objPH.setMaPH(rs.getString("MaPhong"));
		objPH.setTenPH(rs.getString("TenPhong"));
                objPH.setMoTa(rs.getString("MoTa"));
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return objPH;	
    }
    
    /**
     * Hàm tìm kiếm phòng học
     * @return 
     */
    public List<PhongHoc> timKiemPH(String tuKhoa)
    {
	//Khai báo danh sách
	List<PhongHoc> lstPH = new ArrayList<PhongHoc>();
	
	//Khai báo object 
	PhongHoc objPH = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strFind = "Select * from phonghoc where 1=1";
	
	//Nhập thông tin ô từ khóa
	if(!tuKhoa.isEmpty() && tuKhoa.length() > 0)
	{
	    strFind += " AND (MaPhong = '" + tuKhoa + "' OR TenPhong like '%" + tuKhoa + "%' OR MoTa like '%" + tuKhoa + "%')";
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
		objPH = new PhongHoc();
		objPH.setMaPH(rs.getString("MaPhong"));
		objPH.setTenPH(rs.getString("TenPhong"));
                objPH.setMoTa(rs.getString("MoTa"));
		
		//Thêm vào danh sách
		lstPH.add(objPH);
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return lstPH;
    }

    /**
     * Hàm thêm mới thông tin phòng học
     * @param objPH
     * @return 
     */
    public boolean themMoiPH(PhongHoc objPH)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strInsert = "Insert into phonghoc(MaPhong, TenPhong, MoTa) values (?, ?, ?)";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strInsert);
	    
	    //Gán giá trị cho các tham số
	    preStm.setString(1, objPH.getMaPH());
            preStm.setString(2, objPH.getTenPH());
            preStm.setString(3, objPH.getMoTa());
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    } 
    
    /**
     * Hàm kiểm tra trùng mã phòng học
     * @param maPH
     * @return 
     */
    public boolean kiemTraTrungMaPH(String maPH)
    {
	//Khai báo boolean
	boolean ketQua = true;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDuplicate = "Select * from phonghoc";
	
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
		maKiemTra = rs.getString("MaPhong");
		if(maPH.equals(maKiemTra))
		{
		    ketQua = false;
		    break;
		}
	    }    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }    
    
    /**
     * Hàm cập nhật thông tin phòng học
     * @param objPH
     * @return 
     */
    public boolean capNhatPH(PhongHoc objPH)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strUpdate = "Update phonghoc set TenPhong = ?, MoTa = ? where MaPhong = ?";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strUpdate);
	    
	    //Gán giá trị cho các tham số
	    preStm.setString(1, objPH.getTenPH());
	    preStm.setString(2, objPH.getMoTa());
	    preStm.setString(3, objPH.getMaPH());
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }   
    
    /**
     * Hàm xóa thông tin phòng học
     * @param maPH
     * @return 
     */
    public boolean xoaPH(String maPH)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDelete = "Delete from phonghoc where MaPhong = '" + maPH + "'";
	
	try {
	    
	    //Kết nối vớiDatabase cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strDelete);
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(PhongHocBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }        
    
}
