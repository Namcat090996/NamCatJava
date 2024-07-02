/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_qlsinhvien_j0424;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangquang16
 */
public class DataProvider {
    
    /**
     * Khai báo 1 thuộc tính tạo đối tượng thuộc lớp SinhVienBusiness để có thể truy cập từ nhiều nơi
     */
    private static SinhVienBusiness sinhVienBus = null;
    
    public static SinhVienBusiness getSinhVienBus()
    {
        if(sinhVienBus ==null)
        {
            sinhVienBus = new SinhVienBusiness();
        }
        
        return sinhVienBus;
    }
    
    //Khai báo driver mysql cần làm việc
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //Khai báo db cần làm việc
    private static final String DATABASE_LINK = "jdbc:mysql://localhost:3306/j0424cb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    
    /**
     * Hàm kết nối đến db cần làm việc
     * @return 
     */
    public static Connection ketNoi()
    {
	//Declare a connection
	Connection conn = null;
	
	try {
	    //Charge driver into project
	    Class.forName(JDBC_DRIVER);
	   
	    //Connect to database needed to work
	    conn = DriverManager.getConnection(DATABASE_LINK, "root", "Namcat@@0909");
	    
	} catch (ClassNotFoundException ex) {
	    System.out.println("Không tìm thấy driver của MySQL cần dùng. Chi tiết: " + ex.getMessage());;
	} catch (SQLException ex) {
	    System.out.println("Lỗi khi thực hiện trong MySQL. Chi tiết lỗi: " + ex.getMessage());;
	}

	return conn;
    }
    
}
