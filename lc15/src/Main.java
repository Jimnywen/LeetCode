import java.util.*;

public class Main {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        return ans;
    }

    // lc 121
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else {
                ans = Math.max(ans, prices[i] - min);
            }
        }
        return ans;
    }

    // lc 754
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k  % 2;
    }

    // lc 1662
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int index1 = 0, index2 = 0, i = 0, j = 0, length1 = word1.length, length2 = word2.length;

        while (index1 < length1 && index2 < length2) {
            String s1 = word1[index1];
            String s2 = word2[index2];
            if (i == s1.length()) {
                index1++;
                i = 0;
                continue;
            }
            if (j == s2.length()) {
                index2++;
                j = 0;
                continue;
            }
            if (s1.charAt(i) != s2.charAt(j)) return false;
            i++;
            j++;

        }
        // one has been out of bounce but the compare hasn't ended in the other one
        if (index1 == length1 && index2 == length2 - 1 && j == word2[length2 - 1].length()) return true;
        if (index2 == length2 && index1 == length1 - 1 && i == word1[length1 - 1].length()) return true;
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Main().maxProfit(new int[]{2, 5, 1, 2}));
//        System.out.println(new Main().arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        new Main().reachNumber(8);
    }

}