package chap5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Citrix on 2019-01-13.
 */
public class Question_50 {
    /*
     * 第一个只出现一次的数字，但是至少要遍历一次，还得记下坐标，就这样
     * */
    public int FirstNotRepeatingChar(String str) {
        if (str == null) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] strChars = str.toCharArray();
        for (int i = 0; i < strChars.length; i++) {
            if (map.containsKey(strChars[i])) {
                map.put(strChars[i], map.get(strChars[i]) + 1);
            } else {
                map.put(strChars[i], 1);
            }
        }
        for (int i = 0; i < strChars.length; i++) {
            if (map.get(strChars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
