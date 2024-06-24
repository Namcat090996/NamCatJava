/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_lamviecvoifile;
import java.io.*;

/**
 *
 * @author ADMIN
 */
public class NamCat_LamViecVoiLuongKiTu {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {   
	
	/*
	
	//Declare stream that allows reading file data
	FileReader fileReader = null;
	
	try {
	    System.out.println("Đọc dữ liệu từ file: ");
	    
	    fileReader = new FileReader("E:\\OneDrive - EVNPECC3\\Documents\\test3.txt");
	    
	    //Declare object that allows reading file data with cache
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    
	    //Declare variables
	    String dong = "";
	    
	    //Call the function to read file data line by line
	    while((dong = bufferedReader.readLine()) != null)
	    {
		System.out.println(dong);
	    }
	    
	    //Close stream and buffer memory
	    fileReader.close();
	    bufferedReader.close();
	    	    
	} catch (FileNotFoundException ex) {
	    System.out.println("Không tìm thấy file. Chi tiết lỗi: " + ex.getMessage());
	} catch (IOException ex) {
	    System.out.println("Lỗi trong quá trình đọc file. Chi tiết lỗi " + ex.getMessage());
	}
	
	System.out.println("Ghi dữ liệu ra file: ");
	
	//Declare stream that allows writing file data
	FileWriter fileWriter = null;
	
	try {
	    fileWriter = new FileWriter("E:\\OneDrive - EVNPECC3\\Documents\\test4.txt", true);
	    
	for(int i = 0; i < 10; i++)
	{
	    fileWriter.write("Làm việc với File trong java - " + i + "\n");
	}
	
	//Push the data from the buffer must be written currently to the stream
	fileWriter.flush();	
	
	//Close the stream
	fileWriter.close();
	
	System.out.println("Ghi dữ liệu ra file thành công !");
	
	} catch (IOException ex) {
	    System.err.println("Lỗi trong quá trình ghi file. Chi tiết lỗi: " + ex.getMessage());;
	}
	
	*/
		
	System.out.println("Đọc các thư mục và file con trong 01 thư mục cha: ");
	
	System.out.println("Danh sách các file, thư mục con là: ");
	
	File curDir = new File("D:\\File dữ liệu Java\\");
	
	String[] lstDir = curDir.list();
	
	//Duyệt từng thông tin
	for(int i = 0; i < lstDir.length; i++)
	{
	    File fileSub = new File("D:\\File dữ liệu Java\\" + lstDir[i]);
	    
	    if(fileSub.isDirectory())
	    {
		System.out.println("[DIR]" + lstDir[i]);
	    }
	    else
	    {
		System.out.println(lstDir[i]);
	    }
	}
	
	
	
    } 
}
