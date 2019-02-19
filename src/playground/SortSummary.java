package playground;

import java.util.Arrays;

/**
 * Created by Citrix on 2019-02-19.
 */
public class SortSummary {
    /*
     * 选择排序：每次找到一个待排数组中最小的值放在前面
     * */
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }

    /*
     * 插入排序：假设已有一个排序的数组，之后的待排数组挨个进行比较
     * */
    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {//假设第一个是已排序数组
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    /*
     * 归并排序，自定向下的版本:注意很小陷阱，尤其注意那个暂存数组
     * */
    public void mergeSort(int[] array) {
        mergeSortActual(array, 0, array.length - 1);
    }

    private void mergeSortActual(int[] array, int left, int right) {
        if (left >= right) {//注意点
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortActual(array, left, mid);
        mergeSortActual(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;//注意点
        int[] tempArray = new int[array.length];
        for (int k = left; k <= right; k++) {
            tempArray[k] = array[k];
        }
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                array[k] = tempArray[j++];
            } else if (j > right) {
                array[k] = tempArray[i++];
            } else if (tempArray[i] > tempArray[j]) {
                array[k] = tempArray[j++];
            } else {
                array[k] = tempArray[i++];
            }
        }
    }

    public void quickSort(int[] array) {
        quickSortActual(array, 0, array.length - 1);
    }

    private void quickSortActual(int[] array, int left, int right) {
        if (right < left) {
            return;
        }
        int low = left;
        int high = right;
        int mid = low + (high - low) / 2;
        int v = array[mid];
        while (low <= high) {
            while (array[low] < v) {
                low++;
            }
            while (array[high] > v) {
                high--;
            }
            if (low <= high) {
                swap(array, low, high);
                low++;
                high--;
            }
            if (left < high)
                quickSortActual(array, left, high);
            if (low < right)
                quickSortActual(array, low, right);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        SortSummary sortSummary = new SortSummary();
        //int[] testArray = {2, 4, 5, 1, 6};
        int[] testArray = {1, 2, 4, 5, 6};
        long startTime = System.nanoTime();
        sortSummary.quickSort(testArray);
        long endTime = System.nanoTime();
        System.out.println(Arrays.toString(testArray));
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
