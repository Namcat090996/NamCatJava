package vn.com.stanford.bst.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataProvider {

    //Declare database_link and jdbc driver
    private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_LINK = "jdbc:mysql://localhost:3306/je082401dev?useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true";

    /**
     * Function to connect the database needs to work
     * @return
     */
    public static Connection ketNoi()
    {
        //Declare a connection
        Connection conn = null;

        try {
            //Charge the driver
            Class.forName(JDBC_DRIVER);

            //Connect to the database needs to work
            conn = DriverManager.getConnection(DATABASE_LINK, "root", "Namcat@@0909");
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi không tìm thấy driver. Chi tiết lỗi: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Lỗi không kết nối được với database trên MySQL. Chi tiết lỗi: " + ex.getMessage());
        }

        return conn;

    }
}
