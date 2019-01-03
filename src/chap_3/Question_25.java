package chap_3;

import structure.ListNode;

/**
 * Created by Citrix on 2019-01-03.
 */
public class Question_25 {
    /*
     * 考的就是归并排序，归并排序就靠4个比较，2个是空了，2个是大小比较
     * */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
