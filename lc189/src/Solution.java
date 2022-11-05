import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void rotate(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length - k; i++) {
            newNums[i + k] = nums[i];
        }
        for (int j = 0; j < k; j++) {
            newNums[j] = nums[nums.length - k + j];
        }

        System.out.println(Arrays.toString(newNums));

    }

    public static void rotate1(int[] nums, int k) {
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] nums, int i, int j) {
        for (; i < j; i++, j--) {
//            swap(nums[i], nums[j]);
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
    }

    public static void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");

        Solution.rotate1(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);

    }
}
