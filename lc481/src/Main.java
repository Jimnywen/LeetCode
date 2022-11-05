public class Main {

    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");

        int groupCountPtr = 2, numPtr = 3, flag = 0, ans = 1;
        while (numPtr < n) {
            if (sb.charAt(groupCountPtr) == '2') {
                sb.append(flag == 0 ? "11" : "22");
                numPtr += 2;

                if (flag == 0) {
                    if (numPtr > n) ans += 1;
                    else ans += 2;
                }
            } else {
                sb.append(flag == 0 ? "1" : "2");
                numPtr += 1;
                ans += flag == 0 ? 1 : 0;
            }
            groupCountPtr++;
            flag ^= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Main().magicalString(4));

    }
}