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
 * @author ADMIN
 */
public class VaiTroBus {
    /**
     * Hàm lấy danh sách vai trò người dùng
     * @return 
     */
    public List<VaiTro> layDanhSachVaiTro()
    {
	//Khai báo danh sách
	List<VaiTro> lstVaiTro = new ArrayList<>();
	
	//Khai báo object 
	VaiTro objVaiTro = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strShowData = "Select * from vaitro";
	
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
		objVaiTro = new VaiTro();
                objVaiTro.setMaVaiTro(rs.getString("MaVaiTro"));
		objVaiTro.setTenVaiTro(rs.getString("TenVaiTro"));
		objVaiTro.setChucNang(rs.getString("ChucNang"));
		
		//Thêm vào danh sách
                lstVaiTro.add(objVaiTro);
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(VaiTroBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(VaiTroBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return lstVaiTro;
    } 

    /**
     * Hàm lấy chi tiết vai trò người dùng
     * @param maVaiTro  
     * @return 
     */
    public VaiTro layChiTietVaiTroUser(String maVaiTro)
    {
	//Khai báo object 
	VaiTro objVaiTro = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDetail = String.format("Select * from vaitro where MaVaiTro = '%s'", maVaiTro);
	
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
		objVaiTro = new VaiTro();
		
		//Gán giá trị cho các thuộc tính lấy được từ các cột tương ứng với dòng dữ liệu lấy được
		objVaiTro.setMaVaiTro(rs.getString("MaVaiTro"));
		objVaiTro.setTenVaiTro(rs.getString("TenVaiTro"));
                objVaiTro.setChucNang(rs.getString("ChucNang"));
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(VaiTroBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(VaiTroBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return objVaiTro;	
    }    
}
