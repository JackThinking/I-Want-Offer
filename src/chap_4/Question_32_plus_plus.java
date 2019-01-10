package chap_4;

import structure.TreeNode;

import java.util.ArrayList;

/**
 * Created by Citrix on 2019-01-09.
 */
public class Question_32_plus_plus {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        helper(res, pRoot, 0);
        return res;
    }

    private void helper(ArrayList<ArrayList<Integer>> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0,root.val);
        }
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}
