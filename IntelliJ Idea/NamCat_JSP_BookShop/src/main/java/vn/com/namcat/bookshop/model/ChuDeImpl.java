package vn.com.namcat.bookshop.model;

import vn.com.namcat.bookshop.entities.ChuDe;
import vn.com.namcat.bookshop.entities.Sach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ChuDeImpl implements ChuDeDao {

    /**
     * Function to get the subject list
     * @return
     */
    @Override
    public List<ChuDe> layDanhSach() {
        //Declare a book list
        List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

        //Declare a connection
        Connection conn = null;

        //Declare SQL command
        String strGetList  = "{call SP_LayDanhSachChuDe}";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in database
            CallableStatement call = conn.prepareCall(strGetList);

            //Execute the queries and return results
            ResultSet rs = call.executeQuery();

            //Declare a Sach object
            ChuDe objChuDe = null;

            //Loop through the data rows in rs to get the list
            while(rs.next())
            {
                //Instantiate the Sach object
                objChuDe = new ChuDe();

                objChuDe.setMaChuDe(rs.getString("MaChuDe"));
                objChuDe.setTenChuDe(rs.getString("TenChuDe"));

                //Add object to the list
                lstChuDe.add(objChuDe);
            }
        } catch (SQLException ex) {
            System.out.println("Error due to database not connected on MySQL");
        }
        finally {
            try {
                if(conn != null)
                {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error due to unclosed connection");
            }
        }

        return lstChuDe;
    }

    @Override
    public ChuDe layChiTiet(String maChuDe) {
        //Declare a Sach object
        ChuDe objChuDe = null;

        //Declare a connection
        Connection conn = null;

        //Declare SQL command
        String strDetail  = "{call SP_LayChiTietChuDe(?)}";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in database
            CallableStatement call = conn.prepareCall(strDetail);

            //Assign value to MaChuDe that you want to see detailed info
            call.setString(1, maChuDe);

            //Execute the queries and return results
            ResultSet rs = call.executeQuery();

            //Loop through the data rows in rs to get the list
            if(rs.next())
            {
                //Instantiate the Sach object
                objChuDe = new ChuDe();

                //Assign values to subject object
                objChuDe.setMaChuDe(rs.getString("MaChuDe"));
                objChuDe.setTenChuDe(rs.getString("TenChuDe"));

            }
        } catch (SQLException ex) {
            System.out.println("Error due to database not connected on MySQL");
        }
        finally {
            try {
                if(conn != null)
                {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error due to unclosed connection");
            }
        }

        return objChuDe;
    }

    @Override
    public boolean themMoi(ChuDe objChuDe) {
        //Declare a boolean
        boolean ketQua = false;

        //Declare a connection
        Connection conn = null;

        //Declare a SQL command
        String strAdd = "{call SP_ThemChuDe(?,?)}";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in the database
            CallableStatement call = conn.prepareCall(strAdd);

            //Assign values to database
            call.setString(1, objChuDe.getMaChuDe());
            call.setString(2, objChuDe.getTenChuDe());

            //Execute the query and return results
            ketQua = call.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra khi thực hiện truy vấn dữ liệu. Chi tiết lỗi: " + ex.getMessage());
        }
        finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Có lỗi xảy ra khi đóng kết nối. Chi tiết lỗi: " + ex.getMessage());
            }
        }

        return ketQua;
    }

    @Override
    public boolean capNhat(ChuDe objChuDe) {
        //Declare a boolean
        boolean ketQua = false;

        //Declare a connection
        Connection conn = null;

        //Declare a SQL command
        String strUpdate = "{call SP_SuaChuDe(?,?)}";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in the database
            CallableStatement call = conn.prepareCall(strUpdate);

            //Assign values to database
            call.setString(1, objChuDe.getMaChuDe());
            call.setString(2, objChuDe.getTenChuDe());

            //Execute the query and return results
            ketQua = call.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra khi thực hiện truy vấn dữ liệu. Chi tiết lỗi: " + ex.getMessage());
        }
        finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Có lỗi xảy ra khi đóng kết nối. Chi tiết lỗi: " + ex.getMessage());
            }
        }

        return ketQua;
    }

    @Override
    public boolean xoa(String maChuDe) {
        //Declare a boolean
        boolean ketQua = false;

        //Declare a SQL command
        String strDelete = "{call SP_XoaChuDe(?)}";

        //Declare a connection
        Connection conn = null;

        try {

            //Connect to the database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in the database
            CallableStatement call = conn.prepareCall(strDelete);

            //Assign values
            call.setString(1, maChuDe);

            //Execute the queries and return the results
            ketQua = call.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra khi thực hiện truy vấn dữ liệu. Chi tiết lỗi: " + ex.getMessage());
        }
        finally {
            if(conn != null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Có lỗi xảy ra khi đóng kết nối. Chi tiết lỗi: " + ex.getMessage());
                }
            }
        }

        return ketQua;
    }
}
