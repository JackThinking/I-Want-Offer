package chap2;

/**
 * Created by Citrix on 2019-01-08.
 */
public class Question_15 {
    /*
    * 到时候搜索一下常用的位运算
    * */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
