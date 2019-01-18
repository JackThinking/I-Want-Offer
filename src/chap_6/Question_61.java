package chap_6;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Citrix on 2019-01-18.
 */
public class Question_61 {
    /*
     * 1.先排序，再统计零的个数，最后统计间隔；
     * 2.对于重复出现的数字进行排除；
     * */
    public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);//数组排序用Arrays.sort，list接口用Collections.sort
        int zeroNum = 0;
        int gapnum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {//注意边界
            if (numbers[i] == 0) {
                zeroNum++;//对0进行计数
                continue;//这个很妙
            }
            if (numbers[i] == numbers[i + 1]) {//如果是对子就直接不要了
                return false;
            }
            gapnum += numbers[i + 1] - numbers[i] - 1;//统计间隔的方法
        }
        if (gapnum <= zeroNum) {//注意是小于号
            return true;
        }
        return false;
    }
}
