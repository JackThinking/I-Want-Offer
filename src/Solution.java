import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Citrix on 2019/8/30.
 */
public class Solution {
    // 二叉树层级遍历的方式还是bfs更加直观合适，dfs需要额外加上level才能解决的了
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        if ((level & 1) == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }

}
