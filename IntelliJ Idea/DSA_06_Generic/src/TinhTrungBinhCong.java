public class TinhTrungBinhCong {
    public static <T> double TBC (T[] arr)
    {
        double TBC = 0;
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i] + "";
            TBC += Double.parseDouble(arr[i] + "");
        }
        return TBC/arr.length;
    }

    public static <T extends Number> double TBC1 (T[] arr)
    {
        double TBC = 0;
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i] + "";
            TBC += Double.parseDouble(arr[i] + "");
        }
        return TBC/arr.length;
    }
}
