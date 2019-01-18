package chap_6;

/**
 * Created by Citrix on 2019-01-18.
 */
public class Question_62 {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {//特殊条件忘了
            return -1;
        }
        int temp = 0;
        for (int i = 2; i <= n; i++) {//注意这道题整体加一
            temp = (temp + m) % i;
        }
        return temp;
    }
}
