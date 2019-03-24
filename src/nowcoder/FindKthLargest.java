package nowcoder;

import java.util.PriorityQueue;

/**
 * Created by Citrix on 2019-03-14.
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        quickSort(nums, 0, n - 1, n - k);
        return nums[n - k];
    }

    private void quickSort(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        int pivot = choosePivot(nums[mid], nums[start], nums[end]);
        int i = start;
        int j = end;
        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (nums[i] != nums[j]) {
                    swap(nums, i, j);
                }
                i++;
                j--;
            }
        }
        if (target <= i - 1) {
            quickSort(nums, start, i - 1, target);
        } else {
            quickSort(nums, i, end, target);
        }
    }

    private int choosePivot(int a, int b, int c) {
        if (a > b) {
            if (c > a) {
                return a;
            } else if (c > b) {
                return c;
            } else {
                return b;
            }
        } else {
            if (c > b) {
                return b;
            } else if (c > a) {
                return c;
            } else {
                return a;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public int findKthLargest_2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆

        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)  // 维护堆的大小为 K
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] testNums = {1, 2, 4, 6, 3, 1, 3, 6, 7};
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest_2(testNums, 3));
    }
}
