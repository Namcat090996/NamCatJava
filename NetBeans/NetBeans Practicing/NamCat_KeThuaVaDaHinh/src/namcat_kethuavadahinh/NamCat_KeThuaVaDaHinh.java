/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package namcat_kethuavadahinh;

/**
 *
 * @author Dell Precision 7550
 */
public class NamCat_KeThuaVaDaHinh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	
	Cat tom = new Cat();
	
	tom.setSoMat(2);
	tom.setMauLong("Màu đen");
	tom.setSoChan(4);
	
	tom.inThongTin();
	
	Dog minu = new Dog();
	
	minu.setSoMat(2);
	minu.setMauLong("Màu trắng");
	minu.setSoChan(4);
	
	minu.inThongTin();
	
	DataProvider.thucHien(new VietNamese());
	
	DataProvider.thucHien(new English());

    }
    
}
