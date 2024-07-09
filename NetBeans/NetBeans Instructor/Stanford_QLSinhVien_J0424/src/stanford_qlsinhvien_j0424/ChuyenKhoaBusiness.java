/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_qlsinhvien_j0424;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangquang16
 */
public class ChuyenKhoaBusiness {
    
    /**
     * Hàm lấy danh sách chuyên khoa
     * @return 
     */
    public List<ChuyenKhoa> layDanhSach()
    {
        //Khai báo danh sách
        List<ChuyenKhoa> lstKhoa = new ArrayList();
        
        String strSQL = "Select MaKhoa, TenKhoa from ChuyenKhoa";
        
        //Khai báo kết nối
        Connection conn = null;
        
        try {
                    
            //Kết nối với db cần làm việc
            conn = DataProvider.ketNoi();
        
            //Tạo công việc
            Statement stm = conn.createStatement();

            //Thực hiện và trả về kết quả
            ResultSet rs = stm.executeQuery(strSQL);
            
            //Duyệt từng dòng để đưa về object ChuyenKhoa
            ChuyenKhoa objKhoa;
            while(rs.next())
            {
                objKhoa = new ChuyenKhoa();
                objKhoa.setMaKhoa(rs.getString("MaKhoa"));
                objKhoa.setTenKhoa(rs.getString("TenKhoa"));
                //Thêm vào danh sách
                lstKhoa.add(objKhoa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChuyenKhoaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        try {
                if(conn!= null){
                    conn.close();
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenKhoaBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        
        return lstKhoa;
    }
    
    /**
     * Hàm lấy danh sách chuyên khoa
     * @return 
     */
    public ChuyenKhoa layChiTietKhoa(String maKhoa)
    {
        //Khai báo biến
        ChuyenKhoa objKhoa = null;
        
        String strSQL = "Select MaKhoa, TenKhoa from ChuyenKhoa where MaKhoa ='" + maKhoa + "'";
        
        //Khai báo kết nối
        Connection conn = null;
        
        try {
                    
            //Kết nối với db cần làm việc
            conn = DataProvider.ketNoi();
        
            //Tạo công việc
            Statement stm = conn.createStatement();

            //Thực hiện và trả về kết quả
            ResultSet rs = stm.executeQuery(strSQL);
            
            //Duyệt từng dòng để đưa về object ChuyenKhoa
            
            while(rs.next())
            {
                objKhoa = new ChuyenKhoa();
                objKhoa.setMaKhoa(rs.getString("MaKhoa"));
                objKhoa.setTenKhoa(rs.getString("TenKhoa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChuyenKhoaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        try {
                if(conn!= null){
                    conn.close();
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenKhoaBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        
        return objKhoa;
    }
}
