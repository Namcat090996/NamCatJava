package vn.com.namcat.bookshop.model;

import vn.com.namcat.bookshop.entities.ChuDe;
import vn.com.namcat.bookshop.entities.Sach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        String strGetList  = "Select MaChuDe, TenChuDe from chude";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in database
            Statement stm = conn.createStatement();

            //Execute the queries and return results
            ResultSet rs = stm.executeQuery(strGetList);

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
        String strDetail  = "Select MaChuDe, TenChuDe from  where MaChuDe = ?";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in database
            PreparedStatement preStm = conn.prepareStatement(strDetail);

            //Assign value to MaChuDe that you want to see detailed info
            preStm.setString(1, maChuDe);

            //Execute the queries and return results
            ResultSet rs = preStm.executeQuery();

            //Loop through the data rows in rs to get the list
            if(rs.next())
            {
                //Instantiate the Sach object
                objChuDe = new ChuDe();

                //Assign values to subject object
                objChuDe.setMaChuDe(rs.getString("MaChuDe"));
                objChuDe.setTenChuDe(rs.getString("TenSach"));

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
        String strAdd = "Insert into chude(MaChuDe, tenChuDe) values (?, ?)";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in the database
            PreparedStatement preStm = conn.prepareStatement(strAdd);

            //Assign values to database
            preStm.setString(1, objChuDe.getMaChuDe());
            preStm.setString(2, objChuDe.getTenChuDe());

            //Execute the query and return results
            ketQua = preStm.executeUpdate() > 0;

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
        String strUpdate = "Update chude set tenChuDe = ? where MaChuDe = ?";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in the database
            PreparedStatement preStm = conn.prepareStatement(strUpdate);

            //Assign values to database
            preStm.setString(1, objChuDe.getTenChuDe());
            preStm.setString(2, objChuDe.getMaChuDe());

            //Execute the query and return results
            ketQua = preStm.executeUpdate() > 0;

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
        String strDelete = "Delete from chude where MaChuDe = ?";

        //Declare a connection
        Connection conn = null;

        try {

            //Connect to the database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in the database
            PreparedStatement preStm = conn.prepareStatement(strDelete);

            //Assign values
            preStm.setString(1, maChuDe);

            //Execute the queries and return the results
            ketQua = preStm.executeUpdate() > 0;

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
