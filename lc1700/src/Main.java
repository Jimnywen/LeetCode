import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

abstract class absClass {
    abstract void test1(char a);

    void test2() {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

interface test {
    void test1(int a);
}

public class Main {

    public String mergeAlternately(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < length1; i++) {
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));
            if (i == length1 - 1 && i < length2 - 1) {
                return ans.append(word2.substring(i + 1)).toString();
            }
            if (i == length2 - 1) {
                return ans.append(word1.substring(i + 1)).toString();
            }
        }
        return ans.toString();
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.stream(students).boxed().collect(Collectors.toList()));
        for (int i = 0; i < sandwiches.length; i++) {
            int count = 0, size = deque.size();
            while (sandwiches[i] != deque.getFirst()) {
                int first = deque.removeFirst();
                deque.addLast(first);
                count++;
                if (count > size) return deque.size();
            }
            deque.removeFirst();

        }
        return deque.size();
    }

    public static void main(String[] args) {
//        System.out.println(new Main().countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));

//        System.out.println(new Main().mergeAlternately("abcd", "pq"));
        System.out.println(Arrays.toString(new Main().twoSum(new int[]{3,3}, 6)));
    }

}