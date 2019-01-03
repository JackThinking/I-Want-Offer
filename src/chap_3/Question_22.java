package chap_3;

import structure.ListNode;

/**
 * Created by Citrix on 2019-01-03.
 */
public class Question_22 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (k > 0) {
            if (fastNode == null) {
                return null;
            }
            fastNode = fastNode.next;
            k--;
        }

        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
