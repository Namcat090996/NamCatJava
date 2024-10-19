package vn.com.namcat.nhanvien.model;

import vn.com.namcat.nhanvien.entities.NhanVien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DataAccess {

    //Declare database_link and jdbc_driver
    private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_LINK = "jdbc:mysql://localhost:3306/je082401dev?useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true";

    /**
     * Function to connect to database needs to work
     * @return
     */
    public static Connection ketNoi()
    {
        //Declare a connection
        Connection conn = null;

        try {
            //Charge the JDBC driver
            Class.forName(JDBC_DRIVER);

            //Connect to database needs to work
            conn = DriverManager.getConnection(DATABASE_LINK, "root", "Namcat@@0909");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error because of driver not found" + ex.getMessage());
        } catch (SQLException ex) {
            throw new RuntimeException("Error due to database not connected on MYSQL" + ex.getMessage());
        }

        //Return result
        return conn;
    }
}
