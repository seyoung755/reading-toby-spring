package com.toby.suntory.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public int fileReadTemplate(String path, BufferedReaderCallback callback) throws IOException {
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

    public int lineReadTemplate(String path, LineCallback callback, int initVal) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            int res = initVal;
            String line = null;
            while ((line = br.readLine()) != null) {
                res = callback.doSomethingWithLine(line, res);
            }
            return res;
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
        LineCallback sumCallback =
                new LineCallback() {
                    @Override
                    public int doSomethingWithLine(String line, int value) {
                        return Integer.parseInt(line) + value;
                    }
                };
        return lineReadTemplate(path, sumCallback, 0);
    }

    public int calcMultiply(String path) throws IOException {
        LineCallback multiplyCallback =
                new LineCallback() {
                    @Override
                    public int doSomethingWithLine(String line, int value) {
                        return Integer.parseInt(line) * value;
                    }
                };
        return lineReadTemplate(path, multiplyCallback, 1);
    }
}
