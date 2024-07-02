/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stanford_qlsinhvien_j0424;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangquang16
 */
public class Stanford_LopVaDoiTuong_J0424 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            if(!DataProvider.ketNoi().isClosed())
            {
                System.out.println("Kết nối đến MySQL thành công !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stanford_LopVaDoiTuong_J0424.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
