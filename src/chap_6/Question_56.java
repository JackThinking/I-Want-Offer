package chap_6;

/**
 * Created by Citrix on 2019-01-11.
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Question_56 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int tempAns = 0;
        int flag = 1;
        /*
         * 因为有两个不同的数，所以所有的异或总是会产生1的
         * */
        for (int i : array) {
            tempAns = tempAns ^ i;
        }
        /*找到最低1的位置
         * */
        while ((tempAns & flag) == 0) {
            flag = flag << 1;
        }

        for (int i = 0; i < array.length; i++) {
            if ((flag & array[i]) == 0) {
                num1[0] = num1[0] ^ array[i];
            } else {
                num2[0] = num2[0] ^ array[i];
            }
        }
    }
}
