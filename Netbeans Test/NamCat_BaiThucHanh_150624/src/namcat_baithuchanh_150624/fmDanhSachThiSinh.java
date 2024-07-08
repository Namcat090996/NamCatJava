/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package namcat_baithuchanh_150624;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell Precision 7550
 */
public class fmDanhSachThiSinh extends javax.swing.JFrame {

    /**
     * Creates new form DanhSachThiSinh
     */
    public fmDanhSachThiSinh() {
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

        btnGroupHienThi = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDuongDanFile = new javax.swing.JTextField();
        btnChonFile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rdTatCa = new javax.swing.JRadioButton();
        rdTop5 = new javax.swing.JRadioButton();
        rdDiemSan = new javax.swing.JRadioButton();
        rdDiemLiet = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableThiSinh = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblTongSo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnDong = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThemMoi = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dữ liệu tuyển sinh từ file", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Tên file");

        btnChonFile.setText("Chọn file");
        btnChonFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonFileActionPerformed(evt);
            }
        });

        jLabel2.setText("Danh sách thí sinh");

        btnGroupHienThi.add(rdTatCa);
        rdTatCa.setText("Tất cả");
        rdTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTatCaActionPerformed(evt);
            }
        });

        btnGroupHienThi.add(rdTop5);
        rdTop5.setText("Top 5 điểm cao nhất");
        rdTop5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTop5ActionPerformed(evt);
            }
        });

        btnGroupHienThi.add(rdDiemSan);
        rdDiemSan.setText("Đạt điểm sàn");
        rdDiemSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDiemSanActionPerformed(evt);
            }
        });

        btnGroupHienThi.add(rdDiemLiet);
        rdDiemLiet.setText("Thí sinh có điểm liệt");
        rdDiemLiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDiemLietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtDuongDanFile, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChonFile)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(rdTatCa)
                .addGap(18, 18, 18)
                .addComponent(rdTop5)
                .addGap(18, 18, 18)
                .addComponent(rdDiemSan)
                .addGap(18, 18, 18)
                .addComponent(rdDiemLiet)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDuongDanFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonFile)
                    .addComponent(jLabel2)
                    .addComponent(rdTatCa)
                    .addComponent(rdTop5)
                    .addComponent(rdDiemSan)
                    .addComponent(rdDiemLiet))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách thí sinh"));

        jTableThiSinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableThiSinh);

        jLabel3.setText("Tổng số: ");

        lblTongSo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongSo.setText("0");

        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThemMoi.setText("Thêm mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(386, Short.MAX_VALUE)
                .addComponent(btnLuu)
                .addGap(18, 18, 18)
                .addComponent(btnThemMoi)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnDong)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDong)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnThemMoi)
                    .addComponent(btnLuu))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongSo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblTongSo))))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void btnChonFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonFileActionPerformed
	//Khai báo đường dẫn file
	String duongDan = "";
	
	//Khai báo đối tượng chọn file
	JFileChooser chooser = new JFileChooser();
	
	//Mở hộp thoại chọn file
	if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
	{
	    //Lấy đường dẫn file
	    duongDan = chooser.getSelectedFile().getAbsolutePath();
	    
	    txtDuongDanFile.setText(duongDan);
	    txtDuongDanFile.setEditable(false);
	}	
    }//GEN-LAST:event_btnChonFileActionPerformed

    private void rdTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTatCaActionPerformed
	//Bắt lỗi khi chưa chọn file để xem
	if(txtDuongDanFile.getText().length() == 0)
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn file cần xem");
	    btnChonFile.requestFocus();
	    return;
	}
	else
	{
	    hienThiDanhSachThiSinh();
	}
    }//GEN-LAST:event_rdTatCaActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        //Hộp thoại đóng chương trình
	if(JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn thoát không ?", "Thoát chương trình", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	{
	    System.exit(0);
	}
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
	//Bắt lỗi khi table rỗng
	if(jTableThiSinh.getValueAt(1, 0) == null)
	{
	    JOptionPane.showMessageDialog(rootPane, "Không tìm thấy danh sách thí sinh để thêm thông tin");
	    btnChonFile.requestFocus();
	    return;	    
	}

	//Khai báo đối tượng hiển thị
	fmThiSinhRev fmThemMoi = new fmThiSinhRev();
	
	//Hiển thị form thêm mới
	fmThemMoi.setVisible(true);
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //Khai báo dòng được chọn
	int dong = jTableThiSinh.getSelectedRow();
	
	//Khai báo biến để chọn số báo danh
	String soBaoDanh = "";
	
	//Bắt lỗi khi chưa chọn dòng
	if(dong != -1)
	{
	    //Phương thức để chọn số báo danh
	    soBaoDanh = "" + jTableThiSinh.getValueAt(dong, 0);
	}
	else
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn thí sinh cần sửa thông tin");
	    return;
	}
	
	//Khai báo đối tượng hiển thị
	fmThiSinhRev fmSua = new fmThiSinhRev();
	
	//Gán giá trị số báo danh
	fmSua.setSoBaoDanh(soBaoDanh);
	
	//Hiển thị form sửa
	fmSua.setVisible(true);	
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        //Khai báo nội dung, đường dẫn
	String noiDung = "", duongDan = "";
	
	noiDung = "" + jTableThiSinh.getModel();
	
	//Khai báo đối tượng chọn file
	JFileChooser chooser = new JFileChooser();
	
	//Mở hộp thoại ghi file
	if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
	{
	    duongDan = chooser.getSelectedFile().getAbsolutePath();
	    
	    //Gọi hàm ghi file
	    DataProvider.getThiSinhBus().ghiDuLieuFile(noiDung, duongDan);
	    
	    JOptionPane.showMessageDialog(rootPane, "Ghi dữ liệu ra file thành công");	    
	}
    }//GEN-LAST:event_btnLuuActionPerformed

    private void rdTop5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTop5ActionPerformed
        // TODO add your handling code here:
	if(txtDuongDanFile.getText().length() == 0)
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn file cần xem");
	    btnChonFile.requestFocus();
	    return;
	}
	else
	{
	    top5DiemCaoNhat();
	}
    }//GEN-LAST:event_rdTop5ActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       
	//Khai báo dòng chọn để xóa thí sinh
	int dong = jTableThiSinh.getSelectedRow();;
	
	//Khai báo số báo danh cần xóa
	String soBD = "";
	
	//Bắt lỗi khi người dùng chưa chọn thí sinh cần xóa
	if(dong != -1)
	{
	    soBD = "" + jTableThiSinh.getValueAt(dong, 0);
	}
	else
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn thí sinh cần xóa");
	    return;
	}
	
	//Gọi hàm xóa thí sinh
	List<ThiSinh> lstXoa = DataProvider.getThiSinhBus().xoa(soBD);
	
	//Reload lại danh sách
	hienThiDanhSachThiSinh();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void rdDiemSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDiemSanActionPerformed
        // TODO add your handling code here:
	if(txtDuongDanFile.getText().length() == 0)
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn file cần xem");
	    btnChonFile.requestFocus();
	    return;
	}
	else
	{
	    diemSan();
	}        
    }//GEN-LAST:event_rdDiemSanActionPerformed

    private void rdDiemLietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDiemLietActionPerformed
        // TODO add your handling code here:
	if(txtDuongDanFile.getText().length() == 0)
	{
	    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn file cần xem");
	    btnChonFile.requestFocus();
	    return;
	}
	else
	{
	    diemLiet();
	}          
    }//GEN-LAST:event_rdDiemLietActionPerformed
    
    public static void hienThiDanhSachThiSinh()
    {
	//Khai báo tiêu đề danh sách
	String tieuDe[] = new String[]{"Số báo danh","Họ tên","Giới tính","Ngày sinh","Quê quán","Tổng","Toán","Lý","Hóa"};
	
	//Khai báo đối tượng để hiển thị dữ liệu lên bảng
	DefaultTableModel model = new DefaultTableModel(tieuDe, 0);	
	
	//Khai báo đường dẫn file
	String duongDan = "";
	
	//Lấy đường dẫn từ file 
	duongDan = txtDuongDanFile.getText();
	
	//Khai báo list để chứa dữ liệu thí sinh
	List<ThiSinh> lstThiSinh = DataProvider.getThiSinhBus().layDanhSach(duongDan);
	
	//Khai báo mảng để hiển thị dữ liệu lên bảng
	Object row[] = new Object[9];	
	
	//Gán dữ liệu cho mảng
	for(ThiSinh ts: lstThiSinh)
	{
	    row[0] = ts.getSoBaoDanh();
	    row[1] = ts.getHoTen();
	    if(ts.getGioiTinh().equals("0"))
	    {
		row[2] = "Nam";
	    }
	    if(ts.getGioiTinh().equals("1"))
	    {
		row[2] = "Nữ";
	    }
	    row[3] = ts.getNgaySinh();
	    row[4] = ts.getQueQuan();
	    row[5] = ts.getTongDiem();
	    row[6] = ts.getDiemToan();
	    row[7] = ts.getDiemLy();
	    row[8] = ts.getDiemHoa();	
	    
	    //Add mảng vào model
	    model.addRow(row);
	}
	
	int tongSo = 0;
	
	tongSo = lstThiSinh.size();
	
	lblTongSo.setText("" + tongSo);	
	
	//Hiển thị model lên table
	jTableThiSinh.setModel(model);	
    }
    
    public void top5DiemCaoNhat()
    {
	//Khai báo tiêu đề danh sách
	String tieuDe[] = new String[]{"Số báo danh","Họ tên","Giới tính","Ngày sinh","Quê quán","Tổng","Toán","Lý","Hóa"};
	
	//Khai báo đối tượng để hiển thị dữ liệu lên bảng
	DefaultTableModel model = new DefaultTableModel(tieuDe, 0);	

	//Khai báo đường dẫn file
	String duongDan = "";
	
	//Lấy đường dẫn từ file 
	duongDan = txtDuongDanFile.getText();
	
	//Khai báo list để chứa dữ liệu thí sinh
	List<ThiSinh> lstThiSinh = DataProvider.getThiSinhBus().layDanhSach(duongDan);
	
	//Khai báo list để chứa dữ liệu thí sinh
	List<ThiSinh> lstTop5 = DataProvider.getThiSinhBus().top5DiemCaoNhat();
	
	//Khai báo mảng để hiển thị dữ liệu lên bảng
	Object row[] = new Object[9];	
	
	//Gán dữ liệu cho mảng
	for(ThiSinh ts: lstTop5)
	{
	    row[0] = ts.getSoBaoDanh();
	    row[1] = ts.getHoTen();
	    if(ts.getGioiTinh().equals("0"))
	    {
		row[2] = "Nam";
	    }
	    if(ts.getGioiTinh().equals("1"))
	    {
		row[2] = "Nữ";
	    }
	    row[3] = ts.getNgaySinh();
	    row[4] = ts.getQueQuan();
	    row[5] = ts.getTongDiem();
	    row[6] = ts.getDiemToan();
	    row[7] = ts.getDiemLy();
	    row[8] = ts.getDiemHoa();	
	    
	    //Add mảng vào model
	    model.addRow(row);
	}
	
	int tongSo = 0;
	
	tongSo = lstTop5.size();
	
	lblTongSo.setText("" + tongSo);
	
	//Hiển thị model lên table
	jTableThiSinh.setModel(model);	
    }

    public void diemSan()
    {
	//Khai báo tiêu đề danh sách
	String tieuDe[] = new String[]{"Số báo danh","Họ tên","Giới tính","Ngày sinh","Quê quán","Tổng","Toán","Lý","Hóa"};
	
	//Khai báo đối tượng để hiển thị dữ liệu lên bảng
	DefaultTableModel model = new DefaultTableModel(tieuDe, 0);	

	//Khai báo đường dẫn file
	String duongDan = "";
	
	//Lấy đường dẫn từ file 
	duongDan = txtDuongDanFile.getText();
	
	//Khai báo list để chứa dữ liệu thí sinh
	List<ThiSinh> lstThiSinh = DataProvider.getThiSinhBus().layDanhSach(duongDan);
	
	//Khai báo list để chứa dữ liệu thí sinh
	List<ThiSinh> lstDiemSan = DataProvider.getThiSinhBus().diemSan();
	
	//Khai báo mảng để hiển thị dữ liệu lên bảng
	Object row[] = new Object[9];	
	
	//Gán dữ liệu cho mảng
	for(ThiSinh ts: lstDiemSan)
	{
	    row[0] = ts.getSoBaoDanh();
	    row[1] = ts.getHoTen();
	    if(ts.getGioiTinh().equals("0"))
	    {
		row[2] = "Nam";
	    }
	    if(ts.getGioiTinh().equals("1"))
	    {
		row[2] = "Nữ";
	    }
	    row[3] = ts.getNgaySinh();
	    row[4] = ts.getQueQuan();
	    row[5] = ts.getTongDiem();
	    row[6] = ts.getDiemToan();
	    row[7] = ts.getDiemLy();
	    row[8] = ts.getDiemHoa();	
	    
	    //Add mảng vào model
	    model.addRow(row);
	}
	
	int tongSo = 0;
	
	tongSo = lstDiemSan.size();
	
	lblTongSo.setText("" + tongSo);
	
	//Hiển thị model lên table
	jTableThiSinh.setModel(model);	
    }    
    
    public void diemLiet()
    {
	//Khai báo tiêu đề danh sách
	String tieuDe[] = new String[]{"Số báo danh","Họ tên","Giới tính","Ngày sinh","Quê quán","Tổng","Toán","Lý","Hóa"};
	
	//Khai báo đối tượng để hiển thị dữ liệu lên bảng
	DefaultTableModel model = new DefaultTableModel(tieuDe, 0);	

	//Khai báo đường dẫn file
	String duongDan = "";
	
	//Lấy đường dẫn từ file 
	duongDan = txtDuongDanFile.getText();
	
	//Khai báo list để chứa dữ liệu thí sinh
	List<ThiSinh> lstThiSinh = DataProvider.getThiSinhBus().layDanhSach(duongDan);
	
	//Khai báo list để chứa dữ liệu thí sinh
	List<ThiSinh> lstDiemLiet = DataProvider.getThiSinhBus().diemLiet();
	
	//Khai báo mảng để hiển thị dữ liệu lên bảng
	Object row[] = new Object[9];	
	
	//Gán dữ liệu cho mảng
	for(ThiSinh ts: lstDiemLiet)
	{
	    row[0] = ts.getSoBaoDanh();
	    row[1] = ts.getHoTen();
	    if(ts.getGioiTinh().equals("0"))
	    {
		row[2] = "Nam";
	    }
	    if(ts.getGioiTinh().equals("1"))
	    {
		row[2] = "Nữ";
	    }
	    row[3] = ts.getNgaySinh();
	    row[4] = ts.getQueQuan();
	    row[5] = ts.getTongDiem();
	    row[6] = ts.getDiemToan();
	    row[7] = ts.getDiemLy();
	    row[8] = ts.getDiemHoa();	
	    
	    //Add mảng vào model
	    model.addRow(row);
	}
	
	int tongSo = 0;
	
	tongSo = lstDiemLiet.size();
	
	lblTongSo.setText("" + tongSo);
	
	//Hiển thị model lên table
	jTableThiSinh.setModel(model);	
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
	    java.util.logging.Logger.getLogger(fmDanhSachThiSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachThiSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachThiSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(fmDanhSachThiSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new fmDanhSachThiSinh().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonFile;
    private javax.swing.JButton btnDong;
    private javax.swing.ButtonGroup btnGroupHienThi;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTableThiSinh;
    private static javax.swing.JLabel lblTongSo;
    private javax.swing.JRadioButton rdDiemLiet;
    private javax.swing.JRadioButton rdDiemSan;
    private javax.swing.JRadioButton rdTatCa;
    private javax.swing.JRadioButton rdTop5;
    private static javax.swing.JTextField txtDuongDanFile;
    // End of variables declaration//GEN-END:variables
}
