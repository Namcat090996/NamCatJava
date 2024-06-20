/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j0424_kethuavadahinh;

/**
 *
 * @author Dell Precision 7550
 */
public abstract class Animal1 {
    
    private int soMat;
    
    private int soChan;
    
    private String mauLong;
    
    public int getSoMat() {
	return soMat;
    }

    public void setSoMat(int soMat) {
	this.soMat = soMat;
    }

    public int getSoChan() {
	return soChan;
    }

    public void setSoChan(int soChan) {
	this.soChan = soChan;
    }

    public String getMauLong() {
	return mauLong;
    }

    public void setMauLong(String mauLong) {
	this.mauLong = mauLong;
    }  
    
    /**
     * Overload
     * @return 
     */
    public abstract String tiengKeu();

    
    /**
     * Overload
     * @param n 
     */
    public void tiengKeu(int n)
    {
	for(int i = 0; i <= n; i++)
	{
	    System.out.println("Tiếng kêu là: " + i);
	}
    }
    
    public void inThongTin()
    {
	System.out.println("Số mắt: " + soMat);
	System.out.println("Số chân: " + soChan);
	System.out.println("Màu lông " + getMauLong());
	System.out.println("Tiếng kêu: " + tiengKeu());
    }    
}
