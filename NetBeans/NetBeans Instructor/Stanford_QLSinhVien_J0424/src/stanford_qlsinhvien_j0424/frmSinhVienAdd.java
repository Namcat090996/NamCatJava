/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package stanford_qlsinhvien_j0424;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author dangquang16
 */
public class frmSinhVienAdd extends javax.swing.JFrame {

    /**
     * Sử dụng để lưu trữ mã sv được truyền từ form danh sách lên trong trường hợp sửa
     */
    private String maSinhVien = "";

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
    
    /**
     * Creates new form frmSinhVienAdd
     */
    public frmSinhVienAdd() {
        initComponents();
    }

    /**
     * Hàm hiển thị thông tin chi tiết sv
     */
    private void hienThiChiTietSinhVien()
    {
        //Lấy thông tin chi tiết
        SinhVien objSV = DataProvider.getSinhVienBus().layChiTiet(maSinhVien);
        
        if(objSV != null)
        {
            //Hiển thị lên giao diện
            txtMaSV.setText(maSinhVien);
            txtHoTen.setText(objSV.getHoTen());
            txtDienThoai.setText(objSV.getDienThoai());
            txtEmail.setText(objSV.getEmail());
            txtDiaChi.setText(objSV.getDiaChi());
            
            //Nếu là nữ
            if(objSV.getGioiTinh()==1)
            {
                rbtnNu.setSelected(true);
            }
            else
            {
                rbtnNam.setSelected(true);
            }
            
            if(objSV.getNgaySinh() != null)
            {
                jDateChooserNgaySinh.setDate(objSV.getNgaySinh());
            }
            
            ChuyenKhoaBusiness chuyenKhoaBusiness = new ChuyenKhoaBusiness();
            
            ChuyenKhoa objKhoa = chuyenKhoaBusiness.layChiTietKhoa(objSV.getMaKhoa());
            
            if(objKhoa != null){
            //Hiển thị khoa của sv được chọn trên combobox
            cboKhoa.getModel().setSelectedItem(objKhoa);
            }
        }
    }
    
    /**
     * Hiển thị danh sách khoa lấy được từ db lên combobox
     */
    private void hienThiDanhSachKhoa()
    {
        ChuyenKhoaBusiness chuyenKhoaBusiness = new ChuyenKhoaBusiness();
        
        //Lấy danh sách
        List<ChuyenKhoa> lstKhoa = chuyenKhoaBusiness.layDanhSach();
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        //Đuyệt để thêm vào model
        for(ChuyenKhoa objKhoa : lstKhoa)
        {
            model.addElement(objKhoa);
        }
        
        //Render lại thông tin hiển thị lên combobox
        cboKhoa.setRenderer(new KhoaRender());
        
        cboKhoa.setModel(model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbtnNam = new javax.swing.JRadioButton();
        rbtnNu = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtDienThoai = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        btnCapNhat = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        cboKhoa = new javax.swing.JComboBox<>();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập thông tin sinh viên"));

        jLabel1.setText("Mã SV:");

        jLabel2.setText("Họ tên:");

        jLabel3.setText("Giới tính:");

        buttonGroup1.add(rbtnNam);
        rbtnNam.setText("Nam");

        buttonGroup1.add(rbtnNu);
        rbtnNu.setText("Nữ");

        jLabel4.setText("Điện thoại:");

        jLabel5.setText("Email:");

        jLabel6.setText("Địa chỉ:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stanford_qlsinhvien_j0424/images/save.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stanford_qlsinhvien_j0424/images/cancel.gif"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        jLabel7.setText("Ngày sinh:");

        jLabel8.setText("Khoa:");

        cboKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TenKhoa" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnNam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnNu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCapNhat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDong))
                            .addComponent(txtDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                            .addComponent(txtEmail)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                            .addComponent(cboKhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rbtnNam)
                            .addComponent(rbtnNu)
                            .addComponent(jLabel7)))
                    .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboKhoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat)
                    .addComponent(btnDong))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Gọi hàm hiển thị ds khoa
        hienThiDanhSachKhoa();
        
        if(!maSinhVien.isEmpty())//TH sửa
        {
            //Gọi hàm hiển thị chi tiết
            hienThiChiTietSinhVien();
            this.setTitle("Sửa thông tin sinh viên");
        }
        else
        {
            this.setTitle("Thêm mới thông tin sinh viên");
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        //Khai báo các biến
        String maSV = "", hoTen = "", dienThoai = "", email = "", diaChi = "", maKhoa = "";
        
        int gioiTinh = 0;
        
        //Lấy thông tin trên giao diện
        maSV = txtMaSV.getText();
        hoTen = txtHoTen.getText().trim();
        dienThoai = txtDienThoai.getText().trim();
        email = txtEmail.getText();
        diaChi = txtDiaChi.getText();
        
        //Lấy khoa của sinh viên để lưu vào db
        ChuyenKhoa objKhoa = (ChuyenKhoa)cboKhoa.getSelectedItem();
        
        if(objKhoa != null)
        {
            maKhoa = objKhoa.getMaKhoa();
        }
        
        //Nếu chọn giới tính là Nữ
        if(rbtnNu.isSelected())
        {
            gioiTinh = 1;
        }
        
        
        if(maSV.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập mã sinh viên");
            txtMaSV.requestFocus();
            return;
        }
        
        if(hoTen.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập họ tên sinh viên");
            txtHoTen.requestFocus();
            return;
        }
        
        //Khởi tạo đối tượng
        SinhVien objSV = new SinhVien();
        
        //Gán giá trị cho các thuộc tính
        objSV.setMaSV(maSV);
        objSV.setHoTen(hoTen);
        objSV.setDienThoai(dienThoai);
        objSV.setEmail(email);
        objSV.setDiaChi(diaChi);
        
        objSV.setGioiTinh(gioiTinh);
        objSV.setNgaySinh(jDateChooserNgaySinh.getDate());
        objSV.setMaKhoa(maKhoa);
        
        boolean ketQua;
        
        //Khai báo đối tượng
        SinhVienBusiness sinhVienBusiness = new SinhVienBusiness();
        
        //TH sửa
        if(!maSinhVien.isEmpty())
        {
            ketQua = sinhVienBusiness.capNhat(objSV);
        }
        else//TH thêm mới
        {
            ketQua = sinhVienBusiness.themMoi(objSV);
        }
        
        if(ketQua)
        {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin sinh viên thành công"); 
            
            //Reload lại danh sách
            frmDanhSachSinhVien.hienThiDanhSachSinhVien();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        //Đóng cửa sổ hiện thời
        this.setVisible(false);
    }//GEN-LAST:event_btnDongActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSinhVienAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSinhVienAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSinhVienAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSinhVienAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSinhVienAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnDong;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboKhoa;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnNam;
    private javax.swing.JRadioButton rbtnNu;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    // End of variables declaration//GEN-END:variables
}
