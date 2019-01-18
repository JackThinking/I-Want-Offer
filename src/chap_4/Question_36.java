package chap_4;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-01-17.
 */
public class Question_36 {
    /*
     * 一个指向双向链表头的指针
     * 一个编制指针
     * 前后指针的互联
     * 编制指针的滑动
     * 编制指针放到全局可以再递归函数里少写一个参数
     * */
    TreeNode headNode = null;
    TreeNode dummyNode = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        helper(pRootOfTree);
        return headNode;
    }

    public void helper(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        helper(pRootOfTree.left);
        if (dummyNode == null) {
            headNode = pRootOfTree;//只此一次
            dummyNode = pRootOfTree;
        } else {
            dummyNode.right = pRootOfTree;
            pRootOfTree.left = dummyNode;
            dummyNode = pRootOfTree;
        }
        helper(pRootOfTree.right);
    }
}
