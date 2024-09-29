/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_lopvadoituong_j0424;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dangquang16
 */
public class SinhVienBusiness {
    
    /**
     * Khai báo danh sách sinh viên
     */
    private List<SinhVien> lstSinhVien = new ArrayList();
    
    public List<SinhVien> layDanhSach()
    {
        if(lstSinhVien.isEmpty())
        {
            taoDuLieuBanDau();
        }
        
        return lstSinhVien;
    }
    
    /**
     * Hàm tạo dữ liệu ban đầu
     */
    private void taoDuLieuBanDau()
    {
        //Khai báo các đối tượng
        SinhVien objManh = new SinhVien();
        
        //Gán giá trị
        objManh.setMaSV("SF001");
        objManh.setHoTen("Nguyễn Thế Mạnh");
        objManh.setDienThoai("0988333568");
        objManh.setEmail("themanh@gmail.com");
        
        //Thêm vào danh sách
        lstSinhVien.add(objManh);
        
        SinhVien objTruc = new SinhVien("Hà Nam");
        objTruc.setMaSV("SF002");
        objTruc.setHoTen("Bạch Văn Trúc");
        objTruc.setDienThoai("0936548925");
        objTruc.setEmail("trucbv@gmail.com");
        
        //Thêm vào danh sách
        lstSinhVien.add(objTruc);
        
        SinhVien objHoan = new SinhVien("SF003", "Hoàng Văn Hoan", "0988333556", "hoanghv@outlook.com", "Hà Nam");
        //Thêm vào danh sách
        lstSinhVien.add(objHoan);
        
        SinhVien objPhuong = new SinhVien("SF004", "Nguyễn Duy Phương", "0988331258", "duyphuong@outlook.com", "Hồ Chí Minh");
        //Thêm vào danh sách
        lstSinhVien.add(objPhuong);
        
         SinhVien objDuyen = new SinhVien("SF005", "Trần Mỹ Duyên", "0986531258", "myduyen@gmail.com", "Hà Nội");
        //Thêm vào danh sách
        lstSinhVien.add(objDuyen);
    }
    
    /**
     * Hàm lấy thông tin chi tiết sinh viên
     * @param maSV, Mã sv
     * @return Đối tượng sv chứa tất cả thông tin sv cần lấy được theo mã sv
     */
    public SinhVien layChiTiet(String maSV)
    {
        SinhVien objSV = new SinhVien();
        
        //Duyệt từng phần tử để tìm sv trùng mã
        for(SinhVien sv : lstSinhVien)
        {
            if(sv.getMaSV().equals(maSV))
            {
                objSV = sv;
                break;
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
        if(objSV != null)
        {
            //Thêm vào danh sách
            lstSinhVien.add(objSV);
            
            return true;
        }
        
        return false;
    }
    
    /**
     * Hàm cập nhật thông tin sv
     * @param objSV, Đối tượng sv chứa các thông tin mới cần cập nhật
     * @return True nếu cập nhật thành công, False nếu thất bại
     */
    public boolean capNhat(SinhVien objSV)
    {
        //Duyệt sinh viên để tìm sv trùng mã và cập nhật giá trị mới cần sửa
        for(int i = 0; i < lstSinhVien.size(); i++)
        {
            //Nếu có sv trùng mã
            if(lstSinhVien.get(i).getMaSV().equals(objSV.getMaSV()))
            {
                lstSinhVien.set(i, objSV);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Hàm xóa thông tin sinh viên trong hệ thống
     * @param maSV, mã sv cần xóa
     * @return true nếu xóa thành công, false nếu không xóa thành công
     */
    public boolean xoa(String maSV)
    {
        //Lấy thông tin sv cần xóa
        SinhVien objSV = layChiTiet(maSV);
        
        if(objSV != null)
        {
            lstSinhVien.remove(objSV);
            
            return true;
        }
        
        return false;
    }
    
    /**
     * Hàm xóa thông tin sinh viên trong hệ thống
     * @param maSV, mã sv cần xóa
     * @return true nếu xóa thành công, false nếu không xóa thành công
     */
    public boolean xoa1(String maSV)
    {
        
        for(SinhVien objSV: lstSinhVien)
        {
            if(objSV.getMaSV().equals(maSV))
            {
                lstSinhVien.remove(objSV);
                return true;
            }
        }
        
        return false;
    }    
}
