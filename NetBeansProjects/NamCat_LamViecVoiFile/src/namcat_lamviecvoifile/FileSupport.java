/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_lamviecvoifile;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell Precision 7550
 */
public class FileSupport {
    
    /**
     * Function to read file data
     * @param duongDan
     * @return 
     */
    public static String docNoiDungFile(String duongDan)
    {
	//Declare a stringbuilder to contain data from file
	StringBuilder builder = new StringBuilder();	
	
	//Declare a stream that allows reading file data
	FileReader fileReader = null;
	try {

	    fileReader = new FileReader(duongDan);
	    
	    //Reading file data with buffer memory
	    BufferedReader reader = new BufferedReader(fileReader);
	    
	    //Declare variables
	    String dong = "";
	    
	    //Call the function tp read file data line by line
	    while((dong = reader.readLine()) != null)
	    {
		builder.append(dong + "\n");
	    }
	    
	    //Close the stream
	    fileReader.close();
	    reader.close();
	    
	} catch (FileNotFoundException ex) {
	    System.err.println("Không tìm thấy file. Chi tiết lỗi: " + ex.getMessage());;
	} catch (IOException ex) { 
	    System.err.println("Lỗi khi đọc file. Chi tiết lỗi: " + ex.getMessage());
	}
	
	return builder.toString();
    }
    
    public static void ghiDuLieuRaFile(String noiDung, String duongDan)
    {
	
	//Declare a stream that allows writing file data
	FileWriter fileWriter = null;
	
	try {
	    fileWriter = new FileWriter(duongDan);
	    
	    BufferedWriter writer = new BufferedWriter(fileWriter);
	    
	    writer.write(noiDung);
	    
	    //Push the data from the buffer memory to the stream immediately
	    writer.flush();
	    
	    //Close the stream
	    fileWriter.close();
	    writer.close();
	    
	} catch (IOException ex) {
	    System.err.println("Lỗi trong quá trình ghi file. Chi tiết lỗi: " + ex.getMessage());;
	}
    }
    
}
