import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] matrix;
        Matrix mt = new Matrix(2,3);
        mt.printMatrix();
        mt.multiplyMatrix();

        List<String> myList = new ArrayList<String>();
        myList.add("Okbabe");
        String str = myList.get(0);
        System.out.println(str);


    }
}