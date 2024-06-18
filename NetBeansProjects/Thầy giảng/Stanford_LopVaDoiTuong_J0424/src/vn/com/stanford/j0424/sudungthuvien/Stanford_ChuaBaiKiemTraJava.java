/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.com.stanford.j0424.sudungthuvien;

/**
 *
 * @author dangquang16
 */
public class Stanford_ChuaBaiKiemTraJava {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String strChuoiSo = "55,60,15,70,25,40,100,80,90,35";

        TinhToan tt = new TinhToan(strChuoiSo);

        String dayGiamDan = "", top3 = "", daySoLe = "";

        //Gọi hàm tính toán
        dayGiamDan = tt.sapXepGiamDan();

        top3 = tt.top3GiaTriCaoNhat();

        daySoLe = tt.layCacSoLe();

        System.out.println("Sắp xếp giảm dần: ");
        System.out.println(dayGiamDan);
        System.out.println("Top 3 giá trị cao nhất: ");
        System.out.println(top3);
        System.out.println("Các số lẻ: ");
        System.out.println(daySoLe);
        System.out.println("Tổng lẻ: " + tt.getTongLe());

        int soLuong5 = tt.layThongKeSoLuongKiTuSo5();

        System.out.println("Số lượng kí tự số 5 là: " + soLuong5);
    }
}
