package vn.com.namcat.bookshop.model;

import vn.com.namcat.bookshop.entities.Sach;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SachBusiness implements SachImpl {

    /**
     * Function to get the book list
     * @return
     */
    @Override
    public List<Sach> layDanhSach() {
        //Declare a book list
        List<Sach> lstSach = new ArrayList<Sach>();

        //Declare a connection
        Connection conn = null;

        //Declare SQL command
        String strGetList  = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, MaChuDe, NgayTao from sach";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in database
            Statement stm = conn.createStatement();

            //Execute the queries and return results
            ResultSet rs = stm.executeQuery(strGetList);

            //Declare a Sach object
            Sach objSach = null;

            //Loop through the data rows in rs to get the list
            while(rs.next())
            {
                //Instantiate the Sach object
                objSach = new Sach();

                objSach.setMaSach(rs.getString("MaSach"));
                objSach.setTenSach(rs.getString("TenSach"));
                objSach.setMoTa(rs.getString("MoTa"));
                objSach.setAnhSach(rs.getString("AnhSach"));
                objSach.setGiaSach(rs.getInt("GiaSach"));
                objSach.setMaChuDe(rs.getString("MaChuDe"));
                objSach.setNgayTao(rs.getDate("NgayTao"));
                objSach.setTacGia(rs.getString("TacGia"));

                //Add object to the list
                lstSach.add(objSach);
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

        return lstSach;
    }

    /**
     * Function to get the book detailed info
     * @param id
     * @return
     */
    @Override
    public Sach layChiTiet(String id) {
        //Declare a connection
        Connection conn = null;

        //Declare SQL command
        String strDetail  = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, MaChuDe, NgayTao from  where MaSach = ?";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in database
            Statement stm = conn.createStatement();

            //Execute the queries and return results
            ResultSet rs = stm.executeQuery(strDetail);

            //Declare a Sach object
            Sach objSach = null;

            //Loop through the data rows in rs to get the list
            if(rs.next())
            {
                //Instantiate the Sach object
                objSach = new Sach();

                objSach.setMaSach(rs.getString("MaSach"));
                objSach.setTenSach(rs.getString("TenSach"));
                objSach.setMoTa(rs.getString("MoTa"));
                objSach.setAnhSach(rs.getString("AnhSach"));
                objSach.setGiaSach(rs.getInt("GiaSach"));
                objSach.setMaChuDe(rs.getString("MaChuDe"));
                objSach.setNgayTao(rs.getDate("NgayTao"));
                objSach.setTacGia(rs.getString("TacGia"));

                //Add object to the list
                lstSach.add(objSach);
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

        return lstSach;
    }

    @Override
    public boolean themMoi(Sach obj) {
        return false;
    }

    @Override
    public boolean capNhat(Sach obj) {
        return false;
    }

    @Override
    public boolean xoa(String id) {
        return false;
    }
}
