public class _1295_Find_Numbers_with_Even_Number_of_Digits {
        public static int findNumbers(int[] nums) {
            int count = 0;
            for (int i : nums) {
                int demSo = demSoChuSo(i);
                if(demSo%2 == 0)
                {
                    count++;
                }
            }
            return count;
        }

        private static int demSoChuSo(int i) {
            int count = 0;
            int kq = i;
            while(kq != 0)
            {
                kq = kq/10;
                count++;
            }
            return count;
        }

        public static void main(String[] args) {
            int[] b =  new int[]{1, 123, 13};
            int c = findNumbers(b);
            System.out.println(c);
        }
    }
    