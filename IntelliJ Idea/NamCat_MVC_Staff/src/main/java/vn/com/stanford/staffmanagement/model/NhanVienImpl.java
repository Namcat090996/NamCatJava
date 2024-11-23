package vn.com.stanford.staffmanagement.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.staffmanagement.entities.NhanVien;
import vn.com.stanford.staffmanagement.entities.NhanVienMapper;
import vn.com.stanford.staffmanagement.entities.NhanVienModelMapper;
import vn.com.stanford.staffmanagement.entities.NhanVienModel;

import java.util.List;

@Repository
public class NhanVienImpl implements NhanVienDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    /**
     * Function to get total salary list of staff
     * @param tuKhoa
     * @param maPhong
     * @param maChucVu
     * @return
     */
    @Override
    public List<NhanVienModel> danhSachTongLuongNV(String tuKhoa, String maPhong, String maChucVu) {

        //Declare SQL command
        String strList = "Select * from vBangLuongNhanVien where 1=1";

        if(tuKhoa!= null && !tuKhoa.isEmpty())
        {
            strList += " and (MaNV = '" + tuKhoa + "' OR HoTen like '%" + tuKhoa + "%')";
        }

        if(maPhong!= null && !maPhong.isEmpty())
        {
            strList += " and MaPhong = '" + maPhong + "'";
        }

        if(maChucVu!= null && !maChucVu.isEmpty())
        {
            strList += " and MaChucVu = '" + maChucVu + "'";
        }

        strList += " order by MaNV ASC";

        //Execute the queries and return the result
        return jdbcTemplate.query(strList, new NhanVienModelMapper());
    }

    @Override
    public List<NhanVien> getList() {
        return null;
    }

    /**
     * Function to get detailed object by id
     * @param maNV
     * @return
     */
    @Override
    public NhanVien findById(String maNV) {

        //Use try-catch when MaNV is not found in the database
        try {
            //Declare SQL command
            String strDetail = "Select MaNV, HoTen, GioiTinh, NgaySinh, DienThoai, Email, DiaChi, SoCMT, NgayCap, NoiCap, HeSoId, MaChucVu, MaPhong from NhanVien where MaNV = ?";

            //Execute the queries and return the result
            return jdbcTemplate.queryForObject(strDetail, new NhanVienMapper(), maNV);
        }
        catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    /**
     * Function to insert a new object
     * @param objNV
     * @return
     */
    @Override
    public boolean add(NhanVien objNV) {

        //Declare SQL command
        String strAdd = "Insert into NhanVien(MaNV, HoTen, GioiTinh, NgaySinh, DienThoai, Email, DiaChi, SoCMT, NgayCap, NoiCap, HeSoId, MaChucVu, MaPhong) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        //Declare a boolean
        boolean ketQua = false;

        //Execute the queries and return the result
        ketQua = jdbcTemplate.update(strAdd, objNV.getMaNV(), objNV.getHoTen(), objNV.getGioiTinh(), objNV.getNgaySinh(), objNV.getDienThoai(), objNV.getEmail(), objNV.getDiaChi(), objNV.getSoCMT(), objNV.getNgayCap(), objNV.getNoiCap(), objNV.getHeSoId(), objNV.getMaChucVu(), objNV.getMaPhong()) > 0;

        return ketQua;
    }

    /**
     * Function to update info of selected object
     * @param objNV
     * @return
     */
    @Override
    public boolean update(NhanVien objNV) {
        //Declare SQL command
        String strUpdate = "Update NhanVien set HoTen = ?, GioiTinh = ?, NgaySinh = ?, DienThoai = ?, Email = ?, DiaChi = ?, SoCMT = ?, NgayCap = ?, NoiCap = ?, HeSoId = ?, MaChucVu = ?, MaPhong = ? where MaNV = ?";

        //Declare a boolean
        boolean ketQua = false;

        //Execute the queries and return the result
        ketQua = jdbcTemplate.update(strUpdate, objNV.getHoTen(), objNV.getGioiTinh(), objNV.getNgaySinh(), objNV.getDienThoai(), objNV.getEmail(), objNV.getDiaChi(), objNV.getSoCMT(), objNV.getNgayCap(), objNV.getNoiCap(), objNV.getHeSoId(), objNV.getMaChucVu(), objNV.getMaPhong(), objNV.getMaNV()) > 0;

        return ketQua;
    }

    /**
     * Function to delete object by id
     * @param maNV
     * @return
     */
    @Override
    public boolean delete(String maNV) {
        //Declare SQL command
        String strDelete = "Delete from NhanVien where MaNV = ?";

        //Declare a boolean
        boolean ketQua = false;

        //Execute the queries and return the result
        ketQua = jdbcTemplate.update(strDelete, maNV) > 0;

        return ketQua;
    }
}
