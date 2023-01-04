import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    // lc 1801 medium
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> sellQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);


        for (int[] order : orders) {
            int price = order[0], amount = order[1], orderType = order[2];
            if (orderType == 0) {
                while (!sellQueue.isEmpty() && price > sellQueue.peek()[0]) {
                    int[] top = sellQueue.poll();
                    if (amount > top[1]) {
                        amount -= top[1];
                    } else {
                        sellQueue.offer(new int[]{top[0], top[1] - amount});
                        amount = 0;
                        break;
                    }
                }
                if (amount > 0) buyQueue.offer(new int[]{price, amount});
            } else if (orderType == 1) {
                while (!buyQueue.isEmpty() && price < buyQueue.peek()[0]) {
                    int[] top = buyQueue.poll();
                    if (amount > top[1]) {
                        amount -= top[1];
                    } else {
                        sellQueue.offer(new int[]{top[0], top[1] - amount});
                        amount = 0;
                        break;
                    }
                }
                if (amount > 0) sellQueue.offer(new int[]{price, amount});
            }

        }

        return 2;

    }

    public static void main(String[] args) {
Arrays.sort(new int[]{1,23,3}, new Comparator<Integer>(){
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;  // 反过来是升序
    }
});
        System.out.println();
    }
}