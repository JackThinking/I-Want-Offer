package chap_4;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-01-04.
 */
public class Question_27 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        /*
        * 这个条件没有想到
        * */
        if (root.left == root.right) {
            return;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        /*
        * 自顶向下的方式没有想透
        * */
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }
}
