import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();

        int ptr = 0;
        for (int i = 1; i <= n; i++) {
            if (target[ptr] == i) {
                ans.add("Push");
                ptr++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
            if (ptr == target.length) break;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new Main().buildArray(new int[]{1,2}, 4));
    }
}