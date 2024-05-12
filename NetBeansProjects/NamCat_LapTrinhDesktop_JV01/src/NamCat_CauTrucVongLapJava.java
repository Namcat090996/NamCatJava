/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class NamCat_CauTrucVongLapJava {
    
        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //Declare variables
        int i = 1;
        System.out.println("Sử dụng vòng lặp While: ");
        
        while(i <= 10){
            i++;
            System.out.println("Tôi yêu bạn - " + i);
        }
        
        System.out.println("Sử dụng vòng lặp do while: ");
        
        do
        {
            System.out.println("Giá trị của i = " + i);
            i++;
        }
        while(i < 20);
        
        System.out.println("Cấu trúc vòng lặp for: ");
        
        /*
        
        for(int j = 80; j <= 90; j+=2)
        {
            System.out.println(j);
        }
        
        */
        
    }
}
