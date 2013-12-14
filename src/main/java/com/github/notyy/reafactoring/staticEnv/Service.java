package com.github.notyy.reafactoring.staticEnv;

public class Service {
    public void doSomething() {
        String rs = DBRepository.findData();
        if (rs.equals("xx")) {
            FileGenerator.write("1");
        } else {
            FileGenerator.write("2");
        }
    }
}
