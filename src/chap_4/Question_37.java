package chap_4;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-01-16.
 */
public class Question_37 {
    String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        SerializeHelper(root, sb);
        return sb.toString();
    }

    public void SerializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        SerializeHelper(root.left, sb);
        SerializeHelper(root.right, sb);
    }

    TreeNode Deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        String[] strs = str.split(",");
        return DeserializeHelper(strs);
    }

    int i = -1;//这个不熟练

    public TreeNode DeserializeHelper(String[] strs) {//反序列化也不熟练
        i++;
        if (!strs[i].equals("#")) {//string的比较还是用equal吧
            TreeNode node = new TreeNode(0);
            node.val = Integer.parseInt(strs[i]);//
            node.left = DeserializeHelper(strs);
            node.right = DeserializeHelper(strs);
            return node;
        }
        return null;
    }
}
