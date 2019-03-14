package structure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String parameter = input.readLine();
        String[] pars = parameter.split(" ");
        int n = Integer.parseInt(pars[0]);
        int d = Integer.parseInt(pars[1]);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int maxLen = -1;
        for (int i = 0; i < n; i++) {
            String str = input.readLine();
            String[] nums = str.split(" ");
            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);
            if (x >= maxLen) {
                maxLen = x;
            }
            map.put(x - 1, y);
        }
        for (int i = 0; i < maxLen; i++) {
            if (!map.containsKey(i)) {
                map.put(i, -1);
            }
        }
        Main main = new Main();
        System.out.println(main.rob(map, d));

    }

    public int rob(Map<Integer, Integer> map, int d) {
        /*
         * 搞清楚递归的核心方程式之后，在底层用砖块积累
         * */
        if (map.size() == 0) {
            return 0;
        }
        //memo数组还是要用，不过首先要确定其含义，由于其核心方程是nums[i]+helper(i+2,N-1)，可知其是基于未来的，则要从反向进行递推
        int N = map.size();
        int[] memo = new int[N];
        for (int i = 0; i < N; i++) {
            memo[i] = -1;
        }
        memo[N - 1] = map.get(N - 1);//第一个砖块是确定的，可以是设置0，也可以是实际值
        for (int i = N - (d + 1); i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (map.containsKey(j)) {
                    memo[i] = Math.max(memo[i], map.get(j) + (j + (d + 1) < N ? memo[j + (d + 1)] : 0));//注意i,j的变动范围
                }
            }
        }
        return memo[0];
    }
}
