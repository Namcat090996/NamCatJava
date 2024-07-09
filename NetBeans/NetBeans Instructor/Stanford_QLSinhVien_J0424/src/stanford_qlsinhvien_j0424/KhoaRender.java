/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_qlsinhvien_j0424;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author dangquang16
 */
public class KhoaRender extends BasicComboBoxRenderer {
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, 
            int index, boolean isSelected, boolean cellHasFocus) {
        
        
        if(value != null)
        {
            //Lấy đối tượng khoa
            ChuyenKhoa objKhoa = (ChuyenKhoa)value;
            //Hiển thị lại nội dung
            setText(objKhoa.getTenKhoa());
        }
        
        return this;
    }
}
