package vn.com.stanford.je0824.workingwithservlet.model;

public class DataProvider {

	/**
	 * Khai báo 1 đối tượng ở dạng static để có thể sử dụng ở nhiều nơi
	 */
	private static SachBusiness sachBus = null;
	public static SachBusiness getSachBus()
	{
		if(sachBus == null)
		{
			sachBus = new SachBusiness();
		}
		
		return sachBus;
	}
}
