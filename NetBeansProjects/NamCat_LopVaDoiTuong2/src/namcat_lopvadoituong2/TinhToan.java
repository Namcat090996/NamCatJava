/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_lopvadoituong2;

/**
 *
 * @author Dell Precision 7550
 */
public class TinhToan {

private int a = 0;

public int b = 0;

int c = 0;

public void inThongTin()
{
    System.out.println("Trời đẹp");
    System.out.println("" + a);
}

public void inThongTin(int n)
{
    for(int i =0; i < n; i++)
    {
	System.out.println("I love you - " + i );
    }
}

public String layTenCongTy()
{
    return "Stanford";
}

public double tongSo(double a, double b)
{
    double tongSo = 0;
    tongSo = a + b;
    return tongSo;
}
    
    
    
    
}
