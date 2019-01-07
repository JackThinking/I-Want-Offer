package chap_4;

import java.util.ArrayList;

/**
 * Created by Citrix on 2019-01-07.
 */
public class Question_29 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int top = 0;
        int end = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (top <= end && left <= right) {
            //从左到右

            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > end || left > right) {
                break;
            }
            for (int i = top; i <= end; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top > end || left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[end][i]);
            }
            end--;
            if (top > end || left > right) {
                break;
            }
            for (int i = end; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (top > end || left > right) {
                break;
            }
        }
        return res;
    }
}
