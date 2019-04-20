package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Citrix on 2019-04-03.
 */
public class multiLine {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String[] inputString = input.readLine().split(" ");
        int inputInt[] = new int[inputString.length];
        for (int i = 0; i < inputString.length; i++) {
            inputInt[i] = Integer.parseInt(inputString[i]);
        }
        System.out.println(Arrays.toString(inputInt));
    }
}
