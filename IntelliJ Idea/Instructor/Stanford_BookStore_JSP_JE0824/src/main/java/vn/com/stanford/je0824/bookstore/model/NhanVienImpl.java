package vn.com.stanford.je0824.bookstore.model;

import vn.com.stanford.je0824.bookstore.entities.NhanVien;
import vn.com.stanford.je0824.bookstore.entities.NhanVienModel;
import vn.com.stanford.je0824.bookstore.entities.Sach;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NhanVienImpl implements NhanVienDao {

    public List<NhanVienModel> layBangLuongNhanVien()
    {
        //Khai báo 1 danh sách
        List<NhanVienModel> lstNhanVien = new ArrayList<NhanVienModel>();

        String strSQL = " Select * from vBangLuongNhanVien";

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataProvider.ketNoi();

            //Khai báo công việc
            Statement comm = conn.createStatement();

            //Lấy kết quả
            ResultSet rs = comm.executeQuery(strSQL);

            //Đọc từng dòng để đưa về danh sách
            NhanVienModel objNV;
            while(rs.next())
            {
                //Khởi tạo đối tượng
                objNV = new NhanVienModel();

                objNV.setMaNV(rs.getString("MaNV"));
                objNV.setHoTen(rs.getString("HoTen"));
                objNV.setGioiTinh(rs.getInt("GioiTinh"));
                objNV.setNgaySinh(rs.getDate("NgaySinh"));
                objNV.setDienThoai(rs.getString("DienThoai"));
                objNV.setEmail(rs.getString("Email"));
                objNV.setMaChucVu(rs.getString("MaChucVu"));
                objNV.setMaPhong(rs.getString("MaPhong"));
                objNV.setTenPhong(rs.getString("TenPhong"));
                objNV.setTenChucVu(rs.getString("TenChucVu"));
                objNV.setTongLuong(rs.getInt("TongLuong"));

                //Thêm vào danh sách
                lstNhanVien.add(objNV);
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
        return lstNhanVien;
    }

    @Override
    public List<NhanVien> layDanhSach() {
        return new ArrayList<NhanVien>();
    }

    @Override
    public NhanVien layChiTiet(String id) {
        return null;
    }

    @Override
    public boolean themMoi(NhanVien obj) {
        return false;
    }

    @Override
    public boolean capNhat(NhanVien obj) {
        return false;
    }

    @Override
    public boolean xoa(String id) {
        return false;
    }
}
