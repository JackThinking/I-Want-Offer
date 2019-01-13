package chap_6;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Citrix on 2019-01-12.
 */
public class Question_59 {
    /*
     * 三个逻辑：index到末尾了必须走，后来者比前面都大则把前面全部挤出去，后来者虽小不能拒绝，因为前面大的可能到点会走
     * */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        if (num.length == 0 || size == 0 || num.length < size) {
            return res;
        }
        /*
         * 第一阶段是只要最大的,size-1个数，不记录最大值
         * */
        for (int i = 0; i < size - 1; i++) {
            while (!queue.isEmpty() && num[i] > num[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        /*
        * 此时记录最大值，基本逻辑一样
        * */
        for (int i = size - 1; i < num.length; i++) {
            while (!queue.isEmpty() && num[i] > num[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            res.add(num[queue.peekFirst()]);
            if (queue.peekFirst() == i + 1 - size) {
                queue.removeFirst();
            }
        }
        return res;
    }
}
