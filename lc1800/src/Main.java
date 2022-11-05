public class Main {

    public int maxAscendingSum(int[] nums) {

        int length = nums.length;
        int sum = nums[0],ans= nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i]>nums[i-1]){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Main().maxAscendingSum(new int[]{3,6,10,1,8,9,9,8,9}));

    }
}