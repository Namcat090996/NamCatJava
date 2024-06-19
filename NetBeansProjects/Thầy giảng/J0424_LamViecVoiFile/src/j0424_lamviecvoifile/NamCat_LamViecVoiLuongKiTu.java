/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j0424_lamviecvoifile;
//Khai báo thư viện để làm việc với file
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dell Precision 7550
 */
public class NamCat_LamViecVoiLuongKiTu {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

	FileReader fileReader = null;
	
	try {
	    System.out.println("Đọc dữ liệu từ file: ");
	    fileReader = new FileReader("D:\\File dữ liệu Java\\NamCat_Demo4.txt");
	    BufferedReader buffer = new BufferedReader(fileReader);

	    String dong = "";

	    while ((dong = buffer.readLine()) != null) {
		System.out.println(dong);
	    }

	    //Đóng bộ đệm
	    buffer.close();
	    fileReader.close();

	} catch (FileNotFoundException ex) {
	    Logger.getLogger(NamCat_LamViecVoiLuongKiTu.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(NamCat_LamViecVoiLuongKiTu.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	FileWriter writer = null;
	
	try {
	    System.out.println("Ghi dữ liệu ra file: ");
	    
	    writer = new FileWriter("D:\\File dữ liệu Java\\NamCat_Demo5.txt");
	    
	    //Ghi thông tin ra file
	    for(int i = 0; i <= 10; i++)
	    {
		writer.write("Làm việc với File trong Java - " + i + "\n");
	    }
	    
	    //Đẩy file ra để ghi
	    writer.flush();
	    
	    //Đóng luồng ghi
	    writer.close();
	    
	    System.out.println("Ghi dữ liệu ra file thành công");

	} catch (IOException ex) {
	    Logger.getLogger(NamCat_LamViecVoiLuongKiTu.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	System.out.println("Đọc các thư mục và file con trong 01 thư mục cha: ");
	
	System.out.println("Danh sách các file, thư mục con là: ");
	
	File curDir = new File("D:\\File dữ liệu Java");
	
	String[] lstDir = curDir.list();
	
	//Duyệt từng thông tin
	for(int i = 0; i < lstDir.length; i++)
	{
	    File fileSub = new File("D:\\File dữ liệu Java" + lstDir[i]);
	    
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
