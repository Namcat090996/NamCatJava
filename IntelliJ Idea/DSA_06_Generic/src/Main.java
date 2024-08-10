//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{11, 12, 13};
        Float[] arr2 = new Float[]{1.5f, 4.5f};
        Double[] arr1 = new Double[]{11.0, 12.0, 13.0};
        String[] arr3 = new String[]{"1.5", "2.5", "3.5"};
        double TBC = TinhTrungBinhCong.TBC1(arr);
        double TBC1 = TinhTrungBinhCong.TBC1(arr1);
        double TBC2 = TinhTrungBinhCong.TBC1(arr2);
        double TBC3 = TinhTrungBinhCong.TBC(arr3);
        System.out.println(TBC);
        System.out.println(TBC1);
        System.out.println(TBC2);
        System.out.println(TBC3);
    }
}