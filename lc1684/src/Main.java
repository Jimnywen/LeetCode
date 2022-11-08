import java.util.HashSet;

public class Main {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0;

        for (char c : allowed.toCharArray()) {
            set.add(c);
        }
        for (String word : words) {
            int i = 0;
            while (i < word.length()) {
                if (set.contains(word.charAt(i))) {
                    i++;
                } else break;
            }
            if (i == word.length()) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Main().countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }
}