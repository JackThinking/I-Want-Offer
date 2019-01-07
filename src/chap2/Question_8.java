package chap2;

import structure.TreeLinkNode;

/**
 * Created by Citrix on 2019-01-07.
 */
public class Question_8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode tempNode = null;//这个大家都可以用
        if (pNode.right != null) {
            tempNode = pNode.right;
            while (tempNode.left != null) {
                tempNode = tempNode.left;
            }
        } else if (pNode.next != null) {
            TreeLinkNode currNode = pNode;
            TreeLinkNode pareNode = pNode.next;
            while (pareNode != null && pareNode.right == currNode) {
                currNode = pareNode;
                pareNode = pareNode.next;
            }
            tempNode = pareNode;
        }
        return tempNode;
    }
}
