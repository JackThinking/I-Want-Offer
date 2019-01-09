package chap_4;

import structure.TreeNode;

import java.util.ArrayList;

/**
 * Created by Citrix on 2019-01-09.
 */
public class Question_34 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        helper(root, target, res, path, 0);//把变量写到迭代函数里，不算是和好方法吧
        return res;
    }

    public void helper(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum += root.val;
        if (sum == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));//要new一个新的list，否则会出现问题的，先记住再说
        }
        helper(root.left, target, res, path, sum);
        helper(root.right, target, res, path, sum);
        path.remove(path.size()-1);//想起来了嘛？保存根到叶子的路径的时候要及时删除尾巴节点
    }
}
