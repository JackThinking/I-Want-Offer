package chap_6;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-01-06.
 */
public class Question_54 {
    /*TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        int[] tmp = {k};
        return helper(pRoot, tmp);
    }

    *//*
     * 给left的遍历过程加个参数
     * *//*
    private TreeNode helper(TreeNode pRoot, int[] k) {

        TreeNode target = null;
        if (pRoot.left != null) {
            target = helper(pRoot.left, k);
        }
        if (target == null) {
            if (k[0] == 1) {
                target = pRoot;
            } else {
                k[0]--;
            }

        }
        if (target == null && pRoot.right != null) {
            target = helper(pRoot.right, k);
        }
        return target;
    }*/
}
