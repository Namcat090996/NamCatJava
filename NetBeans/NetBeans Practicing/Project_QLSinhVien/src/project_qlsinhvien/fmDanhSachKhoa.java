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
public class fmDanhSachKhoa extends javax.swing.JFrame {

    private String maKhoa = "";

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }    
    
    /**
     * Creates new form fmDanhSachKhoa
     */
    public fmDanhSachKhoa() {
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
        jTableKhoa = new javax.swing.JTable();
        jPanelChiTietKhoa = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKhoa = new javax.swing.JTextField();
        txtTenKhoa = new javax.swing.JTextField();
        txtOrderNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThemMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();

        setTitle("Quản lý thông tin khoa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelTimKiemKhoa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập thông tin tìm kiếm khoa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Từ khóa:");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khoa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jTableKhoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTableKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKhoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKhoa);

        javax.swing.GroupLayout jPanelTimKiemKhoaLayout = new javax.swing.GroupLayout(jPanelTimKiemKhoa);
        jPanelTimKiemKhoa.setLayout(jPanelTimKiemKhoaLayout);
        jPanelTimKiemKhoaLayout.setHorizontalGroup(
            jPanelTimKiemKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTimKiemKhoaLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
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

        jPanelChiTietKhoa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết khoa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Mã khoa:");

        jLabel3.setText("Tên khoa:");

        jLabel4.setText("Order Number:");

        javax.swing.GroupLayout jPanelChiTietKhoaLayout = new javax.swing.GroupLayout(jPanelChiTietKhoa);
        jPanelChiTietKhoa.setLayout(jPanelChiTietKhoaLayout);
        jPanelChiTietKhoaLayout.setHorizontalGroup(
            jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChiTietKhoaLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelChiTietKhoaLayout.createSequentialGroup()
                        .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelChiTietKhoaLayout.setVerticalGroup(
            jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChiTietKhoaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelChiTietKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        //Gọi hàm hiển thị danh sách khoa
        hienThiDanhSachKhoa();
        txtMaKhoa.setText("");
        txtTenKhoa.setText("");
        txtOrderNumber.setText("");
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Ngăn không cho người dùng sửa thông tin khi double click vào jTable
        jTableKhoa.setDefaultEditor(Object.class, null); 	

        //Gọi hàm hiển thị danh sách khoa
        hienThiDanhSachKhoa();
    }//GEN-LAST:event_formWindowOpened

    private void jTableKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKhoaMouseClicked
        //Gọi hàm hiển thị chi tiết khoa
        hienThiChiTietKhoa();
    }//GEN-LAST:event_jTableKhoaMouseClicked

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        //Khai báo biến
        String maKhoa = "", tenKhoa = "", orderNumber = "";
        
        //Lấy thông tin trên giao diện
        maKhoa = txtMaKhoa.getText().trim();
        tenKhoa = txtTenKhoa.getText().trim();
        orderNumber = txtOrderNumber.getText().trim();
        
        //Bắt lỗi người dùng
        //Mã khoa
        if(maKhoa.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập mã khoa");
            txtMaKhoa.requestFocus();
            return;
        }
        //Tên khoa
        if(tenKhoa.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập tên khoa");
            txtTenKhoa.requestFocus();
            return;
        }
        //OrderNumber
        if(orderNumber.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập Order Number");
            txtOrderNumber.requestFocus();
            return;
        }
        
        //Khởi tạo đối tượng để gán thông tin
        ChuyenKhoa objKhoa = new ChuyenKhoa();
        
        //Gán giá trị cho object
        objKhoa.setMaKhoa(maKhoa);
        objKhoa.setTenKhoa(tenKhoa);
        objKhoa.setOrderNumber(orderNumber);
        
        //Khai báo đối tượng để gọi hàm thêm mới
        ChuyenKhoaBus chuyenKhoaBus = new ChuyenKhoaBus();
        
        //Khai báo kết quả trả về và kiểm tra trùng mã khoa
        boolean ketQua, kiemTraTrung;
        
        //Gọi hàm kiểm tra trùng mã khoa
        kiemTraTrung = chuyenKhoaBus.kiemTraTrungMaKhoa(maKhoa);
        
        if(kiemTraTrung == true)
        {
            ketQua = chuyenKhoaBus.themMoiKhoa(objKhoa);
            JOptionPane.showMessageDialog(rootPane, "Thêm mới thông tin khoa thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Mã khoa này đã tồn tại. Vui lòng nhập lại mã khoa");
            txtMaKhoa.requestFocus();
            return;
        }
        
        if(ketQua)
        {
            hienThiDanhSachKhoa();
            txtMaKhoa.setText("");
            txtTenKhoa.setText("");
            txtOrderNumber.setText("");            
        }
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //Khai báo biến
        String maKhoa = "", tenKhoa = "", orderNumber = ""; 

        //Lấy thông tin trên giao diện
        maKhoa = txtMaKhoa.getText().trim();
        tenKhoa = txtTenKhoa.getText().trim();
        orderNumber = txtOrderNumber.getText().trim();

        //Khai báo dòng cần chọn
        int dong = 0;
        
	//Chọn dòng trên table
	dong = jTableKhoa.getSelectedRow();   
        
        //Bắt lỗi người dùng khi chưa chọn khoa để sửa thông tin
        if(dong != -1)
        {
            //Bắt lỗi người dùng khi chưa nhập đủ thông tin
            //Mã khoa
            if(maKhoa.length() == 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Không thể sửa mã khoa. Vui lòng thử lại", "Warning", JOptionPane.ERROR_MESSAGE);
                txtTenKhoa.requestFocus();
                txtMaKhoa.setText(this.maKhoa);
                return;
            }
            //Tên khoa
            if(tenKhoa.length() == 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập tên khoa");
                txtTenKhoa.requestFocus();
                return;
            }
            //OrderNumber
            if(orderNumber.length() == 0)
            {
                JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập Order Number");
                txtOrderNumber.requestFocus();
                return;
            }

            //Khởi tạo đối tượng để gán thông tin
            ChuyenKhoa objKhoa = new ChuyenKhoa();

            //Gán giá trị cho object
            objKhoa.setMaKhoa(maKhoa);
            objKhoa.setTenKhoa(tenKhoa);
            objKhoa.setOrderNumber(orderNumber);

            //Khai báo đối tượng để gọi hàm sửa
            ChuyenKhoaBus chuyenKhoaBus = new ChuyenKhoaBus();

            //Khai báo kết quả trả về 
            boolean ketQua = false;

            //Trả về kết quả
            if(this.maKhoa.equals(maKhoa))
            {

            //Gọi hàm cập nhật khoa
            ketQua = chuyenKhoaBus.capNhatKhoa(objKhoa);

                if(ketQua == true) 
                {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin khoa thành công");
                    hienThiDanhSachKhoa();
                    txtMaKhoa.setText("");
                    txtTenKhoa.setText("");
                    txtOrderNumber.setText("");                      
                }            
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Không thể sửa mã khoa. Vui lòng thử lại", "Warning", JOptionPane.ERROR_MESSAGE);
                txtTenKhoa.requestFocus();
                txtMaKhoa.setText(this.maKhoa);
            }
        }
        else
        {
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn khoa cần sửa thông tin");	            
        }
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
	//Khai báo dòng cần chọn
	int dong = 0;

	//Khai báo mã khoa cần xóa
	String maKhoa = "";

	//Chọn dòng trên table
	dong = jTableKhoa.getSelectedRow();
	
	//Bắt lỗi khi chưa chọn khoa cần xóa
	if(dong != -1)
	{
	    //Lấy mã khoa từ dòng được chọn
	    maKhoa = "" + jTableKhoa.getValueAt(dong, 0);
	    
	    //Khai báo object để gọi hàm xóa thông tin khoa
	    ChuyenKhoaBus chuyenKhoaBus = new ChuyenKhoaBus();
	    
	    //Đưa ra cảnh báo trước khi xóa
	    int ketQua = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	
	    //Thực hiện xóa
	    if(ketQua == JOptionPane.YES_OPTION)
	    {
		//Gọi hàm xóa thông tin khoa
		boolean xoa = chuyenKhoaBus.xoaKhoa(maKhoa);
		
		//Xóa thành công
		if(xoa == true)
		{
		    hienThiDanhSachKhoa();
                    txtMaKhoa.setText("");
                    txtTenKhoa.setText("");
                    txtOrderNumber.setText("");
		}
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Không thể xóa thông tin mã khoa đã được sử dụng. Vui lòng thử lại", "Warning", JOptionPane.ERROR_MESSAGE);
                }
	    }
	}
	else
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn khoa cần xóa thông tin");	    
	}
    }//GEN-LAST:event_btnXoaActionPerformed

    public static void hienThiDanhSachKhoa()
    {
	//Khai báo từ khóa mà mã khoa cần tìm
	String tuKhoa = "";
	
	//Lấy từ khóa để tìm kiếm
	tuKhoa = txtTuKhoa.getText().trim();
	
	//Khai báo tiêu đề cho table
	String tieuDe[] = new String[]{"Mã khoa", "Tên khoa", "Order Number"};
	
	//Khai báo model để hiển thị dữ liệu lên table
	DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
	
	//Khai báo đối tượng 
	ChuyenKhoaBus chuyenKhoaBus = new ChuyenKhoaBus();
	
	//Gọi hàm lấy danh sách 
	List<ChuyenKhoa> lstKhoa = chuyenKhoaBus.timKiemKhoa(tuKhoa);
	
	//Khai báo đối tượng để chứa thông tin khoa và thêm vào model
	Object row[];	
	
	//Duyệt từng đối tượng khoa để thêm vào đối tượng row[]
	for(ChuyenKhoa objKhoa: lstKhoa)
	{
	    row = new Object[3];
	    //Gán giá trị cho đối tượng
	    row[0] = objKhoa.getMaKhoa();
            row[1] = objKhoa.getTenKhoa();
            row[2] = objKhoa.getOrderNumber();
	    
	    //Thêm đối tượng vào model
	    model.addRow(row);
	    
	}
		
	//Thêm model vào table      
        jTableKhoa.setModel(model);
    }
    
    /**
     * Hàm hiển thị chi tiết khoa
     */
    public void hienThiChiTietKhoa()
    {
	//Khai báo đối tượng để gọi hàm hiển thị chi tiết thông tin khoa
	ChuyenKhoaBus chuyenKhoaBus = new ChuyenKhoaBus();
        
        //Khai báo dòng cần chọn
	int dong = 0;
	
	//Chọn dòng trên table
	dong = jTableKhoa.getSelectedRow();
 
	if(dong != -1)
	{
	    //Lấy mã khoa từ dòng được chọn
	    maKhoa = "" + jTableKhoa.getValueAt(dong, 0);	
	}
	else
	{
            this.maKhoa = "";
	    txtMaKhoa.setText("");
	    txtTenKhoa.setText("");
            txtOrderNumber.setText("");
            return;
	}

	//Gọi hàm hiển thị chi tiết khoa
	ChuyenKhoa objKhoa = chuyenKhoaBus.layChiTietKhoa(maKhoa);
	
	//Gán giá trị vào textfield
	if(objKhoa != null)
	{
	    txtMaKhoa.setText(maKhoa);
	    txtTenKhoa.setText(objKhoa.getTenKhoa());
            txtOrderNumber.setText(objKhoa.getOrderNumber());
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
	    java.util.logging.Logger.getLogger(fmDanhSachKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new fmDanhSachKhoa().setVisible(true);
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
    private static javax.swing.JTable jTableKhoa;
    private javax.swing.JTextField txtMaKhoa;
    private javax.swing.JTextField txtOrderNumber;
    private javax.swing.JTextField txtTenKhoa;
    private static javax.swing.JTextField txtTuKhoa;
    // End of variables declaration//GEN-END:variables
}
