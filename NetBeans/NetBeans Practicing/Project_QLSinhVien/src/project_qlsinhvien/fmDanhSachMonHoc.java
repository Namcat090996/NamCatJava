/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project_qlsinhvien;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class fmDanhSachMonHoc extends javax.swing.JFrame {

    private String maMH = "";

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }
    /**
     * Creates new form fmDanhSachKhoa
     */
    public fmDanhSachMonHoc() {
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

        jPanelTimKiemKhoa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTuKhoa = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMH = new javax.swing.JTable();
        jPanelChiTietKhoa = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaMH = new javax.swing.JTextField();
        txtTenMH = new javax.swing.JTextField();
        txtSoTiet = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThemMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();

        setTitle("Quản lý thông tin môn học");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelTimKiemKhoa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập thông tin tìm kiếm môn học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Từ khóa:");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách môn học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jTableMH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTableMH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMH);

        javax.swing.GroupLayout jPanelTimKiemKhoaLayout = new javax.swing.GroupLayout(jPanelTimKiemKhoa);
        jPanelTimKiemKhoa.setLayout(jPanelTimKiemKhoaLayout);
        jPanelTimKiemKhoaLayout.setHorizontalGroup(
            jPanelTimKiemKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTimKiemKhoaLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanelTimKiemKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTimKiemKhoaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnTimKiem)))
                .addGap(20, 20, 20))
        );
        jPanelTimKiemKhoaLayout.setVerticalGroup(
            jPanelTimKiemKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemKhoaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelTimKiemKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelChiTietKhoa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết môn học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Mã môn học:");

        jLabel3.setText("Tên môn học:");

        jLabel4.setText("Số tiết:");

        javax.swing.GroupLayout jPanelChiTietKhoaLayout = new javax.swing.GroupLayout(jPanelChiTietKhoa);
        jPanelChiTietKhoa.setLayout(jPanelChiTietKhoaLayout);
        jPanelChiTietKhoaLayout.setHorizontalGroup(
            jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChiTietKhoaLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelChiTietKhoaLayout.createSequentialGroup()
                        .addComponent(txtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelChiTietKhoaLayout.setVerticalGroup(
            jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChiTietKhoaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtSoTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnThemMoi.setText("Thêm mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");

        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnThemMoi)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnLuu)
                .addGap(18, 18, 18)
                .addComponent(btnDong)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMoi)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLuu)
                    .addComponent(btnDong))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelChiTietKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelTimKiemKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanelTimKiemKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanelChiTietKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        //Gọi hàm hiển thị danh sách môn học
        hienThiDanhSachMH();
        txtMaMH.setText("");
        txtTenMH.setText("");
        txtSoTiet.setText(""); 
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Ngăn không cho người dùng sửa thông tin khi double click vào jTable
        jTableMH.setDefaultEditor(Object.class, null); 	

        //Gọi hàm hiển thị danh sách khoa
        hienThiDanhSachMH();
    }//GEN-LAST:event_formWindowOpened

    private void jTableMHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMHMouseClicked
        //Gọi hàm hiển thị chi tiết môn học
        hienThiChiTietMH();
    }//GEN-LAST:event_jTableMHMouseClicked

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        //Khai báo biến
        String maMH = "", tenMonHoc = "", strSoTiet = "";
        int soTiet = 0;
        
        //Lấy thông tin trên giao diện
        maMH = txtMaMH.getText().trim();
        tenMonHoc = txtTenMH.getText().trim();
        strSoTiet = txtSoTiet.getText().trim();

        
        //Bắt lỗi người dùng
        //Mã môn học
        if(maMH.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập mã môn học");
            txtMaMH.requestFocus();
            return;
        }
        //Tên môn học
        if(tenMonHoc.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập tên môn học");
            txtTenMH.requestFocus();
            return;
        }
        //Số tiết
        if(strSoTiet.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập số tiết");
            txtSoTiet.requestFocus();
            return;
        }
        //Bắt lỗi khi người dùng nhập kí tự chữ cái vào trường số tiết
        try {
            soTiet = Integer.parseInt(strSoTiet);
        } catch (NumberFormatException e) {
            System.out.println("Có lỗi xảy ra. Chi tiết: " + e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Số tiết phải là giá trị kiểu số nguyên");
            return;
        }
        
        //Khởi tạo đối tượng để gán thông tin
        MonHoc objMH = new MonHoc();
        
        //Gán giá trị cho object
        objMH.setMaMH(maMH);
        objMH.setTenMonHoc(tenMonHoc);
        objMH.setSoTiet(soTiet);
        
        //Khai báo đối tượng để gọi hàm thêm mới
        MonHocBus monHocBus = new MonHocBus();
        
        //Khai báo kết quả trả về và kiểm tra trùng mã môn học
        boolean ketQua, kiemTraTrung;
        
        //Gọi hàm kiểm tra trùng mã môn học
        kiemTraTrung = monHocBus.kiemTraTrungMaMH(maMH);
        
        if(kiemTraTrung == true)
        {
            ketQua = monHocBus.themMoiMH(objMH);
            JOptionPane.showMessageDialog(rootPane, "Thêm mới thông tin môn học thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Mã môn học này đã tồn tại. Vui lòng nhập lại mã môn học");
            txtMaMH.requestFocus();
            return;
        }
        
        if(ketQua)
        {
            hienThiDanhSachMH();
            txtMaMH.setText("");
            txtTenMH.setText("");
            txtSoTiet.setText("");            
        }
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //Khai báo biến
        String maMH = "", tenMonHoc = "", strSoTiet = ""; 
        int soTiet = 0;

        //Lấy thông tin trên giao diện
        maMH = txtMaMH.getText().trim();
        tenMonHoc = txtTenMH.getText().trim();
        strSoTiet = txtSoTiet.getText().trim();

        //Khai báo dòng cần chọn
        int dong = 0;
        
	//Chọn dòng trên table
	dong = jTableMH.getSelectedRow();   
        
        //Bắt lỗi người dùng khi chưa chọn khoa để sửa thông tin
        if(dong != -1)
        {
            //Bắt lỗi người dùng
            //Mã môn học
            if(maMH.length() == 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Không thể sửa mã môn học. Vui lòng thử lại", "Warning", JOptionPane.ERROR_MESSAGE);
                txtTenMH.requestFocus();
                txtMaMH.setText(this.maMH);
                return;
            }
            //Tên môn học
            if(tenMonHoc.length() == 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập tên môn học");
                txtTenMH.requestFocus();
                return;
            }
            //Số tiết
            if(strSoTiet.length() == 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập số tiết");
                txtSoTiet.requestFocus();
                return;
            }
            //Bắt lỗi khi người dùng nhập kí tự chữ cái vào trường số tiết
            try {
                soTiet = Integer.parseInt(strSoTiet);
            } catch (NumberFormatException e) {
                System.out.println("Có lỗi xảy ra. Chi tiết: " + e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Số tiết phải là giá trị kiểu số nguyên");
                return;
            }

            //Khởi tạo đối tượng để gán thông tin
            MonHoc objMH = new MonHoc();

            //Gán giá trị cho object
            objMH.setMaMH(maMH);
            objMH.setTenMonHoc(tenMonHoc);
            objMH.setSoTiet(soTiet);

            //Khai báo đối tượng để gọi hàm sửa
            MonHocBus monHocBus = new MonHocBus();

            //Khai báo kết quả trả về 
            boolean ketQua = false;

            //Trả về kết quả
            if(this.maMH.equals(maMH))
            {

            //Gọi hàm cập nhật môn học
            ketQua = monHocBus.capNhatMH(objMH);

                if(ketQua == true) 
                {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin môn học thành công");
                    hienThiDanhSachMH();
                    txtMaMH.setText("");
                    txtTenMH.setText("");
                    txtSoTiet.setText("");                      
                }            
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Không thể sửa mã môn học. Vui lòng thử lại", "Warning", JOptionPane.ERROR_MESSAGE);
                txtTenMH.requestFocus();
                txtMaMH.setText(this.maMH);
            }
        }
        else
        {
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn môn học cần sửa thông tin");	            
        }
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
	//Khai báo dòng cần chọn
	int dong = 0;

	//Khai báo mã môn học cần xóa
	String maMH = "";

	//Chọn dòng trên table
	dong = jTableMH.getSelectedRow();
	
	//Bắt lỗi khi chưa chọn môn học cần xóa
	if(dong != -1)
	{
	    //Lấy mã môn học từ dòng được chọn
	    maMH = "" + jTableMH.getValueAt(dong, 0);
	    
	    //Khai báo object để gọi hàm xóa thông tin môn học
	    MonHocBus monHocBus = new MonHocBus();
	    
	    //Đưa ra cảnh báo trước khi xóa
	    int ketQua = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	
	    //Thực hiện xóa
	    if(ketQua == JOptionPane.YES_OPTION)
	    {
		//Gọi hàm xóa thông tin môn học
		boolean xoa = monHocBus.xoaMH(maMH);
		
		//Xóa thành công
		if(xoa == true)
		{
		    hienThiDanhSachMH();
                    txtMaMH.setText("");
                    txtTenMH.setText("");
                    txtSoTiet.setText("");
		}
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Không thể xóa thông tin môn học đã được sử dụng. Vui lòng thử lại", "Warning", JOptionPane.ERROR_MESSAGE);
                }
	    }
	}
	else
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn môn học cần xóa thông tin");	    
	}
    }//GEN-LAST:event_btnXoaActionPerformed

    public static void hienThiDanhSachMH()
    {
	//Khai báo từ khóa mà mã môn học cần tìm
	String tuKhoa = "";
	
	//Lấy từ khóa để tìm kiếm
	tuKhoa = txtTuKhoa.getText().trim();
	
	//Khai báo tiêu đề cho table
	String tieuDe[] = new String[]{"Mã môn học", "Tên môn học", "Số tiết"};
	
	//Khai báo model để hiển thị dữ liệu lên table
	DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
	
	//Khai báo đối tượng
	MonHocBus monHocBus = new MonHocBus();
	
	//Gọi hàm lấy danh sách 
	List<MonHoc> lstMH = monHocBus.timKiemMH(tuKhoa);
	
	//Khai báo đối tượng để chứa thông tin môn học và thêm vào model
	Object row[];	
	
	//Duyệt từng đối tượng môn học để thêm vào đối tượng row[]
	for(MonHoc objMH: lstMH)
	{
	    row = new Object[3];
	    //Gán giá trị cho đối tượng
	    row[0] = objMH.getMaMH();
            row[1] = objMH.getTenMonHoc();
            row[2] = objMH.getSoTiet();
	    
	    //Thêm đối tượng vào model
	    model.addRow(row);
	    
	}
		
	//Thêm model vào table      
        jTableMH.setModel(model);
    }
    
    /**
     * Hàm hiển thị chi tiết môn học
     */
    public void hienThiChiTietMH()
    {
	//Khai báo đối tượng để gọi hàm hiển thị chi tiết thông tin môn học
	MonHocBus monHocBus = new MonHocBus();
        
        //Khai báo dòng cần chọn
	int dong = 0;
	
	//Chọn dòng trên table
	dong = jTableMH.getSelectedRow();
 
	if(dong != -1)
	{
	    //Lấy mã môn học từ dòng được chọn
	    maMH = "" + jTableMH.getValueAt(dong, 0);	
	}
	else
	{
            this.maMH = "";
	    txtMaMH.setText("");
	    txtTenMH.setText("");
            txtSoTiet.setText("");
            return;
	}

	//Gọi hàm hiển thị chi tiết môn học
        MonHoc objMH = monHocBus.layChiTietMH(maMH);
	
	//Gán giá trị vào textfield
	if(objMH != null)
	{
	    txtMaMH.setText(maMH);
	    txtTenMH.setText(objMH.getTenMonHoc());
            txtSoTiet.setText("" + objMH.getSoTiet());
	}
    }    
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
	    java.util.logging.Logger.getLogger(fmDanhSachMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new fmDanhSachMonHoc().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelChiTietKhoa;
    private javax.swing.JPanel jPanelTimKiemKhoa;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTableMH;
    private javax.swing.JTextField txtMaMH;
    private javax.swing.JTextField txtSoTiet;
    private javax.swing.JTextField txtTenMH;
    private static javax.swing.JTextField txtTuKhoa;
    // End of variables declaration//GEN-END:variables
}
