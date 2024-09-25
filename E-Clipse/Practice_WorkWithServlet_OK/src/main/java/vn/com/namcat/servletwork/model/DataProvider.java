package vn.com.namcat.servletwork.model;

public class DataProvider {

	private static SachBusiness sachBus = null;
	
	public static SachBusiness getSachBus() {
		
		if(sachBus == null)
		{
			sachBus = new SachBusiness();
		}
		
		return sachBus;
	}
	
}
