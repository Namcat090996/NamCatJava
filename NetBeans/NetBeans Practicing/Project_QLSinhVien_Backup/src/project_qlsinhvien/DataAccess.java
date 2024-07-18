/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_qlsinhvien;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Dell Precision 7550
 */
public class DataAccess {
    
    //Khai báo driver MySQL cần làm việc
    private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    //Khai báo database cần làm việc
    private static final String DATABASE_LINK = "jdbc:mysql://localhost:3306/qlsinhvien?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false";  
    
    public static Connection ketNoi()
    {
	Connection conn = null;
	
	try {
	    
	    //Nạp driver cần dùng
	    Class.forName(JDBC_DRIVER);
	    
	    //Tạo kết nối với database thông qua driver
	    conn = DriverManager.getConnection(DATABASE_LINK, "root", "Namcat@@0909");
	    
	} catch (ClassNotFoundException ex) {
	    System.err.println("Không tìm thấy driver của MySQL cần dùng. Chi tiết: " + ex.getMessage());
	} catch (SQLException ex) {
	    System.err.println("Có lỗi xảy ra khi thực hiện trong MySQL. Chi tiết: " + ex.getMessage());
	}
	
	return conn;
    }
     
}
