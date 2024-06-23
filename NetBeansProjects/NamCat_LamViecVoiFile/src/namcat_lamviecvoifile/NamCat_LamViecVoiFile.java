/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package namcat_lamviecvoifile;

//Declare library for working with file
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class NamCat_LamViecVoiFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	
	System.out.println("Đọc dữ liệu từ file: ");
	
	try {
	    //Create stream that allows reading file data
	    FileInputStream fileInputStream = new FileInputStream("E:\\OneDrive - EVNPECC3\\Documents\\test.txt");
	    
	    //Declare varibles
	    int ch = 0;
	    
	    //Call the function to read data from stream
	    while((ch = fileInputStream.read()) != -1)
	    {
		System.out.print((char)ch);
	    }
	    
	    //Close the file reading stream
	    fileInputStream.close();
	    
	} catch (FileNotFoundException ex) {
	    System.err.println("Không tìm thấy file. Chi tiết lỗi: " + ex.getMessage());
	} catch (IOException ex) {
	    System.out.println("Lỗi khi đọc file. Chi tiết lỗi: " + ex.getMessage());;
	}
	
	System.out.println("Đọc dữ liệu từ file: ");
	
	//Declare array containing the characters
	byte b[] = new byte[100];
	
	System.out.println("Nhập thông tin cần ghi: ");
	
	try {
	    //Declare the variable to enter data to array, and read array data
	    int iNum = System.in.read(b);
	    
	    //Declare stream that allows writing file data
	    FileOutputStream fileOutputStream = new FileOutputStream("E:\\OneDrive - EVNPECC3\\Documents\\test1.txt");
	    
	    //Write data to file
	    fileOutputStream.write(b, 0, iNum);
	    
	    //Close the file writing stream
	    fileOutputStream.close();
	    
	    System.out.println("Ghi dữ liệu ra file thành công !");
	    
	} catch (IOException ex) {
	    System.err.println("Lỗi trong quá trình ghi file. Chi tiết lỗi: " + ex.getMessage());;
	}
	
	
	
	
	
    }
}
