package chap_4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Citrix on 2019-01-17.
 */
public class Question_38 {
    /*
     * 要记录字符的状态，排列组合，应该是用dp的
     * */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] strs = str.toCharArray();
        if (str != null && str.length() > 0) {
            helper(strs, 0, res);
        }
        Collections.sort(res);//按照字典排序
        return res;
    }

    public void helper(char[] strs, int index, ArrayList<String> res) {
        if (index == strs.length - 1) {//终止条件
            String val = String.valueOf(strs);//变成String
            if (!res.contains(val)) {
                res.add(val);//这边别忘记判断重复
            }
        } else {
            for (int i = index; i < strs.length; i++) {
                swap(strs, index, i);//dfs的思想
                helper(strs, index + 1, res);
                swap(strs, i, index);//换回去
            }
        }
    }

    public void swap(char[] strs, int i, int j) {
        char temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }
}
