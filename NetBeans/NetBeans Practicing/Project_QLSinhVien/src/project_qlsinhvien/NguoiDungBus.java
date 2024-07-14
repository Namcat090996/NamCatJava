/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_qlsinhvien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
