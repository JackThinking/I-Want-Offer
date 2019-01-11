package chap_6;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2019-01-11.
 */
public class Question_55_plus {
    /*
     * 最想想到的是中序遍历有序即可，然后想到
     * */
    /*public boolean IsBalanced_Solution(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        return helper(root, list);
    }

    private boolean helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return true;
        }
        boolean left = helper(root.left, list);
        if (root.val < list.get(list.size() - 1)) {
            return false;
        }
        list.add(root.val);
        boolean right = helper(root.right, list);
        return left && right;
    }*/

    /*
     * 平衡树的判断的话，左右树节点高度相差不超过1
     * */
    /*public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) && Math.abs(getDepth(root.left) - getDepth(root.right))<= 1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }*/
    /*
    * 想要的标志位设在全局是一种，放到迭代函数里面又是一种
    * */
    boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return isBalanced;
        }
        helper(root);
        return isBalanced;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        /*
        * 后序遍历处理
        * */
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return left > right ? left + 1 : right + 1;
    }


}
