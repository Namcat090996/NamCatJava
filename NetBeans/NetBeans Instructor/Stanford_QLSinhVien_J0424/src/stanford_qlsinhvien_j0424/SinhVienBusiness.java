/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_qlsinhvien_j0424;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dangquang16
 */
public class SinhVienBusiness {

    /**
     * Hàm lấy danh sách sinh viên
     * @return 
     */
    public List<SinhVien> layDanhSach()
    {
        //Khai báo danh sách
        List<SinhVien> lstSinhVien = new ArrayList();
        
        String strSQL = "Select MaSV, HoTen, GioiTinh, NgaySinh, DienThoai, Email, DiaChi from SinhVien";
        
        //Khai báo kết nối
        Connection conn = null;
        
        try {
                    
            //Kết nối với db cần làm việc
            conn = DataProvider.ketNoi();
        
            //Tạo công việc
            Statement stm = conn.createStatement();

            //Thực hiện và trả về kết quả
            ResultSet rs = stm.executeQuery(strSQL);
            
            //Duyệt từng dòng để đưa về object SinhVien
            SinhVien objSV;
            while(rs.next())
            {
                objSV = new SinhVien();
                objSV.setMaSV(rs.getString("MaSV"));
                objSV.setHoTen(rs.getString("HoTen"));
                objSV.setDienThoai(rs.getString("DienThoai"));
                objSV.setEmail(rs.getString("Email"));
                objSV.setDiaChi(rs.getString("DiaChi"));
                objSV.setNgaySinh(rs.getDate("NgaySinh"));
                objSV.setGioiTinh(rs.getInt("GioiTinh"));
                //Thêm vào danh sách
                lstSinhVien.add(objSV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        try {
                if(conn!= null){
                    conn.close();
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        
        return lstSinhVien;
    }
    
   /**
    * Hàm tìm kiếm thông tin sinh viên
    * @param tuKhoa, Từ khóa
    * @param maKhoa, Mã khoa
    * @return Danh sách sinh viên thỏa mãn điều kiện
    */
    public List<SinhVien> timKiem(String tuKhoa, String maKhoa)
    {
        //Khai báo danh sách
        List<SinhVien> lstSinhVien = new ArrayList();
        
        String strSQL = "Select MaSV, HoTen, GioiTinh, NgaySinh, DienThoai, Email, DiaChi from SinhVien where 1=1";
        
        if(!tuKhoa.isEmpty() && tuKhoa.length() > 0)
        {
            strSQL += " AND (MaSV = '" + tuKhoa + "' OR HoTen like '%" + tuKhoa + "%' OR DienThoai like '%" + tuKhoa + "%')";
        }
        
        if(!maKhoa.isEmpty() && maKhoa.length() > 0)
        {
            strSQL += " AND MaKhoa = '" + maKhoa + "'";
        }
        
        //Khai báo kết nối
        Connection conn = null;
        
        try {
                    
            //Kết nối với db cần làm việc
            conn = DataProvider.ketNoi();
        
            //Tạo công việc
            Statement stm = conn.createStatement();

            //Thực hiện và trả về kết quả
            ResultSet rs = stm.executeQuery(strSQL);
            
            //Duyệt từng dòng để đưa về object SinhVien
            SinhVien objSV;
            while(rs.next())
            {
                objSV = new SinhVien();
                objSV.setMaSV(rs.getString("MaSV"));
                objSV.setHoTen(rs.getString("HoTen"));
                objSV.setDienThoai(rs.getString("DienThoai"));
                objSV.setEmail(rs.getString("Email"));
                objSV.setDiaChi(rs.getString("DiaChi"));
                objSV.setNgaySinh(rs.getDate("NgaySinh"));
                objSV.setGioiTinh(rs.getInt("GioiTinh"));
                //Thêm vào danh sách
                lstSinhVien.add(objSV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        try {
                if(conn!= null){
                    conn.close();
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        
        return lstSinhVien;
    }
    
    /**
     * Hàm lấy thông tin chi tiết sinh viên
     * @param maSV, Mã sv
     * @return Đối tượng sv chứa tất cả thông tin sv cần lấy được theo mã sv
     */
    public SinhVien layChiTiet(String maSV)
    {
        SinhVien objSV = null;
        
        String strSQL = "Select * from SinhVien where MaSV = '" + maSV + "'";
        
        //Khai báo kết nối
        Connection conn = null;
        
        try {
                    
            //Kết nối với db cần làm việc
            conn = DataProvider.ketNoi();
        
            //Tạo công việc
            Statement stm = conn.createStatement();

            //Thực hiện và trả về kết quả
            ResultSet rs = stm.executeQuery(strSQL);
            
            //Duyệt từng dòng để đưa về object SinhVien
            while(rs.next())
            {
                objSV = new SinhVien();
                //Gán giá trị cho các thuộc tính lấy được từ các cột tương ứng với dòng dữ liệu lấy được
                objSV.setMaSV(rs.getString("MaSV"));
                objSV.setHoTen(rs.getString("HoTen"));
                objSV.setDienThoai(rs.getString("DienThoai"));
                objSV.setEmail(rs.getString("Email"));
                objSV.setDiaChi(rs.getString("DiaChi"));
                objSV.setGioiTinh(rs.getInt("GioiTinh"));
                objSV.setNgaySinh(rs.getDate("NgaySinh"));
                objSV.setMaKhoa(rs.getString("MaKhoa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        try {
                if(conn!= null){
                    conn.close();
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      

        
        return objSV;
    }
    
    /**
     * Hàm thực hiện thêm thông tin sinh viên vào hệ thống
     * 
     * @param objSV, Đối tượng sinh viên
     * @return True nếu thêm thành công, False nếu thêm không thành công
     */
    public boolean themMoi(SinhVien objSV)
    {
        boolean ketQua = false;
        
        Connection conn = null;
        
        conn = DataProvider.ketNoi();
        
        String strInsert = "Insert into SinhVien(MaSV, HoTen, DienThoai, Email, DiaChi, GioiTinh, NgaySinh, MaKhoa) values(?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strInsert);
            
            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objSV.getMaSV());
            preStament.setString(2, objSV.getHoTen());
            preStament.setString(3, objSV.getDienThoai());
            preStament.setString(4, objSV.getEmail());
            preStament.setString(5, objSV.getDiaChi());
            preStament.setInt(6, objSV.getGioiTinh());
            preStament.setDate(7, new Date(objSV.getNgaySinh().getTime()));
            preStament.setString(8, objSV.getMaKhoa());
            
            //Thực hiện công việc
            ketQua = preStament.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        try {
                if(conn!= null){
                    conn.close();
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        
        return ketQua;
    }
    
    /**
     * Hàm cập nhật thông tin sv
     * @param objSV, Đối tượng sv chứa các thông tin mới cần cập nhật
     * @return True nếu cập nhật thành công, False nếu thất bại
     */
    public boolean capNhat(SinhVien objSV)
    {
        boolean ketQua = false;
        
        Connection conn = null;
        
        conn = DataProvider.ketNoi();
        
        String strUpdate = "Update SinhVien set HoTen=?, DienThoai=?, Email=?, DiaChi=?, GioiTinh=?, NgaySinh=?, MaKhoa = ? where MaSV = ?";
        
        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strUpdate);
            
            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objSV.getHoTen());
            preStament.setString(2, objSV.getDienThoai());
            preStament.setString(3, objSV.getEmail());
            preStament.setString(4, objSV.getDiaChi());
            preStament.setInt(5, objSV.getGioiTinh());
            preStament.setDate(6, new Date(objSV.getNgaySinh().getTime()));   
            preStament.setString(7, objSV.getMaKhoa());
            preStament.setString(8, objSV.getMaSV());
            
            //Thực hiện công việc
            ketQua = preStament.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        try {
                if(conn!= null){
                    conn.close();
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        
        return ketQua;
    }
    
    /**
     * Hàm xóa thông tin sinh viên trong hệ thống
     * @param maSV, mã sv cần xóa
     * @return true nếu xóa thành công, false nếu không xóa thành công
     */
    public boolean xoa(String maSV)
    {
         boolean ketQua = false;
        
        Connection conn = null;
        
        conn = DataProvider.ketNoi();
        
        String strDelete = "Delete from SinhVien where MaSV = '" + maSV + "'";
        //SQL Innjection
        //Delete from SinhVien where MaSV = 'SF001'
        //SF001' or '1' ='1
        //Delete from SinhVien where MaSV = 'SF001' or '1' ='1'
        try {
            Statement stm = conn.createStatement();
            
            //Thực hiện công việc
            ketQua = stm.executeUpdate(strDelete) > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        try {
                if(conn!= null){
                    conn.close();
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        
        return ketQua;
    }
}
