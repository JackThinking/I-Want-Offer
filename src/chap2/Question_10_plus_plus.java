package chap2;

/**
 * Created by Citrix on 2019-01-02.
 */
public class Question_10_plus_plus {
    public int JumpFloorII(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = sumDp(dp, i - 1) + 1;//这个1是关键
        }
        return dp[target];
    }

    private int sumDp(int[] dp, int i) {
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            sum += dp[j];
        }
        return sum;
    }
}
