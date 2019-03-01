package playground;

import java.util.Arrays;

/**
 * Created by Citrix on 2019-02-19.
 */
public class SortSummary {
    /*
     * 选择排序：不稳定，每次找到一个待排数组中最小的值放在前面，记住543的例子
     * */
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;//别忘记
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    /*
     * 插入排序：稳定，假设已有一个排序的数组，之后的待排数组挨个进行比较，记住543的例子
     * */
    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    /*
     * 冒泡排序：稳定，不断的前后比较，若大小出错就换过来，每次都会使得末尾的值确定，相当于选择排序的倒序版
     * */
    public void bubbleSort(int[] array) {
        int N = array.length;
        while (N > 0) {
            for (int i = 1; i < N; i++) {//注意这个的边界
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                }
            }
            N--;
        }
    }

    /*
     * 希尔排序：是插入排序的改进版
     * */
    public void shellSort(int[] array) {
        int N = array.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (array[j] < array[j - h]) {
                        swap(array, j, j - h);
                    }
                }
            }
            h = h / 3;
        }
    }


    /*
     * 归并排序，自定向下的版本:稳定，注意很小陷阱，尤其注意那个暂存数组
     * */
    public void mergeSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        mergeSortActual(array, 0, array.length - 1);
    }

    private void mergeSortActual(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortActual(array, left, mid);
        mergeSortActual(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] tempArray = new int[array.length];
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                array[k] = tempArray[j++];
            } else if (j > right) {
                array[k] = tempArray[i++];
            } else if (tempArray[i] < tempArray[j]) {
                array[k] = tempArray[i++];
            } else {
                array[k] = tempArray[j++];
            }
        }
    }

    /*
     * 自底向上的归并排序：
     * */
    public void mergeSort2(int[] array) {
        int N = array.length;
        for (int size = 1; size < N; size = size + size) {
            for (int i = 0; i < N - size; i += size + size) {
                merge(array, i, i + size - 1, Math.min(i + 2 * size - 1, N - 1));
            }
        }
    }

    /*
     * 快速排序，不稳定，一般而言高效的排序方式，记住45312这个例子
     * */
    public void quickSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        quickSortActual(array, 0, array.length - 1);
    }

    private void quickSortActual(int[] array, int left, int right) {
        int lt = left;
        int rt = right;
        int v = array[left];
        while (lt < rt) {
            while (array[lt] < v) {
                lt++;
            }
            while (array[rt] > v) {
                rt--;
            }
            if (lt <= rt) {
                swap(array, lt++, rt--);
            }
            if (left < rt) {
                quickSortActual(array, left, rt);
            }
            if (lt < right) {
                quickSortActual(array, lt, right);
            }
        }
    }

    /*
     * 三切分快排：针对大量重复元素进行改进，其思路和快排相似，但也有很大的不同
     * */
    public void quickSort3Way(int[] array) {
        quickSort3WayActual(array, 0, array.length - 1);
    }

    private void quickSort3WayActual(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int lt = left;
        int rt = right;
        int v = array[left];
        int i = lt + 1;
        while (i <= rt) {//边界错误
            int cmp = array[i] - v;
            if (cmp > 0) {
                swap(array, i, rt--);
            } else if (cmp < 0) {
                swap(array, i++, lt++);
            } else {
                i++;
            }
        }
        quickSort3WayActual(array, left, lt - 1);
        quickSort3WayActual(array, rt + 1, right);
    }

    /*
     * 堆排序：其实也不难的，理解一下
     * */
    public void heapSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        int N = array.length - 1;
        for (int i = (N - 1) / 2; i >= 0; i--) {
            sink(array, i, N);
        }
        while (N > 0) {
            swap(array, 0, N);
            N--;
            sink(array, 0, N);
        }
    }

    private void sink(int[] array, int k, int N) {
        while (2 * k + 1 <= N) {
            int left = 2 * k + 1;
            if (left + 1 <= N) {
                if (array[left] < array[left + 1]) {
                    left++;
                }
            }
            if (array[k] > array[left]) {
                break;
            }
            swap(array, k, left);
            k = left;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        SortSummary sortSummary = new SortSummary();
        int[] testArray = {2, 4, 5, 1, 6};
        //int[] testArray = {};
        int[] testArrayWithRepeated = {8, 6, 4, 2, 2, 2, 4, 5, 6};
        long startTime = System.nanoTime();
        sortSummary.heapSort(testArray);
        //sortSummary.quickSort3Way(testArrayWithRepeated);
        long endTime = System.nanoTime();
        System.out.println(Arrays.toString(testArray));
        //System.out.println(Arrays.toString(testArrayWithRepeated));
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
