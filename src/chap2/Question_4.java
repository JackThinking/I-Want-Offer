package chap2;


/**
 * Created by Citrix on 2018-12-30.
 */
/*
 * 思路马上想到了，之前在LeetCode上做过
 * */
public class Question_4 {
    public boolean Find(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }
        int m = array.length;
        int n = array[0].length;
        int i = 0;
        int j = n - 1;//这个地方马虎了
        while (i < m && j >= 0) {//这个地方一开始想错了，后面对了
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
