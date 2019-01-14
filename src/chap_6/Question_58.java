package chap_6;

import chap2.Question_4;

/**
 * Created by Citrix on 2019-01-14.
 */
public class Question_58 {
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        swap(chars, 0, chars.length - 1);
        int start = 0;
        int end = 0;
        while (start < chars.length) {
            if (chars[start] == ' ') {//这点也没有想到
                start++;
                end++;
            } else if (end == chars.length ||chars[end] == ' ') {//这点没有想到
                swap(chars, start, end - 1);
                end++;
                start = end;
            } else {
                end++;
            }
        }
        return new String(chars);//必须得新建一个String，否则chars.toString会产生错误
    }

    private void swap(char[] chars, int start, int end) {
        if (chars == null || chars.length < 1 || start < 0 || end > chars.length || start > end) {
            return;
        }
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Question_58 q = new Question_58();
        String str = "I am a student.";
        System.out.println(q.ReverseSentence(str));
    }
}
