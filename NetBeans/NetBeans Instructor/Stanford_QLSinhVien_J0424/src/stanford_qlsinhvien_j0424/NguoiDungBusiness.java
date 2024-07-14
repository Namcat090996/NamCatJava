/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_qlsinhvien_j0424;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangquang16
 */
public class NguoiDungBusiness {
    
    public NguoiDung layThongTinDangNhap(String tenDangNhap)
    {
        NguoiDung objUser = null;
        
        String strSQL = "Select UserId, TenDangNhap, MatKhau, HoTen from NguoiDung where TenDangNhap = '" + tenDangNhap + "'";
        
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
                objUser = new NguoiDung();
                //Gán giá trị cho các thuộc tính lấy được từ các cột tương ứng với dòng dữ liệu lấy được
                objUser.setUserId(rs.getInt("UserId"));
                objUser.setHoTen(rs.getString("HoTen"));
                objUser.setTenDangNhap(rs.getString("TenDangNhap"));
                objUser.setMatKhau(rs.getString("MatKhau"));
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

        
        return objUser;
    }
}
