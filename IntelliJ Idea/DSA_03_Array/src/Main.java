import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Scanner sc = new Scanner(System.in);

        //Bài tập 1:

        //Enter the element quatity of the array
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();

        //Declare an object
        baiTapVeMang bt = new baiTapVeMang();
        float[] mangSoThuc = bt.taoMangSoThuc(n);

        //Print the array
        bt.inMang(mangSoThuc);

    }
}