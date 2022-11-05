public class Main {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;

        int p = 2;
        int q = 1;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = p + q;
            q = p;
            p = p + q;

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Main().climbStairs(5));
    }
}