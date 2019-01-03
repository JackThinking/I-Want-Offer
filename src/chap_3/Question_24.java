package chap_3;

import structure.ListNode;

import java.util.List;

/**
 * Created by Citrix on 2019-01-03.
 */
public class Question_24 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newNode = null;//结果指针
        ListNode tempNode = head;//编制指针
        while (head != null) {
            tempNode = head;//先保存当前值
            head = head.next;//向导指针滑动
            tempNode.next = newNode;//进行编制
            newNode = tempNode;//编制暂存
        }
        return newNode.next;
    }
}
