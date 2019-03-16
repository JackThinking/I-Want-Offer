
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        int n = Integer.parseInt(str);
        Main main = new Main();
        for (int i = 0; i < n; i++) {
            String num = input.readLine();
            String array = input.readLine();
            String[] arrays = array.split(" ");
            int len = Integer.parseInt(num);
            int[] x = new int[len];
            for (int j = 0; j < len; j++) {
                x[j] = Integer.parseInt(arrays[j]);
            }
            System.out.println(main.candy(x));
        }
    }
    /*public static void main(String[] args) {
        Main main = new Main();
        int[] test 1= {1, 2, 3, 3};
        System.out.println(main.candy(test));
    }*/
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = (candies[i - 1] + 1);
        }

        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
        }
        if (ratings[ratings.length - 1] > ratings[0]) {
            candies[ratings.length - 1] = Math.max(candies[ratings.length - 1], candies[0] + 1);
        }

        int sum = 0;
        for (int candy : candies)
            sum += candy;
        return sum;
    }
}