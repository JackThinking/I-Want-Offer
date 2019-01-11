package chap_6;

/**
 * Created by Citrix on 2019-01-11.
 */
public class Question_53 {
    /*
     * 先二叉找到，然后左右平滑计数
     * */
    /*public int GetNumberOfK(int[] array, int k) {

        if (array.length != 0) {
            int left = getFirstK(array, k);
            int right = getLastK(array, k);
            if (left != -1 && right != -1) {
                return right - left + 1;
            }
        }

        return 0;
    }

    private int getFirstK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {//一般还是等于的多
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                if (mid > 0 && array[mid - 1] == k) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int getLastK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {//一般还是等于的多
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                if (mid < array.length - 1 && array[mid + 1] == k) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }*/
    public int GetNumberOfK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                left = mid;
                right = mid;
                while (left > 0 && array[left - 1] == k) {
                    left--;
                }
                while (right < array.length - 1 && array[right + 1] == k) {
                    right++;
                }
                return right - left;

            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}
