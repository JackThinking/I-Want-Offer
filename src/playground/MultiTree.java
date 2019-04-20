package playground;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2019-04-14.
 */
public class MultiTree {
    /*
     * 多叉树（无向图）的实现，DFS版本，可以用Map表示映射关系，也可以用List数组表示，也可以class数组表示
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        //生成节点的邻接矩阵
        Node[] nodes = new Node[n + 1];
        //每棵树都可以连接到自己这边
        for (int i = 1; i <= n; i++) {
            Node node = new Node(i);
            nodes[i] = node;
        }
        for (int i = 1; i < n; i++) {
            String[] ab = input.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            //无向图的连接方式
            nodes[a].childNode.add(b);
            nodes[b].childNode.add(a);
        }
        int max = 0;
        List<Integer> rootChild = nodes[1].childNode;
        for (int child : rootChild) {
            int count = getNodeNum(nodes, child, 1);
            max = Math.max(max, count);
        }
        System.out.println(max + 1);
    }

    private static int getNodeNum(Node[] nodes, int child, int end) {
        int count = 0;
        List<Integer> nextChild = nodes[child].childNode;
        count += nextChild.size() - 1;
        for (int item : nextChild) {
            if (item == end) {
                continue;
            }
            //在判断终止条件时，映射关系只有自己是关键
            count += getNodeNum(nodes, item, nodes[child].fatherNode);
        }
        return count;
    }

    /*
     * 写成类的方式更加直观
     * */
    static class Node {
        int fatherNode;
        List<Integer> childNode;

        public Node(int fatherNode) {
            this.fatherNode = fatherNode;
            childNode = new ArrayList<>();
        }
    }
}
