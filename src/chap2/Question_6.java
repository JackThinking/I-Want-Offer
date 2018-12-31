package chap2;

import structure.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Citrix on 2018-12-31.
 */
/*
 * 最快想到的方法是先从头到尾打印，然后反转即可（链表的特点是逆行很麻烦）
 * */
public class Question_6 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        while (listNode != null) {
            res.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(res);
        return res;
    }
}
