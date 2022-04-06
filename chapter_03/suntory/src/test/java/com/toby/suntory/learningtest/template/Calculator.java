package com.toby.suntory.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public int fileReadTemplate(String path, BufferedReaderCallBack callback) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            int ret = callback.doSomeThingWithReader(br);
            return ret;
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

    public int calcSum(String path) throws IOException {
        BufferedReaderCallBack sumCallback =
                new BufferedReaderCallBack() {
                    @Override
                    public int doSomeThingWithReader(BufferedReader br) throws IOException {
                        int sum = 0;
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            sum += Integer.valueOf(line);
                        }

                        return sum;
                    }
                };
        return fileReadTemplate(path, sumCallback);
    }
}
