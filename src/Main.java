import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] num = input.readLine().split(" ");
        int T = Integer.parseInt(num[0]);
        for (int i = 0; i < T; i++) {
            String[] pars = input.readLine().split(" ");
            int m = Integer.parseInt(pars[0]);
            int n = Integer.parseInt(pars[1]);
            List<Integer> list = new ArrayList<>();
            if (n != 0) {
                String[] inputString = input.readLine().split(" ");
                for (int j = 0; j < inputString.length; j++) {
                    list.add(Integer.parseInt(inputString[j]));
                }
            }
            System.out.println(solution(list, m, n));
        }
    }

    private static int solution(List<Integer> list, int m, int n) {
        int[] month = new int[31];
        // 赋初始值
        if (m == 0) {
            return 30;
        }
        if (!list.isEmpty()) {
            for (Integer day : list) {
                month[day] = 1;
            }
        }
        for (int i = 1; i <= 30; i++) {
            boolean flag = true;
            // 修改逻辑
            /*if (month[i] == 0 && (i + m > 30 || month[i + m] == 0) && (i - m < 1 || month[i - m] == 0)) {
                month[i] = 1;
            }*/
            // 修改后的
            for (int j = 1; j <= m; j++) {
                if ((i + j > 30 || month[i + j] == 0) && ((i - j < 1 || month[i - j] == 0))) {
                    continue;
                } else {
                    flag = false;
                }
            }
            if (flag == true) {
                month[i] = 1;
            }
        }
        // System.out.println(Arrays.toString(month));
        // 计算答案
        int res = 0;
        for (int i = 1; i <= 30; i++) {
            if (month[i] == 1) {
                res++;
            }
        }
        return res;
    }

}