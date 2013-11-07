package com.github.notyy.reafactoring.staticEnv;

public class DBRepository {
    public static String findData() {
        throw new IllegalStateException("must connect to database");
    }
}
