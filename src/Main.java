import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String[] inputString = input.readLine().split(" ");
        List<Integer> inputInt = new ArrayList<>();
        for (int i = 0; i < inputString.length; i++) {
            inputInt.add(Integer.parseInt(inputString[i]));
        }
        System.out.println(solution(inputInt, n));
    }

    private static int solution(List<Integer> inputInt, int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> res = permute(nums);
        int result = 0;
        for (List<Integer> list : res) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 1) < 0) {
                    tmp.add(1);
                } else {
                    tmp.add(0);
                }
                if (tmp.equals(inputInt)) {
                    result++;
                }
            }
        }
        return result % 1000000007;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List list = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, list, res);
        return res;
    }

    private static void dfs(int[] nums, boolean[] visited, List list, List<List<Integer>> res) {
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