package vn.com.stanford.bst.model;

import vn.com.stanford.bst.entities.Sach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachImpl implements SachDao {
    /**
     * Function to get the book list
     * @return
     */
    @Override
    public List<Sach> layDanhSach() {
        //Declare a list
        List<Sach> lstSach = new ArrayList<Sach>();

        //Declare a SQL command
        String strSQL = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, MaChuDe, NgayTao from sach";

        //Declare a connection
        Connection conn = null;

        try {
            //Connect to the database needs to work
            conn = DataProvider.ketNoi();

            //Create a statement to query data in the database
            Statement stm = conn.createStatement();

            //Execute the queries and return the results
            ResultSet rs = stm.executeQuery(strSQL);

            //Declare a book object
            Sach objSach = null;

            //Loop through each row to get the list
            while(rs.next()) {

                //Instantiate the book object
                objSach = new Sach();

                //Assign to book object
                objSach.setMaSach(rs.getString("MaSach"));
                objSach.setTenSach(rs.getString("TenSach"));
                objSach.setMoTa(rs.getString("MoTa"));
                objSach.setAnhSach(rs.getString("AnhSach"));
                objSach.setGiaSach(rs.getInt("GiaSach"));
                objSach.setMaChuDe(rs.getString("MaChuDe"));
                objSach.setNgayTao(rs.getDate("NgayTao"));
                objSach.setTacGia(rs.getString("TacGia"));

                //Add objetc to list
                lstSach.add(objSach);
            }
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

        return lstSach;
    }

    /**
     * Function to get the detailed book info
     * @param maSach
     * @return
     */
    @Override
    public Sach layChiTiet(String maSach) {

        //Declare a book object
        Sach objSach = null;

        //Declare a SQL command
        String strDetail = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, MaChuDe, NgayTao from sach where MaSach = ?";

        //Declare a connection
        Connection conn = null;

        try {
            //Connect to the database needs to work
            conn = DataProvider.ketNoi();

            //Create a statement to query data in the database
            PreparedStatement preStm = conn.prepareStatement(strDetail);

            //Assign value to book code that you want to find
            preStm.setString(1, maSach);

            //Execute the queries and return the results
            ResultSet rs = preStm.executeQuery();

            //If the book code exists
            if(rs.next()) {

                //Instantiate the book object
                objSach = new Sach();

                //Assign to book object
                objSach.setMaSach(rs.getString("MaSach"));
                objSach.setTenSach(rs.getString("TenSach"));
                objSach.setMoTa(rs.getString("MoTa"));
                objSach.setAnhSach(rs.getString("AnhSach"));
                objSach.setGiaSach(rs.getInt("GiaSach"));
                objSach.setMaChuDe(rs.getString("MaChuDe"));
                objSach.setNgayTao(rs.getDate("NgayTao"));
                objSach.setTacGia(rs.getString("TacGia"));
            }
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

        return objSach;
    }

    /**
     * Funnction to add a new book
     * @param objSach
     * @return
     */
    @Override
    public boolean themMoi(Sach objSach) {
        //Declare a boolean
        boolean ketQua = false;

        //Declare a SQL command
        String strAdd = "Insert into sach(MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, NgayTao, MaChuDe) values(?, ?, ?, ?, ?, ?, ?, ?)";

        //Declare a connection
        Connection conn = null;

        try {

            //Connect to the database needs to work
            conn = DataProvider.ketNoi();

            //Create a statement to query data in the database
            PreparedStatement preStm = conn.prepareStatement(strAdd);

            //Assign values
            preStm.setString(1, objSach.getMaSach());
            preStm.setString(2, objSach.getTenSach());
            preStm.setString(3, objSach.getMoTa());
            preStm.setString(4, objSach.getAnhSach());
            preStm.setFloat(5, objSach.getGiaSach());
            preStm.setString(6, objSach.getTacGia());
            preStm.setDate(7, new Date(objSach.getNgayTao().getTime()));
            preStm.setString(8, objSach.getMaChuDe());

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

    @Override
    public boolean capNhat(Sach objSach) {
        //Declare a boolean
        boolean ketQua = false;

        //Declare a SQL command
        String strUpdate = "Update sach set TenSach = ?, MoTa = ?, AnhSach = ?, GiaSach = ?, TacGia = ?, NgayCapNhat = ?, MaChuDe = ? where MaSach = ?";

        //Declare a connection
        Connection conn = null;

        try {

            //Connect to the database needs to work
            conn = DataProvider.ketNoi();

            //Create a statement to query data in the database
            PreparedStatement preStm = conn.prepareStatement(strUpdate);

            //Assign values
            preStm.setString(1, objSach.getTenSach());
            preStm.setString(2, objSach.getMoTa());
            preStm.setString(3, objSach.getAnhSach());
            preStm.setFloat(4, objSach.getGiaSach());
            preStm.setString(5, objSach.getTacGia());
            preStm.setDate(6, new Date(objSach.getNgayCapNhat().getTime()));
            preStm.setString(7, objSach.getMaChuDe());
            preStm.setString(8, objSach.getMaSach());

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

    @Override
    public boolean xoa(String maSach) {
        //Declare a boolean
        boolean ketQua = false;

        //Declare a SQL command
        String strDelete = "Delete from sach where MaSach = ?";

        //Declare a connection
        Connection conn = null;

        try {

            //Connect to the database needs to work
            conn = DataProvider.ketNoi();

            //Create a statement to query data in the database
            PreparedStatement preStm = conn.prepareStatement(strDelete);

            //Assign values
            preStm.setString(1, maSach);

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
