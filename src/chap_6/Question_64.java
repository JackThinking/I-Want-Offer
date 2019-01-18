package chap_6;

/**
 * Created by Citrix on 2019-01-18.
 */
public class Question_64 {
    /*
     * 只能用加减法和位运算，位运算的右移可以当做除2，位运算可以组合成乘法器（不实际）
     * 递归是最应该马上想到的，然后就是二维数组的方式
     * */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = ((n > 0) && (sum += Sum_Solution(n - 1)) > 0);//利用&&的性质，前面断了就直接返回
        return sum;
    }
}
