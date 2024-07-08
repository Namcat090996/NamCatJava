/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.com.stanford.j0424.sudungthuvien;

import vn.com.stanford.j0424.tinhtoanlib.Common;

/**
 *
 * @author dangquang16
 */
public class TinhToan {

    int arr[];

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int[] chuyenTuChuoiVeMangSoNguyen(String strData)
    {
	String data[] = strData.split(",");
	
	int arr[] = new int[data.length];
	
	for(int i = 0; i < data.length; i++)
	{
	    arr[i] = Integer.parseInt(data[i]);
	}
	
	return arr;
    }    
    
    public TinhToan(String strData) {
        this.data = strData;
        arr = chuyenTuChuoiVeMangSoNguyen(strData);
    }

//Thực hiện sắp xếp theo thứ tự giảm dần về mặt giá trị của các phần tử trong mảng lấy được và hiển thị danh sách ra ngoài giao diện. (1đ)
    public String sapXepGiamDan() {
        String strDayGiam = "";

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            strDayGiam += arr[i] + "-";
        }

        strDayGiam = strDayGiam.substring(0, strDayGiam.length() - 1);

        return strDayGiam;
    }

// Thực hiện lấy top 3 thông tin có giá trị cao nhất trong mảng trên chuỗi đã cho. (2đ)
    /**
     * Hàm lấy top 3 giá trị cao nhất
     *
     * @return
     */
    public String top3GiaTriCaoNhat() {
        String strTop3 = "";
        for (int i = 0; i < 3; i++) {
            strTop3 += arr[i] + "-";
        }

        strTop3 = strTop3.substring(0, strTop3.length() - 1);
        return strTop3;
    }
//Hiển thị danh sách các số lẻ về mặt giá trị lên giao diện và tính tổng của chúng rồi hiển thị lên đối tượng Label (1đ)
    private int tongLe = 0;

    public int getTongLe() {
        return tongLe;
    }

    public String layCacSoLe() {
        String strCacSoLe = "";

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                strCacSoLe += arr[i] + "-";
                tongLe += arr[i];
            }
        }

        strCacSoLe = strCacSoLe.substring(0, strCacSoLe.length() - 1);

        return strCacSoLe;
    }

//Sử dụng kiến thức được học để thống kê số lượng số 5 xuất hiện trong dãy số đã cho ở trên (2đ)
    public int layThongKeSoLuongKiTuSo5() {
        int soLuong = 0;

        char arrKiTu[] = data.toCharArray();

        for (int i = 0; i < arrKiTu.length; i++) {
            if (arrKiTu[i] == '5') {
                soLuong++;
            }
        }

        return soLuong;
    }

}
