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
public class fmDanhSachPhongHoc extends javax.swing.JFrame {

    private String maPH = "";

    public String getMaPH() {
        return maPH;
    }

    public void setMaPH(String maPH) {
        this.maPH = maPH;
    }
    /**
     * Creates new form fmDanhSachKhoa
     */
    public fmDanhSachPhongHoc() {
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
        jTablePH = new javax.swing.JTable();
        jPanelChiTietKhoa = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaPH = new javax.swing.JTextField();
        txtTenPH = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThemMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();

        setTitle("Quản lý thông tin phòng học");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelTimKiemKhoa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập thông tin tìm kiếm phòng học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Từ khóa:");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phòng học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jTablePH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTablePH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePH);

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

        jPanelChiTietKhoa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết phòng học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Mã phòng học:");

        jLabel3.setText("Tên phòng học:");

        jLabel4.setText("Mô tả:");

        javax.swing.GroupLayout jPanelChiTietKhoaLayout = new javax.swing.GroupLayout(jPanelChiTietKhoa);
        jPanelChiTietKhoa.setLayout(jPanelChiTietKhoaLayout);
        jPanelChiTietKhoaLayout.setHorizontalGroup(
            jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChiTietKhoaLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelChiTietKhoaLayout.createSequentialGroup()
                        .addComponent(txtMaPH, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenPH, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelChiTietKhoaLayout.setVerticalGroup(
            jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChiTietKhoaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtMaPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanelTimKiemKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanelChiTietKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        //Gọi hàm hiển thị danh sách khoa
        hienThiDanhSachPH();
        txtMaPH.setText("");
        txtTenPH.setText("");
        txtMoTa.setText("");      
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Ngăn không cho người dùng sửa thông tin khi double click vào jTable
        jTablePH.setDefaultEditor(Object.class, null); 	

        //Gọi hàm hiển thị danh sách khoa
        hienThiDanhSachPH();
    }//GEN-LAST:event_formWindowOpened

    private void jTablePHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePHMouseClicked
        //Gọi hàm hiển thị chi tiết môn học
        hienThiChiTietPH();
    }//GEN-LAST:event_jTablePHMouseClicked

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        //Khai báo biến
        String maPH = "", tenPH = "", moTa = "";
        
        //Lấy thông tin trên giao diện
        maPH = txtMaPH.getText().trim();
        tenPH = txtTenPH.getText().trim();
        moTa = txtMoTa.getText().trim();

        
        //Bắt lỗi người dùng
        //Mã phòng học
        if(maPH.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập mã phòng học");
            txtMaPH.requestFocus();
            return;
        }
        //Tên phòng học
        if(tenPH.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập tên phòng học");
            txtTenPH.requestFocus();
            return;
        }
        //Mô tả
        if(moTa.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập phần mô tả phòng học");
            txtMoTa.requestFocus();
            return;
        }
        
        //Khởi tạo đối tượng để gán thông tin
        PhongHoc objPH = new PhongHoc();
        
        //Gán giá trị cho object
        objPH.setMaPH(maPH);
        objPH.setTenPH(tenPH);
        objPH.setMoTa(moTa);
        
        //Khai báo đối tượng để gọi hàm thêm mới
        PhongHocBus phongHocBus = new PhongHocBus();
        
        //Khai báo kết quả trả về và kiểm tra trùng mã khoa
        boolean ketQua, kiemTraTrung;
        
        //Gọi hàm kiểm tra trùng mã khoa
        kiemTraTrung = phongHocBus.kiemTraTrungMaPH(maPH);
        
        if(kiemTraTrung == true)
        {
            ketQua = phongHocBus.themMoiPH(objPH);
            JOptionPane.showMessageDialog(rootPane, "Thêm mới thông tin phòng học thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Mã phòng học này đã tồn tại. Vui lòng nhập lại mã phòng học");
            txtMaPH.requestFocus();
            return;
        }
        
        if(ketQua)
        {
            hienThiDanhSachPH();
            txtMaPH.setText("");
            txtTenPH.setText("");
            txtMoTa.setText("");            
        }
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //Khai báo biến
        String maPH = "", tenPH = "", moTa = ""; 

        //Lấy thông tin trên giao diện
        maPH = txtMaPH.getText().trim();
        tenPH = txtTenPH.getText().trim();
        moTa = txtMoTa.getText().trim();

        //Khai báo dòng cần chọn
        int dong = 0;
        
	//Chọn dòng trên table
	dong = jTablePH.getSelectedRow();   
        
        //Bắt lỗi người dùng khi chưa chọn phòng học để sửa thông tin
        if(dong != -1)
        {
            //Bắt lỗi người dùng
            //Mã phòng học
            if(maPH.length() == 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Không thể sửa mã phòng học. Vui lòng thử lại", "Warning", JOptionPane.ERROR_MESSAGE);
                txtTenPH.requestFocus();
                txtMaPH.setText(this.maPH);
                return;
            }
            //Tên phòng học
            if(tenPH.length() == 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập tên phòng học");
                txtTenPH.requestFocus();
                return;
            }
            //Mô tả
            if(moTa.length() == 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập phần mô tả phòng học");
                txtMoTa.requestFocus();
                return;
            }

            //Khởi tạo đối tượng để gán thông tin
            PhongHoc objPH = new PhongHoc();

            //Gán giá trị cho object
            objPH.setMaPH(maPH);
            objPH.setTenPH(tenPH);
            objPH.setMoTa(moTa);

            //Khai báo đối tượng để gọi hàm sửa
            PhongHocBus phongHocBus = new PhongHocBus();

            //Khai báo kết quả trả về 
            boolean ketQua = false;

            //Trả về kết quả
            if(this.maPH.equals(maPH))
            {

            //Gọi hàm cập nhật phòng học
            ketQua = phongHocBus.capNhatPH(objPH);

                if(ketQua == true) 
                {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin phòng học thành công");
                    hienThiDanhSachPH();
                    txtMaPH.setText("");
                    txtTenPH.setText("");
                    txtMoTa.setText("");                      
                }            
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Không thể sửa mã phòng học. Vui lòng thử lại", "Warning", JOptionPane.ERROR_MESSAGE);
                txtTenPH.requestFocus();
                txtMaPH.setText(this.maPH);
            }
        }
        else
        {
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn phòng học cần sửa thông tin");	            
        }
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
	//Khai báo dòng cần chọn
	int dong = 0;

	//Khai báo mã phòng học cần xóa
	String maPH = "";

	//Chọn dòng trên table
	dong = jTablePH.getSelectedRow();
	
	//Bắt lỗi khi chưa chọn phòng học cần xóa
	if(dong != -1)
	{
	    //Lấy mã môn học từ dòng được chọn
	    maPH = "" + jTablePH.getValueAt(dong, 0);
	    
	    //Khai báo object để gọi hàm xóa thông tin phòng học
	    PhongHocBus phongHocBus = new PhongHocBus();
	    
	    //Đưa ra cảnh báo trước khi xóa
	    int ketQua = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	
	    //Thực hiện xóa
	    if(ketQua == JOptionPane.YES_OPTION)
	    {
		//Gọi hàm xóa thông tin khoa
		boolean xoa = phongHocBus.xoaPH(maPH);
		
		//Xóa thành công
		if(xoa == true)
		{
		    hienThiDanhSachPH();
                    txtMaPH.setText("");
                    txtTenPH.setText("");
                    txtMoTa.setText("");
		}
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Không thể xóa thông tin phòng học đã được sử dụng. Vui lòng thử lại", "Warning", JOptionPane.ERROR_MESSAGE);
                }
	    }
	}
	else
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn phòng học cần xóa thông tin");	    
	}
    }//GEN-LAST:event_btnXoaActionPerformed

    public static void hienThiDanhSachPH()
    {
	//Khai báo từ khóa mà mã phòng học cần tìm
	String tuKhoa = "";
	
	//Lấy từ khóa để tìm kiếm
	tuKhoa = txtTuKhoa.getText().trim();
	
	//Khai báo tiêu đề cho table
	String tieuDe[] = new String[]{"Mã phòng học", "Tên phòng học", "Mô tả"};
	
	//Khai báo model để hiển thị dữ liệu lên table
	DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
	
	//Khai báo đối tượng
	PhongHocBus phongHocBus = new PhongHocBus();
	
	//Gọi hàm lấy danh sách 
        List<PhongHoc> lstPH = phongHocBus.timKiemPH(tuKhoa);
	
	//Khai báo đối tượng để chứa thông tin phòng học và thêm vào model
	Object row[];	
	
	//Duyệt từng đối tượng phòng học để thêm vào đối tượng row[]
	for(PhongHoc objPH: lstPH)
	{
	    row = new Object[3];
	    //Gán giá trị cho đối tượng
	    row[0] = objPH.getMaPH();
            row[1] = objPH.getTenPH();
            row[2] = objPH.getMoTa();
	    
	    //Thêm đối tượng vào model
	    model.addRow(row);
	    
	}
		
	//Thêm model vào table      
        jTablePH.setModel(model);
    }
    
    /**
     * Hàm hiển thị chi tiết môn học
     */
    public void hienThiChiTietPH()
    {
	//Khai báo đối tượng để gọi hàm hiển thị chi tiết thông tin phòng học
	PhongHocBus phongHocBus = new PhongHocBus();
        
        //Khai báo dòng cần chọn
	int dong = 0;
	
	//Chọn dòng trên table
	dong = jTablePH.getSelectedRow();
 
	if(dong != -1)
	{
	    //Lấy mã môn học từ dòng được chọn
	    maPH = "" + jTablePH.getValueAt(dong, 0);	
	}
	else
	{
            this.maPH = "";
	    txtMaPH.setText("");
	    txtTenPH.setText("");
            txtMoTa.setText("");
            return;
	}

	//Gọi hàm hiển thị chi tiết phòng học
        PhongHoc objPH = phongHocBus.layChiTietPH(maPH);
	
	//Gán giá trị vào textfield
	if(objPH != null)
	{
	    txtMaPH.setText(maPH);
	    txtTenPH.setText(objPH.getTenPH());
            txtMoTa.setText(objPH.getMoTa());
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
	    java.util.logging.Logger.getLogger(fmDanhSachPhongHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachPhongHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachPhongHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachPhongHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new fmDanhSachPhongHoc().setVisible(true);
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
    private static javax.swing.JTable jTablePH;
    private javax.swing.JTextField txtMaPH;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtTenPH;
    private static javax.swing.JTextField txtTuKhoa;
    // End of variables declaration//GEN-END:variables
}
