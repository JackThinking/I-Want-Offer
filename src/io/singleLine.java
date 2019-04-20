package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Citrix on 2019-04-03.
 */
public class singleLine {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        String[] inputLine = str.split(" ");
        int m = Integer.parseInt(inputLine[0]);
        System.out.println(m);
        System.out.println(Arrays.toString(inputLine));
    }
}
