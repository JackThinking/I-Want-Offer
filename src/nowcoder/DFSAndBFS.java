package nowcoder;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Citrix on 2019-03-14.
 */
public class DFSAndBFS {
    /*
     * BFS版本，简单易懂，注意如果是按照层级做成子数组的话，还是用DFS的level版本
     * */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.remove();
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

    /*
     * DFS版本，还要在理解一下
     * */
    public ArrayList<Integer> PrintFromTopToBottom_2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            res.add(root.left.val);
        }
        if (root.right != null) {
            res.add(root.right.val);
        }
        dfs(root.left, res);
        dfs(root.right, res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
