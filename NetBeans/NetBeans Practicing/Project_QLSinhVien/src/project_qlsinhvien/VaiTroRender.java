/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_qlsinhvien;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author ADMIN
 */
public class VaiTroRender extends BasicComboBoxRenderer {

    /**
     * Hàm render kiểu object về kiểu String
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     * @return 
     */
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value != null)
        {
            //Lấy thông tin đối tượng
            VaiTro objVaiTro = (VaiTro)value;
            //Hiển thị lại nội dung 
            setText(objVaiTro.getTenVaiTro());            
        }

        return this;
    }
    
   
    
}
