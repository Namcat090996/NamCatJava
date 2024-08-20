import java.util.Arrays;

public class _1_TwoSum {
    public static int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        int[] result = twoSum(arr,9);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("- result[%d] = %d\n", i, result[i]);
        }
        System.out.println(Arrays.toString(twoSum(arr,7)));
    }
}


