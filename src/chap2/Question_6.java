package chap2;

import structure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by Citrix on 2018-12-31.
 */
public class Question_6 {
    /*
     * 思路一：最快想到的方法是先从头到尾打印，然后反转即可（链表的特点是逆行很麻烦）
     * 思路二：用堆栈的方式到达逆序
     * */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
           /* ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        while (listNode != null) {
            res.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(res);
        return res;*/
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {//判断堆栈为空要用stack.empty()而不是stack.pop()==null
            res.add(stack.pop());
        }
        return res;
    }
}
