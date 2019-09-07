import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] pars = input.readLine().split(" ");
        int m = Integer.parseInt(pars[0]);
        List<Long> inputAllLine = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] inputLine = input.readLine().split(" ");
            inputAllLine.add(Long.parseLong(inputLine[0]));
        }
        solution(inputAllLine);
    }

    private static void solution(List<Long> inputAllLine) {
        for (int i = 0; i < inputAllLine.size(); i++) {
            String result = "N0";
            String str = Long.toString(inputAllLine.get(i), 2);
            //System.out.println(str);
            int flag = 0;
            for (int k = 0, t = str.length() - 1; k < t; k++, t--) {
                if (str.charAt(k) != str.charAt(t)) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                result = "YES";
            }
            System.out.println(result);
        }
    }

}