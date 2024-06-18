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
    
    public PhanSo tongHaiSo(PhanSo a, PhanSo b)
    {
	PhanSo c = new PhanSo();
	
	if(a.getMauSo() == b.getMauSo())
	{
	    c.setTuSo(a.getTuSo() + b.getTuSo());
	    c.setMauSo(a.getMauSo());
	}
	else
	{
	    c.setTuSo(a.getTuSo() * b.getMauSo() + a.getMauSo() * b.getTuSo());
	    c.setMauSo(a.getMauSo() * b.getMauSo());
	}
	
	return c;
	
    }
    
    public PhanSo hieuHaiSo(PhanSo a, PhanSo b)
    {
	PhanSo c = new PhanSo();
	
	if(a.getMauSo() == b.getMauSo())
	{
	    c.setTuSo(a.getTuSo() - b.getTuSo());
	    c.setMauSo(a.getMauSo());
	}
	else
	{
	    c.setTuSo(a.getTuSo() * b.getMauSo() - a.getMauSo() * b.getTuSo());
	    c.setMauSo(a.getMauSo() * b.getMauSo());
	}
	
	return c;
	
    }
    
    public PhanSo tichHaiSo (PhanSo a, PhanSo b)
    {
	PhanSo c = new PhanSo();
	
	c.setTuSo(a.getTuSo() * b.getTuSo());
	c.setMauSo(a.getMauSo() * b.getMauSo());
	
	return c;
    }
    
    public PhanSo thuongHaiSo(PhanSo a, PhanSo b)
    {
	PhanSo c = new PhanSo();
	
	c.setTuSo(a.getTuSo() * b.getMauSo());
	c.setMauSo(a.getMauSo() * b.getTuSo());
	
	return c;
    }
    
    private int timUocChungLonNhat(int a, int b)
    {
	int min = a > b ? a : b;
	
	int uocChungLN = 0;
	
	for(int i = 1; i <= min; i++)
	{
	    if(a%i == 0 && b%i == 0)
	    {
		uocChungLN = i;
	    }
	}
	
	return uocChungLN;
    }
    
    public PhanSo rutGon(PhanSo a)
    {
	PhanSo c = new PhanSo();
	
	int uocChung = timUocChungLonNhat(a.getTuSo(), a.getMauSo());
	
	c.setTuSo(a.getTuSo()/uocChung);
	c.setMauSo(a.getMauSo()/uocChung);
	
	return c;
    }
}
