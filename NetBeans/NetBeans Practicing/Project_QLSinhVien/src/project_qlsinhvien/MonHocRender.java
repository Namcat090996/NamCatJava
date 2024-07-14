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
 * @author Dell Precision 7550
 */
public class MonHocRender extends BasicComboBoxRenderer {

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
            //Lấy đối tượng môn học
            MonHoc objMH = (MonHoc)value; 
            //Render lại nội dung
            setText(objMH.getTenMonHoc());   
        }
        
        return this;
    }
    
    
    
}
