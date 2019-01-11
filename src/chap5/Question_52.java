package chap5;

import structure.ListNode;

/**
 * Created by Citrix on 2019-01-11.
 */
public class Question_52 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        /*if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode tempNode1 = pHead1;
        ListNode dummyNode1 = tempNode1;
        ListNode tempNode2 = pHead2;
        ListNode dummyNode2 = tempNode2;
        while(tempNode1.next!=null){
            tempNode1 = tempNode1.next;
        }
        tempNode1.next = pHead2;
        while(tempNode2.next!=null){
            tempNode2 = tempNode2.next;
        }
        tempNode2.next = pHead1;

        while (dummyNode1 != null && dummyNode2 != null) {
            dummyNode1 = dummyNode1.next;
            dummyNode2 = dummyNode2.next;
            if (dummyNode1 == dummyNode2) {
                return dummyNode1;
            }
        }
        return null;*/ //；loser的记录
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode point1 = pHead1;
        ListNode point2 = pHead2;
        while (point1 != point2) {
            /*
            * 不熟练呀
            * */
            point1 = point1 == null ? pHead2 : point1.next;
            point2 = point2 == null ? pHead1 : point2.next;
        }
        return point1;
    }
}
