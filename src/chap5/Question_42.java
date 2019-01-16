package chap5;

import java.util.Map;

/**
 * Created by Citrix on 2019-01-15.
 */
public class Question_42 {
    /*
     * 最大连续子数组的和，最大上升子序列，都是经典的动态规划题，有必要细究
     * 两个核心思想，要是拖上别人是累赘就自立门户；还有就是自立门户的时候招到徒弟的最大值；
     * */
    public int FindGreatestSumOfSubArray(int[] array) {
        int tempSum = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            tempSum = Math.max(tempSum + num, num);
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}
