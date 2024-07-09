/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.com.stanford.j0424.baitaplop;

/**
 *
 * @author dangquang16
 */
public class SoPhucBusiness {
    
//* Tính cộng, trừ, nhân, chia 2 số phức:
//(a + bi) + (c + di) = (a+c) + (b+d)i
public SoPhuc tongHaiSo(SoPhuc a, SoPhuc b)
{
    SoPhuc c = new SoPhuc(0, 0);
    
    c.setPhanThuc(a.getPhanThuc() + b.getPhanThuc());
    c.setPhanAo(a.getPhanAo() + b.getPhanAo());
    
    return c;
}
//(a + bi) - (c + di) = (a-c) + (b-d)i
public SoPhuc hieuHaiSo(SoPhuc a, SoPhuc b)
{
    SoPhuc c = new SoPhuc(0, 0);
    
    c.setPhanThuc(a.getPhanThuc() - b.getPhanThuc());
    c.setPhanAo(a.getPhanAo() - b.getPhanAo());
    
    return c;
}
//(a + bi) * (c + di) = (ac - bd) + (ad + bc)i
public SoPhuc tichHaiSo(SoPhuc a, SoPhuc b)
{
    SoPhuc c = new SoPhuc(0, 0);
    
    c.setPhanThuc(a.getPhanThuc() * b.getPhanThuc() - a.getPhanAo()*b.getPhanAo());
    c.setPhanAo(a.getPhanThuc()*b.getPhanAo() + a.getPhanAo()*b.getPhanThuc());
    
    return c;
}
//(a + bi) / (c + di) = (ac + bd)/(a2 + b2) + (ad - bc)/(a2 + b2) * i
public SoPhuc thuongHaiSo(SoPhuc a, SoPhuc b)
{
    SoPhuc c = new SoPhuc(0, 0);
    
    double mauSo = 0;
    
    mauSo = a.getPhanThuc()*a.getPhanThuc() + a.getPhanAo()*a.getPhanAo();
    
    c.setPhanThuc((a.getPhanThuc()*b.getPhanThuc() + a.getPhanAo()*b.getPhanAo())/mauSo);
    
    c.setPhanAo((a.getPhanThuc()*b.getPhanAo() - a.getPhanAo()*b.getPhanThuc())/mauSo);
    return c;
}
    /*Bình phương:
(x + yi)2 = a + bi

=> x2 - y2 + 2xyi = a + bi

=> x2 - y2 = a, 2xy=b(*).*/

    public SoPhuc binhPhuong(SoPhuc a)
    {
        SoPhuc c = new SoPhuc(0, 0);
        
        c.setPhanThuc(a.getPhanThuc()*a.getPhanThuc() - a.getPhanAo()*a.getPhanAo());
        c.setPhanAo(2*a.getPhanThuc()*a.getPhanAo());
        
        return c;
    }
}
