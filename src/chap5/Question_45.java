package chap5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Citrix on 2019-01-16.
 */
public class Question_45 {
    public String PrintMinNumber(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {//可耻的用到了内置排序算法
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : list) {
            stringBuilder.append(integer);
        }
        return stringBuilder.toString();
    }
}
