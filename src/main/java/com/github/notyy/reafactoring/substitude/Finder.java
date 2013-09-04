package com.github.notyy.reafactoring.substitude;

public class Finder {
    public String findPerson(String[] persons) {
        for (String person : persons) {
            if (person.equals("Don")) {
                return "Don";
            }
            if (person.equals("John")) {
                return "John";
            }
            if (person.equals("Kent")) {
                return "Kent";
            }
        }
        return "";
    }
}
