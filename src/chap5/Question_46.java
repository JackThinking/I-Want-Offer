package chap5;

/**
 * Created by Citrix on 2019-01-20.
 */
public class Question_46 {
    /*
     * string变char数组之后，进行乘10计算，然后判断其大小范围，还要对负号进行正确的处理
     * */
    public int StrToInt(String str) {
        if (str.equals("") || str.length() == 0) {//记住string用equal()进行判断
            return 0;
        }
        char[] strs = str.toCharArray();
        int flag = 0;
        if (strs[0] == '-') {//判断符号位
            flag = 1;
        }
        int sum = 0;
        for (int i = flag; i < strs.length; i++) {//要考虑正号的呀，用int的符号位
            if (strs[i] == '+') {
                continue;
            }
            //不符合0-9的范围之内
            if (strs[i] < 48 || strs[i] > 57) {
                return 0;
            }
            sum = sum * 10 + strs[i] - 48;//记住0-9的范围是48-57
        }
        return flag == 1 ? -1 * sum : sum;
    }
}
