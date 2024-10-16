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

    public static Connection ketNoi()
    {
        //Declare a connection
        Connection conn = null;

        //Charge the driver
        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DATABASE_LINK, "root", "Namcat@@0909");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }
}
