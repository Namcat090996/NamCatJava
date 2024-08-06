import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Declare an object to enter data from the keyboard
        Scanner sc = new Scanner(System.in);

        //Bài tập 1:
        baiTapVeMang bt = new baiTapVeMang();
        System.out.println();

        //Bài tập 2:
        bt.ganX(1.5f);
        bt.inMang();
        System.out.println();

        //Bài tập 3:
        float tong2PhanTuDauTien = bt.tong2PhanTuDauTien();
        System.out.printf("- Tổng của 2 phần tử đầu tiên là: %.2f\n", tong2PhanTuDauTien);

        //Bài tập 4:
        float tong = bt.tong();
        System.out.printf("- Tổng của tất cả các phần tử trong mảng là: %.2f\n", tong);

        //Bài tập 5:
        float min = bt.giaTriNhoNhat();
        System.out.printf("- Giá trị phần tử nhỏ nhất trong mảng là: %.2f\n", min);

        //Bài tập 6:
        bt.taoNgauNhien();
        System.out.println();

        //Bài tập 7: Array Initializer
        float[] arr = new float[]{3.5f, 5.5f, 4.52f, 5.6f};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %.2f\t", i, arr[i]);
        }
    }
}