package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.namcat_e_commerce.entities.AnhSanPham;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.service.AnhSanPhamService;
import vn.com.namcat_e_commerce.service.GioHangService;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.util.List;


@Controller
public class SinglePageController {
    
    @Autowired
    SanPhamService sanPhamService;
    
    @Autowired
    AnhSanPhamService anhSanPhamService;
    
    @Autowired
    GioHangService gioHangService;
    
    @RequestMapping(value = "/chitiet/{id}")
    public String hienThiChiTiet(Model model, @PathVariable("id") String maSP, HttpSession session)
    {
        SanPham objSP = sanPhamService.findById(maSP);
        
        //Lấy ds loại sp tương ứng
        List<SanPham> lstSPTheoLoai = sanPhamService.timTheoLoaiSP(objSP.getLoaiSanPham());
        
        //Lấy ds ảnh sản phẩm
        List<AnhSanPham> lstASP_F = anhSanPhamService.timTheoMaSP(maSP);
        //Chỉ lấy 6 ảnh đầu trong danh sách
        List<AnhSanPham> lstASP = lstASP_F.stream().limit(6).toList();
        
        String nguoiDung = "";
        long soLuong = 0;
        
        if(session.getAttribute("user_Online") != null)
        {
            nguoiDung = session.getAttribute("user_Online").toString();
            soLuong = gioHangService.soLuongGH_TND(nguoiDung);
            model.addAttribute("SoLuong", soLuong);
            model.addAttribute("User_Online", nguoiDung);
        }
        
        model.addAttribute("objSP", objSP);
        model.addAttribute("lstASP", lstASP);
        model.addAttribute("lstSPTheoLoai", lstSPTheoLoai);

        
        return "single-product";
    }
}
