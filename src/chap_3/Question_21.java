package chap_3;

/**
 * Created by Citrix on 2019-01-08.
 */
public class Question_21 {
    /*
     * 单独将奇数拎到前面，使其相对顺序不变的话还是可以的。想到了001122的再排序
     *
     * */
    public void reOrderArray(int[] array) {
        /*if (array.length < 2) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && array[start] % 2 == 1) {
                start++;
            }
            while (start < end && array[end] % 2 == 0) {
                end--;
            }
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }*/
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
