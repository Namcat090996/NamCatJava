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
		objVaiTro.setVaiTro(rs.getString("VaiTro"));
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
}
