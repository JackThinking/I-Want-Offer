package chap_3;

/**
 * Created by Citrix on 2019-01-02.
 */
public class Question_10 {
    /*
     * 第一种思路要注意特殊情况，第二种思路以及总结出来了，但是要进行实践
     * */
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        /*int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];*/
        int pre = 0;
        int now = 1;
        int curr = 0;
        /*
        * 这里的逻辑实际写起来还好理解的
        * */
        for (int i = 2; i <= n; i++) {//注意等号
            curr = pre + now;
            pre = now;
            now = curr;
        }
        return curr;
    }
}
