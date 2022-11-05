import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static int maxScore(String s) {
        int length = s.length();
        int score = 0;
        if (s.charAt(0) == '0') {
            score=1;
        }
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '1') {
                score++;
            }
        }
        int ans = score;
        for (int j = 1; j < length-1; j++) {
            if (s.charAt(j) == '0') {
                score++;
            } else if (s.charAt(j) == '1') {
                score--;
            }
            ans=Math.max(ans,score);
        }
        return  ans;
    }

//    public List<List<Integer>> groupThePeople(int[] groupSizes) {
//        int length = groupSizes.length;
//        for (int i = 0; i <length ; i++) {
//
//        }
//    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashTable1 = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if (hashTable1.containsKey(target-nums[i])) {
                return new int[]{hashTable1.get(target-nums[i]),i};
            }
            hashTable1.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}

