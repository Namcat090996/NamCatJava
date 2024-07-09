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
public class ChuyenKhoaBus {
    
    /**
     * Hàm lấy danh sách khoa
     * @return 
     */
    public List<ChuyenKhoa> layDanhSachKhoa()
    {
	//Khai báo danh sách
	List<ChuyenKhoa> lstKhoa = new ArrayList<ChuyenKhoa>();
	
	//Khai báo object SinhVien
	ChuyenKhoa objKhoa = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strShowData = "Select * from chuyenkhoa";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strShowData);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    //Gán giá trị cho objSV và add object vào ListSV
	    while(rs.next())//Duyệt từng dòng trong database
	    {
		objKhoa = new ChuyenKhoa();
		objKhoa.setMaKhoa(rs.getString("MaKhoa"));
		objKhoa.setTenKhoa(rs.getString("TenKhoa"));
		
		//Thêm vào danh sách
		lstKhoa.add(objKhoa);
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(ChuyenKhoaBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(ChuyenKhoaBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return lstKhoa;
    } 
    
    public ChuyenKhoa layChiTietKhoa(String maKhoa)
    {
	//Khai báo object SinhVien
	ChuyenKhoa objKhoa = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDetail = String.format("Select * from chuyenkhoa where MaKhoa = '%s'", maKhoa);
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strDetail);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    //Gán giá trị cho objSV và add object vào ListSV
	    while(rs.next())//Duyệt từng dòng trong database
	    {
		objKhoa = new ChuyenKhoa();
		
		//Gán giá trị cho các thuộc tính lấy được từ các cột tương ứng với dòng dữ liệu lấy được
		objKhoa.setMaKhoa(rs.getString("MaKhoa"));
		objKhoa.setTenKhoa(rs.getString("TenKhoa"));
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(ChuyenKhoaBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(ChuyenKhoaBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return objKhoa;	
    }
    
    /**
     * Hàm tìm kiếm khoa
     * @return 
     */
    public List<ChuyenKhoa> timKiemKhoa(String tuKhoa)
    {
	//Khai báo danh sách
	List<ChuyenKhoa> lstKhoa = new ArrayList<ChuyenKhoa>();
	
	//Khai báo object SinhVien
	ChuyenKhoa objKhoa = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strFind = "Select MaKhoa, TenKhoa, OrderNumber from chuyenkhoa where 1=1";
	
	//Nhập thông tin ô từ khóa
	if(!tuKhoa.isEmpty() && tuKhoa.length() > 0)
	{
	    strFind += " AND (MaKhoa = '" + tuKhoa + "' OR TenKhoa like '%" + tuKhoa + "%' OR OrderNumber like '%" + tuKhoa + "%')";
	}
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strFind);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    //Gán giá trị cho objSV và add object vào ListSV
	    while(rs.next())//Duyệt từng dòng trong database
	    {
		objKhoa = new ChuyenKhoa();
		objKhoa.setMaKhoa(rs.getString("MaKhoa"));
		objKhoa.setTenKhoa(rs.getString("TenKhoa"));
                objKhoa.setOrderNumber(rs.getString("OrderNumber"));
		
		//Thêm vào danh sách
		lstKhoa.add(objKhoa);
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
	
	return lstKhoa;
    }
       
}
