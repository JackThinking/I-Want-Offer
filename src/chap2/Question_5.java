package chap2;

/**
 * Created by Citrix on 2018-12-31.
 */
public class Question_5 {
    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.insert(i," ");
                str.insert(i," ");
                str.replace(i, i + 3, "%20");
            }
        }
        return str.toString();
    }
}
