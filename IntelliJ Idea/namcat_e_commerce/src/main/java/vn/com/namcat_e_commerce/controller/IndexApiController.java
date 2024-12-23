package vn.com.namcat_e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.*;
import vn.com.namcat_e_commerce.service.AnhSanPhamService;
import vn.com.namcat_e_commerce.service.NguoiDungSevice;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class IndexApiController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @Autowired
    AnhSanPhamService anhSanPhamService;
    
    @GetMapping("/sanpham/xemnhanh/{id}")
    public ResponseEntity<?> xemNhanhSP(@PathVariable("id") String id, Model model) {
        
        SanPham objSP = sanPhamService.findById(id);
        List<AnhSanPham> lstASP_F = anhSanPhamService.timTheoMaSP(id);
        //Chỉ lấy 6 ảnh đầu trong danh sách
        List<AnhSanPham> lstASP = lstASP_F.stream().limit(6).toList();
        
        if(objSP != null) {
            
            // Format giá sản phẩm
            String giaSPFormat = String.format("%,dđ", objSP.getGiaSanPham());
            
            // Tạo DTO
            SanPhamDTO sanPhamDTO = new SanPhamDTO();
            
            sanPhamDTO.setMaSanPham(objSP.getMaSanPham());
            sanPhamDTO.setTenSanPham(objSP.getTenSanPham());
            sanPhamDTO.setMoTa(objSP.getMoTa());
            sanPhamDTO.setNoiDung(objSP.getNoiDung());
            sanPhamDTO.setMauSac(objSP.getMauSac());
            sanPhamDTO.setGiaTienFormat(giaSPFormat);
            sanPhamDTO.setLstASP(lstASP);
            
            return new ResponseEntity<SanPhamDTO>(sanPhamDTO, HttpStatus.OK);
        }
        else {
            Message msg = new Message("not_found_qv", "Không tìm thấy sản phẩm với mã: " + id);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
    }
}
