package chap_3;

import structure.ListNode;

/**
 * Created by Citrix on 2019-01-12.
 */
public class Question_18_plus {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode p = pHead;//滑动指针
        ListNode newNode = new ListNode(-1);//answer指针
        newNode.next = pHead;//answer指针指向pHead
        ListNode preNode = newNode;//删除链表需要pre指针跳过需要删除的指向下一个 ，需要是newNode，为了应对1，1，2这样的情况
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
                preNode.next = p;
            } else {
                preNode = p;
                p = p.next;
            }
        }
        return newNode.next;
    }
}
