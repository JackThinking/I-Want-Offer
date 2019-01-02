package chap_3;

/**
 * Created by Citrix on 2019-01-02.
 */
public class Question_10 {
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
