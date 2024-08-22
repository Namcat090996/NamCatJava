import java.util.Arrays;

public class _88_Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int x : nums2) {
            chenPhanTuVaoMang(x, nums1, m);      
            m++;    
        }
    }
    private static void chenPhanTuVaoMang(int x, int[] nums1, int m) {
        boolean isKT = false;
        for (int i = 0; i < m; i++) {
            if(nums1[i] > x)
            {
                isKT = true;
                for(int k = m; k > i; k--)
                {
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = x;
                break;
            }
        }
        if(isKT == false)
        {
            nums1[m] = x;
        }
    }

    public static void merge2(int[] n1, int m, int[] n2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = (m + n) - 1;

        while (k >= 0) {
            if (i < 0) {
                n1[k] = n2[j];
                j--;
            } else if (j < 0) {
                n1[k] = n1[i];
                i--;
            } else if (n1[i] > n2[j]) {
                n1[k] = n1[i];
                i--;
            } else if (n1[i] <= n2[j]) {
                n1[k] = n2[j];
                j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        int[] n1 = {1,2,3,0,0,0};
        int[] n2 = {2,5,6};
        merge2(n1, 3, n2, 3);
        System.out.println(Arrays.toString(n1));

    }
}
