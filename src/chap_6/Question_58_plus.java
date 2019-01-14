package chap_6;

/**
 * Created by Citrix on 2019-01-14.
 */
public class Question_58_plus {
    public String LeftRotateString(String str, int n) {
        if (str != null && n >= 0 && str.length() > n) {
            char[] data = str.toCharArray();
            reverse(data, 0, n - 1);
            reverse(data, n, data.length - 1);
            reverse(data, 0, data.length - 1);
            return new String(data);
        }
        return str;
    }

    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
