/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project_qlsinhvien;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell Precision 7550
 */
public class fmDSDiemThi extends javax.swing.JFrame {   
    
    /**
     * Creates new form fmDiemThi
     */
    public fmDSDiemThi() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSinhVien = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTuKhoa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboMonHoc = new javax.swing.JComboBox<>();
        btnTraCuu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboChuyenKhoa = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        btnThemMoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDiemThi = new javax.swing.JTable();

        setTitle("Quản lý thông tin điểm thi");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sinh viên", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(460, 423));

        jTableSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Giới tính", "Điện thoại", "Mã khoa"
            }
        ));
        jTableSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSinhVien);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập thông tin tra cứu điểm thi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Từ khóa:");

        jLabel4.setText("Môn học:");

        cboMonHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TenMonHoc" }));

        btnTraCuu.setText("Tra cứu");
        btnTraCuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuActionPerformed(evt);
            }
        });

        jLabel5.setText("Khoa:");

        cboChuyenKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TenKhoa" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboChuyenKhoa, 0, 154, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnTraCuu)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cboMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTraCuu))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cboChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

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

        btnThemMoi.setText("Thêm mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemMoi)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnLuu)
                .addGap(18, 18, 18)
                .addComponent(btnDong)
                .addGap(16, 16, 16))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLuu)
                    .addComponent(btnDong)
                    .addComponent(btnThemMoi))
                .addContainerGap())
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kết quả điểm thi sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jTableDiemThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Tên môn học", "Ngày thi", "Điểm thi", "Mã phòng học"
            }
        ));
        jScrollPane2.setViewportView(jTableDiemThi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTraCuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraCuuActionPerformed
        //Gọi hàm tra cứu điểm sinh viên
        hienThiDanhSachTraCuuDiem();
    }//GEN-LAST:event_btnTraCuuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //Khai báo dòng cần chọn
	int dong = 0;
	
	//Khai báo mã sinh viên và mã môn học của sinh viên cần sửa điểm
	String maSV = "", tenMH = "", maMH = "";
	
	//Chọn dòng trên table
	dong = jTableDiemThi.getSelectedRow();
 
	if(dong != -1)
	{
	    //Lấy mã sinh viên và tên môn học từ dòng được chọn
	    maSV = "" + jTableDiemThi.getValueAt(dong, 0);
            tenMH = "" + jTableDiemThi.getValueAt(dong, 2);
            
            //Khai báo đối tượng và gọi hàm lấy chi tiết mã môn học
            DiemThiBus diemThiBus = new DiemThiBus();
            DiemThi objDT = diemThiBus.layChiTietMaMH(maSV, tenMH);
            if(objDT != null)
            {
                maMH = objDT.getMaMH();                
            }
	}
	else
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn môn học và điểm của sinh viên cần sửa");
	    return;	    
	}
	
	//Khai báo object để hiển thị form sửa điểm sinh viên
	fmRevDiemThi fmSua = new fmRevDiemThi();
	
	//Truyền giá trị vào form sửa
        fmSua.setMaSV(maSV);
        fmSua.setMaMH(maMH);	
	
	//Hiển thị form sửa thông tin sinh viên
	fmSua.setVisible(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
	//Khai báo dòng cần chọn
	int dong = 0;

	//Khai báo mã sinh viên và mã môn học của sinh viên cần xóa
	String maSV = "", tenMH = "", maMH = "";

	//Chọn dòng trên table
	dong = jTableDiemThi.getSelectedRow();
	
	//Bắt lỗi khi chưa chọn sinh viên cần xóa
	if(dong != -1)
	{
	    //Lấy mã sinh viên và tên môn học từ dòng được chọn
	    maSV = "" + jTableDiemThi.getValueAt(dong, 0);
            tenMH = "" + jTableDiemThi.getValueAt(dong, 2);
            
            //Khai báo đối tượng và gọi hàm lấy chi tiết mã môn học
            DiemThiBus diemThiBus = new DiemThiBus();
            DiemThi objDT = diemThiBus.layChiTietMaMH(maSV, tenMH);
            if(objDT != null)
            {
                maMH = objDT.getMaMH();                
            }
	    
	    //Đưa ra cảnh báo trước khi xóa
	    int ketQua = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	
	    //Thực hiện xóa
	    if(ketQua == JOptionPane.YES_OPTION)
	    {
		//Gọi hàm xóa thông tin sinh viên
		boolean xoa = diemThiBus.xoaDiemSV(maSV, maMH);
		
		//Xóa thành công
		if(xoa)
		{
		    hienThiDanhSachDiem();
		}
	    }
	}
	else
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn môn học và điểm của sinh viên cần xóa");	    
	}
    }//GEN-LAST:event_btnXoaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        //Ngăn không cho người dùng sửa thông tin khi double click vào jTable
        jTableSinhVien.setDefaultEditor(Object.class, null); 
        jTableDiemThi.setDefaultEditor(Object.class, null);  
                
        //Gọi hàm hiển thị danh sách môn học và khoa
        hienThiDanhSachMonHoc();
        hienThiDanhSachKhoa();
        
        //Gọi hàm hiển thị danh sách sinh viên
        hienThiDanhSachSinhVien();
    }//GEN-LAST:event_formWindowOpened

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
	//Khai báo dòng cần chọn
	int dong = 0;       
	
	//Khai báo mã sinh viên cần lấy để thêm mới điểm
	String maSV = "";
	
	//Chọn dòng trên table
	dong = jTableSinhVien.getSelectedRow();
 
	if(dong != -1)
	{
	    //Lấy mã sinh viên từ dòng được chọn
	    maSV = "" + jTableSinhVien.getValueAt(dong, 0);	
	}
	else
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn sinh viên cần thêm mới điểm số");
	    return;	    
	}
	
	//Khai báo object để hiển thị form thêm mới điểm sinh viên
	fmRevDiemThi fmSua = new fmRevDiemThi();
	
	//Truyền giá trị điểm vào form sửa
	fmSua.setMaSV(maSV);
	
	//Hiển thị form sửa thông tin sinh viên
	fmSua.setVisible(true);        
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnDongActionPerformed

    private void jTableSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSinhVienMouseClicked
        //Gọi hàm hiển thị danh sách điểm sinh viên
        hienThiDanhSachDiem();
    }//GEN-LAST:event_jTableSinhVienMouseClicked

    /**
     * Hàm hiển thị danh sách khoa
     */
    public void hienThiDanhSachKhoa()
    {
	//Khai báo object
	ChuyenKhoaBus chuyenKhoaBus = new ChuyenKhoaBus();
	
	//Gọi hàm lấy danh sách khoa
	List<ChuyenKhoa> lstKhoa = chuyenKhoaBus.layDanhSachKhoa();
	
	//Set mục khoa đầu trống để hiển thị toàn bộ danh sách sinh viên
        ChuyenKhoa root = new ChuyenKhoa();
        root.setMaKhoa("");
        root.setTenKhoa("---Chọn khoa---");
        lstKhoa.add(0, root);
	
	//Khai báo model để hiển thị lên combobox
	DefaultComboBoxModel model = new DefaultComboBoxModel();
	
	//Gán object vào model
	for(ChuyenKhoa objKhoa: lstKhoa)
	{
	    model.addElement(objKhoa);         
	}
       
	//Render để hiển thị tên khoa trên combobox
	cboChuyenKhoa.setRenderer(new ChuyenKhoaRender());
	
	//Set model lên combobox
	cboChuyenKhoa.setModel(model);
    }    
    
    /**
     * Hàm hiển thị danh sách môn học
     */
    public void hienThiDanhSachMonHoc()
    {
	//Khai báo object
	MonHocBus monHocBus = new MonHocBus();
	
	//Gọi hàm lấy danh sách môn học
	List<MonHoc> lstMH = monHocBus.layDanhSachMH();
	
	//Set mục khoa đầu trống để hiển thị toàn bộ danh sách sinh viên
        MonHoc root = new MonHoc();
        root.setMaMH("");
        root.setTenMonHoc("---Chọn môn học---");
        lstMH.add(0, root);
	
	//Khai báo model để hiển thị lên combobox
	DefaultComboBoxModel model = new DefaultComboBoxModel();
	
	//Gán object vào model
	for(MonHoc objMH: lstMH)
	{
	    model.addElement(objMH);         
	}
       
	//Render để hiển thị tên khoa trên combobox
	cboMonHoc.setRenderer(new MonHocRender());
	
	//Set model lên combobox
	cboMonHoc.setModel(model);
    }      
    
    /**
    * Hàm hiển thị danh sách tìm kiếm sinh viên
    */
    public static void hienThiDanhSachSinhVien()
    {	
	//Khai báo tiêu đề cho table
	String tieuDe[] = new String[]{"Mã sinh viên", "Họ tên", "Giới tính", "Điện thoại", "Mã khoa"};
	
	//Khai báo model để hiển thị dữ liệu lên table
	DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
	
	//Khai báo đối tượng từ lớp 
	SinhVienBus sinhVienBus = new SinhVienBus();
	
	//Gọi hàm lấy danh sách 
	List<SinhVien> lstSV = sinhVienBus.layDanhSachSV();
	
	//Khai báo đối tượng để chứa thông tin sinh viên và thêm vào model
	Object row[];	
	
	//Duyệt từng đối tượng sinh viên để thêm vào đối tượng row[]
	for(SinhVien objSV: lstSV)
	{
	    row = new Object[5];
	    //Gán giá trị cho đối tượng
	    row[0] = objSV.getMaSV();
	    row[1] = objSV.getHoTen();
	    if(objSV.getGioiTinh() == 1)
	    {
		row[2] = "Nữ";
	    }
	    else
	    {
		row[2] = "Nam";
	    }
	    row[3] = objSV.getDienThoai();
	    row[4] = objSV.getMaKhoa();
	    
	    //Thêm đối tượng vào model
	    model.addRow(row);
	    
	}
		
	//Thêm model vào table
	jTableSinhVien.setModel(model);	
    }
    
    /**
    * Hàm hiển thị danh sách điểm thi sinh viên
    */
    public static void hienThiDanhSachDiem()
    {
	//Khai báo tiêu đề cho table
	String tieuDe[] = new String[]{"Mã sinh viên", "Họ tên", "Tên môn học", "Ngày thi", "Điểm thi", "Mã phòng học"};
	
	//Khai báo model để hiển thị dữ liệu lên table
	DefaultTableModel model = new DefaultTableModel(tieuDe, 0);        
        
        //Khai báo dòng cần chọn và mã cần chọn
	String maSV = "";
        int dong = 0;
	
	//Chọn dòng trên table
	dong = jTableSinhVien.getSelectedRow();
        
        //Chọn mã
	if(dong != -1)
	{
	    //Lấy mã môn học từ dòng được chọn
	    maSV = "" + jTableSinhVien.getValueAt(dong, 0);
            //Khai báo đối tượng từ lớp 
            DiemThiBus diemThiBus = new DiemThiBus();
            
            //Khai báo đối tượng để format ngày sinh
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            
            //Gọi hàm lấy danh sách 
            List<DiemThi> lstDiemSV = diemThiBus.layDanhSachDiem(maSV);

            //Khai báo đối tượng để chứa thông tin sinh viên và thêm vào model
            Object row[];	

            //Duyệt từng đối tượng sinh viên để thêm vào đối tượng row[]
            for(DiemThi objDiemSV: lstDiemSV)
            {
                row = new Object[6];
                //Gán giá trị cho đối tượng
                row[0] = objDiemSV.getMaSV();
                row[1] = objDiemSV.getHoTen();
                row[2] = objDiemSV.getTenMH();
                row[3] = date.format(objDiemSV.getNgayThi());
                row[4] = objDiemSV.getDiemThi();
                row[5] = objDiemSV.getMaPhong();              

                //Thêm đối tượng vào model
                model.addRow(row);
            }

            //Thêm model vào table
            jTableDiemThi.setModel(model);	            
        }
	else
	{
            jTableDiemThi.setModel(model);
	}
    } 
    
    /**
    * Hàm hiển thị danh sách tra cứu điểm thi sinh viên
    */
    public void hienThiDanhSachTraCuuDiem()
    {
	//Khai báo tiêu đề cho table
	String tieuDe[] = new String[]{"Mã sinh viên", "Họ tên", "Tên môn học", "Ngày thi", "Điểm thi", "Mã phòng học"};
	
	//Khai báo model để hiển thị dữ liệu lên table
	DefaultTableModel model = new DefaultTableModel(tieuDe, 0);        
        
        //Khai báo dòng cần chọn và mã cần chọn
	String tuKhoa, maKhoa, maMH;
	
	//Chọn dòng trên table
	tuKhoa = txtTuKhoa.getText();
        
        //Lấy mã khoa 
        ChuyenKhoa objKhoa = (ChuyenKhoa)cboChuyenKhoa.getSelectedItem();
        maKhoa = objKhoa.getMaKhoa();
        
        //Lấy mã môn học
        MonHoc objMH = (MonHoc)cboMonHoc.getSelectedItem();
        maMH = objMH.getMaMH();
        
        //Khai báo đối tượng 
        DiemThiBus diemThiBus = new DiemThiBus();

        //Khai báo đối tượng để format ngày sinh
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        //Gọi hàm lấy danh sách 
        List<DiemThi> lstDiemSV = diemThiBus.traCuuDiemSV(tuKhoa, maKhoa, maMH);

        //Khai báo đối tượng để chứa thông tin sinh viên và thêm vào model
        Object row[];

        //Duyệt từng đối tượng sinh viên để thêm vào đối tượng row[]
        for (DiemThi objDiemSV : lstDiemSV) {
            row = new Object[6];
            //Gán giá trị cho đối tượng
            row[0] = objDiemSV.getMaSV();
            row[1] = objDiemSV.getHoTen();
            row[2] = objDiemSV.getTenMH();
            row[3] = date.format(objDiemSV.getNgayThi());
            row[4] = objDiemSV.getDiemThi();
            row[5] = objDiemSV.getMaPhong();

            //Thêm đối tượng vào model
            model.addRow(row);
        }

        //Thêm model vào table
        jTableDiemThi.setModel(model);
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
            java.util.logging.Logger.getLogger(fmDSDiemThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmDSDiemThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmDSDiemThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmDSDiemThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmDSDiemThi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTraCuu;
    private javax.swing.JButton btnXoa;
    private static javax.swing.JComboBox<String> cboChuyenKhoa;
    private static javax.swing.JComboBox<String> cboMonHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jTableDiemThi;
    private static javax.swing.JTable jTableSinhVien;
    private static javax.swing.JTextField txtTuKhoa;
    // End of variables declaration//GEN-END:variables
}
