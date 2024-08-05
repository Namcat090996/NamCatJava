import java.util.Random;
import java.util.Scanner;

public class baiTapVeMang {

    public baiTapVeMang()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử của mảng: ");
        
    }


    /**
     * Function to create an array of float numbers
     * @param n
     * @return
     */
    public float[] taoMangSoThuc(int n)
    {
        //Declare an object
        Random rd = new Random();

        //Declare an array of float numbers
        float[] arr = new float[n];

        //Assign values for the array
        for(int i = 0; i < n; i++)
        {
            arr[i] = rd.nextFloat();
        }

        return arr;
    }

    public void inMang(float[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.printf("arr[%d] = %.2f\n", i, arr[i]);
        }
    }


}
