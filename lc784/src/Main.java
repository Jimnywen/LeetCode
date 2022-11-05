import java.util.*;

public class Main {


    public List<String> letterCasePermutation1(String s) {
        List<String> ans = new ArrayList<String>();
        Queue<StringBuilder> queue = new ArrayDeque<StringBuilder>();
        queue.offer(new StringBuilder());
        while (!queue.isEmpty()) {
            StringBuilder curr = queue.peek();
            if (curr.length() == s.length()) {
                ans.add(curr.toString());
                queue.poll();
            } else {
                int pos = curr.length();
                if (Character.isLetter(s.charAt(pos))) {
                    StringBuilder next = new StringBuilder(curr);
                    next.append((char) (s.charAt(pos) ^ 32));
                    queue.offer(next);
                }
                curr.append(s.charAt(pos));
            }
        }
        return ans;
    }
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        int length = s.length();
        Deque<StringBuilder> deque = new ArrayDeque<>();
        deque.offer(new StringBuilder());

        while (!deque.isEmpty()) {
            StringBuilder curr = deque.peek();
            if (curr.length() == length) {
                ans.add(curr.toString());
                deque.poll();
            }else {
                int index = curr.length();
                if (Character.isLetter(s.charAt(index))) {
                    StringBuilder next = new StringBuilder(curr);
                    String currChar = String.valueOf(s.charAt(index));
                    next.append(currChar.toLowerCase());
                    curr.append(currChar.toUpperCase());
                    deque.offer(next);
                } else {
                    curr.append(s.charAt(index));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Main().letterCasePermutation1("a1b2");
    }
}
