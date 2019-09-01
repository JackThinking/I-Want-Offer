import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        String[] inputLine = str.split(" ");
        int n = Integer.parseInt(inputLine[0]);
        String[] array = input.readLine().split("");
        int[] arrayInt = new int[array.length];
        for (int i = 0; i < n; i++) {
            arrayInt[i] = Integer.parseInt(array[i]);
        }
    }
}