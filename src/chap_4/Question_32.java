package chap_4;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by Citrix on 2019-01-09.
 */
public class Question_32 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue).add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = ((LinkedList<TreeNode>) queue).pop();
            res.add(tempNode.val);
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return res;
    }
}
