package vn.com.namcat.servletworking.model;

public class DataSupplier {

	public static SachBus sachBusiness;
	
	public static SachBus getSachBus()
	{
		if(sachBusiness == null)
		{
			sachBusiness = new SachBus();
		}
		
		return sachBusiness;
	}
	
}
