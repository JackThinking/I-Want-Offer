package chap5;

/**
 * Created by Citrix on 2019-01-13.
 */
public class Question_49 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {//鲁棒性保证
            return 0;
        }
        int[] list = new int[index];
        int count = 0;
        list[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while (count < index - 1) {
            int tmp = min(list[i2] * 2, min(list[i3] * 3, list[i5] * 5));//关键点
            if (tmp == list[i2] * 2) {
                i2++;
            }
            if (tmp == list[i3] * 3) {
                i3++;
            }
            if (tmp == list[i5] * 5) {
                i5++;
            }
            list[++count] = tmp;
        }
        return list[index - 1];
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }
}
