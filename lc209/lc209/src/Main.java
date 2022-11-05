import java.util.Arrays;

public class Main {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int res = nums.length + 1;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res > nums.length ? 0 : res;
    }

    public static void main(String[] args) {

//        System.out.println(Main.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(Main.minSubArrayLen(15, new int[]{1, 2,3,4,5}));


    }
}