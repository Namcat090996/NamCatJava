package vn.com.stanford.bst.model;

import vn.com.stanford.bst.entities.ChuDe;

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
        //Declare subject list
        List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

        //Declare connection
        Connection conn = null;

        //Declare a SQL command
        String strList = "Select MaChuDe, tenChuDe from chude";

        try {
            //Connect to the database needs to work
            conn = DataProvider.ketNoi();

            //Create a statement to query data in the database
            Statement stm = conn.createStatement();

            //Execute the queries and return results
            ResultSet rs = stm.executeQuery(strList);

            //Declare a subject object
            ChuDe objChuDe = null;

            //Loop through each row to get the list
            while (rs.next())
            {
                //Instantiate the subject object
                objChuDe = new ChuDe();

                //Assign values to subject object
                objChuDe.setMaChuDe(rs.getString("MaChuDe"));
                objChuDe.setTenChuDe(rs.getString("tenChuDe"));

                //Add object to the list
                lstChuDe.add(objChuDe);
            }
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

        return lstChuDe;
    }

    /**
     * Function to get the detailed subject info
     * @param maChuDe
     * @return
     */
    @Override
    public ChuDe layChiTiet(String maChuDe) {
        //Declare subject object
        ChuDe objChuDe = null;

        //Declare a SQL command
        String strDetail = "Select MaChuDe, tenChuDe from chude where MaChuDe = ?";

        //Declare a connection
        Connection conn = null;

        try {
            //Connect to database needs to work
            conn = DataProvider.ketNoi();

            //Create a statement to query data in the database
            PreparedStatement preStm = conn.prepareStatement(strDetail);

            //Set subject code to SQL command
            preStm.setString(1, maChuDe);

            //Execute the query and return results
            ResultSet rs = preStm.executeQuery();

            if(rs.next())
            {
                //Instantiate subject object
                objChuDe = new ChuDe();

                //Assign values to subject object
                objChuDe.setMaChuDe(rs.getString("MaChuDe"));
                objChuDe.setTenChuDe(rs.getString("tenChuDe"));
            }

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

        return objChuDe;

    }

    /**
     * Function to add a new subject
     * @param objChuDe
     * @return
     */
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
            conn = DataProvider.ketNoi();

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

    /**
     * Function to update subject info
     * @param objChuDe
     * @return
     */
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
            conn = DataProvider.ketNoi();

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

    /**
     * Function to delete subject
     * @param maChuDe
     * @return
     */
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
            conn = DataProvider.ketNoi();

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
