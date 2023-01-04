import java.util.*;

public class Main {

    // TODO
    public int numMatchingSubseq(String s, String[] words) {

        HashMap<Character, List<Integer>> map = new HashMap<>();
        int ans = 0;
        int s_length = s.length();
        for (int i = 0; i < s_length; i++) {
            List<Integer> charSeq = map.getOrDefault(s.charAt(i), new ArrayList<Integer>());
            charSeq.add(i);
            map.put(s.charAt(i), charSeq);
        }

        for (String word : words) {
            int word_length = word.length();
            for (int i = 0; i < word_length; i++) {
                map.get(word.charAt(i));
            }
        }

        return ans;
    }

    // lc 75 medium
    public void sortColors(int[] nums) {
        if (nums.length <= 1) return;
        int left = 0, right = nums.length - 1, i = 0;

        while (i < nums.length) {
            while (nums[i] == 2 && i <= right) {
                swap(i, right, nums);
                right--;
            }
            if (nums[i] == 0) {
                swap(i, left, nums);
                left++;
            }
            i++;
        }
    }

    static void swap(int a, int b, int[] arr) {
        if (a == b) return;
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    // lc 1742 easy
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int boxNum = 0, temp = i;
            while (temp != 0) {
                boxNum += temp % 10;
                temp = temp / 10;
            }
            map.put(boxNum, map.getOrDefault(boxNum, 0) + 1);
            ans = Math.max(ans, map.get(boxNum));
        }
        return ans;
    }

    // lc1758 easy
    public int minOperations(String s) {

        int length = s.length();
        if (length <= 1) return 0;
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < length; i++) {
            if (chars[i] == chars[i - 1]) {
                ans++;
                chars[i] = chars[i - 1] == '1' ? '0' : '1';
            }
        }
        return Math.min(ans, length - ans);
    }

    // lc 1752 easy
    public boolean check(int[] nums) {


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                while (i + 1 < nums.length && nums[i] <= nums[i + 1]) {
                    i++;
                }
                if (i == nums.length - 1 && nums[i] <= nums[0]) return true;
                return false;
            }
        }
        return true;
    }

    // lc 1781 medium
    public int beautySum(String s) {
        int ans = 0, length = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int max = 0, min = Integer.MAX_VALUE;
            for (int j = i; j < length; j++) {
                int cnt = map.getOrDefault(s.charAt(j), 0);
                cnt++;
                max = Math.max(max, cnt);
                map.put(s.charAt(j), cnt);
                min = Collections.min(map.entrySet(), Map.Entry.comparingByValue()).getValue();
                ans += max - min;
            }
            map.clear();
        }


        return ans;
    }

    // lc 1832 easy
    public boolean checkIfPangram(String sentence) {
        int[] map = new int[26];
        int cnt = 26;
        for (char c : sentence.toCharArray()) {
            map[c - 'a']++;
            if (map[c - 'a'] == 1) cnt--;
        }
        return cnt == 0;
    }


    // lc 1945 easy
    public int getLucky(String s, int k) {
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        String charInt = sb.toString();
        int length = charInt.length(), temp = 0;

        for (int i = length - 1, j = 0; i >= 0; i--, j++) {
            temp += charInt.charAt(i) - '0';
        }
        ans = temp;
        k--;

        while (k > 0) {
            ans = 0;
            while (temp > 0) {
                ans += temp % 10;
                temp = temp / 10;
            }
            temp = ans;
            k--;
        }

        return ans;
    }

    // lc 1785 medium
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long target = goal - sum;
        return (int) Math.ceil(Math.abs(target) * 1.0 / limit);
    }


    // lc 1760 medium
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt(), ans = Integer.MAX_VALUE;

        while (left <= right) {
            int division = (left + right) / 2, count = 0;

            for (int num : nums) {
                count += (num - 1) / division;
            }

            if (count > maxOperations) left = division + 1;
            else {
                right = division - 1;
                ans = Math.min(division, ans);
            }
        }

        return ans;
    }


    // lc 2042 easy
    public boolean areNumbersAscending(String s) {

        int previous = -1, curr = 0, length = s.length(), ptr = 0;
        while (ptr < length) {
            if (!Character.isDigit(s.charAt(ptr))) {
                ptr++;
                continue;
            }
            while (ptr < length && Character.isDigit(s.charAt(ptr))) {
                curr += curr * 10 + (s.charAt(ptr) - '0');
                ptr++;
            }
            if (curr <= previous) return false;
            previous = curr;
            curr = 0;

        }

        return true;
    }

    public static void main(String[] args) {
//        new Main().numMatchingSubseq("abcde",new String[]{"a","bb","acd","ace"});

//        int[] arr = new int[]{1, 2, 0};
//        new Main().sortColors(arr);
//        System.out.println(Arrays.toString(arr));

//        new Main().minOperations("10010100");
//        System.out.println(new Main().minElements(new int[]{1, -1, 1}, 3, -4));
//        new Main().beautySum("aabcbaa");
//        new Main().minimumSize(new int[]{9}, 2);
        System.out.println(new Main().areNumbersAscending("891"));
    }
}