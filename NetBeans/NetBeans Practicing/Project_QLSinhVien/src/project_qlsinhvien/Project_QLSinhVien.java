/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project_qlsinhvien;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.sound.sampled.AudioFormat.Encoding;

/**
 *
 * @author Dell Precision 7550
 */
public class Project_QLSinhVien {

    public static String convertByteToHex1(byte[] data) {
        BigInteger number = new BigInteger(1, data);
        String hashtext = number.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

     public static String GenerateMD5(String data){
        try {
            // gọi phương thức tạo đối tượng mã hóa MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            byte[] alo = data.getBytes();
            //chuyển chuỗi mã hóa về dạng byte
            byte[] messageDigest = md.digest(data.getBytes());
            //chuyển mảng byte thành ký số
            BigInteger no = new BigInteger(-1, messageDigest);
            // convert thành chuỗi hexa 16
            String hashtext = no.toString(16);
            int doDai = hashtext.length();
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            } 
            return hashtext;
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Sai tên giải thuật");
        }
        return null;
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println(GenerateMD5("12AB"));

    }

}
