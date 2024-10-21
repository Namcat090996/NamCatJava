package vn.com.stanford.je082401.amthuc.model;

import vn.com.stanford.je082401.amthuc.entities.MonAn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonAnImpl implements MonAnDao {

    @Override
    public List<MonAn> layDanhSach() {
        //Khai báo 1 danh sách
        List<MonAn> lstMonAn = new ArrayList<MonAn>();

        String strList = "{call SP_LayDanhSachMonAn()}";

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataAccess.ketNoi();

            //Khai báo công việc
            Statement comm = conn.createStatement();

            //Lấy kết quả
            ResultSet rs = comm.executeQuery(strList);

            //Đọc từng dòng để đưa về danh sách
            MonAn objMonAn;
            while(rs.next())
            {
                //Khởi tạo đối tượng
                objMonAn = new MonAn();

                objMonAn.setTenMonAn(rs.getString("TenMonAn"));
                objMonAn.setMoTa(rs.getString("MoTa"));
                objMonAn.setNoiDung(rs.getString("NoiDung"));
                objMonAn.setAnhMonAn(rs.getString("ImageName"));
                objMonAn.setChuDe(rs.getString("ChuDe"));

                //Thêm vào danh sách
                lstMonAn.add(objMonAn);
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Có lỗi xảy ra. Chi tiết: " + ex.getMessage());
        }
        finally {
            if(conn!= null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return lstMonAn;
    }

    @Override
    public MonAn layChiTiet(String id) {
        //Khai báo 1 đối tượng
        MonAn objMonAn = null;

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataAccess.ketNoi();

            String strSQL = "{call SP_LayChiTietMonAn(?)}";

            //Khai báo công việc
            CallableStatement comm = conn.prepareCall(strSQL);
            comm.setString(1, id);

            //Lấy kết quả
            ResultSet rs = comm.executeQuery();

            //Đọc từng dòng để đưa về danh sách
            while(rs.next())
            {
                //Khởi tạo đối tượng
                objMonAn = new MonAn();

                objMonAn.setTenMonAn(rs.getString("TenMonAn"));
                objMonAn.setMoTa(rs.getString("MoTa"));
                objMonAn.setNoiDung(rs.getString("NoiDung"));
                objMonAn.setAnhMonAn(rs.getString("ImageName"));
                objMonAn.setChuDe(rs.getString("ChuDe"));
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Khong lay duoc thong tin chi tiet. Chi tiet loi: " + ex.getMessage());
        }
        finally {
            if(conn!= null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return objMonAn;
    }

    @Override
    public boolean themMoi(MonAn obj) {
        //Khai báo 1 kết quả
        boolean ketQua = false;

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataAccess.ketNoi();

            String strSQL = "{call SP_ThemMonAn(?,?,?,?,?)}";

            //Khai báo công việc
            CallableStatement comm = conn.prepareCall(strSQL);

            comm.setString(1, obj.getTenMonAn());
            comm.setString(2, obj.getMoTa());
            comm.setString(3, obj.getNoiDung());
            comm.setString(4, obj.getAnhMonAn());
            comm.setString(5, obj.getChuDe());

            //Thực hiện công việc
            ketQua = comm.executeUpdate() > 0;

        }
        catch(SQLException ex)
        {
            System.err.println("Có lỗi xảy ra. Chi tiết: " + ex.getMessage());
        }
        finally {
            if(conn!= null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }

    @Override
    public boolean capNhat(MonAn obj) {
        //Khai báo 1 kết quả
        boolean ketQua = false;

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataAccess.ketNoi();

            String strSQL = "Update monan set MoTa=?, NoiDung=?, ImageName=?, ChuDe=? where TenMonAn=?";

            //Khai báo công việc
            CallableStatement comm = conn.prepareCall(strSQL);


            comm.setString(1, obj.getMoTa());
            comm.setString(2, obj.getNoiDung());
            comm.setString(3, obj.getAnhMonAn());
            comm.setString(4, obj.getChuDe());
            comm.setString(5, obj.getTenMonAn());

            //Thực hiện công việc
            ketQua = comm.executeUpdate() > 0;

        }
        catch(SQLException ex)
        {
            System.err.println("Có lỗi xảy ra. Chi tiết: " + ex.getMessage());
        }
        finally {
            if(conn!= null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }

    @Override
    public boolean xoa(String id) {
        //Khai báo 1 kết quả
        boolean ketQua = false;

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataAccess.ketNoi();

            String strSQL = "Delete from monan where TenMonAn=?";

            //Khai báo công việc
            CallableStatement comm = conn.prepareCall(strSQL);

            comm.setString(1, id);

            //Thực hiện công việc
            ketQua = comm.executeUpdate() > 0;

        }
        catch(SQLException ex)
        {
            System.err.println("Có lỗi xảy ra. Chi tiết: " + ex.getMessage());
        }
        finally {
            if(conn!= null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }
}
