import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {

    public int getKthMagicNumber(int k) {

        var factors = new int[]{3, 5, 7};
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> tempSet = new HashSet<>();
        int ans = 0;

        tempSet.add(1L);
        queue.offer(1L);
        for (int i = 0; i < k; i++) {
            long peak = queue.poll();
            ans = (int) peak;
            for (int factor : factors) {
                if (tempSet.contains(peak * factor)) {
                    continue;
                }
                queue.offer(peak * factor);
                tempSet.add(peak * factor);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Main().getKthMagicNumber(5));

    }
}