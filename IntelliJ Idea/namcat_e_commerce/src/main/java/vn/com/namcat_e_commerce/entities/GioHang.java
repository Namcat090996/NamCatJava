package vn.com.namcat_e_commerce.entities;

import jakarta.persistence.*;

@Table
@Entity(name = "cart")
public class GioHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    
    @Column(name = "username", nullable = false, length = 50)
    private String tenNguoiDung;
    
    @Column(name = "product_id", nullable = false)
    private int maSanPham;
    
    @Column(name = "quantity", nullable = false)
    private int soLuong;
    
    
}
