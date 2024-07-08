/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_qlsinhvien_j0424;
import java.sql.*;

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
    private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    //Khai báo db cần làm việc
    private static final String DATABASE_LINK = "jdbc:mysql://localhost:3306/qlsinhvien?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    
    /**
     * Hàm kết nối đến db cần làm việc
     * @return 
     */
    public static Connection ketNoi()
    {
        Connection conn = null;
        
        try
        {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DATABASE_LINK, "root", "Namcat@@0909");
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Không tìm thấy driver của MySQL cần dùng. Chi tiết: " + ex.getMessage());
        } catch (SQLException ex) {
            System.err.println("Có lỗi xảy ra khi thực hiện trong MySQL. Chi tiết: " + ex.getMessage());
        }
        
        return conn;
    }
    
}
