package chap_3;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-01-04.
 */
public class Question_26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        /*if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return DoHasSubtree(root1, root2);
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);*/

        //这样子写的鲁棒性更加好
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = DoHasSubtree(root1, root2);
            }
            if (!result) {
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    private boolean DoHasSubtree(TreeNode root1, TreeNode root2) {
        //这个一定要先放到前面
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }
        return DoHasSubtree(root1.left, root2.left) && DoHasSubtree(root1.right, root2.right);
    }
}
