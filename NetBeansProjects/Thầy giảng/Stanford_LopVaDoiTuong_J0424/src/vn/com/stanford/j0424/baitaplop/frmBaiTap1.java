/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vn.com.stanford.j0424.baitaplop;

import javax.swing.JOptionPane;

/**
 *
 * @author dangquang16
 */
public class frmBaiTap1 extends javax.swing.JFrame {

    /**
     * Creates new form frmBaiTap1
     */
    public frmBaiTap1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtChieuDaiHCN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtChieuRongHCN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtChuViHCN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDienTichHCN = new javax.swing.JTextField();
        btnTinhToanHCN = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtDayLon = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDayNho = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtChieuCao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDienTichHinhThang = new javax.swing.JTextField();
        btnTinhToanHinhThang = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtBanKinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtChuViHT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDienTichHT = new javax.swing.JTextField();
        btnTinhToanHT = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtGiaiThua = new javax.swing.JTextField();
        btnTinhToanGT = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Chiều dài:");

        jLabel2.setText("Chiều rộng:");

        jLabel3.setText("Chu vi:");

        jLabel4.setText("Diện tích:");

        btnTinhToanHCN.setText("Tính toán");
        btnTinhToanHCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhToanHCNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTinhToanHCN)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtChieuDaiHCN, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtChieuRongHCN)
                                .addComponent(txtChuViHCN)
                                .addComponent(txtDienTichHCN)))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtChieuDaiHCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtChieuRongHCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtChuViHCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDienTichHCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTinhToanHCN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hình chữ nhật", jPanel1);

        jLabel8.setText("Đáy lớn:");

        jLabel9.setText("Đáy nhỏ:");

        jLabel10.setText("Chiều cao:");

        jLabel11.setText("Diện tích:");

        btnTinhToanHinhThang.setText("Tính toán");
        btnTinhToanHinhThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhToanHinhThangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTinhToanHinhThang))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChieuCao)
                            .addComponent(txtDayNho)
                            .addComponent(txtDayLon)
                            .addComponent(txtDienTichHinhThang, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDayLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDayNho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtChieuCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDienTichHinhThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTinhToanHinhThang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hình thang", jPanel3);

        jLabel5.setText("Bán kính:");

        jLabel6.setText("Chu vi:");

        jLabel7.setText("Diện tích:");

        btnTinhToanHT.setText("Tính toán");
        btnTinhToanHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhToanHTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTinhToanHT)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(txtDienTichHT, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtBanKinh)
                                .addComponent(txtChuViHT, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBanKinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtChuViHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDienTichHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTinhToanHT)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hình tròn", jPanel2);

        jLabel12.setText("Giá trị:");

        jLabel13.setText("Giai thừa:");

        btnTinhToanGT.setText("Tính toán");
        btnTinhToanGT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhToanGTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiaiThua))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTinhToanGT)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtGiaiThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTinhToanGT)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Giai thừa", jPanel4);

        btnDong.setText("Đóng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTinhToanHCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhToanHCNActionPerformed
        //Khai báo biến
        double dai = 0, rong = 0, chuVi = 0, dienTich = 0;
        
        //Lấy giá trị trên giao diện
        dai = Double.parseDouble(txtChieuDaiHCN.getText());
        rong = Double.parseDouble(txtChieuRongHCN.getText());
        
        //Gọi hàm tính toán
        chuVi = TinhToan.chuViHCN(dai, rong);
        dienTich = TinhToan.dienTichHCN(dai, rong);
        
        //Hiển thị
        txtChuViHCN.setText("" + chuVi);
        txtDienTichHCN.setText("" + dienTich);
    }//GEN-LAST:event_btnTinhToanHCNActionPerformed

    private void btnTinhToanHinhThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhToanHinhThangActionPerformed
        double dayLon = 0, dayNho = 0, chieuCao = 0, dienTich = 0;
        
        String strDayLon = "", strDayNho = "", strChieuCao = "";
        
        strDayLon = txtDayLon.getText().trim();
        strDayNho = txtDayNho.getText().trim();
        strChieuCao = txtChieuCao.getText().trim();
        
        if(strDayLon.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần phải nhập đáy lớn hình thang");
            txtDayLon.requestFocus();
            return;
        }
        
        if(strDayNho.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần phải nhập đáy nhỏ hình thang");
            txtDayNho.requestFocus();
            return;
        }
        
        if(strChieuCao.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần phải nhập chiều cao hình thang");
            txtChieuCao.requestFocus();
            return;
        }
        
        //Chuyển về dạng số
        try 
        {
            dayLon = Double.parseDouble(strDayLon);
            dayNho = Double.parseDouble(strDayNho);
            chieuCao = Double.parseDouble(strChieuCao);
            
            //Gọi hàm tính diện tích
            dienTich = TinhToan.dienTichHinhThang(dayLon, dayNho, chieuCao);
            
            //Hiển thị kết quả
            txtDienTichHinhThang.setText("" + dienTich);
            
        } catch (NumberFormatException e) {
            System.err.println("Có lỗi xảy ra khi chuyển về dạng số. Chi tiết: "+ e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Bạn cần phải nhập các thông tin kiểu số thực");
        }
    }//GEN-LAST:event_btnTinhToanHinhThangActionPerformed

    private void btnTinhToanHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhToanHTActionPerformed
        //Khai báo biến
        double r = 0, chuVi = 0, dienTich = 0;
        
        //Lấy thông tin và chuyển về dạng số
        r = Double.parseDouble(txtBanKinh.getText());
        
        //Gọi hàm tính toán
        chuVi = TinhToan.chuViHT(r);
        dienTich = TinhToan.dienTichHT(r);
        
        //Hiển thị lên giao diện
        txtChuViHT.setText("" + chuVi);
        txtDienTichHT.setText("" + dienTich);
    }//GEN-LAST:event_btnTinhToanHTActionPerformed

    private void btnTinhToanGTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhToanGTActionPerformed
       int giaTri = 0, giaiThua = 0;
       
       giaTri = Integer.parseInt(txtGiaTri.getText());
       
       //Gọi hàm tính giai thừa
       giaiThua = TinhToan.giaiThua(giaTri);
       
       txtGiaiThua.setText("" + giaiThua);
    }//GEN-LAST:event_btnTinhToanGTActionPerformed

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
            java.util.logging.Logger.getLogger(frmBaiTap1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBaiTap1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBaiTap1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBaiTap1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBaiTap1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnTinhToanGT;
    private javax.swing.JButton btnTinhToanHCN;
    private javax.swing.JButton btnTinhToanHT;
    private javax.swing.JButton btnTinhToanHinhThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtBanKinh;
    private javax.swing.JTextField txtChieuCao;
    private javax.swing.JTextField txtChieuDaiHCN;
    private javax.swing.JTextField txtChieuRongHCN;
    private javax.swing.JTextField txtChuViHCN;
    private javax.swing.JTextField txtChuViHT;
    private javax.swing.JTextField txtDayLon;
    private javax.swing.JTextField txtDayNho;
    private javax.swing.JTextField txtDienTichHCN;
    private javax.swing.JTextField txtDienTichHT;
    private javax.swing.JTextField txtDienTichHinhThang;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtGiaiThua;
    // End of variables declaration//GEN-END:variables
}
