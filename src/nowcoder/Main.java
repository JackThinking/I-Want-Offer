package nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String parameter = input.readLine();
        int n = Integer.parseInt(parameter);
        String[] strings1 = input.readLine().split(" ");
        int array1[] = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = Integer.parseInt(strings1[i]);
        }
        String[] strings2 = input.readLine().split(" ");
        int array2[] = new int[n];
        for (int i = 0; i < n; i++) {
            array2[i] = Integer.parseInt(strings2[i]);
        }
        //Main main = new Main();
        Arrays.sort(array1);
        Arrays.sort(array2);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += array1[i] * array2[n - i - 1];
        }
        System.out.println(res);
    }
}