/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baitapcautruc_jv01;

import java.util.Scanner;

/**
 *
 * @author Dell Precision 7550
 */
public class NamCat_BaiTapCauTruc_Part5 {

 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
    
    //Declare an object to enter information from the keyboard
    Scanner sc = new Scanner(System.in);
    
    /*
    
    //Bài tập 1: Sử dụng for, while, do while để cho ra kết quả a, b, c, d như ảnh:
    //1a
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            System.out.print("#");
        }
        System.out.println("");
    }
    
    //1b
    String chuoi = "";
    chuoi = "#########";
    for (int i = 9; i > 0; i--)
    {
        for (int j = chuoi.length(); j >= i; j--)
        {
        chuoi = chuoi.substring(0, j-1);
        System.out.print(chuoi);
        }
        System.out.println("");
    }

    */
    
    //1c
    String khoangTrang = "", kq = "", chuoi = "#########";
    for (int i = 9; i > 1; i--)
    {
        for (int j = chuoi.length(); j >= i; j--)
        {
            chuoi = chuoi.substring(0, j-1);   
            khoangTrang = khoangTrang + " ";
            kq = khoangTrang + chuoi;
            System.out.print(kq);
        }
        System.out.println("");
    }   
    



    

    
 
  }  
}
