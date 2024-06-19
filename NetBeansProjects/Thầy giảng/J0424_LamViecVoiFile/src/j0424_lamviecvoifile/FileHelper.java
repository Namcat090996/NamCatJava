/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j0424_lamviecvoifile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell Precision 7550
 */
public class FileHelper {
    
    /**
     * Hàm lấy nội dung từ 1 file đọc được
     * @param duongDan, Đường dẫn đến file
     * @return Nội dung đọc được từ file
     */
    public static String docNoiDungFile(String duongDan)
    {
        StringBuilder builder = new StringBuilder("");
        
        FileReader fileReader = null;
            try {
                System.out.println("Đọc dữ liệu từ file: ");
                fileReader = new FileReader(duongDan);
                BufferedReader buffer = new BufferedReader(fileReader);
                
                String dong = "";
                
                while((dong = buffer.readLine()) != null)
                {
                    builder.append(dong + " ");
                }
                
                //Đóng bộ đệm
                buffer.close();
                fileReader.close();
                
            } catch (FileNotFoundException ex) {
                System.err.println("Không tìm thấy file. Chi tiết: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Lỗi quá trình đọc file. Chi tiết: " + ex.getMessage());
            }
            
        return builder.toString();
    }
    
    /**
     * Hàm ghi thông tin ra file để lưu trữ
     * @param noiDung, Nội dung cần ghi ra file
     * @param duongDan, Đường dẫn file ghi dữ liệu
     */
    public static void ghiDuLieuRaFile(String noiDung, String duongDan) 
    {
        FileWriter writer = null;

        try {
            System.out.println("Ghi dữ liệu ra file: ");
            writer = new FileWriter(duongDan, true);

            //Ghi thông tin ra file
            writer.write(noiDung);

            //Đẩy ra file để ghi
            writer.flush();

            //Đóng luồng ghi
            writer.close();

            System.out.println("Ghi dữ liệu ra file thành công");
        } catch (IOException ex) {
            System.err.println("Lỗi khi ghi thông tin ra file. Chi tiết: " + ex.getMessage());
        }
    }
}
