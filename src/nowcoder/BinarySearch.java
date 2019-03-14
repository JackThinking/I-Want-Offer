package nowcoder;

/**
 * Created by Citrix on 2019-03-13.
 */
public class BinarySearch {
    public int binarySearch(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int[] res = new int[2];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > value) {
                right = mid - 1;
            } else if (array[mid] < value) {
                left = mid + 1;
            } else {
                left = mid;
                right = mid;
                while (left > 0 && array[left - 1] == value) {
                    left--;//找到左边边界
                }
                while (right < array.length - 1 && array[right + 1] == value) {
                    right++;//找到右边边界
                }
                return right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] testArray = {1, 2, 4, 4, 4, 4, 4, 5, 6};
        long startTime = System.nanoTime();
        System.out.println(search.binarySearch(testArray, 4));
        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
