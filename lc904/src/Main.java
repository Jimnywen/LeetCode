import java.util.HashMap;
import java.util.Map;

public class Main {

    public int totalFruit(int[] fruits) {
        int length = fruits.length;

        Map<Integer, Integer> map = new HashMap<>();

        int start = 0, end = 0, ans = 0;
        while (start <= end && end < length) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
            if (map.size() <= 2) {
                end++;
            } else {
                while (map.size() > 2) {
                    map.put(fruits[start], map.get(fruits[start]) - 1);
                    if (map.get(fruits[start]) == 0) {
                        map.remove(fruits[start]);
                    }
                    start++;
                }

                end++;
            }
            ans = Math.max(ans, end - start);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Main().totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(new Main().totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));
    }
}