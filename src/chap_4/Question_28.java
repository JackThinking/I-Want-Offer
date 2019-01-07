package chap_4;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-01-07.
 */
public class Question_28 {
    boolean isSymmetrical(TreeNode pRoot) {

        return pRoot == null || helper(pRoot, pRoot);
    }

    private boolean helper(TreeNode left, TreeNode rigjt) {
        if (left == null || rigjt == null) {
            return left == rigjt;
        }
        if (left.val != rigjt.val) {
            return false;
        }
        return helper(left.left, rigjt.right) && helper(left.right, rigjt.left);
    }
}
