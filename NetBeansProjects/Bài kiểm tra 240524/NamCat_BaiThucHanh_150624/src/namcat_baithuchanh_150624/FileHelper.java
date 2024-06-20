/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baithuchanh_150624;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class FileHelper {
    
    /**
     * Hàm lấy nội dung từ 1 file đọc được
     * @param duongDan
     * @return 
     */
    public static String docNoiDungFile(String duongDan)
    {
	StringBuilder builder = new StringBuilder();
	
	FileReader fileReader = null;
	
	try {
	    fileReader = new FileReader(duongDan);
	    BufferedReader buffer = new BufferedReader(fileReader);
	    
	    String dong = "";
	    
	    while((dong = buffer.readLine()) != null)
	    {
		builder.append(dong + ";");
	    }
	    
	    //Đóng bộ đệm
	    buffer.close();
	    fileReader.close();
	    
	} catch (FileNotFoundException ex) {
	    System.out.println("Không tìm thấy file. Chi tiết lỗi: " + ex.getMessage());
	} catch (IOException ex) {
	    System.out.println("Lỗi quá trình đọc file. Chi tiết lỗi: " + ex.getMessage());
	} 
	
	return builder.toString();
    }
}
