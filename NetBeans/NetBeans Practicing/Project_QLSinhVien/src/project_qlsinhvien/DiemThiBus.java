/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_qlsinhvien;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell Precision 7550
 */
public class DiemThiBus {
    
    /**
     * Hàm lấy danh sách điểm thi sinh viên
     * @return 
     */
    public List<DiemThi> layDanhSachDiem(String maSV)
    {
	//Khai báo danh sách
	List<DiemThi> lstDiemSV = new ArrayList<DiemThi>();
	
	//Khai báo object 
	DiemThi objDiemSV = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strShowData = String.format("Select dt.MaSV, sv.HoTen, dt.MaMH, mh.TenMonHoc, dt.NgayThi, dt.DiemThi, dt.MaPhong from diemthi dt JOIN sinhvien sv ON dt.MaSV = sv.MaSV JOIN monhoc mh ON dt.MaMH = mh.MaMH where sv.MaSV = '%s'", maSV);
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strShowData);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    //Gán giá trị cho object và add object vào list
	    while(rs.next())//Duyệt từng dòng trong database
	    {
		objDiemSV = new DiemThi();
                objDiemSV.setMaSV(rs.getString("MaSV"));
                objDiemSV.setHoTen(rs.getString("HoTen"));
                objDiemSV.setMaMH(rs.getString("MaMH"));
                objDiemSV.setTenMH(rs.getString("TenMonHoc"));
                objDiemSV.setNgayThi(rs.getDate("NgayThi"));
                objDiemSV.setDiemThi(rs.getFloat("DiemThi"));
                objDiemSV.setMaPhong(rs.getString("MaPhong"));
		
		//Thêm vào danh sách
		lstDiemSV.add(objDiemSV);
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(DiemThiBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(DiemThiBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return lstDiemSV;
    }    
    
    /**
     * Hàm thêm mới điểm sinh viên
     * @param objDiem 
     * @return 
     */
    public boolean themMoiDiem(DiemThi objDiem)
    {
	//Khai báo boolean
	boolean ketQua = false;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strInsert = "Insert into diemthi(MaSV, MaMH, NgayThi, DiemThi, MaPhong) values (?, ?, ?, ?, ?)";
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strInsert);
	    
	    //Gán giá trị cho các tham số
	    preStm.setString(1, objDiem.getMaSV());
            preStm.setString(2, objDiem.getMaMH());
            preStm.setDate(4, new Date(objDiem.getNgayThi().getTime()));
            preStm.setFloat(4, objDiem.getDiemThi());
            preStm.setString(5, objDiem.getMaPhong());
            
	    
	    //Thực hiện công việc và trả về kết quả
	    ketQua = preStm.executeUpdate() > 0;//Trả về true khi biểu thức đúng, false khi ngược lại	    
	    
	} catch (SQLException ex) {
	    Logger.getLogger(DiemThiBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(DiemThiBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return ketQua;	
    }   
    
    /**
     * Hàm lấy chi tiết điểm sinh viên
     * @param maSV
     * @param maMH 
     * @return 
     */
    public DiemThi layChiTietDiemSV(String maSV, String maMH)
    {
	//Khai báo object 
	DiemThi objDiem = null;
	
	//Khai báo kết nối
	Connection conn = null;
	
	//Khai báo câu lệnh MySQL
	String strDetail = String.format("Select * from diemthi where (MaSV = '%s' AND MaMH = '%s')", maSV, maMH);
	
	try {
	    
	    //Kết nối với Database cần làm việc
	    conn = DataAccess.ketNoi();
	    
	    //Khai báo PreStatement
	    PreparedStatement preStm = conn.prepareStatement(strDetail);
	    
	    //Thực hiện công việc và trả về kết quả
	    ResultSet rs = preStm.executeQuery();
	    
	    //Gán giá trị cho object 
	    while(rs.next())//Duyệt từng dòng trong database
	    {
		objDiem = new DiemThi();
		
		//Gán giá trị cho các thuộc tính lấy được từ các cột tương ứng với dòng dữ liệu lấy được
		objDiem.setMaSV(rs.getString("MaSV"));
                objDiem.setMaSV(rs.getString("MaSV"));
                objDiem.setMaMH(rs.getString("MaMH"));
                objDiem.setNgayThi(rs.getDate("NgayThi"));
                objDiem.setDiemThi(rs.getFloat("DiemThi"));
                objDiem.setMaPhong(rs.getString("MaPhong"));
	    }
	    
	} catch (SQLException ex) {
	    Logger.getLogger(DiemThiBus.class.getName()).log(Level.SEVERE, null, ex);
	} finally
	{
	    try {
		if(conn != null)
		{
		    conn.close();		    
		}
	    } catch (SQLException ex) {
		Logger.getLogger(DiemThiBus.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	return objDiem;
    }    
    
    
}
