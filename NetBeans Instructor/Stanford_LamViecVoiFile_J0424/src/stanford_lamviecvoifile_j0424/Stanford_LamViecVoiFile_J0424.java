/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stanford_lamviecvoifile_j0424;

//Khai báo thư viện để làm việc với Java
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangquang16
 */
public class Stanford_LamViecVoiFile_J0424 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
            
            FileInputStream fileInputStream = null;
            try {
                //Đọc dữ liệu từ file
                System.out.println("Đọc dữ liệu từ file: ");
                fileInputStream =
                        new FileInputStream("/Volumes/DATA/Stanford/Courses/Java/Data/j0424_demo.txt");
                int ch = 0;
                
                while((ch = fileInputStream.read()) != -1)
                {
                    System.out.print((char)ch);
                }
                
                //Đóng luồng đọc file
                fileInputStream.close();
                
            } catch (FileNotFoundException ex) {
                System.err.println("Không tìm thấy file. Chi tiết: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Lỗi khi đọc file. Chi tiết: " + ex.getMessage());
            }
            
        try {  
            System.out.println("Ghi dữ liệu ra file: ");
            
            byte b[] = new byte[100];
            
            System.out.println("Nhập dữ liệu cần ghi: ");
            
            int iNum = System.in.read(b);
            
            //Khai báo 1 đối tượng để ghi file
            FileOutputStream fileOutputStream = 
                    new FileOutputStream("/Volumes/DATA/Stanford/Courses/Java/Data/j042402_demo.txt");
            
            fileOutputStream.write(b, 0, iNum);
            
            //Đóng luồng ghi
            fileOutputStream.close();
            
            System.out.println("Ghi thông tin ra file thành công");
            
        } catch (IOException ex) {
            System.err.println("Lỗi quá trình ghi file. Chi tiết: " + ex.getMessage());
        } 
        
        
    }
    
}
