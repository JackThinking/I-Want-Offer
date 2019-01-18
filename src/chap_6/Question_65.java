package chap_6;

/**
 * Created by Citrix on 2019-01-18.
 */
public class Question_65 {
    /*
     * 就是要用位运算解决加分喽，到时候特意准备一下
     * */
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;//没进位的加法
            num2 = (num1 & num2) << 1;//得到进位
            num1 = temp;
        }
        return num1;
    }
}
