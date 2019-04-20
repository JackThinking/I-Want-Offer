package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Citrix on 2019-04-03.
 */
public class unsureLine {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        List<String[]> inputData = new ArrayList<>();
        String lineData = input.readLine();
        while (!lineData.equals("")) {
            String[] strings = lineData.split(",");
            inputData.add(strings);
            lineData = input.readLine();
        }
        String outputData = "";
        for (int i = 0; i < inputData.size(); i++) {
            outputData += Arrays.toString(inputData.get(i));
        }
        System.out.println(outputData);
    }
}
