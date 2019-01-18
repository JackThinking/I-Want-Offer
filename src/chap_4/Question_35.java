package chap_4;


/**
 * Created by Citrix on 2019-01-17.
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Question_35 {
    /*
     * 分三步走
     * 先复制节点到原节点后面
     * 复制节点的random指针
     * 分拆链表
     * */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        /*
         * 先复制节点到原节点后面
         * */
        RandomListNode currentNode = pHead;
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;//这边的顺序无所谓的
            //currentNode = currentNode.next;
            currentNode = nextNode;
        }
        /*
         * 复制节点的random指针
         * */
        currentNode = pHead;
        while (currentNode != null) {//有点意思，自己想不到
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;//出错，应该是二连跳
        }
        /*
         * 分拆链表
         * */
        currentNode = pHead;
        RandomListNode resNode = currentNode.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;//准备不能是resNode
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;

        }
        return resNode;
    }
}
