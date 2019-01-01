package chap_3;

/**
 * Created by Citrix on 2019-01-01.
 */
public class Question_11 {
    public int minNumberInRotateArray(int[] array) {
        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = index1 + (index2 - index1) / 2;

            if (array[index1] == array[index2] && array[index1] == array[indexMid]) {
                return minOrder(array, index1, index2);
            } else if (array[indexMid] >= array[index1]) {
                index1 = indexMid;
            } else if (array[indexMid] <= array[index2]) {
                index2 = indexMid;
            }
        }
        return array[indexMid];
    }

    private int minOrder(int[] array, int index1, int index2) {
        int res = array[index1];
        for (int i = index1; i < index2; i++) {
            if (array[i] < res) {
                res = array[i];
            }
        }
        return res;
    }
}
