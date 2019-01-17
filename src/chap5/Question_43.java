package chap5;


/**
 * Created by Citrix on 2019-01-15.
 */
public class Question_43 {
    /*
     * 挨个找，每个都对10取余的方式找1的个数
     * */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int before = 0, current = 0, after = 0;
        int i = 1;
        while ((n / i) != 0) {
            current = (n / i) % 10;//12013的百位 12013/100 = 120 120%10 = 0
            before = n / (i * 10);//12013中的12 12013/100*10 = 12
            after = n - (n / i) * i;//12013的百位 12013 - 12000 = 13
            if (current == 0) {
                count += before * i;
            } else if (current == 1) {
                count += before * i + after + 1;
            } else {
                count += (before + 1) * i;
            }
            i *= 10;
        }
        return count;
    }
}
