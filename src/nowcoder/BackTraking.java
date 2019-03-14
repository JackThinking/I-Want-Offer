package nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2019-03-10.
 */
public class BackTraking {
    //组合
    /*
    *Input: n = 4, k = 2
     Output:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
    * */
    List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n<1||k<1||k>n){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        helper(n,k,1,path);
        return res;
    }

    private void helper(int n, int k, int index, List<Integer> path) {
        if (path.size()==k){
            res.add(path);
            return;
        }
        for (int i = index; i <= n-(k-path.size())+1; i++) {
            path.add(i);
            helper(n, k, i+1, new ArrayList<>(path));
            path.remove(path.size()-1);
        }
        return;
    }
    //排列
    /*
    * Input: [1,2,3]
      Output:
      [
         [1,2,3],
         [1,3,2],
         [2,1,3],
         [2,3,1],
         [3,1,2],
         [3,2,1]
      ]
    * */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List list = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, list, res);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, visited, list, res);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
