/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package namcat_baitaplaptrinhdesktopjv01part3;

import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class fmChuongTrinhKetBan extends javax.swing.JFrame {

    /**
     * Creates new form fmChuongTrinhKetBan
     */
    public fmChuongTrinhKetBan() {
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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenCuaBan = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        cboTinhTrang = new javax.swing.JComboBox<>();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKetQua = new javax.swing.JTextArea();
        btnDangKi = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chương trình kết bạn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Tên của bạn:");

        jLabel2.setText("Tuổi:");

        jLabel3.setText("Tình trạng hôn nhân:");

        jLabel4.setText("Giới tính:");

        jLabel5.setText("Kết quả:");

        cboTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã có gia đình", "Chưa có gia đình", "Đã ly hôn" }));

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        txtKetQua.setColumns(20);
        txtKetQua.setRows(5);
        jScrollPane1.setViewportView(txtKetQua);

        btnDangKi.setText("Đăng kí");
        btnDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKiActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDangKi)
                        .addGap(46, 46, 46)
                        .addComponent(btnThoat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenCuaBan)
                            .addComponent(txtTuoi)
                            .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenCuaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDangKi)
                    .addComponent(btnThoat))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKiActionPerformed
        
	//Declare variables
	String tenCuaBan = "", strTuoi = "", tinhTrang = "", ketQua = "";
	int tuoi = 0, gioiTinh = 0;
	
	//Take user information entered on the interface
	tenCuaBan = txtTenCuaBan.getText();
	tinhTrang = "" + cboTinhTrang.getSelectedItem();
	gioiTinh = cboGioiTinh.getSelectedIndex();
	strTuoi = txtTuoi.getText();
	
	//Convert String to Int and use Catch - Try, For - If to catch the error
	
	//Cacth the tenCuaBan error
	if(tenCuaBan.length() == 0)
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập đầy đủ họ tên");
	    txtTenCuaBan.requestFocus();
	    return;	    
	}
	char arr[] = tenCuaBan.toCharArray();
	for(int i = 0; i < arr.length; i++)
	{
	    if(Character.isAlphabetic(arr[i]) || Character.isSpaceChar(arr[i]))
	    {
		
	    }
	    else
	    {
		JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập tên là kí tự chữ cái");
		txtTenCuaBan.requestFocus();
		return;
	    }
	}
	
	//Catch the tuoi error
	if(strTuoi.length() == 0)
	{
		JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập số tuổi");
		txtTuoi.requestFocus();
		return;	    
	}
	try
	{
	    tuoi = Integer.parseInt(strTuoi);
	}
	catch(NumberFormatException ex)
	{
	    System.err.println("Bạn phải nhập tuổi là giá trị số nguyên. Chi tiết lỗi: " + ex.getMessage());
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập tuổi là giá trị số nguyên");
	    txtTuoi.requestFocus();
	    return;
	}
	
	//Computational processing
	if(tuoi < 19)
	{
	    ketQua = "Bạn không được phép tham gia chương trình";
	}
	else
	{
	    if(tinhTrang.equals("Chưa có gia đình") || tinhTrang.equals("Đã ly hôn"))
	    {
		if(gioiTinh == 0 && tuoi >= 22)
		{
		    ketQua = "Bạn được phép tham gia chương trình";
		}
		if(gioiTinh == 1 && tuoi >= 19)
		{
		    ketQua = "Bạn được phép tham gia chương trình";
		}
	    }
	    else
	    {
		ketQua = "Bạn không được phép tham gia chương trình";
	    }
	}
	
	//Print results
	txtKetQua.setText(ketQua);
	

	
	
	
	
	
	
	/*
        //Declare variables
        String tenCuaBan = "", strTuoi = "", tinhTrang = "", ketQua = "";
        int tuoi = 0, gioiTinh = 0;
        
        //Take user information entered on interface
        tenCuaBan = txtTenCuaBan.getText();
        strTuoi = txtTuoi.getText();
        tinhTrang = "" + cboTinhTrang.getSelectedItem();
        gioiTinh = cboGioiTinh.getSelectedIndex();
        
        //Use for if to catch the error
	if(tenCuaBan.length() == 0)
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập đầy đủ họ tên");
	    txtTenCuaBan.requestFocus();
	    return;
	}
        char arr[] = tenCuaBan.toCharArray();
        for(int i = 0; i < arr.length; i++)
        {
		if(Character.isAlphabetic(arr[i]) || Character.isSpaceChar(arr[i]))
		{

		}
		else
		{
		    System.err.println("Bạn cần phải nhập tên là kí tự chữ cái");
		    JOptionPane.showMessageDialog(rootPane, "Bạn cần phải nhập tên là kí tự chữ cái");
		    txtTenCuaBan.requestFocus();
		    return;                
		}
        }        
	if(strTuoi.length() ==0)
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập số tuổi");
	    txtTuoi.requestFocus();
	    return;
	}
        //Try - Catch 
        try
        {
            tuoi = Integer.parseInt(strTuoi);
        }
        catch(NumberFormatException ex)
        {
            System.err.println("Bạn cần phải nhập tuổi là giá trị số nguyên. Chi tiết lỗi: " + ex.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Bạn cần phải nhập giá trị tuổi là số nguyên");
            txtTuoi.requestFocus();
            return;
        }
	if(tuoi < 19)
	{
	    ketQua = "Bạn không được phép tham gia chương trình";
	}
	else
	{
	    if(tinhTrang.equals("Chưa có gia đình") || tinhTrang.equals("Đã ly hôn"))
	    {
		if(gioiTinh == 0 && tuoi >= 22)
		{
		    ketQua = "Bạn được phép tham gia chương trình";
		}
		else
		{
		    if(gioiTinh == 1 && tuoi >= 19)
		    {
			ketQua = "Bạn được phép tham gia chương trình";
		    }
		    else
		    {
			ketQua = "Bạn không được phép tham gia chương trình";
		    }
		}
	    }
	    else
	    {
		ketQua = "Bạn không được phép tham gia chương trình";
	    }
	}
        
        //Show results
        txtKetQua.setText("" + ketQua);
	
	*/

    }//GEN-LAST:event_btnDangKiActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
	if (JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn thoát không ?", "Cảnh báo thoát chương trình", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	{
	    System.exit(0);
	}
	else
	{
	    txtTenCuaBan.requestFocus();
	}
	
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(fmChuongTrinhKetBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmChuongTrinhKetBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmChuongTrinhKetBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmChuongTrinhKetBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmChuongTrinhKetBan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKi;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboTinhTrang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtKetQua;
    private javax.swing.JTextField txtTenCuaBan;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
