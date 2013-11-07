package com.github.notyy.reafactoring.staticEnv;

public class Service {
    public int doSomething() {
        String rs = DBRepository.findData();
        return rs.equals("xx") ? 1 : -1;
    }
}
