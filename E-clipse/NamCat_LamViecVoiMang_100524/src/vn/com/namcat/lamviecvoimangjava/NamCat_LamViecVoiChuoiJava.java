package vn.com.namcat.lamviecvoimangjava;

public class NamCat_LamViecVoiChuoiJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strChuoiA = "Stanforf";
		String strChuoiB = "Stanrford";
		
		//So sánh chuỗi

		int soSanh = strChuoiA.compareTo(strChuoiB);
		
		System.out.println("Kết quả so sánh chuỗi = " + soSanh);
		
		//Nối chuỗi
		strChuoiA = strChuoiB.concat(" - Dạy học");
		
		System.out.println(strChuoiA);
		
		System.out.println("Chữ thường = " + strChuoiA.toLowerCase());
		
		System.out.println("Chữ hoa = " + strChuoiA.toUpperCase());
		
		System.out.println("Stanford " + "         dạy lập trình" + ",   công nghệ".trim());
		
		//Lấy chuỗi con
		String tenVietTat = strChuoiA.substring(0,8);
		
		System.out.println("Tên viết tắt: " + tenVietTat);
		
		int idx1 = strChuoiA.indexOf('r');
		
		System.out.println("Vị trí đầu tiên của kí tự r là = " + idx1);
		
		int ldx = strChuoiA.lastIndexOf('r');
		
		System.out.println("Vị trí cuối cùng của kí tự r là = " + ldx);
		
		String strData = "10;50;60;80";
		
		String arr[] = strData.split(";");
		
		System.out.println("Các số lấy được từ chia chuỗi = ");
		
		for(String gt: arr)
		{
			System.out.println(gt);
		}
		
		char arr2[] = tenVietTat.toCharArray();
		
		System.out.println("Các kí tự là: ");
		
		for(char ch: arr2)
		{
			System.out.println(ch);
		}
		
	}

}
