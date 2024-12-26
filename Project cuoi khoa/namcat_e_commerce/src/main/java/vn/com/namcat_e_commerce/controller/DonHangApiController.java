package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.DonHang;
import vn.com.namcat_e_commerce.entities.DonHangChiTiet;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.service.DHChiTietService;
import vn.com.namcat_e_commerce.service.DonHangService;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
@SessionAttributes("Online_User")
public class DonHangApiController {
    
    @Autowired
    DonHangService donHangService;
    
    @Autowired
    DHChiTietService dhChiTietService;
    
    @Autowired
    SanPhamService sanPhamService;
    
    @PostMapping(value = "/donhang/duyet")
    public ResponseEntity<?> xyLyDuyetHoacBoDuyet(@RequestParam("donHangChon") String donHangChon, @RequestParam("thaoTac") String thaoTac, @ModelAttribute("Online_User") String onlineUser) {
        
        //Chuyển chuỗi mã đơn hàng thành danh sách
        String[] arr_maDH = donHangChon.split(";");
        List<String> lstMaDH = Arrays.stream(arr_maDH).toList();
        int soLuongHangDaBan = 0;
        String maSP = "";
        SanPham objSP = new SanPham();
        
        try {
            if(thaoTac.equals("duyet")) {
                for(String id : lstMaDH) {
                    DonHang objDH = donHangService.findById(Integer.parseInt(id));
                    List<DonHangChiTiet> lstDHCT = dhChiTietService.layDSDonHangCTByMaDH(objDH.getMaDonHang());
                    
                    if(objDH.getTrangThai().equals("PENDING")) {
                        //Trừ số lượng sản phẩm, kiểm tra thủ công
                        for(DonHangChiTiet dhct : lstDHCT) {
                            
                            soLuongHangDaBan = dhct.getSoLuong();
                            maSP = dhct.getMaSanPham();
                            objSP = sanPhamService.findById(maSP);
                            
                            objSP.setTonKho(objSP.getTonKho() - soLuongHangDaBan);
                            
                            boolean b_sanPham = sanPhamService.update(objSP);
                        }
                    }
                    
                    objDH.setTrangThai("ACCEPTED");
                    objDH.setTenNguoiTao(onlineUser);
                    
                    boolean ketQua = donHangService.update(objDH);
                }
            }
            else if(thaoTac.equals("boDuyet")) {
                for(String id : lstMaDH) {
                    DonHang objDH = donHangService.findById(Integer.parseInt(id));
                    
                    objDH.setTrangThai("CANCELED");
                    objDH.setTenNguoiTao(onlineUser);
                    
                    boolean ketQua = donHangService.update(objDH);
                }
            }
            else {
                Message msg = new Message("er_thaoTac", "Thao tác không hợp lệ");
                return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception ex) {
            Message msg = new Message("er_duyet", "Có lỗi xảy ra khi thực hiện duyệt đơn hàng");
            return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
        }
        
        Message msg = new Message("er_duyetTC", "Duyệt thành công các đơn hàng đã chọn");
        return new ResponseEntity<Message>(msg, HttpStatus.OK);
    }
}
