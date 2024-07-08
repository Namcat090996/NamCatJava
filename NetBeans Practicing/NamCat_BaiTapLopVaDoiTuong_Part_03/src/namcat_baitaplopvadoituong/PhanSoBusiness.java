/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package namcat_baitaplopvadoituong;

/**
 *
 * @author Dell Precision 7550
 */
public class PhanSoBusiness {
    
    public PhanSo tongPhanSo(PhanSo a, PhanSo b)
    {
	PhanSo c = new PhanSo();
	
	if(a.getMauSo() == b.getMauSo())
	{
	    c.setTuSo(a.getTuSo() + b.getTuSo());
	    c.setMauSo(a.getMauSo());
	}
	else
	{
	    c.setTuSo(a.getTuSo() * b.getMauSo() + b.getTuSo() * a.getMauSo());
	    c.setMauSo(a.getMauSo() * b.getMauSo());
	}
	
	return c;
	
    }
    
    public PhanSo hieuPhanSo(PhanSo a, PhanSo b)
    {
	PhanSo c = new PhanSo();
	
	if(a.getMauSo() == b.getMauSo())
	{
	    c.setTuSo(a.getTuSo() - b.getTuSo());
	    c.setMauSo(a.getMauSo());
	}
	else
	{
	    c.setTuSo(a.getTuSo() * b.getMauSo() - b.getTuSo() * a.getMauSo());
	    c.setMauSo(a.getMauSo() * b.getMauSo());
	}
	
	return c;
	
    }    
    public PhanSo tichPhanSo(PhanSo a, PhanSo b)
    {
	PhanSo c = new PhanSo();

	c.setTuSo(a.getTuSo() * b.getTuSo());
	c.setMauSo(b.getMauSo() * b.getMauSo());
	
	return c;
	
    }   
    
    public PhanSo thuongPhanSo(PhanSo a, PhanSo b)
    {
	PhanSo c = new PhanSo();

	c.setTuSo(a.getTuSo() * b.getMauSo());
	c.setMauSo(a.getMauSo() * b.getTuSo());
	
	return c;	
    }
    
    public int timUocChungLonNhat(int a, int b)
    {
	int min = a < b ? a : b;
	
	int uocChungLonNhat = 0;
	
	for(int i = 1; i <= min; i++)
	{
	    if(a%i == 0 && b%i == 0)
	    {
		uocChungLonNhat = i;
	    }
	}
	
	return uocChungLonNhat;
    }
    
    public PhanSo rutGon(PhanSo a)
    {
	PhanSo c = new PhanSo();
	
	int uocChungLN = timUocChungLonNhat(a.getTuSo(), a.getMauSo());
	
	c.setTuSo(a.getTuSo()/uocChungLN);
	c.setMauSo(a.getMauSo()/uocChungLN);
	
	return c;
    }
    
}
