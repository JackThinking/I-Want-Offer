package chap_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Citrix on 2019-01-12.
 */
public class Question_57 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length < 2) {
            return res;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] > sum) {
                right--;
            } else if (array[left] + array[right] < sum) {
                left++;
            } else {
                res.add(array[left]);
                res.add(array[right]);
                break;
            }
        }
        return res;
    }
}
