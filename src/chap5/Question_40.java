package chap5;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Citrix on 2019-01-15.
 */
public class Question_40 {
    /*
     * 排序找到前面四个
     * 但是应该还是最小堆比较好
     * */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length <= 0 || k == 0 || k > input.length) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }
        for (int i = 0; i < k; i++) {
            res.add(queue.poll());
        }
        return res;
        /*ArrayList<Integer> res = new ArrayList<>();
        if (input.length == 0 || k < 0 || k > input.length) {
            return res;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            pq.offer(input[i]);
        }
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;*/
    }

    public static void main(String[] args) {
        Question_40 q = new Question_40();
        int[] input = {3, 4, 6, 2, 1};
        System.out.println(q.GetLeastNumbers_Solution(input, 3));
    }
}
