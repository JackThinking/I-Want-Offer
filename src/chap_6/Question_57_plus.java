package chap_6;

import java.util.ArrayList;

/**
 * Created by Citrix on 2019-01-14.
 */
public class Question_57_plus {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) {
            return res;
        }
        int left = 1;
        int right = 2;
        //int tempSum = left + right;
        while (left < right) {
            int tempSum = (right + left) * (right - left + 1) / 2;
            if (tempSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                res.add(list);
                right++;
            } else if (tempSum > sum) {
                //tempSum = tempSum - left;
                left++;
            } else {
                right++;
                //tempSum = tempSum + right;
            }
        }
        return res;
    }
}
