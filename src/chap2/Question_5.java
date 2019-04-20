package chap2;


/**
 * Created by Citrix on 2018-12-31.
 */
public class Question_5 {
    /*
     * 思路一：找到空格后使用先额外插入两个空格，然后进行整体替换，但是其时间复杂度过高
     * */
    public String replaceSpace(StringBuffer str) {
       /* for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.insert(i," ");
                str.insert(i," ");
                str.replace(i, i + 3, "%20");
            }
        }
        return str.toString();*/
        int originLen = str.length();
        int spaceNum = 0;
        for (int i = 0; i < originLen; i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        /*
        * 这一步是没有想到
        * */
        if (spaceNum == 0) {
            return str.toString();
        }
        int resizeLen = originLen + 2 * spaceNum;
        str.setLength(resizeLen);//重新设置新的长度
        int indexOfOrigin = originLen - 1;
        int indexOfResize = resizeLen - 1;
        while (indexOfOrigin >= 0 && indexOfOrigin < indexOfResize) {//这个条件我想的简单了
            if (str.charAt(indexOfOrigin) == ' ') {
                str.setCharAt(indexOfResize--, '0');
                str.setCharAt(indexOfResize--, '2');
                str.setCharAt(indexOfResize--, '%');
            } else {
                str.setCharAt(indexOfResize--, str.charAt(indexOfOrigin));
            }
            indexOfOrigin--;//这个变量单独提出来的步骤我也是忽略了
        }

        return str.toString();
    }
}
