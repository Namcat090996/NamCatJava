/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package NamCat_SuDungThuVienTinhToan;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import NamCat_TinhToanLib.TinhToanCongChuoiSo;

/**
 *
 * @author Dell Precision 7550
 */
public class fmCongChuoi extends javax.swing.JFrame {

    /**
     * Creates new form fmCongChuoi
     */
    public fmCongChuoi() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtChuoiThuNhat = new javax.swing.JTextField();
        txtChuoiThuHai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtKetQua = new javax.swing.JTextField();
        btnTinhToan = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tính toán cộng hai chuỗi số nguyên\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Chuỗi thứ nhất:");

        jLabel2.setText("Chuỗi thứ hai:");

        jLabel3.setText("Kết quả:");

        btnTinhToan.setText("Tính toán");
        btnTinhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhToanActionPerformed(evt);
            }
        });

        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtChuoiThuHai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(txtChuoiThuNhat, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKetQua))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTinhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtChuoiThuNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTinhToan))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtChuoiThuHai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDong))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn đóng chương trình không", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	{
	    System.exit(0);
	}
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnTinhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhToanActionPerformed
	
	//Declare variables
	String strChuoiThuNhat = "", strChuoiThuHai = "", strKetQua = "";
	List<Integer> ketQua = new ArrayList<Integer>();
	
	//Take user information entered from the keyboard
	strChuoiThuNhat = txtChuoiThuNhat.getText();
	strChuoiThuHai = txtChuoiThuHai.getText();
	
	//Catch error
	if(strChuoiThuNhat.length() == 0 || strChuoiThuHai.length() == 0)
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập giá trị hai chuỗi số");
	    return;
	}
	
	try {
	    int chuoiThuNhat = Integer.parseInt(strChuoiThuNhat);
	    int chuoiThuHai = Integer.parseInt(strChuoiThuHai);
	} catch (NumberFormatException e) {
	    System.err.println("Bạn phải nhập giá trị là số nguyên. Chi tiết lỗi: " + e.getMessage());
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập giá trị là số nguyên");
	    return;
	}

	//Equalize the lengths of two sequences
	if(strChuoiThuNhat.length() > strChuoiThuHai.length())
	{
	    strChuoiThuHai = TinhToanCongChuoiSo.canBangChuoi(strChuoiThuNhat, strChuoiThuHai);
	}
	
	if(strChuoiThuNhat.length() < strChuoiThuHai.length())
	{
	    strChuoiThuNhat = TinhToanCongChuoiSo.canBangChuoi(strChuoiThuHai, strChuoiThuNhat);
	}
	
	//Calculate addition of two sequences of numbers
	ketQua = TinhToanCongChuoiSo.tinhToanCongChuoi(strChuoiThuNhat, strChuoiThuHai);
	
	//Convert List to String
	for(int i = ketQua.size()-1; i >= 0; i--)
	{
	    strKetQua += ketQua.get(i);
	}
	
	//Show result on the interface
	txtKetQua.setText(strKetQua);
	txtKetQua.setEditable(false);
	
    }//GEN-LAST:event_btnTinhToanActionPerformed

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
	    java.util.logging.Logger.getLogger(fmCongChuoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(fmCongChuoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(fmCongChuoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(fmCongChuoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new fmCongChuoi().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnTinhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtChuoiThuHai;
    private javax.swing.JTextField txtChuoiThuNhat;
    private javax.swing.JTextField txtKetQua;
    // End of variables declaration//GEN-END:variables
}
