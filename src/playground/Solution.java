package playground;

import java.util.Arrays;

/**
 * Created by Citrix on 2019-01-24.
 */
public class Solution {
    public void quickSort(int[] arrays, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int priot = arrays[start];
        while (left < right) {
            while (arrays[start] < priot && left < right) {
                left++;
            }
            while (arrays[end] > priot && left < right) {
                right--;
            }
            /*
            * 这个可以是相等才行
            * */
            if (left<=right){
                swap(arrays, left, right);
            }
        }
        quickSort(arrays, start, left - 1);
        quickSort(arrays, left + 1, end);
    }

    public void quickQort3(int[] arrays, int start, int end) {
        if (start < end) {
            return;
        }
        int lt = start;
        int rt = end;
        int pi = start + 1;
        int key = arrays[lt];
        while (pi < rt) {
            int cmp = arrays[pi] - arrays[key];
            if (cmp < 0) {
                swap(arrays, lt++, pi++);
            } else if (cmp > 0) {
                swap(arrays, pi, rt--);
            } else {
                pi++;
            }
        }
        quickQort3(arrays, start, lt - 1);
        quickQort3(arrays, rt + 1, end);
    }

    public void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {19, 12, 4, 6, 7, 9, 4};
        solution.quickQort3(test, 0, 6);
        Arrays.asList(test);
    }
}
