package vn.com.namcat.bookshop.model;

import vn.com.namcat.bookshop.entities.Sach;

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
     * @param maSach
     * @return
     */
    @Override
    public Sach layChiTiet(String maSach) {
        //Declare a Sach object
        Sach objSach = null;

        //Declare a connection
        Connection conn = null;

        //Declare SQL command
        String strDetail  = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, MaChuDe, NgayTao from  where MaSach = ?";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in database
            PreparedStatement preStm = conn.prepareStatement(strDetail);

            //Assign value to MaSach that you want to see detailed info
            preStm.setString(1, maSach);

            //Execute the queries and return results
            ResultSet rs = preStm.executeQuery();

            //Loop through the data rows in rs to get the list
            if(rs.next())
            {
                //Instantiate the Sach object
                objSach = new Sach();

                //Assign values to Sach object
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

        return objSach;
    }

    /**
     * Function to insert a new book into book list
     * @param objSach
     * @return
     */
    @Override
    public boolean themMoi(Sach objSach) {
        //Declare a boolean
        boolean ketQua = false;

        //Declare a connection
        Connection conn = null;

        //Declare SQL command
        String strAdd  = "Insert into sach(MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, NgayTao, MaChuDe) values(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in database
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

            //Execute the queries and return results
            ketQua = preStm.executeUpdate() > 0;

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

        return ketQua;
    }

    /**
     * Function to update info of a selected book
     * @param objSach
     * @return
     */
    @Override
    public boolean capNhat(Sach objSach) {
        //Declare a boolean
        boolean ketQua = false;

        //Declare a connection
        Connection conn = null;

        //Declare SQL command
        String strAdd  = "Update sach set TenSach = ?, MoTa = ?, AnhSach = ?, GiaSach = ?, TacGia = ?, NgayCapNhat = ?, MaChuDe = ? where MaSach = ?";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in database
            PreparedStatement preStm = conn.prepareStatement(strAdd);

            //Assign values
            preStm.setString(1, objSach.getTenSach());
            preStm.setString(2, objSach.getMoTa());
            preStm.setString(3, objSach.getAnhSach());
            preStm.setFloat(4, objSach.getGiaSach());
            preStm.setString(5, objSach.getTacGia());
            preStm.setDate(6, new Date(objSach.getNgayCapNhat().getTime()));
            preStm.setString(7, objSach.getMaChuDe());
            preStm.setString(8, objSach.getMaSach());

            //Execute the queries and return results
            ketQua = preStm.executeUpdate() > 0;

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

        return ketQua;
    }

    /**
     * Function to delete a selected book
     * @param maSach
     * @return
     */
    @Override
    public boolean xoa(String maSach) {
        //Declare a boolean
        boolean ketQua = false;

        //Declare a connection
        Connection conn = null;

        //Declare SQL command
        String strAdd  = "Delete from sach where MaSach = ?";

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in database
            PreparedStatement preStm = conn.prepareStatement(strAdd);

            //Assign values
            preStm.setString(1, maSach);

            //Execute the queries and return results
            ketQua = preStm.executeUpdate() > 0;

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

        return ketQua;
    }

    /**
     * Function to search the book by using keyword and selected subject
     * @param tuKhoa
     * @param maChuDe
     * @return
     */
    @Override
    public List<Sach> timKiemSach(String tuKhoa, String maChuDe) {
        //Declare a book list
        List<Sach> lstSach = new ArrayList<Sach>();

        //Declare a connection
        Connection conn = null;

        //Declare SQL command
        String strSearch  = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, MaChuDe, NgayTao from sach where 1=1";

        if(!tuKhoa.isEmpty())
        {
            strSearch += " and (MaSach = ? OR TenSach like ? OR TacGia like ?)";
        }

        if(!maChuDe.isEmpty())
        {
            strSearch += " and MaChuDe = ?";
        }

        try {
            //Connect to database needs to work
            conn = DataAccess.ketNoi();

            //Create a statement to query data in database
            PreparedStatement preStm = conn.prepareStatement(strSearch);

            //Declare index of statement
            int index = 1;

            //Assign values to statement
            if(!tuKhoa.isEmpty())
            {
                preStm.setString(index++, tuKhoa); //MaSach
                preStm.setString(index++, "%" + tuKhoa + "%"); //TenSach
                preStm.setString(index++, "%" + tuKhoa + "%"); //TacGia
            }

            if(!maChuDe.isEmpty())
            {
                preStm.setString(index++, maChuDe); //MaChuDe
            }

            //Execute the queries and return results
            ResultSet rs = preStm.executeQuery();

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
}
