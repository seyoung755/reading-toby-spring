package com.toby.suntory.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public int calcSum(String path) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            int sum = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                sum += Integer.valueOf(line);
            }

            br.close();
            return sum;
        } catch (IOException e) {
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
