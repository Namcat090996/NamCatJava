package vn.com.stanford.je082401.amthuc.model;

import vn.com.stanford.je082401.amthuc.entities.ChuDe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChuDeImpl implements ChuDeDao {

    @Override
    public List<ChuDe> layDanhSach() {
        //Khai báo 1 danh sách
        List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

        String strSQL = "Select TenChuDe, MoTa from ChuDe";

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataAccess.ketNoi();

            //Khai báo công việc
            Statement comm = conn.createStatement();

            //Lấy kết quả
            ResultSet rs = comm.executeQuery(strSQL);

            //Đọc từng dòng để đưa về danh sách
            ChuDe objChuDe;
            while(rs.next())
            {
                //Khởi tạo đối tượng
                objChuDe = new ChuDe();

                objChuDe.setTenChuDe(rs.getString("TenChuDe"));
                objChuDe.setMoTa(rs.getString("MoTa"));

                //Thêm vào danh sách
                lstChuDe.add(objChuDe);
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
        return lstChuDe;
    }

    @Override
    public ChuDe layChiTiet(String id) {
        return null;
    }

    @Override
    public boolean themMoi(ChuDe obj) {
        return false;
    }

    @Override
    public boolean capNhat(ChuDe obj) {
        return false;
    }

    @Override
    public boolean xoa(String id) {
        return false;
    }
}
