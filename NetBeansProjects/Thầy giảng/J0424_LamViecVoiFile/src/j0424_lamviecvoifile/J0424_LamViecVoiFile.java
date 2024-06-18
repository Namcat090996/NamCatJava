/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j0424_lamviecvoifile;
//Khai báo thư viện để làm việc
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dell Precision 7550
 */
public class J0424_LamViecVoiFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	
            FileInputStream fileInputStream = null;
            try {
                //Đọc dữ liệu từ file
                System.out.println("Đọc dữ liệu từ file: ");
                fileInputStream =
                        new FileInputStream("D:\\File dữ liệu Java\\NamCat_Demo.txt");
		
                int ch = 0;
                
                while((ch=fileInputStream.read()) != -1)
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
	
	
	
	
	
	
	
	
	
	
    }
    
}
