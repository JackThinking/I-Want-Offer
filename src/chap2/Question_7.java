package chap2;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-01-01.
 */

public class Question_7 {
    /*
     * 这道题能想到用helper函数，也能纸笔进行推导，但是具体的实现方式还是参考了过去的做法
     * */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return helper(0, 0, in.length - 1, pre, in);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] pre, int[] in) {
        /*
         * 截止条件，自己只想到了第一个
         * */
        if (preStart > pre.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode tempNode = new TreeNode(pre[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == tempNode.val) {
                index = i;
            }
        }
        /*
         * 进行编织，主要inStart,index,inEnd之间的关系
         * */
        tempNode.left = helper(preStart + 1, inStart, index - 1, pre, in);
        tempNode.right = helper(preStart + 1 + index - inStart, index + 1, inEnd, pre, in);//这边的编制preStart出错了
        return tempNode;
    }
}
