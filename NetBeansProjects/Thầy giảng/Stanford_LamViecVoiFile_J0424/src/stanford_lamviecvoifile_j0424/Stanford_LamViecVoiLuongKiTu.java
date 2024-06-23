/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanford_lamviecvoifile_j0424;

//Khai báo thư viện để làm việc với file
import java.io.*;
/**
 *
 * @author dangquang16
 */
public class Stanford_LamViecVoiLuongKiTu {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      /*
            FileReader fileReader = null;
            try {
                System.out.println("Đọc dữ liệu từ file: ");
                fileReader = new FileReader("/Volumes/DATA/Stanford/Courses/Java/Data/j042403_demo.txt");
                BufferedReader buffer = new BufferedReader(fileReader);
                
                String dong = "";
                
                while((dong = buffer.readLine()) != null)
                {
                    System.out.println(dong);
                }
                
                //Đóng bộ đệm
                buffer.close();
                fileReader.close();
                
            } catch (FileNotFoundException ex) {
                System.err.println("Không tìm thấy file. Chi tiết: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Lỗi quá trình đọc file. Chi tiết: " + ex.getMessage());
            }
         
                    
          FileWriter writer = null;
          
        try {
            System.out.println("Ghi dữ liệu ra file: ");
            writer = new FileWriter("/Volumes/DATA/Stanford/Courses/Java/Data/j042404_demo.txt", true);
         
            //Ghi thông tin ra file
            for(int i = 1; i <= 100; i++)
            {
                writer.write("Làm việc với File trong Java - " + i + "\n");
            }
            
            //Đẩy ra file để ghi
            writer.flush();
            
            //Đóng luồng ghi
            writer.close();
            
            System.out.println("Ghi dữ liệu ra file thành công");
            

        } catch (IOException ex) {
            Logger.getLogger(Stanford_LamViecVoiLuongKiTu.class.getName()).log(Level.SEVERE, null, ex);
        }
*/      
        System.out.println("Đọc các thư mục và file con trong 1 thư mục cha: ");
        
        System.out.println("Danh sách các file, thư mục con là: ");
        File curDir = new File("E:\\Làm việc");
        
        String[] lstDir = curDir.list();
        
        //Duyệt từng thông tin
        for(int i = 0; i < lstDir.length; i++)
        {
            File fileSub = new File("E:\\Làm việc" + lstDir[i]);
            
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
