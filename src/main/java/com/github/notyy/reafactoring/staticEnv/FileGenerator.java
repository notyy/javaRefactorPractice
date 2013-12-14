package com.github.notyy.reafactoring.staticEnv;

public class FileGenerator {
    public static void write(String s) {
        throw new IllegalStateException("can only run on server");
    }
}
