package vn.com.namcat_e_commerce.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_e_commerce.entities.Message;
import vn.com.namcat_e_commerce.entities.NguoiDung;
import vn.com.namcat_e_commerce.service.NguoiDungSevice;

import java.util.ArrayList;
import java.util.List;

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
        String tenNguoiDung = objND.getTenNguoiDung();
        
        if(!tenNguoiDung.matches("^[A-Za-z0-9+_.-]+$")) {
            msg.add(new Message("er_tenNguoiDung", "Tên người dùng không được chứa các kí tự đặc biệt, không được chứa dấu cách"));
        }
        
        NguoiDung objNDCheck = nguoiDungSevice.findById(tenNguoiDung);
        
        //Kiểm tra người dùng đã tồn tại chưa
        if(objNDCheck != null) {
            msg.add(new Message("er_tenNguoiDung", "Tên người dùng này đã tồn tại"));
        }
        
        //Kiểm tra email
        String email = objND.getEmail().trim();
        boolean b_email = nguoiDungSevice.kiemTraEmailTonTai(email);
        
        if(b_email)
        {
            msg.add(new Message("er_email", "Địa chỉ email này đã tồn tại"));
        }
        
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            msg.add(new Message("er_email", "Địa chỉ email không hợp lệ"));
        }
        
        //Kiểm tra họ tên
        String hoTen = objND.getHoTen().trim();
        
        if(!hoTen.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")) {
            msg.add(new Message("er_hoTen", "Họ tên người dùng không hợp lệ"));
        }
        
        //Kiểm tra số điện thoại
        String dienThoai = objND.getDienThoai().trim();
        boolean b_dienThoai = nguoiDungSevice.kiemTraSDTTonTai(dienThoai);
        
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
        String matKhauMH = BCrypt.hashpw(objND.getMatKhau(), BCrypt.gensalt());
        
        objND.setMatKhau(matKhauMH);
        
        boolean ketQua = nguoiDungSevice.add(objND);

        if (ketQua) {
            return new ResponseEntity<NguoiDung>(objND, HttpStatus.OK);
        }
        
        Message msg1 = new Message("er_nguoiDung", "Thêm mới người dùng thất bại");
        return new ResponseEntity<Message>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PutMapping(value = "/nguoidung/capnhat/{id}")
    public ResponseEntity<?> capNhat(@PathVariable("id") String tenNguoiDung, @RequestBody NguoiDung objND) {
        
        List<Message> msg = new ArrayList<Message>();
        
        NguoiDung objNDCheck = nguoiDungSevice.findById(tenNguoiDung);
        
        if(objNDCheck == null) {
            Message msg1 = new Message("er_tenNguoiDung", "Không tìm thấy người dùng với mã: " + tenNguoiDung);
            return new ResponseEntity<Message>(msg1, HttpStatus.BAD_REQUEST);
        }
        
        //Kiểm tra email
        String email = objND.getEmail();
        boolean b_email = nguoiDungSevice.kiemTraEmailTonTai(email);
        
        if(!email.equals(objNDCheck.getEmail()))
        {
            if(b_email)
            {
                msg.add(new Message("er_email", "Địa chỉ email này đã tồn tại"));
            }
        }
        
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            msg.add(new Message("er_email", "Địa chỉ email không hợp lệ"));
        }
        
        //Kiểm tra họ tên
        String hoTen = objND.getHoTen();
        
        if(!hoTen.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")) {
            msg.add(new Message("er_hoTen", "Họ tên người dùng không hợp lệ"));
        }
        
        //Kiểm tra số điện thoại
        String dienThoai = objND.getDienThoai();
        boolean b_dienThoai = nguoiDungSevice.kiemTraSDTTonTai(dienThoai);
        
        if(!dienThoai.equals(objNDCheck.getDienThoai()))
        {
            if(b_dienThoai)
            {
                msg.add(new Message("er_dienThoai", "Số điện thoại này đã tồn tại"));
            }
        }

        
        if(!dienThoai.matches("\\d{10}")) {
            msg.add(new Message("er_dienThoai", "Số điện thoại người dùng chỉ được bao gồm 10 chữ số"));
        }
        
        if (!msg.isEmpty()) {
            return new ResponseEntity<List<Message>>(msg, HttpStatus.BAD_REQUEST);
        }
        
        //Mã hóa mật khẩu
        String matKhau = objND.getMatKhau();
        String matKhauMH = "";
        
        //So sánh nếu mật khẩu không đổi thì lấy lại mk cũ, đổi thì mã hõa mk mới
        if(matKhau.equals(objNDCheck.getMatKhau()))
        {
            matKhauMH = objNDCheck.getMatKhau();
        }
        else
        {
            matKhauMH = BCrypt.hashpw(matKhau, BCrypt.gensalt());
        }
        
        objND.setMatKhau(matKhauMH);
        
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
