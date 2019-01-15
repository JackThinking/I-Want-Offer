package chap5;

/**
 * Created by Citrix on 2019-01-15.
 */
public class Question_39 {
    /*
     * 首先想到count对每个计数，然后挨个比较
     * 或者用优先级队列去处理
     * 还有简单易懂的方法是用count和数字来保存，因为超过一半，出现一半还有的数字的count一定大于0
     * 难题还在如何判断不存在大于长度超过一半的
     * */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int result = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                result = array[i];
                count++;
            } else if (array[i] != result) {
                count--;
            } else {
                count++;
            }
        }
        if (!isChecked(array, result)) {
            return 0;
        }
        return result;
    }

    private boolean isChecked(int[] array, int result) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return true;
        }
        return false;
    }
}
