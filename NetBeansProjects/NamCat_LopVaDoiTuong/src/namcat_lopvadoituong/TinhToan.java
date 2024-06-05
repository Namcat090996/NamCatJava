/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_lopvadoituong;

/**
 *
 * @author Dell Precision 7550
 */
public class TinhToan {
    
    private int a = 10;
    
    public int  b = 15;
    
    int c = 5;
    
    /**
     * Dạng 1: Hàm không có giá trị trả về và không có tham số truyền vào
     */
    public void inThongTin()
    {
	System.out.println("Hôm nay trời đẹp quá");
    }
    
    /**
     * Dạng 2: Hàm không có giá trị trả về và có tham số truyền vào
     * @param n 
     */
    public void inThongTin(int n)
    {
	for(int i = 0; i < n; i++)
	{
	    System.out.println("I Love U" + i);
	}
    }
    
    /**
     * Dạng 3: Hàm có giá trị trả về và không có tham số truyền vào
     * @return 
     */
    public String layTenCongTy()
    {
	return "Stanford";
    }
    
    /**
     * Dạng 4: Hàm có giá trị trả về và có tham số truyền vào
     * @param a
     * @param b
     * @return 
     */
    public int tongSo(int a, int b)
    {
	int tongSo = 0;
	
	tongSo = a + b;
	
	return tongSo;
    }
    
    
    
}
