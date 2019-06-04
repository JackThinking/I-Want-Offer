package playground;

import java.util.Map;

/**
 * Created by Citrix on 2019-04-26.
 */
public class Knapsack01 {
    public int knapsack01(int[] w, int[] v, int C) {
        if (w.length != v.length) {
            return -1;
        }
        int n = w.length;
        /*
         * 需要一个dp的数组，保存的意义是存储容量C时的最大价值，由于0是无意义的，故长度为C+1;
         * */
        int[] dp = new int[C + 1];
        /*
         * 赋初值，其实就是第一个物品
         * */
        for (int i = 0; i <= C; i++) {
            dp[i] = i > w[0] ? v[0] : 0;
        }
        /*
         * dp的迭代过程，注意把物品的种类放到外层循环，将容量的迭代放到里面层，可以省去一个if条件的判断
         * */
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        return dp[C];
    }
}
