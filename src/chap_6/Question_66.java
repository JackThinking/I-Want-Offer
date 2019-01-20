package chap_6;

/**
 * Created by Citrix on 2019-01-20.
 */
public class Question_66 {
    /*
     * 构建乘积数组，每一行保存除了自己的乘积，不能用除法，可以使用双for循环做出来
     * 书上的方法假借上三角和下三角进行计算
     * */
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        if (len != 0) {
            res[0] = 1;
            for (int i = 1; i < len; i++) {
                res[i] = res[i - 1] * A[i-1];//i-1呀我去
            }
            int temp = 1;
            for (int i = len - 2; i >= 0; i--) {
                temp *= A[i+1];
                res[i] *= temp;
            }
        }
        return res;
    }
}
