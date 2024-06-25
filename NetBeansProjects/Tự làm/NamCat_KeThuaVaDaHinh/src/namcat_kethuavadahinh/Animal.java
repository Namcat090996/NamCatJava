/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_kethuavadahinh;

/**
 *
 * @author Dell Precision 7550
 */
public abstract class Animal {

    private int soMat = 0;
    
    private int soChan = 0;
    
    private String mauLong = "";

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
    
    public abstract String tiengKeu();

    
    public void inThongTin()
    {
	System.out.println("Số mắt: " + soMat);
	System.out.println("Số chân: " + getSoChan());
	System.out.println("Màu lông: " + mauLong);
	System.out.println("Tiếng kêu: " + tiengKeu());
    }
    
}
