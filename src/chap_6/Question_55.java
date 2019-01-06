package chap_6;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-01-06.
 */
public class Question_55 {
    public int TreeDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
