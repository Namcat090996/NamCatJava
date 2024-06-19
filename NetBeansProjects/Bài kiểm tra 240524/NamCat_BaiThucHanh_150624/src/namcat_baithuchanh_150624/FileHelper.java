/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baithuchanh_150624;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class FileHelper {
    
    public static String docNoiDungFile(String duongDan)
    {
	StringBuilder builder = new StringBuilder();
	
	FileReader fileReader = null;
	
	try {
	    fileReader = new FileReader(duongDan);
	    BufferedReader buffer = new BufferedReader(fileReader);
	    
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(FileHelper.class.getName()).log(Level.SEVERE, null, ex);
	} 
	
	
    }
}
