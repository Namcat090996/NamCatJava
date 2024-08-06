import java.util.Random;
import java.util.Scanner;

public class baiTapVeMang {
    //Declare an array

    float[] arr;

    //Declare the elements number of the array
    int n;

    public baiTapVeMang()
    {
        //Declare an object to enter data from the keyboard
        Scanner sc = new Scanner(System.in);

        //Enter the elements number of the array
        System.out.print("Nhập số lượng phần tử của mảng: ");
        n = sc.nextInt();
        arr = taoMangSoThuc(n);
        inMang();
    }

    /**
     * Function to create an array of float numbers
     * @param n
     * @return
     */
    public float[] taoMangSoThuc(int n)
    {
        //Declare an object to create the random number
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

    /**
     * Function to print the array
     */
    public void inMang()
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.printf("arr[%d] = %.2f\t", i, arr[i]);
        }
    }

    /**
     * Function to assign x for last element
     * @param x
     */
    public void ganX(float x)
    {
        //Increase the elements number of the array
        n = n+1;

        //Declare a temporary array
        float[] temp = new float[n];

        //Copy the values from old array to new array
        for(int i = 0; i < arr.length; i++)
        {
            temp[i] = arr[i];
        }

        //Assign x to last element of temp array
        temp[n-1] = x;

        //Assign values to array again
        this.arr = temp;
    }

    /**
     * Function to sum of the 1st & 2nd element in the array
     * @return
     */
    public float tong2PhanTuDauTien()
    {
        //Declare a variable
        float tong = 0;

        //Process the computational
        for(int i = 0; i < arr.length; i++)
        {
            if(i < 2)
            {
                tong += arr[i];
            }
        }

        return tong;
    }

    /**
     * Function to sum of the 1st & 2nd element in the array
     * @return
     */
    public float tong2PhanTuDauTienCach2()
    {
        //Declare a variable
        float tong = 0;

        //Process the computational
        for(int i = 0; i < 2 & i < arr.length; i++)
        {
            tong += arr[i];
        }

        return tong;
    }

    /**
     * Function to sum all the elements in the array
     * @return
     */
    public float tong()
    {
        //Declare a variable
        float tong = 0;

        //Process the computational
        for(int i = 0; i < arr.length; i++)
        {
            tong += arr[i];
        }

        return tong;
    }

    public float giaTriNhoNhat()
    {
        //Declare variable
        float min = 0;

        //Process the computational
        min = arr[0];

        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] < min)
            {
                min = arr[i];
            }
        }

        return min;
    }

    /**
     * Function to create a random element index in the array
     */
    public void taoNgauNhien()
    {
        //Declare an object
        Random rd = new Random();

        //Process the computational
        int index = rd.nextInt(arr.length); //A random index will have value from 0 to (arr.length - 1)

        //Print the result
        System.out.printf("- Giá trị phần tử ngẫu nhiên trong mảng arr[%d] = %.2f\t", index, arr[index]);
    }

    


}
