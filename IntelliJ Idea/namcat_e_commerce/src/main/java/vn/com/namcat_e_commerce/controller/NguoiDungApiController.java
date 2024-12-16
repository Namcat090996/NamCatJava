package vn.com.namcat_e_commerce.controller;

import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.entities.SanPham;
import vn.com.namcat_e_commerce.service.NguoiDungSevice;
import vn.com.namcat_e_commerce.service.SanPhamService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api")
public class NguoiDungApiController {
    
    @Autowired
    NguoiDungSevice nguoiDungSevice;
    
    @GetMapping("/nguoidung/{id}")
    public ResponseEntity<?> layChiTiet(@PathVariable("id") String id) {
        
        NguoiDung objND = nguoiDungSevice.findById(id);
        
        if(objND != null) {
            return new ResponseEntity<NguoiDung>(objND, HttpStatus.OK);
        }
        else {
            Message msg = new Message("not_found", "Không tìm thấy người dùng với mã: " + id);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping(value = "/nguoidung/themmoi")
    public ResponseEntity<?> themMoi(@RequestBody NguoiDung objND) {
        
        List<Message> msg = new ArrayList<Message>();
        
        //Lấy tên người dùng đầu vào
        String tenNguoiDung = nguoidung.get("tenNguoiDung");
        
        if(!tenNguoiDung.matches("^[A-Za-z0-9+_.-]+$")) {
            msg.add(new Message("er_tenNguoiDung", "Tên người dùng không được chứa các kí tự đặc biệt"));
        }
        
        NguoiDung objNDCheck = nguoiDungSevice.findById(tenNguoiDung);
        
        //Kiểm tra người dùng đã tồn tại chưa
        if(objNDCheck != null) {
            msg.add(new Message("er_tenNguoiDung", "Tên người dùng này đã tồn tại"));
        }
        
        //Kiểm tra email
        String email = nguoidung.get("email");
        boolean b_email = nguoiDungSevice.kiemTraEmailTonTai(email);
        
        if(b_email)
        {
            msg.add(new Message("er_email", "Địa chỉ email này đã tồn tại"));
        }
        
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            msg.add(new Message("er_email", "Địa chỉ email không hợp lệ"));
        }
        
        //Kiểm tra họ tên
        String hoTen = nguoidung.get("hoTen");
        
        if(!hoTen.matches("^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$")) {
            msg.add(new Message("er_hoTen", "Họ tên người dùng không hợp lệ"));
        }
        
        //Kiểm tra số điện thoại
        String dienThoai = nguoidung.get("dienThoai");
        boolean b_dienThoai = nguoiDungSevice.kiemTraSDTTonTai(nguoidung.get("dienThoai"));
        
        if(b_dienThoai)
        {
            msg.add(new Message("er_dienThoai", "Số điện thoại này đã tồn tại"));
        }
        
        if(!dienThoai.matches("\\d{10}")) {
            msg.add(new Message("er_dienThoai", "Số điện thoại người dùng chỉ được bao gồm 10 chữ số"));
        }
        
        if (!msg.isEmpty()) {
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
        
        //Mã hóa mật khẩu
        String matKhauMH = BCrypt.hashpw(nguoidung.get("matKhau"), BCrypt.gensalt());
        
        NguoiDung objND = new NguoiDung();
        
        objND.setTenNguoiDung(tenNguoiDung);
        objND.setMatKhau(matKhauMH);
        objND.setEmail(email);
        objND.setDienThoai(dienThoai);
        objND.setHoTen(hoTen);
        objND.setVaiTro(nguoidung.get("vaiTro"));
        objND.setDiaChi(nguoidung.get("diaChi"));
        
        boolean ketQua = nguoiDungSevice.add(objND);

        if (ketQua) {
            return new ResponseEntity<NguoiDung>(objND, HttpStatus.OK);
        }
        
        Message msg1 = new Message("er_nguoiDung", "Thêm mới người dùng thất bại");
        return new ResponseEntity<Message>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PutMapping(value = "/nguoidung/capnhat/{id}")
    public ResponseEntity<?> capNhat(@PathVariable("id") String tenNguoiDung, @RequestParam Map<String, String> nguoidung) {
        
        List<Message> msg = new ArrayList<Message>();
        
        NguoiDung objND = nguoiDungSevice.findById(tenNguoiDung);
        
        if(objND == null) {
            Message msg1 = new Message("er_tenNguoiDung", "Không tìm thấy người dùng với mã: " + tenNguoiDung);
            return new ResponseEntity<Message>(msg1, HttpStatus.BAD_REQUEST);
        }
        
        //Kiểm tra email
        String email = nguoidung.get("email");
        boolean b_email = nguoiDungSevice.kiemTraEmailTonTai(email);
        
        if(b_email)
        {
            msg.add(new Message("er_email", "Địa chỉ email này đã tồn tại"));
        }
        
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            msg.add(new Message("er_email", "Địa chỉ email không hợp lệ"));
        }
        
        //Kiểm tra họ tên
        String hoTen = nguoidung.get("hoTen");
        
        if(!hoTen.matches("^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$")) {
            msg.add(new Message("er_hoTen", "Họ tên người dùng không hợp lệ"));
        }
        
        //Kiểm tra số điện thoại
        String dienThoai = nguoidung.get("dienThoai");
        boolean b_dienThoai = nguoiDungSevice.kiemTraSDTTonTai(nguoidung.get("dienThoai"));
        
        if(b_dienThoai)
        {
            msg.add(new Message("er_dienThoai", "Số điện thoại này đã tồn tại"));
        }
        
        if(!dienThoai.matches("\\d{10}")) {
            msg.add(new Message("er_dienThoai", "Số điện thoại người dùng chỉ được bao gồm 10 chữ số"));
        }
        
        if (!msg.isEmpty()) {
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
        
        //Mã hóa mật khẩu
        String matKhau = nguoidung.get("matKhau");
        String matKhauMH = "";
        
        //So sánh nếu mật khẩu không đổi thì lấy lại mk cũ, đổi thì mã hõa mk mới
        if(BCrypt.checkpw(matKhau, objND.getMatKhau()))
        {
            matKhauMH = objND.getMatKhau();
        }
        else
        {
            matKhauMH = BCrypt.hashpw(matKhau, BCrypt.gensalt());
        }
        
        objND.setMatKhau(matKhauMH);
        objND.setEmail(email);
        objND.setDienThoai(dienThoai);
        objND.setHoTen(hoTen);
        objND.setVaiTro(nguoidung.get("vaiTro"));
        objND.setDiaChi(nguoidung.get("diaChi"));
        
        boolean ketQua = nguoiDungSevice.update(objND);
        
        if (ketQua) {
            return new ResponseEntity<NguoiDung>(objND, HttpStatus.OK);
        }
        
        Message msg2 = new Message("er_nguoiDung", "Cập nhật người dùng thất bại");
        return new ResponseEntity<Message>(msg2, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/nguoidung/xoa/{id}")
    public ResponseEntity<?> xoa(@PathVariable("id") String tenNguoiDung)
    {
        NguoiDung objND = nguoiDungSevice.findById(tenNguoiDung);

        if(objND == null)
        {
            Message msg = new Message("er_tenNguoiDung", "Không tìm thấy người dùng với mã: " + tenNguoiDung);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
        else
        {
            boolean ketQua = nguoiDungSevice.delete(tenNguoiDung);

            if(ketQua)
            {
                Message msg = new Message("ok_nguoiDung", "Xóa thành công người dùng với mã: " + tenNguoiDung);
                return new ResponseEntity<Message>(msg, HttpStatus.OK);
            }

            Message msg = new Message("er_tenNguoiDung", "Không thể xóa thông tin đang được sử dụng. Vui lòng kiểm tra lại");
            return new ResponseEntity<Message>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
