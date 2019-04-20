package io;

import sun.security.krb5.internal.crypto.Aes128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Citrix on 2019-04-03.
 */
public class sureLine {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] pars = input.readLine().split(" ");
        int m = Integer.parseInt(pars[0]);
        int n = Integer.parseInt(pars[1]);
        List<String[]> inputAllLine = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] inputLine = input.readLine().split("");
            inputAllLine.add(inputLine);
        }
        String outputAllLine = "";
        for (int i = 0; i < inputAllLine.size(); i++) {
            outputAllLine += Arrays.toString(inputAllLine.get(i));
        }
        System.out.println(outputAllLine);
    }
}
