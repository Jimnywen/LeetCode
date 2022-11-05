import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static int minStartValue(int[] nums) {
        int startValue = 1;
        int sum = startValue;
        for (int num : nums) {
            sum += num;
            while (sum < 1) {
                startValue++;
                sum++;
            }

        }
        return startValue;
    }

    public static int minStartValu1e(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return 1 - min;
    }

    // lc 1422
    public static int maxScore(String s) {
        int score = 0;
        int length = s.length();
        if (s.charAt(0) == '0') score = 1;
        for (int j = 1; j < length; j++) {
            if (s.charAt(j) == '1') score++;
        }
        int ans = score;
        for (int i = 1; i < length - 1; i++) {
            if (s.charAt(i) == '0') score++;
            else if (s.charAt(i) == '1') score--;

            ans = Math.max(ans, score);
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(Main.minStartValu1e(new int[]{1, -2, -3}));
//        System.out.println(maxScore("00111"));
        System.out.println(maxScore("00"));
        LinkedList<Integer> integers = new LinkedList<>();
        new ArrayDeque<>()
    }
}