package chap_3;

import structure.ListNode;

/**
 * Created by Citrix on 2019-01-03.
 */
public class Question_23 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fastNode = pHead;
        ListNode slowNode = pHead;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                ListNode slowNode2 = pHead;
                while (slowNode2 != slowNode) {
                    slowNode = slowNode.next;
                    slowNode2 = slowNode2.next;
                }
                return slowNode;
            }
        }
        return null;
    }
}
